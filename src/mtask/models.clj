(ns mtask.models
  (:use korma.db
        korma.core))

;;; Defines the database for lobos migrations
(defdb mydb {:subprotocol "mysql"
             :subname "//127.0.0.1:3306/test"
             :user ""
             :password ""})


(defentity mtask_user)
(defentity mtask_user_detail)
(defentity mtask_project)
(defentity mtask_task_detail)
