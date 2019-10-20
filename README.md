# zenroom-example

A [re-frame](https://github.com/Day8/re-frame) application designed to work with the Zenroom npm package.

## Development Mode

### Run application:

    lein clean
    npm i
    lein dev

shadow-cljs will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:8280](http://localhost:8280).

### Start Cider from Emacs:

Refer to the [shadow-cljs Emacs / CIDER documentation](https://shadow-cljs.github.io/docs/UsersGuide.html#cider).

## Production Build

Run

    lein clean
    shadow-cljs release prod

Compiled frontend will be available in `resources/public`.
