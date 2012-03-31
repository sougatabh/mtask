

-- Table structure for table `mtask_code`

DROP TABLE IF EXISTS `mtask_code`;
CREATE TABLE `mtask_code` (
  `type` varchar(20) DEFAULT NULL,
  `value` varchar(30) DEFAULT NULL
);

--

INSERT INTO `mtask_code` VALUES ('TASK_STATUS','Completed'),('TASK_STATUS','New'),('TASK_STATUS','In Progress');

DROP TABLE IF EXISTS `mtask_user`;
CREATE TABLE `mtask_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
);

INSERT INTO `mtask_user` VALUES (2,'sougata','123456'),(3,'sakshi','123456');

-- Table structure for table `mtask_user_detail`

DROP TABLE IF EXISTS `mtask_user_detail`;
CREATE TABLE `mtask_user_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(30) DEFAULT NULL,
  `lastname` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `username` (`username`),
  CONSTRAINT `mtask_user_detail_ibfk_1` FOREIGN KEY (`username`) REFERENCES `mtask_user` (`username`)
);

-- Dumping data for table `mtask_user_detail`

INSERT INTO `mtask_user_detail` VALUES (1,'Sougata','Bhattacharya','sougata@gmail.com','sougata'),(2,'Sakshi','Bhattacharya','sakshi@gmail.com','sakshi');



-- Table structure for table `mtask_project`

DROP TABLE IF EXISTS `mtask_project`;
CREATE TABLE `mtask_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectname` varchar(30) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `startdate` date DEFAULT NULL,
  `enddate` date DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `username` (`username`),
  CONSTRAINT `mtask_project_ibfk_1` FOREIGN KEY (`username`) REFERENCES `mtask_user` (`username`)
);

-- Dumping data for table `mtask_project`

INSERT INTO `mtask_project` VALUES (1,'mtask','This is my project','2012-03-30','2012-04-27','sougata');

--

DROP TABLE IF EXISTS `mtask_task_detail`;
CREATE TABLE `mtask_task_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `startdate` date DEFAULT NULL,
  `enddate` date DEFAULT NULL,
  `assigned_to` varchar(30) DEFAULT NULL,
  `assigned_by` varchar(30) DEFAULT NULL,
  `projectname` varchar(30) NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `assigned_to` (`assigned_to`),
  CONSTRAINT `mtask_task_detail_ibfk_1` FOREIGN KEY (`assigned_to`) REFERENCES `mtask_user` (`username`)
);

INSERT INTO `mtask_task_detail` VALUES (1,'Design','Design the templates','2012-03-30','2012-03-31','sougata','sougata','mtask','New'),(2,'Code','Please go and Code','2012-03-31','2012-04-02','sakshi','sougata','mtask','New'),(3,'Play','Play for sometime','2012-03-31','2012-04-28','sakshi','sougata','mtask','New');


