drop database if exists shoppingmall;
create database if not exists shoppingmall;
use shoppingmall;

drop table if exists `user`;
 CREATE TABLE if not exists `user` (
	`us_id`	varchar(20)	NOT NULL,
	`us_pw`	varchar(16)	NULL,
	`us_birth`	date	NULL,
	`us_address`	varchar(100)	NULL,
	`us_authority`	varchar(5)	NULL
);
drop table if exists `product`;
CREATE TABLE if not exists `product` (
	`pr_code`	char(6)	NOT NULL,
	`pr_title`	varchar(30)	NULL,
	`pr_detail`	longtext	NULL,
	`pr_price`	int	NULL,
	`pr_type`	varchar(10)	NULL
);
drop table if exists  `option`;
CREATE TABLE `option` (
	`op_num`	int	NOT NULL auto_increment,
	`op_size`	varchar(10)	NULL,
	`op_amount`	int	NULL,
	`op_pr_code`	char(6)	NOT NULL,
    primary key(op_num)
);
drop table if exists `buy`;
CREATE TABLE `buy` (
	`bu_num`	int	NOT NULL auto_increment,
	`bu_address`	varchar(100)	NULL,
	`bu_us_id`	varchar(20)	NOT NULL,
	`bu_op_num`	int	NOT NULL,
     primary key(bu_num)
);

ALTER TABLE `user` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
	`us_id`
);

ALTER TABLE `product` ADD CONSTRAINT `PK_PRODUCT` PRIMARY KEY (
	`pr_code`
);

ALTER TABLE `option` ADD CONSTRAINT `FK_product_TO_option_1` FOREIGN KEY (
	`op_pr_code`
)
REFERENCES `product` (
	`pr_code`
);

ALTER TABLE `buy` ADD CONSTRAINT `FK_user_TO_buy_1` FOREIGN KEY (
	`bu_us_id`
)
REFERENCES `user` (
	`us_id`
);

ALTER TABLE `buy` ADD CONSTRAINT `FK_option_TO_buy_1` FOREIGN KEY (
	`bu_op_num`
)
REFERENCES `option` (
	`op_num`
);
--  관리자 정보를 등록하는 쿼리를 작성, 단 주소는 null, 생일도 null
insert into user(us_id, us_pw, us_authority) values('admin','damin','ADMIN');
-- 관리자가 다음 제품을 등록
-- 코드 : ABC001, 분류 : 상의, 제품명 : 셔츠, 상세 : 셔츠입니다.
-- 크기 : xs , 수량 : 10,
-- 크기 : s, 수량 : 10,
-- 크기 : m, 수량 : 10,
-- 크기 : l, 수량 : 10,
-- 크기 : xl, 수량 : 10,

insert into product(pr_code, pr_type, pr_title, pr_detail, pr_price)
	values('ABC001', '상의', '셔츠', '셔츠입니다', 10000); 
insert into `option`(op_size, op_amount, op_pr_code) values
	('xs','10','ABC001'),
	('s','10','ABC001'),
	('m','10','ABC001'),
	('l','10','ABC001'),
	('xl','10','ABC001');

-- id가 abc123, 비번 abc123, 주소가 청주시, 생일 2000-01-01인 회원이 회원가입을 했다.
alter table user 
	change us_authority us_authority varchar(5) not null default 'user';
 
insert into user(us_id, us_pw, us_address, us_birth) 
	values('abc123', 'abc123', '청주시', '2000-01-01');
-- abc123 회원이 ABC001 제품 xl 를 구매했을 때 필요한 쿼리문을 작성
-- 구매시 입력한 주소는 청주시 
insert into buy(bu_us_id, bu_op_num, bu_address)
	select 'abc123', op_num, '청주시' from `option`
		where op_pr_code = 'ABC001' and op_size = 'xl';
-- values('abc123','청주시','abc123','1');

-- 추가도 하고 재고량도 맞춰야하기 때문에 update를 사용 
-- 데이터의 일관성
-- update 재고량
update `option` set op_amount = op_amount - 1 
	where op_pr_code = 'ABC001' and op_size = 'xl';

-- 관리자가 다음 제품을 등록
-- 코드 : DEF001, 분류 : 신발, 제품명 : 신상운동화 , 상세 : 신상운동화입니다 .가격 : 20000원
-- 크기 : 220, 수량 : 10
-- 크기 : 230, 수량 : 10
-- 크기 : 240, 수량 : 10
-- 크기 : 250, 수량 : 10
-- 크기 : 260, 수량 : 10

insert into product(pr_code, pr_type, pr_title, pr_detail, pr_price)
	values('DEF001', '신발', '신상운동화', '신상운동화입니다', 20000); 
insert into `option`(op_size, op_amount, op_pr_code) values
	('220','10','DEF001'),
	('230','10','DEF001'),
	('240','10','DEF001'),
	('250','10','DEF001'),
	('260','10','DEF001');

-- abc123회원이 DEF001 제품을 220과 260을 구매했다.
-- 구매시 주소는 청주시
insert into buy(bu_us_id, bu_op_num, bu_address)
	select 'abc123', op_num, '청주시' from `option`
		where op_pr_code = 'DEF001' and (op_size = '220' or op_size = '260');
 /*insert into buy(bu_us_id, bu_op_num, bu_address)
	select 'abc123', op_num, '청주시' from `option`
		where op_pr_code = 'DEF001' and op_size in ('220','260');  */
			
-- update 재고량
update `option` set op_amount = op_amount - 1 
	where op_pr_code = 'DEF001' and  op_size in ('220','260');
    
-- abc 회원의 누적 구매액
select bu_us_id as 회원ID , sum(pr_price) as 누적금액 from buy 
	join `option` on op_num = bu_op_num
	join  product on pr_code = op_pr_code
	where bu_us_id = 'abc123';
-- 속도를 줄여주는 코드
select bu_us_id as 회원ID , sum(pr_price) as 누적금액 
	from (select * from buy where bu_us_id = 'abc123') as tmp
	join `option` on op_num = bu_op_num
	join  product on pr_code = op_pr_code;

-- 각 제품별 구매 횟수를 조회(동일 회원 구매도 포함)
select op_pr_code as 제품, count(bu_num) as 구매횟수 from buy 
	right join `option` on bu_op_num = op_num
	group by op_pr_code;
    
-- 모든 제품에 대해 각 제품별, 옵션별 구매 횟수를 조회(동일 회원 구매도 포함)
select op_pr_code as 제품코드 , op_size as 옵션 , count(bu_num) as 구매횟수 
	from `option`
	left join buy on op_num = bu_op_num
    group by op_num;

-- 제품코드가 ABC001인 제품 정보를 조회(제품코드, 제품명, 제품분류, 가격, 구매가능한 사이즈)
select * from product
	join `option` on op_pr_code = pr_code
	where op_pr_code = 'ABC001' and op_amount > 0;

-- abc123 회원이 구매한 제품명 조회(중복x)
select pr_title as 제품명 from buy 
	join `option` on op_num = bu_op_num
	join  product on pr_code = op_pr_code
	where bu_us_id = 'abc123'
    group by pr_code;  -- 제품명이 같을경우 distinct보다는 group by를 통하는게 좋다.

-- 2000년생 회원들의 구매 제품 목록을 조회
select distinct op_pr_code from buy 
	join `option` on op_num = bu_op_num
	join  user on bu_us_id = us_id
	where us_birth between '2000-01-01' and '2000-12-31';
   
    
    
    
    

