(ns aspire.core
  (:gen-class)
  (:require [ring.adapter.jetty :as jetty]
            [clojure.pprint]
            [aspire.routes :as routes]))

(defn -main
  [& args]
  (jetty/run-jetty routes/app
                   {:port (Integer/parseInt (System/getenv "PORT"))
                    :join? true}))