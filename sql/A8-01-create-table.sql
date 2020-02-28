\c hb_student_tracker hbstudent;
CREATE TABLE employee (
    id serial PRIMARY KEY NOT NULL,
    first_name varchar(50) DEFAULT NULL,
    last_name varchar(50) DEFAULT NULL,
    company varchar(50) DEFAULT NULL
);