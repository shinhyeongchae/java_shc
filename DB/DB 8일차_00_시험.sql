drop database if exists university;
create database if not exists university;

drop table if exists professor;
CREATE TABLE professor (
	pr_num  varchar(10),
	pr_name   varchar(10)	NOT NULL,
    primary key(pr_num)
);

drop table if exists `subject`;
CREATE TABLE `subject` (
	su_code  varchar(6),
	su_name   varchar(15)	NOT NULL,
    su_pr_num   varchar(10)	NOT NULL,-- 외래키
    primary key(su_code),
	FOREIGN KEY (su_pr_num) REFERENCES professor (pr_num)
);

drop table if exists student;
CREATE TABLE student (
	st_num   varchar(10),
	st_name   varchar(10)	NOT NULL,
	st_pr_num  varchar(10)	NOT NULL, -- 외래키
    primary key(st_num),
    FOREIGN KEY (st_pr_num) REFERENCES professor (pr_num)
);

drop table if exists course;
CREATE TABLE course (
	co_num    varchar(10),
    co_st_num  		varchar(10) NOT NULL, -- 외래키
	co_su_code   varchar(6) NOT NULL, -- 외래키
    co_mid     	int NOT NULL DEFAULT 0,
    co_final     	int NOT NULL DEFAULT 0,
    co_homework   	int NOT NULL DEFAULT 0,
    co_attendance    	int NOT NULL DEFAULT 0,
    co_total   	int NOT NULL DEFAULT 0,
    primary key(co_num),
    FOREIGN KEY (co_st_num) REFERENCES `student` (st_num),
    FOREIGN KEY (co_su_code) REFERENCES `subject`(su_code)
);

