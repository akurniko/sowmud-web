# Mud-discord-gateway

Bot for Discord and IRC.

# TODO

Add parallel support between IRC and Discord.
Channels and Clojure async, like Go channel.

Heroku for Clojure.
No need for Heroku?
Add Heroku remote.

Clojure Discord.

Running in the backend.
Lein REPL is not concurrent with Discord bot.
Make Discljord work in REPL.
Try with real token.

Test IRC bot.
Connects and works and okay with REPL.

Create relay.

# Clojure IRC
https://github.com/obohrer/clj-irc

# Heroku

This application support the [Getting Started with Clojure](https://devcenter.heroku.com/articles/getting-started-with-clojure) article - check it out.

## Running Locally

Make sure you have Clojure installed.  Also, install the [Heroku Toolbelt](https://toolbelt.heroku.com/).
And Leiningen (or Clojure CLI tools).

```sh
$ lein repl
user=> (require 'clojure-getting-started.web)
user=> (def server (clojure-getting-started.web/-main))
```

Your app should now be running on [localhost:5000](http://localhost:5000/).

## Deploying to Heroku

```sh
$ heroku create
$ git push heroku master
$ heroku open
```

## Documentation

For more information about using Clojure on Heroku, see these Dev Center articles:

- [Clojure on Heroku](https://devcenter.heroku.com/categories/clojure)

# Debugging

No create in this context.
