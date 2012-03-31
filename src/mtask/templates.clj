(ns mtask.templates
  (:use [net.cgrand.enlive-html]))

(deftemplate show-singin-page "signin.html" []
  [:title] (content "mtask:- The Task Manager"))

(deftemplate show-singup-page "signup.html" []
  [:title] (content "mtask:- The Task Manager"))



(deftemplate show-welcome-page "welcome.html" [username tasks]
  [:title] (content "mtask:- The Task Manager!")
  [:div#username](content username)
  
  
  
   [:tr.task] (clone-for [task tasks]
                
                [:td.title] (html-content(:title task) )
                [:td.description] (html-content(:description task) )
                [:td.startdate] (html-content(:startdate task) )
                [:td.enddate] (html-content(:enddate task) )
                [:td.status] (html-content(:status task) )
                [:td.assigned_by] (html-content(:assigned_by task) )
                
                )
)


(deftemplate show-singup-faliure-page "signup.html" []
  [:title] (content "mtask:- The Task Manager")
  [:div#error](content "Username already exist, Please try with another")
  )

;;The Project 

(deftemplate show-create-project-page "create-project.html" []
  [:title] (content "mtask:- Create Project")
  
)


(deftemplate show-create-task-page "create-task.html" [users projects statuses]
  [:title] (content "mtask:- The Task Manager!")
  [:option.users] (clone-for [user users]
                             (content (:username user))
                  )
  [:option.projects](clone-for[theproject projects]
                        (content (:projectname theproject))
                     )
  [:option.status](clone-for[status statuses]
                        (content (:value status))
                     )
                   
  
  ;;[:div.content] (str "<select>" (reduce str "" (map #(str "<option>" ( :username %) "</option>") users)) "</select>")
  
                           
)

