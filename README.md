# Mud-discord-gateway

Bot for Discord and IRC.

# TODO

Create relay between Discord and IRC.
Get message from DS.
And pass it to IRC.

Clojure Discord and IRC.

Use Okteto. Maybe Flyctl.
Helm and Kubernetes manifest.

Try with real Discord token.
Only can get it once, so need to restore it from backup.
In progress. No content in the message. Token leaked and revoked.
Need to read token from file.

# Clojure IRC
https://github.com/obohrer/clj-irc

# Running Locally

Make sure you have Clojure installed.
And Leiningen (or Clojure CLI tools).

```sh
$ lein repl
user=> (def bot (sowmud_web/core/bot))
```

Your app should now be connected to Libera chat and Discord.

