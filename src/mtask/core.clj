(ns mtask.core
  (:use ring.adapter.jetty
        ring.middleware.resource
        ring.middleware.reload
        ring.util.response
        ring.middleware.file
        ring.middleware.params
        ring.middleware.session
        ring.middleware.session.cookie
        net.cgrand.moustache
        mtask.controller
        ))

;; Template defination
;;(deftemplate index "home.html"[])

;; Routes definition

;;This is the same thing has been used with start


(def routes
  (app
   (wrap-file "resources")
   (wrap-params)
   (wrap-session {:cookie-name "clog-session" :store (cookie-store)})
   [""] (delegate signin-page)
   ["signup-page"] (delegate signup-page)
   ["signin"] (delegate signin)
   ["signup"] (delegate signup)
   ["welcome-page"] (delegate welcome-page)
   ["create-project-page"] (delegate create-project-page)
   ["create-project"] (delegate create-project)
   ["create-task-page"] (delegate create-task-page)
   ["create-task"] (delegate create-task)
   
   ))

;;; start function for starting jetty

(defn start [port]
  (run-jetty #'routes {:port (or port 8080) :join? false}))



