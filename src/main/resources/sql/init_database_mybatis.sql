set names utf8;

use mybatis;

-- 1.创建注册用户表
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE auth_user (
   id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
   uid bigint(20) NOT NULL DEFAULT 0,
   username varchar(100) NOT NULL DEFAULT '',
   password varchar(100) NOT NULL DEFAULT '',
   email    varchar(50)  NOT NULL DEFAULT '',
   nickname  varchar(50)  NOT NULL DEFAULT '',
   gender    varchar(10)  NOT NULL DEFAULT '',
   is_active tinyint(2)   DEFAULT 0,
   is_superuser tinyint(2) DEFAULT 0,
   is_locked    tinyint(2) DEFAULT 0,
   create_time  bigint(20) DEFAULT 0,
   update_time  bigint(20) DEFAULT 0,
   role         bigint(20) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 2.创建权限表
DROP TABLE IF EXISTS `auth_permission`;
CREATE TABLE auth_permission (
   id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
   name varchar(100) NOT NULL DEFAULT '' COMMENT '权限名称',
   code varchar(100) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 3. 创建验证码表
DROP TABLE IF EXISTS `auth_identifier`;
CREATE TABLE auth_identifier (
   id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
   uuid varchar(100) NOT NULL DEFAULT '',
   type varchar(20) NOT NULL DEFAULT '' COMMENT '验证码类型 如 Email Phone',
   code varchar(20) NOT NULL DEFAULT '' COMMENT '验证码',
   data varchar(50) NOT NULL DEFAULT '',
   expired  bigint(20) NOT NULL DEFAULT 0
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
