(defproject mtask "1.0.0-SNAPSHOT"
  :description "mBlog: A Blog engine written in Clojure, Author:sougata@gmail.com"
    :dependencies [[org.clojure/clojure "1.3.0"]
                   [ring "1.0.1" ;;; Exclude the clojure and clj-stacktrace from ring dependency
                    :exclusions [org.clojure/clojure
                                 clj-stacktrace]]
                   [net.cgrand/moustache "1.1.0"]
                   [lobos "1.0.0-SNAPSHOT"]
                   [korma "0.2.1"]
                   [enlive "1.0.0"]
                   [postgresql "9.1-901.jdbc4"]
                   [mysql/mysql-connector-java "5.1.18"]
                   [clj-yaml "0.3.1"]])

