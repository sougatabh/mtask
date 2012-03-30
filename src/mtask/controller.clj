(ns mtask.controller
  (:use  
         ring.util.response
         korma.db
         korma.core
         mtask.models
         mtask.validator
         mtask.templates
         mtask.util
    )
 )

(import java.util.Date)

(defn signin-page
  "Index page handler"
  [req]
  (->> (show-singin-page) response)
  
 )




(defn signin
  "Login Handler"
[req]
(let [params (:params req)]

  (let [user (select mtask_user (where {:username (get params "username")}))]
    
    (assoc (redirect "/welcome-page") :session {:username (get params "username")})
   )
  ))

(defn welcome-page
  "The welcome Page"
   [req]
   (let [username (:username (:session req))
        params (:params req)]
   
   (->> (show-welcome-page username) response)
   
   )
)  

(defn signup-page
   "Index page handler"
   [req]
   (->> (show-singup-page) response)
 )

(defn gotosuccesspage [params]
  (insert  mtask_user (values { :username (get params "username"):password (get params "password")}))
  (insert  mtask_user_detail (values { :firstname (get params "firstname"):lastname (get params "lastname"):email (get params "email"):username (get params "username")}))
  (redirect "/welcome-page")
)


(defn signup-failure
  "The Sigup filure page"
  [req]
  (->>(show-singup-faliure-page) response)
 )


(defn signup
  "Login Handler"
[req]
(let [params (:params req)]

  (let [user (user_exists (get params "username"))]
    (if-not (empty? user)
      ;;(response "Some Text")
      (signup-failure req)
      (gotosuccesspage params)
    )
  )
)
)



;;Project Management 

(defn create-project-page
   "Index Page for Creating Project"
   [req]
   (->> (show-create-project-page) response)
 )

(defn create-project
  "Project Handler"
[req]
(let [params (:params req)]
  (let [startdate(string-to-date (get params"startdate"))]
    (let [enddate (string-to-date (get params"enddate"))]
       (println enddate)
      (insert  mtask_project (values { :projectname (get params "projectname"):description (get params "description"):username "sougata":enddate enddate :startdate startdate}))
    )
 )
)
)

;;Task Management
(defn create-task-page
  "The Create task page"
   [req]
   (let [users (select mtask_user)
         projects(select mtask_project)
        params (:params req)]
   
   (->> (show-create-task-page users projects) response)
   
   )
)  

(defn create-task
  "This is to Create task detail in the task detail table"
  [req]
(let [params (:params req)]
(let [startdate(string-to-date (get params"startdate"))]
    (let [enddate (string-to-date (get params"enddate"))]
       (println enddate)
      (insert  mtask_task_detail (values { :title (get params "tasktitle"):description (get params "description"):assigned_to (get params "assigned_to"):assigned_by "sougata":projectname (get params "projectname"):enddate enddate :startdate startdate}))
    )
 )
  
 )  
  
 )



