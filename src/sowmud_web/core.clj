(ns sowmud-web.core
  (:require [clj-irc.core]
            [clojure.core.async :as a]
            [clojure.edn :as edn]
            [discljord.events :refer [message-pump!]]))

(defn msg_relay [c msg]
  (a/go (a/>! c msg))
  (str "did you really say:" (a/<!! (a/go (a/<! c)))))

(let [c (a/chan)]
  (clj-irc.core/defbot {:nick "sowmud-web" :host "irc.libera.chat"
           :channels ["#sowmud"]
           :auto-reconnect false}
          (clj-irc.core/on-message {:keys [content]} reply-to {:regexp #"^test:.*"}
            (msg_relay c content))))
;; (add-handler (fn[m r]
;;                  (r (str "You just said" (:content m)))))

;;  (go (>! c "hello"))
;;  (assert (= "hello" (<!! (go (<! c)))))
;;  (close! c))
