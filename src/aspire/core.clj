(ns aspire.core
  (:gen-class)
  (:require [ring.adapter.jetty :as jetty]
            [clojure.pprint]
            [compojure.core :as compojure]
            [compojure.route :as compojure-route]))


(compojure/defroutes app
  (compojure/GET "/" [] "Hello World")
  (compojure-route/not-found "Page not found"))


(defn -main
  [& args]
  (jetty/run-jetty app
                   {:port 3000
                    :join? true}))