(ns aspire.db
  (:require [clojure.data.json :as json]
            [clojure.java.io :as io]))

(def data
  (json/read-str (slurp (io/resource "data.txt"))
                 :key-fn keyword))

(def data-map
  (reduce
   (fn
     [accumulator element]
     (let [id (:id element)]
       (assoc accumulator id element)))
   {}
   data))

(defn get
  [id]
  (data-map id))


(defn random-id
  []
  (:id (rand-nth data)))

