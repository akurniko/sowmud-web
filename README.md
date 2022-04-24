# Mud-web

ClojureScript based MUD client.

Bot for Discord and IRC.

# TODO

Connect outside.

Heroku for Clojure.

Clojure Discord.
Clojure IRC.

Lyntin bots.

Overall model.

Fly with virtual, CodeSignal with Clojure and Go, Codility.
Does not seem to be happening.

Security challenges (what to do with passwords and authentication).
Real world security course.

# Clojure MUD
https://github.com/dhleong/rainboots
https://github.com/markx/batman

# Clojure IRC
https://github.com/obohrer/clj-irc

# WebSockets
https://github.com/novnc/websockify-other

# clojure-getting-started

A barebones Clojure app, which can easily be deployed to Heroku.  

This application support the [Getting Started with Clojure](https://devcenter.heroku.com/articles/getting-started-with-clojure) article - check it out.

## Running Locally

Make sure you have Clojure installed.  Also, install the [Heroku Toolbelt](https://toolbelt.heroku.com/).

```sh
$ git clone https://github.com/heroku/clojure-getting-started.git
$ cd clojure-getting-started
$ lein repl
user=> (require 'clojure-getting-started.web)
user=>(def server (clojure-getting-started.web/-main))
```

Your app should now be running on [localhost:5000](http://localhost:5000/).

## Deploying to Heroku

```sh
$ heroku create
$ git push heroku master
$ heroku open
```

or

[![Deploy to Heroku](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy)

## Documentation

For more information about using Clojure on Heroku, see these Dev Center articles:

- [Clojure on Heroku](https://devcenter.heroku.com/categories/clojure)

