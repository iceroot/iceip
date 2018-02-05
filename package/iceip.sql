# Host: 127.0.0.1  (Version: 5.5.53)
# Date: 2018-02-05 16:48:13
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "iceip"
#

DROP TABLE IF EXISTS `iceip`;
CREATE TABLE `iceip` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `hostname` varchar(50) DEFAULT NULL COMMENT 'hostname',
  `ip` varchar(50) DEFAULT NULL COMMENT 'ip',
  `groupx` int(11) DEFAULT NULL COMMENT '分组',
  `client_time` varchar(50) DEFAULT NULL COMMENT '客户端时间',
  `server_time` varchar(50) DEFAULT NULL COMMENT '服务端时间',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `client_ip` varchar(50) DEFAULT NULL COMMENT '客户端ip',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1018 DEFAULT CHARSET=utf8;

#
# Data for table "iceip"
#

/*!40000 ALTER TABLE `iceip` DISABLE KEYS */;
INSERT INTO `iceip` VALUES (1001,'localhost','127.0.0.1',0,NULL,NULL,NULL,NULL,NULL),(1002,'localhost','127.0.0.1',0,NULL,NULL,NULL,NULL,NULL),(1003,'localhost','127.0.0.1',0,'2010-12-23 13:46:57','2018-02-03 20:18:45',NULL,NULL,NULL),(1004,'localhost','127.0.0.1',0,'2010-12-23 13:46:57','2018-02-03 20:20:50','username','password','clientIp'),(1005,'hostname','192.168.123.122',1,'2018-02-03 20:43:09','2018-02-03 20:44:32','username','password','127.0.0.1'),(1006,'hostname','192.168.123.123',1,'2018-02-03 20:43:09','2018-02-03 20:46:36','username','password','127.0.0.1'),(1008,'hostname','192.168.111.111',-1,'2018-02-03 20:43:09','2018-02-03 20:52:35',NULL,NULL,'127.0.0.1'),(1009,'node1','192.168.1.101',1,'2018-02-04 20:39:23','2018-02-04 20:39:23','zs','testpwd','127.0.0.1'),(1010,'node2','192.168.2.102',1,'2018-02-04 20:38:13','2018-02-04 20:38:13','zs','testpwd','127.0.0.1'),(1011,'node3','192.168.1.103',1,'2018-02-04 20:35:39','2018-02-04 20:35:39','zs','testpwd','127.0.0.1'),(1012,'node4','192.168.1.104',1,'2018-02-04 20:41:29','2018-02-04 20:41:29','zs','testpwd','127.0.0.1'),(1013,'node5','192.168.1.105',1,'2018-02-04 21:00:56','2018-02-04 21:00:56','zs','testpwd','127.0.0.1'),(1014,'node6','192.168.1.106',1,'2018-02-04 21:02:13','2018-02-04 21:02:13','zs','testpwd','127.0.0.1'),(1015,'node7','192.168.1.107',1,'2018-02-04 21:04:20','2018-02-04 21:04:21','zs','testpwd','127.0.0.1'),(1016,'node8','192.168.1.108',1,'2018-02-04 21:09:16','2018-02-04 21:09:17','zs','testpwd','127.0.0.1'),(1017,'node1','192.168.3.102',1,'2018-02-04 21:23:01','2018-02-04 21:23:02','zs','testpwd','127.0.0.1'),(1018,'node1','192.168.5.102',1,'2018-02-05 16:36:19','2018-02-05 16:36:19','zs','testpwd','127.0.0.1'),(1019,'node1','192.168.1.102',1,'2018-02-05 16:37:11','2018-02-05 16:37:11','zs','testpwd','127.0.0.1');
/*!40000 ALTER TABLE `iceip` ENABLE KEYS */;
