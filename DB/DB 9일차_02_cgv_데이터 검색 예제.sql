use cgv;

-- 송강호가 출연한 영화 제목 리스트를 조회
-- 데이터베이스에 조회할 데이터들이 별로 없을때
select mo_title from movie 
	join appearance on mo_num = ap_mo_num
    join movieman on ap_mm_num = mm_num
    where mm_name = '송강호';
-- 더빠르게 조회할수 있는 쿼리문
select mo_title from movie 
	join appearance on mo_num = ap_mo_num
    join (select * from movieman where mm_name = '송강호') as mm on ap_mm_num = mm_num;
  
-- 고레에다 히로카즈가 감독한 영화 제목 리스트 조회
-- 데이터베이스에 조회할 데이터들이 별로 없을때
select mo_title from movie 
	join (select * from appearance where ap_role = '감독') as ap on mo_num = ap_mo_num
    join (select * from movieman where mm_name = '고레에다 히로카즈') as mm on ap_mm_num = mm_num;
-- 더빠르게 조회할수 있는 쿼리문
select mo_title from movie 
	join appearance on mo_num = ap_mo_num
    join movieman on ap_mm_num = mm_num
    where mm_name = '고레에다 히로카즈';

-- 장르가 드라마인 영화 조회
select mo_title as 영화제목, mo_genre as 장르 from movie where mo_genre = '드라마';
select * from movie where mo_genre like '%드라마%';

-- 6/14 CGV 청주 성안길에서 상영하는 영화 브로커 상영시간표를 조회
select mo_title as 제목, ci_th_name as 영화관, ci_name as 상영관, sc_start_time as 상영시간 from screen
	join movie on sc_mo_num = mo_num -- 영화제목을 위해 join
	join cinema on sc_ci_num = ci_num -- 지점을 위해 join
	where mo_title = '브로커'
		and ci_th_name = 'CGV청주성안길'
		and sc_start_time like '2022-06-14%';

-- 6/14일 CGV 청주 성안길  11:30에 하는 영화 브로커에 예매 가능한 좌석을 표시 
select distinct mo_title as 제목, ci_th_name as 영화관, ci_name as 상영관, sc_start_time as 상영시간, 
	se_name as 좌석명, count(bd_bo_num) as 예약수
	from screen
	join movie on sc_mo_num = mo_num
	join cinema on sc_ci_num = ci_num
    join seat on se_ci_num = ci_num
    left join book on bo_sc_num = sc_num
    left join bookdetail on bo_num = bd_bo_num
	where mo_title = '브로커'
		and ci_th_name = 'CGV청주성안길'
		and sc_start_time like '2022-06-14 11:30:00'
	group by 좌석명
    having count(bd_bo_num) = 0; -- 예약이 안된 좌석들을 표시

-- 브로커를 상영하는 모든 극장들을 조회
select ci_th_name as 극장명, ci_name, ci_type, th_region as 지역명 from screen 
	join movie on sc_mo_num = mo_num -- 내가 한것
	join cinema on sc_ci_num = ci_num
    join theater on ci_th_name = th_name
    where mo_title = '브로커';
select distinct ci_th_name from cinema -- 강사버전
	join screen on sc_ci_num = ci_num
    join movie on mo_num = sc_mo_num
    where mo_title = '브로커';

-- CGV청주성안길에서 상영하는 모든 영화 제목들을 조회
select distinct mo_title from screen 
	join movie on sc_mo_num = mo_num
	join cinema on sc_ci_num = ci_num
    where ci_th_name = 'CGV청주성안길';
select distinct mo_title from cinema -- 강사버전
	join screen on sc_ci_num = ci_num
    join movie on mo_num = sc_mo_num
    where ci_th_name = 'CGV청주성안길';

-- 2022년 6월 14일에 상영하는 모든 영화관과 영화 제목들을 조회
select distinct ci_th_name as 영화관이름, mo_title as 영화제목  from movie
	join screen on mo_num = sc_mo_num
    join cinema on sc_ci_num = ci_num
    where sc_start_time like '2022-06-14%';
select distinct ci_th_name, mo_title from cinema -- 강사버전
	join screen on sc_ci_num = ci_num
    join movie on mo_num = sc_mo_num
    where sc_start_time like '2022-06-14%';

		

    



           
