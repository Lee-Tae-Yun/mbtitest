# ************************************************************
# Sequel Pro SQL dump
# Version 5446
#
# https://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.5.5-10.8.3-MariaDB)
# Database: taeyundb
# Generation Time: 2022-12-23 06:46:00 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table mbtiborad
# ------------------------------------------------------------

DROP TABLE IF EXISTS `mbtiborad`;

CREATE TABLE `mbtiborad` (
  `bid` int(20) NOT NULL AUTO_INCREMENT,
  `uid` varchar(20) DEFAULT NULL,
  `boradtype` varchar(10) DEFAULT NULL,
  `btitle` varchar(50) DEFAULT NULL,
  `borad` varchar(400) DEFAULT NULL,
  `bname` varchar(50) DEFAULT NULL,
  `bdate` varchar(50) DEFAULT NULL,
  `boradview` int(20) DEFAULT NULL,
  PRIMARY KEY (`bid`) USING BTREE,
  KEY `uid` (`uid`) USING BTREE,
  CONSTRAINT `mbtiborad_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `mbtilogin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

LOCK TABLES `mbtiborad` WRITE;
/*!40000 ALTER TABLE `mbtiborad` DISABLE KEYS */;

INSERT INTO `mbtiborad` (`bid`, `uid`, `boradtype`, `btitle`, `borad`, `bname`, `bdate`, `boradview`)
VALUES
	(46,'dlxodbs','MBTI','부트캠프','부트캠프네요','이태윤','2022-12-05 11:35',4),
	(47,'cntnwls','MBTI','교육다녀왔습니다','교육갔다왔어요','추수진','2022-12-05 11:36',6),
	(48,'wjdtmdcks','MBTI','역시 학교가짱이네요','학교짱짱맨','정승찬','2022-12-05 11:36',8),
	(49,'wkdtjddlr','MBTI','취업','취업개굴띠','장성익','2022-12-05 11:39',5),
	(50,'dkswlsgur','MBTI','고양이','캣맘 걸리만 걸려봐라','안진혁','2022-12-05 11:45',6),
	(51,'rlatndla','MBTI','맥날 해방','유플러스 가자구!','김수임','2022-12-05 11:45',5),
	(52,'whgusdk','MBTI','폴짝이','폴짝이 찔빱이','조현아','2022-12-05 11:46',4),
	(53,'rlaalstjr','MBTI','감자감자','감자전','김민석','2022-12-05 11:47',4),
	(54,'rlawlstnr','MBTI','수업 열심히 듣자','집중하자','김진숙','2022-12-05 11:47',6),
	(55,'dhdbrud','MBTI','일본 취업','가자구!','오유경','2022-12-05 11:48',7),
	(56,'dhwlsdn','MBTI','반오십','반오십이다 커커커커','오진우','2022-12-05 11:48',13),
	(57,'dlwnsals','MBTI','알람','알람알람','이준민','2022-12-05 11:49',0),
	(58,'dlgnlwo','MBTI','민석이 탈모','머리카락 그만 흩날려','이휘재','2022-12-05 11:50',1),
	(59,'qorrjsgy','MBTI','자바','전화걸기앱','백건효','2022-12-05 11:50',5),
	(60,'rhdiddl','MBTI','진혁아....제발..','살려만주라 그만 죽여..','고양이','2022-12-05 11:51',6),
	(61,'rlawhdgus','MBTI','인구분포','양정동의 인구분포를 구해보자','김종현','2022-12-05 11:51',0),
	(62,'tjfwogur','MBTI','부트캠프 촬영','부트캠프 촬영중이에욘','설재혁','2022-12-05 11:52',2),
	(63,'whekawls','MBTI','1학년이다','나는 1학년 인데 머리길러야지','조담진','2022-12-05 11:53',6),
	(64,'wjswldnjs','MBTI','우와','어우와','전지원','2022-12-05 11:54',6),
	(65,'gjqhdtlr','MBTI','컴퓨터정보과','많이 지원하세요','허봉식','2022-12-05 12:03',8),
	(66,'thsgmdals','MBTI','8강 가자구!','브라질 이길수있다 꿈은 이뤄진다','손흥민','2022-12-05 12:15',1),
	(67,'whrbtjd','MBTI','인스타 팔로우','감사합니다 8강 가겠습니다.','조규성','2022-12-05 12:16',2),
	(68,'rlaalswo','MBTI','수비만 잘할께요','나는 막자','김민재','2022-12-05 12:17',5),
	(69,'whgusdn','MBTI','나도 경기 뛸래...','저도 경기 뛰고싶어요','조현우','2022-12-05 12:18',1),
	(70,'dlrkddls','MBTI','슛돌이','슛돌이입니다 컹컹','이강인','2022-12-05 12:19',3),
	(71,'text','INFP','테스트','테스트','이태윤','2022-12-05 15:54',2);

/*!40000 ALTER TABLE `mbtiborad` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table mbticomment
# ------------------------------------------------------------

DROP TABLE IF EXISTS `mbticomment`;

CREATE TABLE `mbticomment` (
  `cnum` int(20) NOT NULL AUTO_INCREMENT,
  `uid` varchar(20) DEFAULT NULL,
  `cbid` int(20) DEFAULT NULL,
  `cname` varchar(50) DEFAULT NULL,
  `cmt` varchar(200) DEFAULT NULL,
  `chacter` varchar(10) DEFAULT NULL,
  `cdate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cnum`) USING BTREE,
  KEY `cbid` (`cbid`) USING BTREE,
  CONSTRAINT `mbticomment_ibfk_1` FOREIGN KEY (`cbid`) REFERENCES `mbtiborad` (`bid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

LOCK TABLES `mbticomment` WRITE;
/*!40000 ALTER TABLE `mbticomment` DISABLE KEYS */;

INSERT INTO `mbticomment` (`cnum`, `uid`, `cbid`, `cname`, `cmt`, `chacter`, `cdate`)
VALUES
	(62,'thsgmdals',70,'손흥민','가자가자','MBTI','2022-12-05 12:22'),
	(63,'thsgmdals',67,'손흥민','100만!','MBTI','2022-12-05 12:22'),
	(64,'thsgmdals',47,'손흥민','커커','MBTI','2022-12-05 12:24'),
	(65,'thsgmdals',49,'손흥민','뾰','MBTI','2022-12-05 12:24'),
	(66,'thsgmdals',59,'손흥민','냐','MBTI','2022-12-05 12:24'),
	(67,'thsgmdals',63,'손흥민','화이팅','MBTI','2022-12-05 12:24'),
	(68,'text',71,'이태윤','ㅁㄴㅇㅁㄴㅇㅁㄴㅇ','INFP','2022-12-05 15:54');

/*!40000 ALTER TABLE `mbticomment` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table mbtilogin
# ------------------------------------------------------------

DROP TABLE IF EXISTS `mbtilogin`;

CREATE TABLE `mbtilogin` (
  `id` varchar(20) NOT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `chacter` varchar(10) DEFAULT NULL,
  `udate` date DEFAULT NULL,
  `pNumber` varchar(13) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `filename` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

LOCK TABLES `mbtilogin` WRITE;
/*!40000 ALTER TABLE `mbtilogin` DISABLE KEYS */;

INSERT INTO `mbtilogin` (`id`, `pwd`, `name`, `chacter`, `udate`, `pNumber`, `email`, `gender`, `filename`)
VALUES
	('cntnwls','cntnwls','추수진','MBTI','2022-12-02','010-0000-0000','tnwls@naver.com','남자','INFP.png'),
	('dhdbrud','dhdbrud','오유경','MBTI','2022-12-02','010-0000-0000','dbrud@naver.com','남자','ESFP.png'),
	('dhwlsdn','dhwlsdn','오진우','MBTI','2022-12-01','010-0000-0000','wlsdn@naver.com','남자','ESTJ.png'),
	('dkswlsgur','dkswlsgur','안진혁','MBTI','2022-12-08','010-0000-0000','wlsgur@naver.com','남자','INFJ.png'),
	('dlgnlwo','dlgnlwo','이휘재','MBTI','2022-11-27','010-0000-0000','gnlwo@naver.com','남자','ESTJ.png'),
	('dlrkddls','dlrkddls','이강인','MBTI','2022-11-16','010-0000-0000','rkddls@naver.com','남자','ESFP.png'),
	('dlwnsals','dlwnsals','이준민','MBTI','2022-11-27','010-0000-0000','wnsals@naver.com','남자','INTP.png'),
	('dlxodbs','dlxodbs','이태윤','MBTI','2022-11-27','010-0000-0000','xodbs@naver.com','남자','ESTJ.png'),
	('gjqhdtlr','gjqhdtlr','허봉식','MBTI','2022-11-15','010-0000-0000','qhdtlr@naver.com','남자','isfp.png'),
	('qorrjsgy','qorrjsgy','백건효','MBTI','2022-10-19','010-0000-0000','rjsgy@naver.com','남자','ENTP.png'),
	('rhdiddl','rhdiddl','고양이','MBTI','2022-11-16','010-0000-0000','diddl@naver.com','남자','INFJ.png'),
	('rlaalstjr','rlaalstjr','김민석','MBTI','2020-03-24','010-0000-0000','alstjr@naver.com','남자','ENFJ.png'),
	('rlaalswo','rlaalswo','김민재','MBTI','2022-11-15','010-0000-0000','alswo@naver.com','남자','INTP.png'),
	('rlatndla','rlatndla','김수임','MBTI','2022-12-21','010-0000-0000','tndla@naver.com','남자','INTJ.png'),
	('rlawhdgus','rlawhdgus','김종현','MBTI','2022-12-20','010-0000-0000','whdgus@naver.com','남자','ENFJ.png'),
	('rlawlstnr','rlawlstnr','김진숙','MBTI','2022-11-28','010-0000-0000','wlstnr@naver.com','남자','ESTP.png'),
	('text','text','이태윤','INFP','2022-10-18','010-0000-2111','cmsk@naver.com','남자','chunsik.jpg'),
	('thsgmdals','THSGMDALS','손흥민','MBTI','2022-12-01','010-0000-0000','gmdals@naver.com','남자','ESTJ.png'),
	('tjfwogur','tjfwogur','설재혁','MBTI','2022-12-02','010-0000-0000','wogur@naver.com','남자','INTJ.png'),
	('whekawls','whekawls','조담진','MBTI','2022-11-30','010-0000-0000','ekawls@naver.com','남자','INFJ.png'),
	('whgusdk','whgusdk','조현아','MBTI','2022-12-01','010-0000-0000','gusdk@naver.com','남자','ENTJ.png'),
	('whgusdn','whgusdn','조현우','MBTI','2022-10-26','010-0000-0000','gusdn@naver.com','남자','ENTP.png'),
	('whrbtjd','whrbtjd','조규성','MBTI','2022-12-09','010-0000-0000','whrbtjd@naver.com','남자','ESTP.png'),
	('wjdtmdcks','wjdtmdcks','정승찬','MBTI','2022-12-27','010-0000-0000','tmdcks@naver.com','남자','isfp.png'),
	('wjswldnjs','wjswldnjs','전지원','MBTI','2022-11-23','010-0000-0000','wldnjs@naver.com','남자','ISTJ.png'),
	('wkdtjddlr','wkdtjddlr','장성익','MBTI','2022-11-27','010-0000-0000','tjddlr@naver.com','남자','ESFJ.png');

/*!40000 ALTER TABLE `mbtilogin` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table mbtisns
# ------------------------------------------------------------

DROP TABLE IF EXISTS `mbtisns`;

CREATE TABLE `mbtisns` (
  `sid` int(20) NOT NULL AUTO_INCREMENT,
  `fid` varchar(20) DEFAULT NULL,
  `tid` varchar(20) DEFAULT NULL,
  `stitle` varchar(50) DEFAULT NULL,
  `content` varchar(400) DEFAULT NULL,
  `readCheck` int(10) DEFAULT NULL,
  `sdate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `mbtisns` WRITE;
/*!40000 ALTER TABLE `mbtisns` DISABLE KEYS */;

INSERT INTO `mbtisns` (`sid`, `fid`, `tid`, `stitle`, `content`, `readCheck`, `sdate`)
VALUES
	(1,'dlxodbs','rlaalstjr','감자','감감자자',0,'2022-12-05 12:04'),
	(2,'dlxodbs','dhwlsdn','진진우우','오오진진우우',0,'2022-12-05 12:05'),
	(3,'dlrkddls','thsgmdals','준비됐어 형?','가자구',1,'2022-12-05 12:20'),
	(4,'thsgmdals','dlrkddls','준비됐어!','가자!',1,'2022-12-05 12:22'),
	(5,'text','whekawls','텟트','테스트',1,'2022-12-05 15:56');

/*!40000 ALTER TABLE `mbtisns` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
