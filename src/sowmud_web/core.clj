(ns sowmud-web.core
  (:require [clj-irc.core]
            [clojure.edn :as edn]
            [clojure.core.async :refer [chan close!] :as a]
            [discljord.messaging :as discord-rest]
            [discljord.connections :as discord-ws]
            [discljord.formatting :refer [mention-user]]
            [discljord.events :refer [message-pump!]]))

(def state (atom nil))
(def bot-id (atom nil))
(def config (edn/read-string (slurp "config.edn")))

(defn random-response [user]
  (str (rand-nth (:responses config)) ", " (mention-user user) \!))

(clj-irc.core/defbot {:nick "sowmud-web" :host "irc.libera.chat"
         :channels ["#sowmud"]
         :auto-reconnect false}
        (clj-irc.core/on-message {:keys [content]} reply-to {:regexp #"^test:.*"}
          (reply-to (str "did you really say :" content))))


(def token "TOKEN")
(def intents #{:guilds :guild-messages})

(let [event-ch      (a/chan 100)
      connection-ch (discord-rest/connect-bot! token event-ch :intents intents)
      message-ch    (discord-ws/start-connection! token)]
  (try
    (loop []
      (let [[event-type event-data] (a/<!! event-ch)]
        (println "í¾‰ NEW EVENT! í¾‰")
        (println "Event type:" event-type)
        (println "Event data:" (pr-str event-data))
        (recur)))
    (finally
      (discord-ws/stop-connection! message-ch)
      (discord-rest/disconnect-bot!  connection-ch)
      (a/close!           event-ch))))
