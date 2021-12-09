--------------------------------------------------------------------------------
--1. Student table

CREATE TABLE student_a (
name      VARCHAR2(20) NOT NULL,
std_code  NUMBER PRIMARY KEY,
score     NUMBER(4) DEFAULT 0,
result    VARCHAR2(4) CHECK(result IN('PASS', 'FAIL')) NOT NULL,
apply     VARCHAR2(4) CHECK(apply IN('YES', 'NO')) NOT NULL,
manager   VARCHAR2(4) CHECK(manager IN('Y', 'N')) NOT NULL
);

INSERT INTO student_a (name, std_code, result, apply, manager)
VALUES ('seonguk', 1001, 'FAIL', 'NO','N');

INSERT INTO student_a (name, std_code, result, apply, manager)
VALUES ('jooun', 1002, 'FAIL', 'NO','N');

INSERT INTO student_a (name, std_code, result, apply, manager)
VALUES ('jikang', 1003, 'FAIL', 'NO','N');

INSERT INTO student_a (name, std_code, result, apply, manager)
VALUES ('geontea', 1004, 'FAIL', 'NO','N');

INSERT INTO student_a (name, std_code, result, apply, manager)
VALUES ('myoungun', 9999, 'PASS', 'YES', 'Y');

SELECT * FROM student_a;

--------------------------------------------------------------------------------
--2. Answer table

CREATE TABLE answer_a (answer NUMBER NOT NULL);

INSERT INTO answer_a
VALUES (1);
INSERT INTO answer_a
VALUES (2);
INSERT INTO answer_a
VALUES (3);
INSERT INTO answer_a
VALUES (4);
INSERT INTO answer_a
VALUES (1);
INSERT INTO answer_a
VALUES (2);
INSERT INTO answer_a
VALUES (3);
INSERT INTO answer_a
VALUES (4);
INSERT INTO answer_a
VALUES (1);
INSERT INTO answer_a
VALUES (2);

SELECT * FROM answer_a;

--------------------------------------------------------------------------------
--3. Timer table

CREATE TABLE timer_a (
minutes   NUMBER NOT NULL,
seconds   NUMBER NOT NULL
);

INSERT INTO timer_a
VALUES(5, 0);

SELECT * FROM timer_a;

commit;
