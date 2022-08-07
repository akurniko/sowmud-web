(ns sowmud-web.core
  (:require [clj-irc.core]
            [clojure.core.async :as a]
            [clojure.edn :as edn]
            [discljord.formatting :refer [mention-user]]
            [discljord.events :refer [message-pump!]]))

(defn msg_relay [c msg]
  (a/go (a/>! c msg))
  (reply-to (str "did you really say:" (a/<!! (a/go (a/<! c))))))

(let [c (chan)]
  (clj-irc.core/defbot {:nick "sowmud-web" :host "irc.libera.chat"
           :channels ["#sowmud"]
           :auto-reconnect false}
          (clj-irc.core/on-message {:keys [content]} reply-to {:regexp #"^test:.*"}
            (msg_relay c content))))

;;  (go (>! c "hello"))
;;  (assert (= "hello" (<!! (go (<! c)))))
;;  (close! c))
