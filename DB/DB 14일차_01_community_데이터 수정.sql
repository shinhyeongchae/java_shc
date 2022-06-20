-- 기존에 likes 테이블에 있는 데이터들로 추천/ 비추천 수 업데이트

update board 
set 
	bd_up = (select 
			count(*) 
		from 
			likes 
		where 
			bd_num = li_target_num
				and li_target= 'board'
                and li_state = 1),
	bd_down = (select 
			  count(*)
		from 
			likes 
		where 
			bd_num = li_target_num 
				and li_target= 'board'
				and li_state = -1);









