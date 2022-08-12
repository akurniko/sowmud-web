(ns sowmud-web.core
  (:require [clj-irc.core]
            [clojure.core.async :as a]
            [clojure.edn :as edn]
            [discljord.messaging :as discord-rest]
            [discljord.connections :as discord-ws]
            [discljord.events :refer [message-pump!]]))

(defn msg_relay [c msg reply-to]
  (a/go (a/>! c msg))
  (println msg)
  (reply-to (str "did you really say:" (a/<!! (a/go (a/<! c))))))

(let [c (a/chan)]
  (clj-irc.core/defbot {:nick "sowmud-web" :host "irc.libera.chat"
           :channels ["#sowmud"]
           :auto-reconnect false}
          (clj-irc.core/on-message {:keys [content]} reply-to {:regexp #"^test:.*"}
            (msg_relay c content reply-to))))

(def token "")
(def intents #{:guilds :guild-messages})

(let [event-ch      (a/chan 100)
      connection-ch (discord-ws/connect-bot! token event-ch :intents intents)
      message-ch    (discord-rest/start-connection! token)]
  (a/go 
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
;; (add-handler (fn[m r]
;;                  (r (str "You just said" (:content m)))))

;;  (go (>! c "hello"))
;;  (assert (= "hello" (<!! (go (<! c)))))
;;  (close! c))
