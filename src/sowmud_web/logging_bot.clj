(ns sowmud-web.core
  (:require [clojure.core.async :as a]
            [discljord.messaging :as discord-rest]
            [discljord.connections :as discord-ws]))

(def token "")
(def intents #{:guilds :guild-messages})

(def -bot
(let [event-ch      (a/chan 100)
      connection-ch (discord-ws/connect-bot! token event-ch :intents intents)
      message-ch    (discord-rest/start-connection! token)]
  (try
    (loop []
      (let [[event-type event-data] (a/<!! event-ch)]
        (println "í¾‰ NEW EVENT! í¾‰")
        (println "Event type:" event-type)
        (println "Event data:" (pr-str event-data))
        (recur)))
    (finally
      (discord-rest/stop-connection! message-ch)
      (discord-ws/disconnect-bot! connection-ch)
      (a/close!           event-ch)))))
