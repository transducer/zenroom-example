(defproject org.dyne.zenroom-example "1.0.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.597"
                  :exclusions [com.google.javascript/closure-compiler-unshaded
                               org.clojure/google-closure-library]]
                 [thheller/shadow-cljs "2.8.98"]
                 [reagent "0.10.0"]]
  :plugins []
  :min-lein-version "2.5.3"
  :jvm-opts ["-Xmx1G"]
  :source-paths ["src/clj" "src/cljs"]
  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]
  :aliases {"dev"  ["with-profile" "dev" "run" "-m" "shadow.cljs.devtools.cli" "watch" "app"]
            "prod" ["with-profile" "prod" "run" "-m" "shadow.cljs.devtools.cli" "release" "app"]}
  :profiles {:dev {:dependencies [[binaryage/devtools "1.0.0"]]}
             :prod {}})
