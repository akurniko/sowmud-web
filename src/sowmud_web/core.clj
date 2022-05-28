(ns sowmud-web.core)
  (:use [clj-irc.core]))

(defbot {:nick "sowmud-web" :host "libera.chat"
         :channels ["#sowmud"]
         :auto-reconnect false}
        (on-message {:keys [content]} reply-to {:regexp #"^test:.*"}
          (reply-to (str "did you really say :" content))))
