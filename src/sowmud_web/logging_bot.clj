(require '[clojure.core.async    :as a])
(require '[discljord.connections :as c])
(require '[discljord.messaging   :as m])

(def token "TOKEN")
(def intents #{:guilds :guild-messages})

(let [event-ch      (a/chan 100)
      connection-ch (c/connect-bot! token event-ch :intents intents)
      message-ch    (m/start-connection! token)]
  (try
    (loop []
      (let [[event-type event-data] (a/<!! event-ch)]
        (println "í¾‰ NEW EVENT! í¾‰")
        (println "Event type:" event-type)
        (println "Event data:" (pr-str event-data))
        (recur)))
    (finally
      (m/stop-connection! message-ch)
      (c/disconnect-bot!  connection-ch)
      (a/close!           event-ch))))
