-- 각 회원이 구매한 총 개수
-- sum(속성명) :  속성명에 있는 값을 누적함.
-- sum(속성명)이 order by와 같이 사용되면 그룹화한 속성을 기준으로 누적합을 구함
select userid, sum(amount) as 구매량 from buytbl group by userid;

-- 각 회원이 구매한 횟수를 조회
select userid ,count(userID) as '구매 횟수' from buytbl group by userid;
-- 각 제품을 산 회원들의 수
select prodName, count(distinct userid) from buytbl group by prodName;

-- 각 구매 별 구매금액을 조회
select *, price*amount as 구매금액 from buytbl;

-- 회원별 구매 총금액을 조회
select userid, sum(price * amount) as '총 구매 금액' from buytbl group by userid;

-- 회원별 구매 총 금액이 500원 이상인 구매 내역을 조회
select userid, sum(price * amount) as '총 구매 금액'
	from buytbl
    group by userid
	having sum(price *amount) >= 500;
    
select userid, sum(price * amount) as 총구매금액
	from buytbl 
    group by userid
	having 총구매금액 >= 500;

-- 가장 많이 구매한 회원의 아이디를 조회
select userid, sum(price * amount) as 총구매금액 from buytbl 
    group by userid
	order by 총구매금액 desc 
    limit 1;

-- 경남에 사는 회원의 수를 조회하는 쿼리문
select addr, count(userID) from usertbl where addr = '경남';

-- 각 지역에 사는 회원의 수를 조회
select addr, count(userID) as 회원수 from usertbl group by addr;

-- 경남지역에 사는 회원들이 구매한 제품 목록을 조회
select distinct userid, prodname from buytbl where userid = any(select userid from usertbl where addr = '경남');
select distinct userid, prodname from buytbl where userid in(select userid from usertbl where addr = '경남');











