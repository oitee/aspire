(ns aspire.db
  (:require [clojure.data.json :as json]))

(def data
  (json/read-str (slurp "resources/data.txt")
                 :key-fn keyword))

(def data-map
  (reduce
   (fn
     [accumulator element]
     (let [id (:id element)]
       (assoc accumulator id element)))
   {}
   data))

(defn data-size
  []
  (count data-map))


(defn get
  [id]
  (data-map id))


(defn random-id
  []
  (:id (rand-nth data)))

