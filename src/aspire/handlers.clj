(ns aspire.handlers
  (:require [clostache.parser :as mustache]
            [aspire.db :as db]
            [ring.util.response :as ring-response]))

(defn home
  [request]
  "Home Page")

(defn problem-by-id
  [request]
  (let [id (:id (:params request))
        data (db/get id)]
    (if-not data
      (str "Problem cannot be loaded, as ID is not valid " id)
      (mustache/render-resource "templates/home.mustache"
                                {:title (:problemTitle data)
                                 :description (:problemDescription data)}))))

(db/get "find-peak-element")

(defn next-problem
  [request]
  (str "Next"))

(defn hint
  [request]
  (let [id (:id (:params request))]
    (str "Hint for " id)))

(defn solution
  [request]
  (let [id (:id (:params request))]
    (str "Solution for " id)))

(defn not-found
  [request]
  "404: Page not Found")
