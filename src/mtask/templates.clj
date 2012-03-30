(ns mtask.templates
  (:use [net.cgrand.enlive-html]))

(deftemplate show-singin-page "signin.html" []
  [:title] (content "mtask:- The Task Manager"))

(deftemplate show-singup-page "signup.html" []
  [:title] (content "mtask:- The Task Manager"))



(deftemplate show-welcome-page "welcome.html" [username]
  [:title] (content "mtask:- The Task Manager!")
  [:div#username](content username)
)


(deftemplate show-singup-faliure-page "signup.html" []
  [:title] (content "mtask:- The Task Manager")
  [:div#error](content "Username already exist, Please try with another")
  )

;;The Project 

(deftemplate show-create-project-page "create-project.html" []
  [:title] (content "mtask:- Create Project")
  
)


(deftemplate show-create-task-page "create-task.html" [users projects]
  [:title] (content "mtask:- The Task Manager!")
  [:option.users] (clone-for [user users]
                             (content (:username user))
                  )
  [:option.projects](clone-for[theproject projects]
                        (content (:projectname theproject))
                     )
                   
  
  ;;[:div.content] (str "<select>" (reduce str "" (map #(str "<option>" ( :username %) "</option>") users)) "</select>")
  
                           
)

