INSERT INTO `brewmap`.`user` (`user_category`, `user_id`, `user_pw`, `user_name`, `user_tel`, `user_email`, `user_grade`, `user_birth_date`, `user_nick_name`, `user_gender`) VALUES ('user', 'abc', '1234', '홍길동', '010-1234-5678', 'abc@naver.com', '브론즈', '19940714', 'ABCDEF', 0);
INSERT INTO `brewmap`.`user` (`user_category`, `user_id`, `user_pw`, `user_name`, `user_tel`, `user_email`, `user_grade`, `user_birth_date`, `user_nick_name`, `user_gender`) VALUES ('user', 'b', '1235', '길동', '010-1234-5679', 'abcd@naver.com', '브론즈1', '19940715', 'ABCDEF', 0);
INSERT INTO `brewmap`.`user` (`user_category`, `user_id`, `user_pw`, `user_name`, `user_tel`, `user_email`, `user_grade`, `user_birth_date`, `user_nick_name`, `user_gender`) VALUES ('user', 'c', '1236', '홍길', '010-1234-5670', 'abce@naver.com', '브론즈2', '19940716', 'ABCDEF', 0);
INSERT INTO `brewmap`.`user` (`user_category`, `user_id`, `user_pw`, `user_name`, `user_tel`, `user_email`, `user_grade`, `user_birth_date`, `user_nick_name`, `user_gender`) VALUES ('user', 'ab', '1237', '홍동잉', '010-1234-5671', 'abcf@naver.com', '브론즈3', '19940717', 'ABCDEF', 0);
INSERT INTO `brewmap`.`user` (`user_category`, `user_id`, `user_pw`, `user_name`, `user_tel`, `user_email`, `user_grade`, `user_birth_date`, `user_nick_name`, `user_gender`) VALUES ('user', 'bc', '1238', '김동', '010-1234-5672', 'abcg@naver.com', '브론즈4', '19940718', 'ABCDEF', 0);

insert into store_info(store_code, store_name, store_category, store_road_addr, store_addr, store_tel, store_tag , store_regdate, store_latitude, store_longitude, review_count, store_staravg)
select k.store_code, k.store_name, k.store_category, k.store_addr, k.store_Oldaddr, k.store_tel, s.store_tag, s.store_regdate, k.y, k.x, 0, 0
from store as s
inner join kakao as k 
on s.store_addr = k.store_addr or s.store_name = k.store_name;

INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 01', '글 내용 01', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 02', '글 내용 02', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 03', '글 내용 03', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 04', '글 내용 04', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 05', '글 내용 05', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 06', '글 내용 06', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 07', '글 내용 07', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 08', '글 내용 08', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 09', '글 내용 09', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 10', '글 내용 10', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 11', '글 내용 11', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 12', '글 내용 12', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 13', '글 내용 13', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 14', '글 내용 14', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 15', '글 내용 15', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 16', '글 내용 16', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 17', '글 내용 17', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 18', '글 내용 18', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 19', '글 내용 19', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 20', '글 내용 20', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 21', '글 내용 21', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 22', '글 내용 22', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 23', '글 내용 23', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 24', '글 내용 24', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 25', '글 내용 25', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 26', '글 내용 26', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 27', '글 내용 27', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 28', '글 내용 28', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 29', '글 내용 29', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 30', '글 내용 30', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 31', '글 내용 31', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 32', '글 내용 32', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 33', '글 내용 33', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 34', '글 내용 34', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 35', '글 내용 35', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 36', '글 내용 36', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 37', '글 내용 37', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 38', '글 내용 38', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 39', '글 내용 39', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 40', '글 내용 40', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 41', '글 내용 41', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 42', '글 내용 42', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 43', '글 내용 43', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 44', '글 내용 44', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 45', '글 내용 45', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 46', '글 내용 46', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 47', '글 내용 47', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 48', '글 내용 48', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 49', '글 내용 49', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 50', '글 내용 50', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 51', '글 내용 51', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 52', '글 내용 52', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 53', '글 내용 53', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 54', '글 내용 54', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 55', '글 내용 55', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 56', '글 내용 56', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 57', '글 내용 57', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 58', '글 내용 58', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 59', '글 내용 59', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 60', '글 내용 60', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 61', '글 내용 61', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 62', '글 내용 62', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 63', '글 내용 63', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 64', '글 내용 64', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 65', '글 내용 65', 'recommendStore', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('맛집추천 66', '글 내용 66', 'recommendStore', 0, now(), 'abc');
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
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 41', '글 내용 41', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 42', '글 내용 42', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 43', '글 내용 43', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 44', '글 내용 44', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 45', '글 내용 45', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 46', '글 내용 46', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 47', '글 내용 47', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 48', '글 내용 48', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 49', '글 내용 49', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 50', '글 내용 50', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 51', '글 내용 51', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 52', '글 내용 52', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 53', '글 내용 53', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 54', '글 내용 54', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 55', '글 내용 55', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 56', '글 내용 56', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 57', '글 내용 57', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 58', '글 내용 58', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 59', '글 내용 59', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 60', '글 내용 60', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 61', '글 내용 61', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 62', '글 내용 62', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 63', '글 내용 63', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 64', '글 내용 64', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 65', '글 내용 65', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 66', '글 내용 66', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 67', '글 내용 67', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 68', '글 내용 68', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 69', '글 내용 69', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 70', '글 내용 70', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 71', '글 내용 71', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 72', '글 내용 72', 'serviceCenter', 0, now(), 'abc');
INSERT INTO board (board_title, board_content, board_category, board_like_count, board_date, user_id) VALUES ('고객센터 73', '글 내용 73', 'serviceCenter', 0, now(), 'abc');