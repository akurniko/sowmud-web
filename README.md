# Mud-discord-gateway

Bot for Discord and IRC.

# TODO

Heroku for Clojure.

Clojure Discord.
Clojure IRC.

# Clojure IRC
https://github.com/obohrer/clj-irc

# Heroku

This application support the [Getting Started with Clojure](https://devcenter.heroku.com/articles/getting-started-with-clojure) article - check it out.

## Running Locally

Make sure you have Clojure installed.  Also, install the [Heroku Toolbelt](https://toolbelt.heroku.com/).

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

or

[![Deploy to Heroku](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy)

## Documentation

For more information about using Clojure on Heroku, see these Dev Center articles:

- [Clojure on Heroku](https://devcenter.heroku.com/categories/clojure)

