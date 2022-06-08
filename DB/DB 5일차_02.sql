use score;
-- 각 학생들의 성적을 조회
-- inner join을 이용해서 모든 학생들의 성적을 조회할 수 없다 => 아직 성적이 등록이 안된 학생들이 있을 수 있어서
-- inner join은 성적이 등록된(보유) 학생들만 조회 가능
select * from 보유
	join 학생 on 학생.학생번호 = 보유.학생번호
    join 성적 on 보유.성적번호 = 성적.성적번호;
	
-- outer join을 이용하면 성적이 아직 등록되지 않은 학생도 조회할 수 있다
select * from 학생 
	left join 보유 on 학생.학생번호 = 보유.학생번호
    left join 성적 on 보유.성적번호 = 성적.성적번호;

select 학생.*,보유.*,성적.* from 보유
	right join 학생 on 학생.학생번호 = 보유.학생번호
    left join 성적 on 보유.성적번호 = 성적.성적번호;

use 대학생;
-- 강좌코드가 MSC003인 이산수학을 2022160001 교수님이 강의 
INSERT INTO `대학생`.`강좌` (`강좌코드`, `강좌명`, `교번`) VALUES ('MSC003', '이산수학', '2022160001');

-- 각 강좌에 수강생 수를 조회 
select 강좌명,count(수강.학번) from 수강 
	right join 강좌 on 수강.강좌코드 = 강좌.강좌코드
	group by 수강.강좌코드;
	
-- ======================================================
use green;
SELECT 직원.이름, 직원.직급, 직속상사.이름 as 직속상사 FROM green.직원
		left join 직원 직속상사 on 직속상사.사번 = 직원.직속상사;    
-- ======================================================






    