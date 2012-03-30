(ns mtask.util)

(import java.util.Date)

(defn string-to-date[strdate]
  (Date. strdate)
)

(defn printall [s]

(println (map :username s))

);

;;(def myset (conj{:id 4, :username "sougata", :password "123"}{:id 4, :username "sougata", :password "123"}))

;;(printall myset)
(println "sougata");





