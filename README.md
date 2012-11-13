# hubview

Simple GitHub timeline viewer for your terminal.

## Usage

`hubview` is not yet quite finished but there ios a script which makes it usable.

Here's how to get it working:

- get Clojure and Leiningen (via brew or whatever)
- `git clone` the repo
- get your feed url from GitHub dashboard
- run: `./doeet "https://github.com/<username>.private.atom?token=<a token>"`

It will refresh every 5 minutes  by default but you can pass interval (in seconds)
as second argument

## License

Copyright (C) 2012 Łukasz Korecki

Distributed under the Eclipse Public License, the same as Clojure.
