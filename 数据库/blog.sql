/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50614
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 50614
 File Encoding         : 65001

 Date: 17/06/2020 00:27:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bloginfo
-- ----------------------------
DROP TABLE IF EXISTS `bloginfo`;
CREATE TABLE `bloginfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(110) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` datetime(0) NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `remark_count` int(11) NOT NULL,
  `like_count` int(11) NOT NULL,
  `scan_count` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `classifyid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bloginfo
-- ----------------------------
INSERT INTO `bloginfo` VALUES (1, 'Java', '2020-05-15 14:04:00', '测试测试测试', 2, 1, 53, 1, 1);
INSERT INTO `bloginfo` VALUES (2, 'C语言', '2020-05-15 14:04:39', '今天开始学习C语言啦', 1, 1, 10, 1, 1);
INSERT INTO `bloginfo` VALUES (4, 'Hadoop', '2020-05-15 14:07:31', 'Hadoop也很重要哦', 0, 0, 4, 1, 2);
INSERT INTO `bloginfo` VALUES (5, '数据结构（1）', '2020-05-15 14:08:04', '数据结构与算法入门', 0, 0, 0, 1, 3);
INSERT INTO `bloginfo` VALUES (6, '数据结构(2)', '2020-05-15 14:08:53', '数据结构域算法进阶', 0, 0, 25, 1, 3);
INSERT INTO `bloginfo` VALUES (7, '全网最全的Java教程', '2020-05-25 11:41:13', 'Java啊啊啊啊啊', 0, 0, 3, 1, 1);
INSERT INTO `bloginfo` VALUES (10, 'Java基础', '2020-05-25 18:40:53', '介绍Java基础知识', 0, 0, 0, 1, 1);
INSERT INTO `bloginfo` VALUES (11, 'Java进阶', '2020-05-25 18:41:36', '介绍Java进阶知识', 28, 0, 31, 1, 1);
INSERT INTO `bloginfo` VALUES (13, '可行性分析', '2020-05-27 00:20:07', '# 技术可行性分析\n因为开发人人员是专业的，所以哒哒哒哒哒\n# 经济可行性\n不要钱，经济上可行\n# 社会可行性\n不犯法，社会因素可行\n[http://www.baidu.com](http://www.baidu.com)\n以下展示一点代码\n    <html>\n    	<body>\n    		<label>我又来测试了，哈哈哈哈</label>\n    	</body>\n    </html>```html\n<html>\n	<label>这个有没有背景呢</label>\n</html>\n```', 0, 0, 1, 1, 8);
INSERT INTO `bloginfo` VALUES (14, 'Java学习新一天', '2020-05-27 00:22:56', '今天又是学习Java的一天', 1, 0, 3, 1, 1);
INSERT INTO `bloginfo` VALUES (15, '啦啦啦啦', '2020-05-28 19:04:16', '# 126521\n是的艺术的意思\n是的语言是', 2, 0, 3, 1, 1);
INSERT INTO `bloginfo` VALUES (16, 'wenzhang1', '2020-05-29 10:58:44', '是的交际第四季度是', 2, 0, 3, 1, 2);
INSERT INTO `bloginfo` VALUES (17, 'Java高阶', '2020-05-29 11:05:04', '# 开始学习啦\n市地税局的健康', 0, 0, 8, 1, 1);
INSERT INTO `bloginfo` VALUES (18, 'Java', '2020-05-29 11:07:26', 'asasasas', 0, 0, 4, 1, 1);
INSERT INTO `bloginfo` VALUES (19, 'Javaxuexi', '2020-05-29 11:19:54', 'Javaxuexi新一天', 0, 0, 2, 1, 1);
INSERT INTO `bloginfo` VALUES (20, 'Java', '2020-05-29 11:26:24', 'xuexixuei', 1, 0, 9, 1, 1);
INSERT INTO `bloginfo` VALUES (22, '测试修改', '2020-05-31 23:57:57', '# 题目\n测试修改\n[http://127.0.0.1:8020/Blog/html/blog-edit.html?blogId=22](http://127.0.0.1:8020/Blog/html/blog-edit.html?blogId=22)\n``121212\n\n    <html>\n    	<body>\n    		<label>ceshi</label>\n    	</body>\n    </html>``\n\n**232323223**\n|  题目 |  测试 |\n| ------12------ | -----1212------- |\n|  啥啥 |  啥啥  |\n| 12121  |  12121 |\n', 1, 1, 66, 1, 5);
INSERT INTO `bloginfo` VALUES (23, 'Java学习', '2020-06-04 20:28:27', '# 题目 \nJava学习\n## 测试一下图片\n![](../userImg/blog/1591273531251_.jpg)\n## 测试一下代码\n```java\npublic Class Test{\n	public Test(){\n		System.out.println();\n	}\n}\n```\n### 测试一下链接\n[博客添加页面](http://127.0.0.1:8020/Blog/html/blog-add.html \"博客添加页面\")\n\n', 0, 0, 22, 2, 10);
INSERT INTO `bloginfo` VALUES (24, '测试', '2020-06-04 20:32:50', '就开始角度看\n![](../userImg/blog/1591273931452_.jpg)\n测试一下\n\n\n', 3, 0, 61, 2, 10);
INSERT INTO `bloginfo` VALUES (25, 'C语言学习', '2020-06-11 01:27:11', '# C语言学习第一天\n今天开始学习C了\n![](../userImg/blog/1591809966270_.jpg)\n    int main(){\n    	printf(\"\");\n    	return 0;\n    }\n## 结束\n学习完毕', 28, 0, 52, 15, 24);
INSERT INTO `bloginfo` VALUES (29, 'C++', '2020-06-12 00:29:14', '# 学习\nC++\n![](../userImg/blog/1591892943719_.jpg)\n\n', 5, 1, 29, 1, 9);
INSERT INTO `bloginfo` VALUES (31, '测试测试', '2020-06-12 07:29:18', '测试\n![](../userImg/blog/1591918141944_.jpg)\n', 2, 1, 17, 1, 1);

-- ----------------------------
-- Table structure for bloglike
-- ----------------------------
DROP TABLE IF EXISTS `bloglike`;
CREATE TABLE `bloglike`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `blogid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bloglike
-- ----------------------------
INSERT INTO `bloglike` VALUES (2, 1, 2);
INSERT INTO `bloglike` VALUES (4, 4, 12);
INSERT INTO `bloglike` VALUES (6, 5, 12);
INSERT INTO `bloglike` VALUES (7, 7, 12);
INSERT INTO `bloglike` VALUES (8, 8, 12);
INSERT INTO `bloglike` VALUES (10, 2, 12);
INSERT INTO `bloglike` VALUES (11, 3, 12);
INSERT INTO `bloglike` VALUES (12, 6, 12);
INSERT INTO `bloglike` VALUES (16, 1, 1);
INSERT INTO `bloglike` VALUES (18, 1, 29);
INSERT INTO `bloglike` VALUES (19, 1, 22);
INSERT INTO `bloglike` VALUES (21, 1, 31);

-- ----------------------------
-- Table structure for classify
-- ----------------------------
DROP TABLE IF EXISTS `classify`;
CREATE TABLE `classify`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of classify
-- ----------------------------
INSERT INTO `classify` VALUES (1, '程序设计语言', '记录我的语言学习之路', 1);
INSERT INTO `classify` VALUES (2, '大数据', '记录大数据的相关知识', 1);
INSERT INTO `classify` VALUES (3, '算法', '记录算法和数据结构的相关知识', 1);
INSERT INTO `classify` VALUES (4, '框架', 'Javaweb程序开发的各种框架', 1);
INSERT INTO `classify` VALUES (5, '计算机基础', '归纳计算机基础知识', 1);
INSERT INTO `classify` VALUES (6, '操作系统', '学习操作系统', 1);
INSERT INTO `classify` VALUES (7, '计算机网络', '计算机网络', 1);
INSERT INTO `classify` VALUES (8, '中文', '', 1);
INSERT INTO `classify` VALUES (9, 'C语言', '2323', 1);
INSERT INTO `classify` VALUES (10, '程序设计语言', '啦啦啦啦啦', 2);
INSERT INTO `classify` VALUES (11, '其他', '', 1);
INSERT INTO `classify` VALUES (12, '其他', NULL, 2);
INSERT INTO `classify` VALUES (13, '其他', NULL, 3);
INSERT INTO `classify` VALUES (14, '其他', NULL, 4);
INSERT INTO `classify` VALUES (15, '其他', NULL, 5);
INSERT INTO `classify` VALUES (16, '其他', NULL, 6);
INSERT INTO `classify` VALUES (17, '其他', NULL, 7);
INSERT INTO `classify` VALUES (18, '其他', NULL, 8);
INSERT INTO `classify` VALUES (19, '其他', NULL, 9);
INSERT INTO `classify` VALUES (20, '其他', NULL, 11);
INSERT INTO `classify` VALUES (21, '其他', NULL, 12);
INSERT INTO `classify` VALUES (22, '其他', NULL, 13);
INSERT INTO `classify` VALUES (23, '其他', NULL, 14);
INSERT INTO `classify` VALUES (24, '其他', NULL, 15);
INSERT INTO `classify` VALUES (26, 'Linux', '', 1);
INSERT INTO `classify` VALUES (27, '类别1', '', 1);
INSERT INTO `classify` VALUES (28, 'SSM', '', 1);
INSERT INTO `classify` VALUES (29, 'Java', '', 1);
INSERT INTO `classify` VALUES (30, 'Test', '', 1);
INSERT INTO `classify` VALUES (31, '测试', '记录系统的各种测试方法', 1);

-- ----------------------------
-- Table structure for friends
-- ----------------------------
DROP TABLE IF EXISTS `friends`;
CREATE TABLE `friends`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fansid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 149 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of friends
-- ----------------------------
INSERT INTO `friends` VALUES (4, 5, 1);
INSERT INTO `friends` VALUES (5, 6, 1);
INSERT INTO `friends` VALUES (6, 7, 1);
INSERT INTO `friends` VALUES (18, 3, 2);
INSERT INTO `friends` VALUES (82, 2, 3);
INSERT INTO `friends` VALUES (83, 2, 4);
INSERT INTO `friends` VALUES (84, 2, 5);
INSERT INTO `friends` VALUES (85, 6, 2);
INSERT INTO `friends` VALUES (86, 7, 2);
INSERT INTO `friends` VALUES (132, 1, 9);
INSERT INTO `friends` VALUES (133, 1, 8);
INSERT INTO `friends` VALUES (134, 1, 10);
INSERT INTO `friends` VALUES (135, 1, 11);
INSERT INTO `friends` VALUES (136, 1, 12);
INSERT INTO `friends` VALUES (137, 1, 13);
INSERT INTO `friends` VALUES (138, 1, 14);
INSERT INTO `friends` VALUES (139, 1, 15);
INSERT INTO `friends` VALUES (145, 1, 2);
INSERT INTO `friends` VALUES (146, 1, 6);
INSERT INTO `friends` VALUES (147, 1, 7);
INSERT INTO `friends` VALUES (148, 1, 5);

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `blogid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for remark
-- ----------------------------
DROP TABLE IF EXISTS `remark`;
CREATE TABLE `remark`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` datetime(0) NOT NULL,
  `attitude` tinyint(4) NOT NULL,
  `userid` int(11) NOT NULL,
  `blogid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 77 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of remark
-- ----------------------------
INSERT INTO `remark` VALUES (1, '写得好', '2020-05-24 00:14:15', 1, 1, 1);
INSERT INTO `remark` VALUES (2, '写的太差了', '2020-05-24 00:14:40', -1, 1, 1);
INSERT INTO `remark` VALUES (3, '写得好', '2020-05-26 15:59:25', 1, 1, 11);
INSERT INTO `remark` VALUES (4, '哈哈哈哈哈哈', '2020-05-26 16:00:39', 1, 1, 11);
INSERT INTO `remark` VALUES (5, '一点用都没有', '2020-05-26 16:01:00', 1, 1, 11);
INSERT INTO `remark` VALUES (6, '写的太差了', '2020-05-26 16:01:31', 1, 1, 11);
INSERT INTO `remark` VALUES (7, '有用', '2020-05-26 16:09:09', 1, 1, 11);
INSERT INTO `remark` VALUES (8, '差劲', '2020-05-26 16:11:21', 1, 1, 11);
INSERT INTO `remark` VALUES (9, '真的没有用', '2020-05-26 17:05:52', 1, 1, 11);
INSERT INTO `remark` VALUES (10, '差劲哟', '2020-05-26 17:10:28', 1, 1, 11);
INSERT INTO `remark` VALUES (11, '太差', '2020-05-26 17:20:20', 1, 1, 11);
INSERT INTO `remark` VALUES (12, '差劲', '2020-05-26 17:29:38', 1, 1, 11);
INSERT INTO `remark` VALUES (13, '写得太差了', '2020-05-26 17:30:18', 1, 1, 11);
INSERT INTO `remark` VALUES (14, '不开心', '2020-05-26 17:32:25', 1, 1, 11);
INSERT INTO `remark` VALUES (15, '难过', '2020-05-26 17:32:36', 1, 1, 11);
INSERT INTO `remark` VALUES (16, '写的太差了', '2020-05-26 17:38:30', 1, 1, 11);
INSERT INTO `remark` VALUES (17, '写得太差了', '2020-05-26 17:40:16', 1, 1, 11);
INSERT INTO `remark` VALUES (18, '哈哈哈哈', '2020-05-26 17:49:14', 1, 1, 11);
INSERT INTO `remark` VALUES (19, '写得太差了', '2020-05-26 17:53:37', -1, 1, 11);
INSERT INTO `remark` VALUES (20, '写的不太好', '2020-05-26 18:06:04', 1, 1, 11);
INSERT INTO `remark` VALUES (21, '我试过了，没有用', '2020-05-26 18:16:12', -1, 1, 11);
INSERT INTO `remark` VALUES (22, '还行', '2020-05-26 18:17:18', 1, 1, 11);
INSERT INTO `remark` VALUES (23, '写的不行', '2020-05-26 18:17:32', -1, 1, 11);
INSERT INTO `remark` VALUES (24, '啦啦啦', '2020-05-26 18:18:12', 1, 1, 11);
INSERT INTO `remark` VALUES (25, '哈哈哈', '2020-05-26 18:18:23', 1, 1, 11);
INSERT INTO `remark` VALUES (26, '啦啦啦', '2020-05-26 18:18:45', 1, 1, 11);
INSERT INTO `remark` VALUES (27, '写得好', '2020-05-26 18:18:58', 1, 1, 11);
INSERT INTO `remark` VALUES (28, '啦啦啦', '2020-05-26 18:20:01', 1, 1, 11);
INSERT INTO `remark` VALUES (29, 'youlaile', '2020-05-26 23:56:04', 1, 1, 11);
INSERT INTO `remark` VALUES (30, '12', '2020-05-26 23:56:13', -1, 1, 11);
INSERT INTO `remark` VALUES (31, '写的差', '2020-05-28 19:01:25', -1, 1, 14);
INSERT INTO `remark` VALUES (32, '测试评论啦啦啦啦', '2020-05-28 19:06:40', 1, 1, 15);
INSERT INTO `remark` VALUES (33, '可以可以额可以额可以可以可以', '2020-05-28 19:08:06', 1, 1, 15);
INSERT INTO `remark` VALUES (34, '写得好', '2020-05-29 10:59:15', 1, 1, 16);
INSERT INTO `remark` VALUES (35, '写得好', '2020-05-29 11:26:57', 1, 1, 20);
INSERT INTO `remark` VALUES (36, '啦啦啦', '2020-06-03 19:45:10', 1, 1, 16);
INSERT INTO `remark` VALUES (37, '写的太好啦', '2020-06-10 20:51:08', 1, 1, 24);
INSERT INTO `remark` VALUES (38, '写的太好啦', '2020-06-10 20:53:34', 1, 1, 24);
INSERT INTO `remark` VALUES (39, '图很好看', '2020-06-10 20:59:21', 1, 1, 24);
INSERT INTO `remark` VALUES (40, '我大致看了一下，用了文中所写的方法，竟然把我的问题解决了，哇~惊喜', '2020-06-11 20:54:05', 1, 1, 25);
INSERT INTO `remark` VALUES (41, '我看了全文，照着文中的方法测试了一下，根本行不通呀！！！', '2020-06-11 21:08:01', 1, 1, 25);
INSERT INTO `remark` VALUES (42, '我照着写了一下，运行不通！行不通！！！！', '2020-06-11 21:09:30', -1, 1, 25);
INSERT INTO `remark` VALUES (43, '啦啦啦啦啦啦啦啦啦啦阿拉啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦了', '2020-06-11 21:20:40', 1, 1, 25);
INSERT INTO `remark` VALUES (44, '运行结果不对呀,博主是不是写错了呀，真的好想不太对哦', '2020-06-11 21:21:30', 1, 1, 25);
INSERT INTO `remark` VALUES (45, '这个不对呀', '2020-06-11 21:22:22', 1, 1, 25);
INSERT INTO `remark` VALUES (46, '我照着写了，运行结果不对呀，真的真的不对呀~', '2020-06-11 21:24:06', 1, 1, 25);
INSERT INTO `remark` VALUES (47, '我照着写了，运行结果不对呀，真的真的不对呀~', '2020-06-11 21:24:53', 1, 1, 25);
INSERT INTO `remark` VALUES (48, '能不能分类对一次，准确率高点行不行', '2020-06-11 21:25:40', -1, 1, 25);
INSERT INTO `remark` VALUES (49, '这次能成功吗', '2020-06-11 21:33:01', 1, 1, 25);
INSERT INTO `remark` VALUES (50, '随便写一下', '2020-06-11 21:33:39', -1, 1, 25);
INSERT INTO `remark` VALUES (51, '写的有点差，我照着写都运行不了', '2020-06-11 21:38:08', 1, 1, 25);
INSERT INTO `remark` VALUES (52, '太差了', '2020-06-11 21:38:39', -1, 1, 25);
INSERT INTO `remark` VALUES (53, '垃圾', '2020-06-11 21:38:49', -1, 1, 25);
INSERT INTO `remark` VALUES (61, '我觉得写的还不够好吧', '2020-06-11 21:44:42', 1, 1, 25);
INSERT INTO `remark` VALUES (62, '我 觉得 写 的 还 不够 好 吧 ', '2020-06-11 21:46:50', 1, 1, 25);
INSERT INTO `remark` VALUES (63, '我觉得写的还不够好吧 ', '2020-06-11 21:47:40', 1, 1, 25);
INSERT INTO `remark` VALUES (64, '运行结果不对呀,博主是不是写错了呀，真的好想不太对哦', '2020-06-11 21:48:04', 1, 1, 25);
INSERT INTO `remark` VALUES (65, '垃圾垃圾真垃圾', '2020-06-11 21:51:24', -1, 1, 25);
INSERT INTO `remark` VALUES (66, '太差了', '2020-06-11 21:51:51', -1, 1, 25);
INSERT INTO `remark` VALUES (67, '写得好', '2020-06-12 00:08:49', 1, 1, 25);
INSERT INTO `remark` VALUES (68, '写的好', '2020-06-12 00:27:37', 1, 1, 1);
INSERT INTO `remark` VALUES (69, '图片很好看', '2020-06-12 01:03:54', 1, 1, 29);
INSERT INTO `remark` VALUES (70, '写的很好哦', '2020-06-12 07:25:27', 1, 1, 29);
INSERT INTO `remark` VALUES (72, '写的差', '2020-06-12 07:26:38', -1, 1, 29);
INSERT INTO `remark` VALUES (73, '写得很差啊', '2020-06-12 07:27:06', -1, 1, 29);
INSERT INTO `remark` VALUES (74, '写的好', '2020-06-12 07:36:41', 1, 1, 22);
INSERT INTO `remark` VALUES (75, '写的好', '2020-06-12 08:24:20', 1, 1, 31);
INSERT INTO `remark` VALUES (76, '写的差', '2020-06-12 09:21:28', -1, 1, 31);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `image` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `registertime` datetime(0) NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'HH', 'FC55CA6C1858CABA1CEB1C608BE00CBB734FA7EC10AF84E826E65DAC', '15182982150', '235672563@qq.com', '../userImg/user/1591924911397_.jpg', '2020-05-15 00:00:00', '哈哈哈哈哈哈哈哈');
INSERT INTO `user` VALUES (2, '张三', '82576A5E6CFF5F742A3D882723F873D8C357CEA24EA38E40E8FEDB80', '1234523', ' ', '../userImg/touxiang.png', '2020-05-15 00:00:00', ' ');
INSERT INTO `user` VALUES (3, '李四', '976F84C90154F887DA2A25128D3DB1D07C6EE042A92103101B1F66E6', '9090910', ' ', '../userImg/touxiang.png', '2020-05-15 00:00:00', ' ');
INSERT INTO `user` VALUES (4, '王二', '6F81DCE31493A5E0E5CBC9633ABA9F759FF62A6B9CFA18441648BFEA', '0817110', ' ', '../userImg/touxiang.png', '2020-05-15 00:00:00', ' ');
INSERT INTO `user` VALUES (5, '李狗蛋', 'FADEC74648F3A6FD533116F4845250D25817F1725CBDE9CC3C9EBA47', '0102389', ' ', '../userImg/touxiang.png', '2020-05-15 00:00:00', ' ');
INSERT INTO `user` VALUES (6, '田二妞', '960C860C0D1BC7DDEC5B363EC5252DF0722F6B0B450C98820F6256EF', '126782367', ' ', '../userImg/touxiang.png', '2020-05-15 00:00:00', ' ');
INSERT INTO `user` VALUES (7, '李铁柱', '1953C5791CEB88971E10CB2CA9EDE70B6C5A25D137E2F0B19B025188', '2367112', ' ', '../userImg/touxiang.png', '2020-05-15 00:00:00', ' ');
INSERT INTO `user` VALUES (8, '郭郭', '0DE3E0D06DD280EC2132C731AA84F8AC6B7DA439ED07A79C953A79E9', '562376712', '', '../userImg/touxiang.png', '2020-05-20 00:00:00', '');
INSERT INTO `user` VALUES (9, 'hsdjasd', 'D06D42B7A4C5ED922C0CAC8708C6ACB33EC22BA1A79204A3F41DE3EB', '1672381890', '', '../userImg/touxiang.png', '2020-05-29 00:00:00', '');
INSERT INTO `user` VALUES (11, 'Chen', 'ED0ED80F8DD8EC0A8A7AC6197488267C445126D72097B190062F4FD3', '15182982151', '', '../userImg/touxiang.png', '2020-06-06 00:00:00', '');
INSERT INTO `user` VALUES (12, 'Wang', 'D142A38090C3A994BAD2A82D6349F94D6C7A443D3185C8440420765C', '13276788732', '', '../userImg/touxiang.png', '2020-06-06 00:00:00', '');
INSERT INTO `user` VALUES (13, '1997', '49BB909F4519EFCF9FA9633B919BB548A22512B60C09EFF6B62C4D39', '15723899823', '', '../userImg/touxiang.png', '2020-06-06 00:00:00', '');
INSERT INTO `user` VALUES (14, '小白', 'E41BEBD13F263A1AF71AFAD42ED0E22C8ADAE9ABC76CEDB799709FFE', '13623678761', '', '../userImg/touxiang.png', '2020-06-06 00:00:00', '');
INSERT INTO `user` VALUES (15, 'XiXi', 'ECCEF81E87DB5890AE2548A819D80E03E1672D3C0E0178EDE26CBA5E', '15623718762', '', '../userImg/user/1591455737846_.jpg', '2020-06-06 00:00:00', '');

SET FOREIGN_KEY_CHECKS = 1;
