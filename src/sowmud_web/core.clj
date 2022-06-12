(ns sowmud-web.core
  (:require [clj-irc.core sowmud-bot.core]))

(clj-irc.core/defbot {:nick "sowmud-web" :host "irc.libera.chat"
         :channels ["#sowmud"]
         :auto-reconnect false}
        (clj-irc.core/on-message {:keys [content]} reply-to {:regexp #"^test:.*"}
          (reply-to (str "did you really say :" content))))

(defn -main [& args]
  (reset! state (start-bot! (:token config) :guild-messages))
  (reset! bot-id (:id @(discord-rest/get-current-user! (:rest @state))))
  (try
    (message-pump! (:events @state) handle-event)
    (finally (stop-bot! @state))))

