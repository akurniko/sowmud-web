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
  ;;(discord-message msg)
  (reply-to (str "did you really say:" (a/<!! (a/go (a/<! c))))))

(def token (slurp "token"))
(def intents #{:guilds :guild-messages})

(def channels (chat common))
;; is irc channel same as discord
;; DS channel is atom, sync state
;; async channel

(defn -main
(let [irc-ch        (a/chan)
      event-ch      (a/chan 100)
      connection-ch (discord-ws/connect-bot! token event-ch :intents intents)
      message-ch    (discord-rest/start-connection! token)]
  (clj-irc.core/defbot {:nick "sowmud-web" :host "irc.libera.chat"
           :channels ["#sowmud"]
           :auto-reconnect false}
          (clj-irc.core/on-message {:keys [content]} reply-to {:regexp #"^test:.*"}
            (msg_relay message-ch content reply-to)))
  (a/go 
    (try
    (loop []
      (let [[event-type event-data] (a/<!! event-ch)]
        (println "í¾‰ NEW EVENT! í¾‰")
        (println "Event type:" event-type)
        ;; (clj-irc.core/send "new DS message")
        (println "Event data:" (pr-str (:content event-data)))
        (recur)))
    (finally
      (discord-rest/stop-connection! message-ch)
      (discord-ws/disconnect-bot! connection-ch)
      (a/close!           event-ch)
      (a/close!           irc-ch))))))
;; (add-handler (fn[m r]
;;                  (r (str "You just said" (:content m)))))

