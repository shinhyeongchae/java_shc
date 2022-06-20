-- 상영 영화 예매 가능 좌석 수로 업데이트하는 쿼리문

update screen 
set 
	sc_pos_seat = (select ci_max_seat
		from
			cinema
		where 
			sc_ci_num = ci_num) - (select 
			ifnull(sum(bo_amount),0) 
		from 
			book 
		where 
			sc_num = bo_sc_num and bo_state = 'Y');
SELECT * FROM cgv.screen;