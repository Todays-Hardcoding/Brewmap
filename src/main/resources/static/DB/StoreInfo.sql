-- use brewmap;

-- drop table store_info;

-- CREATE TABLE `store_info`
-- (
--     `store_code` VARCHAR(20) NOT NULL COMMENT '술집코드',
--     `store_name` VARCHAR(50) NOT NULL COMMENT '상호',
--     `store_category` VARCHAR(50) NOT NULL COMMENT '술집분류',
--     `store_road_addr` VARCHAR(50) NOT NULL COMMENT '도로명주소',
--     `store_addr` VARCHAR(50) NOT NULL COMMENT '지번주소',
--     `store_tel` VARCHAR(20) NOT NULL COMMENT '전화번호',
--     `store_tag` VARCHAR(100) COMMENT '술집태그',
--     `store_regdate` DATETIME COMMENT '술집등록일',
--     `store_latitude` VARCHAR(50) NOT NULL COMMENT '술집위치_위도',
--     `store_longitude` VARCHAR(50) NOT NULL COMMENT '술집위치_경도',
--     `store_staravg`    FLOAT NOT NULL COMMENT '술집별점평균' default 3.0,
--     PRIMARY KEY ( `store_code` )
-- );

insert into store_info(store_code, store_name, store_category, store_road_addr, store_addr, store_tel, store_tag , store_regdate, store_latitude, store_longitude, store_staravg)
select k.store_code, k.store_name, k.store_category, k.store_addr, k.store_Oldaddr, k.store_tel, s.store_tag, s.store_regdate, k.y, k.x, 0, 0
from store as s
inner join kakao as k 
on s.store_addr = k.store_addr or s.store_name = k.store_name;


select * from store_info order by review_count;

select * from store_info ORDER BY store_name ASC;