(defproject sowmud-web "0.0.1"
  :description "Clojure Discord-IRC gateway"
  :dependencies [[clj-irc "0.0.3-SNAPSHOT"]
                 [org.clojure/clojure   "1.8.0"]
                 [org.clojure/core.async   "1.5.648"]
                 [org.pircbotx/pircbotx "1.9"]]

  :repl-options {:init-ns sowmud-web.core}
  :main sowmud-web.core)
