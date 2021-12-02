--------------------------------------------------------------------------------
--1. Student table

CREATE TABLE student (
name      VARCHAR2(20) NOT NULL,
std_code  NUMBER PRIMARY KEY,
score     NUMBER(4) DEFAULT 0,
result    VARCHAR2(4) CHECK(result IN('PASS', 'FAIL')) NOT NULL,
apply     VARCHAR2(4) CHECK(apply IN('YES', 'NO')) NOT NULL,
manager   VARCHAR2(4) CHECK(manager IN('Y', 'N')) NOT NULL
);

INSERT INTO Student (name, std_code, result, apply, manager)
VALUES ('hanul', 1001, 'FAIL', 'NO','N');

INSERT INTO Student (name, std_code, result, apply, manager)
VALUES ('hanul', 1002, 'FAIL', 'NO','N');

INSERT INTO Student (name, std_code, result, apply, manager)
VALUES ('hanul', 1003, 'FAIL', 'NO','N');

INSERT INTO Student (name, std_code, result, apply, manager)
VALUES ('hanul', 1004, 'FAIL', 'NO','N');

INSERT INTO Student (name, std_code, result, apply, manager)
VALUES ('admin', 9999, 'PASS', 'YES', 'Y');

SELECT * FROM student;

--------------------------------------------------------------------------------
--2. Answer table

CREATE TABLE answer (answer   CHAR(1) NOT NULL);

INSERT INTO answer
VALUES (1);
INSERT INTO answer
VALUES (2);
INSERT INTO answer
VALUES (3);
INSERT INTO answer
VALUES (4);
INSERT INTO answer
VALUES (1);
INSERT INTO answer
VALUES (2);
INSERT INTO answer
VALUES (3);
INSERT INTO answer
VALUES (4);
INSERT INTO answer
VALUES (1);
INSERT INTO answer
VALUES (2);

SELECT * FROM answer;

--------------------------------------------------------------------------------
--3. Timer table

CREATE TABLE timer (
minutes   VARCHAR2(3) NOT NULL,
seconds   VARCHAR2(3) NOT NULL
);

INSERT INTO timer
VALUES(5, 0);

SELECT * FROM timer;