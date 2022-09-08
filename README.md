# Mud-discord-gateway

Bot for Discord and IRC.
No need to connect from MUD.
But Netlify MUD client is still interesting.

# TODO

Clojure Discord and IRC.

Add parallel support between IRC and Discord.
Done with Go-like async package.

Use Okteto. Maybe Flyctl.
Helm and Kubernetes manifest.

Try with real Discord token.
Only can get it once, so need to restore it from backup.

Create relay between Discord and IRC.
Get message from DS.

# Clojure IRC
https://github.com/obohrer/clj-irc

# Running Locally

Make sure you have Clojure installed.
And Leiningen (or Clojure CLI tools).

```sh
$ lein repl
user=> (def bot (sowmud_web/core/bot))
```

Your app should now be connected to Libera chat.
It should also connect to Discord.

