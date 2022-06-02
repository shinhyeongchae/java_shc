-- 1970년대 이후에 출생한 사람의 아이디와 이름을 조회
select userID,userName from userTBL where birthYear between 1970 and 1979;
-- birthYear >= 1970;

-- 회원의 키가 180 ~ 182인 사람의 이름과 키를 조회
select userName,height from userTBL where height between 180 and 182;
-- height >= 180 and height <= 182;

-- 지역이 경남이거나 충남이거나 경북인 사람의 이름과 주소를 조회.
select userName,addr from userTBL where addr = '경남' or addr = '충남' or addr = '경북';
select userName,addr from userTBL where addr in('경남','충남','경북');

-- 성이 김씨인 회원의 이름과 키를 조회
select userName,height from userTBL where userName like '김%';

-- 1970년대 출생한 회원의 아이디와 이름을 조회
select userID,userName from userTBL where birthYear between 1970 and 1979;
select userID,userName from userTBL where birthYear >= 1970 and birthYear <=1979;
select userID,userName from userTBL where birthYear like '197_';

-- 2013년에 가입한 회원의 모든 정보를 조회
select * from userTBL where mDate like '2013%';

-- khd 회원이 구매한 제품을 조회
select prodName from buytbl where userID = 'khd';
select prodName from buytbl where userID like 'khd';

-- 회원의 키가 180 ~ 182 인 회원중 경북에 사는 회원 정보를 조회
select * from userTBL where height between 180 and 182 and addr = '경북';


-- 회원의 키가 180미만이거나 182초과인 회원정보를 조회
select * from userTBL where height < 180 or height > 182;
select * from userTBL where !(height between 180 and 182);

-- 회원의 키가 180미만이거나 182초과인 회원 중 경남에 사는 회원 정보를 조회
select * from userTBL where (height < 180 or height > 182) and addr = '경남';

-- 김용만 회원보다 큰 회원정보를 조회(select 안의 select문) 서브쿼리문
select * from userTbl where height > (select height from usertbl where username = '김용만');
-- 주의사항 : 쿼리의 결과 갯수에 따라 동작이 안될 수 도 있다.

-- 경기 지역에 사는 회원 중 가장 큰회원보다 큰 회원 정보를 조회
select * from usertbl where height > all(select height from usertbl where addr = '경기');
-- 경기 지역에 사는 회원 중 가장 작은 회원보다 큰 회원 정보를 조회
select * from usertbl where height > any(select height from usertbl where addr = '경기');

-- khd 회원이 구매한 제품과 동일한 제품을 구매한 회원 정보를 조회
-- =any(서브쿼리)를 in(서브쿼리)로 바꿀 수 있다
select * from buyTBL;
select * from buyTBL where prodName = any(select prodName from buyTBL where userID = 'khd');
select * from buyTBL where prodName in(select prodName from buyTBL where userID = 'khd');

-- khd 회원이 구매한 제품과 동일한 제품을 구매한 회원 아이디만 조회
select userId from buyTBL where userid != 'khd' and prodName = any(select prodName from buyTBL where userID = 'khd');

-- 구매 목록을 userid와 prodname순으로 정렬하여 조회하는 코드
select * from buytbl order by userId asc, prodname asc;
-- asc : 기본값, 오름차순 -- desc : 내림차순

-- distinct  : 동일한 결과가 있을때 중복된 결과를 안보이게 해줌
-- select distinct 속성 from 테이블명 where 조건식;

-- 회원들이 구매한 제품 목록을 조회
select prodName from buytbl; -- 중복된 경우 
select distinct prodName from buytbl;  -- 중복이 되지 않은 경우











