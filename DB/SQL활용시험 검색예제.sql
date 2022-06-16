-- 1.학생 정보 추가
insert into student(st_num, st_name)
	values('2022160001','고길동'),('2022160002','홍길동'),('2022135001','유관순'),('2022135002','이순신'),('2022123001','논개'),('2022123002','세종대왕');
insert into professor(pr_num, pr_name)
	values('2022160001','유재석'),('2022135001','강호동'),('2022123001','나영석');
-- 2.교수 정보 추가
insert into professor 
	values('2022160001','유재석'),('2022135001','강호동'),('2022123001','나영석');
-- 3.학생들은 학과 교수님들에게 지도를 받음
update student set st_pr_num ='2022160001' where st_num like '____160___';
update student set st_pr_num = '2022135001'where st_num like '____135___';
update student set st_pr_num = '2022123001'where st_num like '____123___';
-- 4. 강좌 정보 추가
insert into `subject` select 'MSC001', '대학수학기초', pr_num from professor  where pr_name =  '유재석';
insert into `subject` select 'MSC002', '대학영어', pr_num from professor  where pr_name =  '나영석';
insert into `subject` select 'ITC001', '컴퓨터개론', pr_num from professor  where pr_name =  '유재석';
insert into `subject` select 'ITE001', '기초전기', pr_num from professor  where pr_name =  '강호동';
insert into `subject` select 'ITT001', '기초기계', pr_num from professor  where pr_name =  '나영석';
-- 5. 수강 정보 추가
-- 고길동
insert into course(co_st_num, co_su_code) select '2022160001', su_code from `subject` where su_name = '대학수학기초';
insert into course(co_st_num, co_su_code) select '2022160001', su_code from `subject` where su_name = '대학영어';
insert into course(co_st_num, co_su_code) select '2022160001', su_code from `subject` where su_name = '컴퓨터개론';
-- 홍길동
insert into course(co_st_num, co_su_code) select '2022160002', su_code from `subject` where su_name = '대학수학기초';
insert into course(co_st_num, co_su_code) select '2022160002', su_code from `subject` where su_name = '컴퓨터개론';
-- 유관순
insert into course(co_st_num, co_su_code) select '2022135001', su_code from `subject` where su_name = '대학영어';
insert into course(co_st_num, co_su_code) select '2022135001', su_code from `subject` where su_name = '기초전기';
-- 이순신
insert into course(co_st_num, co_su_code) select '2022135002', su_code from `subject` where su_name = '대학수학기초';
insert into course(co_st_num, co_su_code) select '2022135002', su_code from `subject` where su_name = '대학영어';
-- 논개
insert into course(co_st_num, co_su_code) select '2022123001', su_code from `subject` where su_name = '기초기계';
-- 세종대왕
insert into course(co_st_num, co_su_code) select '2022123002', su_code from `subject` where su_name = '대학수학기초';
insert into course(co_st_num, co_su_code) select '2022123002', su_code from `subject` where su_name = '대학영어';
insert into course(co_st_num, co_su_code) select '2022123002', su_code from `subject` where su_name = '기초기계';
-- 6.나영석 교수가 강의하는 강좌명을 조회
select pr_name as 교수명, su_name as 강좌명, su_code as 강좌코드 from subject 
	join professor on su_pr_num = pr_num
    where  pr_name = '나영석';
-- 컴퓨터개론을 수강하는 학생들 이름을 조회
select su_name as 강좌명, st_name as 학생이름 from course
	join subject on co_su_code = su_code
    join student on co_st_num = st_num
    where su_name = '컴퓨터개론';
-- 나영석 교수의 지도 학생 이름을 조회
select pr_name as 교수명, st_name as 학생이름 from `subject` 
	join professor on su_pr_num = pr_num
    join course on co_su_code = su_code
    join student on st_num = co_st_num
	where pr_name = '나영석';
			