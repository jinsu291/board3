# DB 생성
DROP DATABASE IF EXISTS board3;
CREATE DATABASE board3;
USE board3;

# 게시물 테이블 생성
CREATE TABLE article (
                         id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                         PRIMARY KEY(id),
                         createDate DATETIME NOT NULL,
                         modifyDate DATETIME NOT NULL,
                         `subject` CHAR(100) NOT NULL,
                         content LONGTEXT NOT NULL
);

# 게시물 데이터
INSERT INTO article
SET createDate = NOW(),
modifyDate = NOW(),
`subject` = '제목1',
content = '내용1';

INSERT INTO article
SET createDate = NOW(),
modifyDate = NOW(),
`subject` = '제목2',
content = '내용2';