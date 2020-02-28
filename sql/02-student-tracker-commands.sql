CREATE DATABASE hb_student_tracker;
\c hb_student_tracker hbstudent;
DROP TABLE IF EXISTS student;
CREATE TABLE student (
    id serial PRIMARY KEY NOT NULL,
    first_name varchar(45) DEFAULT NULL,
    last_name varchar(45) DEFAULT NULL,
    email varchar(45) DEFAULT NULL
);

ALTER SEQUENCE student_id_seq RESTART WITH 3000;