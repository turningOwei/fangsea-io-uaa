drop table if exists fangsea_user_part_permissions;
create table if not exists fangsea_user_part_permissions
(
  id mediumint unsigned auto_increment comment '权限编号'
    primary key,
  create_time  int(10) unsigned not null comment '记录创建时间'
);
ALTER TABLE `fangsea_io`.`fangsea_message_template` COMMENT = '局部权限表';