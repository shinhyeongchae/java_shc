-- 학교 데이터베이스를 생성하는 쿼리문
-- create database 학교;
create database if not exists 학교;
-- 학교 데이터베이스를 삭제하는 방법
-- drop database if exists 학교; 
use 학교;
-- table만드는 방법
create table if not exists 학생(
	학생번호 int not null auto_increment,
    이름 char(6) not null,
    primary key(학생번호)                 -- 기본키
);
-- insert into 학생 values('8', '임꺽정'); -- 정수가 들어가야하는곳에 ''에 정수만있으면 있으면 가능
-- insert into 학생 values(3,'이순신'); -- 순서가 잘못되어 에러가 발생 
-- insert into 학생(학생번호, 이름) values( 4, '유관순');
-- insert into 학생(이름, 학생번호) values('세종대왕' ,5);
-- insert into 학생(이름) values('고길동'); -- 학생번호가 없지만 
-- auto_increment를 통해 다음숫자가 자동으로 입력이됨
-- insert into 학생(학생번호) values(7); -- 에러 발생//이름이 없어서 null이 들어가야하는데 이름은 not null로 설정했기 때문에 추가할 수가 없다
SELECT * FROM 학교.학생;
