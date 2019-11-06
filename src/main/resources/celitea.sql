CREATE DATABASE IF NOT EXISTS celitea;
USE celitea;
CREATE TABLE IF NOT EXISTS `alliance_member`
(
    `id`              INT AUTO_INCREMENT COMMENT '主键',
    `student_id`      VARCHAR(64)  NOT NULL COMMENT '学号',
    `name`            VARCHAR(64)  NOT NULL COMMENT '姓名',
    `sex`             tinyint      NOT NULL COMMENT '性别:1男 2女',
    `birth_date`      VARCHAR(32)  NULL COMMENT '出生年月',
    `admission_year`  VARCHAR(16)  NULL COMMENT '入学年份',
    `graduation_year` VARCHAR(16)  NULL COMMENT '毕业年份',
    `major`           VARCHAR(64)  NULL COMMENT '主修专业',
    `hometown`        VARCHAR(128) NULL COMMENT '家乡',
    `current_address` VARCHAR(256) NULL COMMENT '现居城市',
    `company`         VARCHAR(256) NULL COMMENT '公司',
    `phone`           VARCHAR(16)  NULL COMMENT '手机号',
    `mail`            VARCHAR(32)  NULL COMMENT '邮箱地址',
    `blog_address`    VARCHAR(256) NULL COMMENT '博客地址',
    `create_time`     TIMESTAMP    NOT NULL COMMENT '创建时间',
    `update_time`     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id),
    UNIQUE INDEX uk_student_id (student_id)
) DEFAULT CHARSET = utf8 COMMENT '社团成员报名表';

