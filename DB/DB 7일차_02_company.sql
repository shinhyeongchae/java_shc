-- 홍길동 직원의 월급 내역서를 조회
select em_num, em_name, pa_salary, pa_date from pay
	join employee on pa_em_num = em_num
	where em_name = '홍길동';
-- 개발부 직원 명단을 조회
select em_name from employee where em_de_name = '개발부';

-- 테이블안의 정보들을 초기화 하는 쿼리
truncate table pay;

-- 회사내의 모든 차장 사번과 이름을 조회
select * from employee;
select em_num as 사번, em_name as 이름 from employee
	where em_rn_name = '차장';
    
 -- 월급이 300이상인 직원들 이름을 조회
 select distinct em_name from pay 
	join employee on em_num = pa_em_num
    where pa_salary >= 300;
    
select pa_em_num, em_name, max(pa_salary) as 월급 from pay 
	join employee on em_num = pa_em_num
	group by pa_em_num
	having max(pa_salary) >= 300;

-- 직급별 인원수를 조회
select rn_name as 직급 , count(em_num) as 인원수 from `rank` 
	left join employee on em_rn_name = rn_name
	group by rn_name;
    
    
    
    