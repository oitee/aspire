(ns aspire.core
  (:gen-class)
  (:require [ring.adapter.jetty :as jetty]
            [clojure.pprint]
            [compojure.core :as compojure]
            [compojure.route :as compojure-route]))

(defn home
  [request]
  "Home Page")

(defn problem-by-id
  [request]
  (let [id (:id (:params request))]
    (str "Problem Page for " id)))

(defn next-problem
  [request]
  "Next Problem Page")

(defn hint
  [request]
  (let [id (:id (:params request))]
    (str "Hint for " id)))

(defn solution
  [request]
  (let [id (:id (:params request))]
    (str "Solution for " id)))

(compojure/defroutes app
  (compojure/GET "/" params home)
  (compojure/GET "/problem/:id" params problem-by-id)
  (compojure/GET "/next" params next-problem)
  (compojure/GET "/hint/:id" params hint)
  (compojure/GET "/solution/:id" params solution)

  (compojure-route/not-found "Page not found"))


;; router.get ("/", renderHome);

;; router.get ("/problem/:id", getProblem);

;; router.get ("/next", goToNext);

;; router.get ("/hint/:id", getHint);

;; router.get ("/solution/:id", getSolution);



(defn -main
  [& args]
  (jetty/run-jetty app
                   {:port 3000
                    :join? true}))