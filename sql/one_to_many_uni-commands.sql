\c hb_student_tracker hbstudent;

DROP SCHEMA IF EXISTS "hb-04-one-to-many-uni";
CREATE SCHEMA "hb-04-one-to-many-uni";
SET search_path TO "hb-04-one-to-many-uni";

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

DROP TABLE IF EXISTS course;

CREATE TABLE course (
  id serial PRIMARY KEY NOT NULL,
  title varchar(128) UNIQUE DEFAULT NULL,
  instructor_id integer REFERENCES instructor(id) DEFAULT NULL
);

DROP TABLE IF EXISTS review;

CREATE TABLE review (
  id serial PRIMARY KEY NOT NULL,
  comment varchar(256) DEFAULT NULL,
  course_id integer REFERENCES course(id) DEFAULT NULL
);
