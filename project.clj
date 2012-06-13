(defproject RemoteHello "0.1.0-SNAPSHOT"
            :description "noir and clojurescript remote hello world"
            :dependencies [[org.clojure/clojure "1.3.0"]
                           [noir "1.2.2"]
                           [crate "0.1.0-SNAPSHOT"]
                           [jayq "0.1.0-SNAPSHOT"]
                           [fetch "0.1.0-alpha2"]
                          ]
            :dev-dependencies [[lein-cljsbuild "0.0.13"]] ; cljsbuild plugin
            :cljsbuild {:source-path "src-cljs"
                        :compiler
                          {:output-dir "resources/public/cljs"
                           :output-to "resources/public/cljs/main.js"
                           :optimizations :simple
                           :pretty-print true}}
            :main RemoteHello.server)

