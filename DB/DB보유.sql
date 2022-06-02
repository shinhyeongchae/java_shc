/*alter table 보유
	add 총점 int not null default 0;*/
-- 중간 40 %, 기말 50 %, 수행 10%를 반영한 점수를 총점에 수정하는 쿼리문
/*update 보유
	set
		총점 = 기말 * 0.5 + 중간 * 0.4 + 수행 * 0.1;*/
-- 1학년 1반 1번 학생의 1학년 1학기 국어 성적을 삭제하는 쿼리문
-- delete from 보유 where 학생번호 = 1 and 성적번호 = 1;
SELECT * FROM score.보유;