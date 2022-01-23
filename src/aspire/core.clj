(ns aspire.core
  (:gen-class)
  (:require [org.httpkit.server :as http-kit])
  [ring.middleware.reload :as reload]
  [compojure.handler :refer [site]]
  [compojure.route :as route]
  [compojure.core :refer [defroutes GET POST]])


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (let [server (http-kit/run-server app options)]
  ;; run-server returns a function that stops the server
    (server))
  )
