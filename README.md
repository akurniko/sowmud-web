# Mud-discord-gateway

Bot for Discord and IRC.

# TODO

Create relay between Discord and IRC.

Get message from DS, pass it to IRC and vice versa.

Clojure Discord and IRC.

## For the bot
!connect - brings character up in the control channel
!smile - debugging smile in the control channel

!chat - specify chat channel for clan chat, starts with '['
!control - specify control channel
!common - specify common chat channel, starts with b
!bylins - specify bylins chat channel
!auc - specify auction channel, check what it starts with

Map of channels and correct forwarding of messages.

## For the hosting
Oracle IRC needs SAML.
SAML page.

# Clojure IRC
https://github.com/obohrer/clj-irc

# Running Locally
Clojure and Leiningen (or Clojure CLI tools) must be installed.
Lein vs clojure tools.
Tools.build.

```sh
$ lein repl
```

Your app is now connected to Libera chat and Discord.

# Future
Elastic. Store logs and index.
Interesting to see performance.

