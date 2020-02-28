\c hb_student_tracker jadams;
GRANT CREATE ON DATABASE hb_student_tracker TO hbstudent;
\c hb_student_tracker hbstudent;

DROP SCHEMA IF EXISTS "hb-01-one-to-one-uni";

CREATE SCHEMA "hb-01-one-to-one-uni";

SET search_path TO "hb-01-one-to-one-uni";

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS instructor_detail;

CREATE TABLE instructor_detail (
  id serial PRIMARY KEY NOT NULL,
  youtube_channel varchar(128) DEFAULT NULL,
  hobby varchar(45) DEFAULT NULL 
);


DROP TABLE IF EXISTS instructor;

CREATE TABLE instructor (
  id serial PRIMARY KEY NOT NULL,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  instructor_detail_id integer REFERENCES instructor_detail(id) DEFAULT NULL
);

SET FOREIGN_KEY_CHECKS = 1;
