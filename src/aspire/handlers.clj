(ns aspire.handlers
  (:require [clostache.parser :as mustache]
            [aspire.db :as db]
            [ring.util.response :as ring-response]
            [clojure.data.json :as json]))

(defn home
  [request]
  (ring-response/redirect (str "/problem/" (db/random-id))))

(defn problem-by-id
  [request]
  (let [id (:id (:params request))
        data (db/get id)]
    (if-not data
      (str "Problem cannot be loaded, as ID is not valid " id)
      (mustache/render-resource "templates/home.mustache"
                                {:title (:problemTitle data)
                                 :description (:problemDescription data)}))))

(defn next-problem
  [request]
  (ring-response/redirect (str "/problem/" (db/random-id))))

(defn hint
  [request]
  (let [id (:id (:params request))
        data (db/get id)]
    (json/write-str {"hint" (:hint data)})))

(defn solution
  [request]
  (let [id (:id (:params request))
        data (db/get id)]
    (json/write-str {"hint" (:hint data)
                     "solution" (:solution data)})))

(defn not-found
  [request]
  "404: Page not Found")
