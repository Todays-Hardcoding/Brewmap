INSERT INTO `brewmap`.`user` (`user_category`, `user_id`, `user_pw`, `user_name`, `user_tel`, `user_email`, `user_grade`, `user_birth_date`, `user_nick_name`, `user_gender`) VALUES ('user', 'abc', '1234', '홍길동', '010-1234-5678', 'abc@naver.com', '브론즈', '19940714', 'ABCDEF', 0);
INSERT INTO `brewmap`.`user` (`user_category`, `user_id`, `user_pw`, `user_name`, `user_tel`, `user_email`, `user_grade`, `user_birth_date`, `user_nick_name`, `user_gender`) VALUES ('user', 'b', '1235', '길동', '010-1234-5679', 'abcd@naver.com', '브론즈1', '19940715', 'ABCDEF', 0);
INSERT INTO `brewmap`.`user` (`user_category`, `user_id`, `user_pw`, `user_name`, `user_tel`, `user_email`, `user_grade`, `user_birth_date`, `user_nick_name`, `user_gender`) VALUES ('user', 'c', '1236', '홍길', '010-1234-5670', 'abce@naver.com', '브론즈2', '19940716', 'ABCDEF', 0);
INSERT INTO `brewmap`.`user` (`user_category`, `user_id`, `user_pw`, `user_name`, `user_tel`, `user_email`, `user_grade`, `user_birth_date`, `user_nick_name`, `user_gender`) VALUES ('user', 'ab', '1237', '홍동잉', '010-1234-5671', 'abcf@naver.com', '브론즈3', '19940717', 'ABCDEF', 0);
INSERT INTO `brewmap`.`user` (`user_category`, `user_id`, `user_pw`, `user_name`, `user_tel`, `user_email`, `user_grade`, `user_birth_date`, `user_nick_name`, `user_gender`) VALUES ('user', 'bc', '1238', '김동', '010-1234-5672', 'abcg@naver.com', '브론즈4', '19940718', 'ABCDEF', 0);

insert into store_info(store_code, store_name, store_category, store_road_addr, store_addr, store_tel, store_tag , store_regdate, store_latitude, store_longitude, store_staravg)
select k.store_code, k.store_name, k.store_category, k.store_addr, k.store_Oldaddr, k.store_tel, s.store_tag, s.store_regdate, k.y, k.x, 0
from store as s
inner join kakao as k 
on s.store_addr = k.store_addr or s.store_name = k.store_name;

INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 01', '글 내용 01', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 02', '글 내용 02', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 03', '글 내용 03', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 04', '글 내용 04', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 05', '글 내용 05', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 06', '글 내용 06', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 07', '글 내용 07', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 08', '글 내용 08', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 09', '글 내용 09', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 10', '글 내용 10', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 11', '글 내용 11', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 12', '글 내용 12', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 13', '글 내용 13', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 14', '글 내용 14', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 15', '글 내용 15', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 16', '글 내용 16', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 17', '글 내용 17', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 18', '글 내용 18', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 19', '글 내용 19', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 20', '글 내용 20', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 21', '글 내용 21', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 22', '글 내용 22', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 23', '글 내용 23', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 24', '글 내용 24', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 25', '글 내용 25', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 26', '글 내용 26', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 27', '글 내용 27', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 28', '글 내용 28', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 29', '글 내용 29', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 30', '글 내용 30', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 31', '글 내용 31', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 32', '글 내용 32', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 33', '글 내용 33', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 34', '글 내용 34', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 35', '글 내용 35', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 36', '글 내용 36', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 37', '글 내용 37', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 38', '글 내용 38', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 39', '글 내용 39', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 40', '글 내용 40', 'serviceCenter', 0, now(), 'abc');