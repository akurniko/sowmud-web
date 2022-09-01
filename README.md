# Mud-discord-gateway

Bot for Discord and IRC.
No need to connect from MUD.

# TODO

Add parallel support between IRC and Discord.

Use Okteto. Maybe Flyctl.

Clojure Discord.

Try with real token.
Only can get it once.

Create relay.
Get message from DS.

# Clojure IRC
https://github.com/obohrer/clj-irc

# Running Locally

Make sure you have Clojure installed.  Also, install the [Heroku Toolbelt](https://toolbelt.heroku.com/).
And Leiningen (or Clojure CLI tools).

```sh
$ lein repl
user=> (def bot (sowmud_web/core/bot))
```

Your app should now be connected to Libera chat.
It should also connect to Discord.

