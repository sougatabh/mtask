(ns mtask.validator
  (:use mtask.templates
         ring.util.response
         korma.db
         korma.core
         mtask.models
         ))


(defn user_exists
 "This is a validator method to check user exist or not"
 [theusername]

   (select mtask_user (where {:username theusername}))
    
 )