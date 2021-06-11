CREATE TABLE User (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  firstName varchar(250) NOT NULL,
  lastName varchar(250) NOT NULL,
  email varchar(250) NOT NULL,
  deptId bigint(20) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_user_email (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;