(ns aspire.routes
  (:require [compojure.core :as compojure]
            [compojure.route :as compojure-route]
            [aspire.handlers :as handlers]))

(compojure/defroutes app
  (compojure/GET "/" params handlers/home)
  (compojure/GET "/problem/:id" params handlers/problem-by-id)
  (compojure/GET "/next" params handlers/next-problem)
  (compojure/GET "/hint/:id" params handlers/hint)
  (compojure/GET "/solution/:id" params handlers/solution)

  (compojure-route/not-found handlers/not-found))