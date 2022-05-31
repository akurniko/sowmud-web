(ns sowmud-web.core
  (:require [clj-irc.core]))

(clj-irc.core/defbot {:nick "sowmud-web" :host "irc.libera.chat"
         :channels ["#sowmud"]
         :auto-reconnect false}
        (clj-irc.core/on-message {:keys [content]} reply-to {:regexp #"^test:.*"}
          (reply-to (str "did you really say :" content))))
