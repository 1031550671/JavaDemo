--动作表
drop table if exists sports_action;
create table sports_action (
    id serial4 primary key,
    action_type int2 not null,
    action_name varchar(64) not null,
    unit_type int2,
    action_image varchar(255),
    action_video varchar(255),
    create_time timestamp(6),
    update_time timestamp(6)
);
comment on column sports_action.id is '主键id';
comment on column sports_action.action_type is '动作类型(1.热身2.激活3.能量代谢4.抗阻训练5.放松)';
comment on column sports_action.action_name is '动作名称';
comment on column sports_action.unit_type is '单位(1.时间(min)2.次数3.时间(s))';
comment on column sports_action.action_image is '动作图片';
comment on column sports_action.action_video is '视频内容';
comment on column sports_action.create_time is '创建时间';
comment on column sports_action.update_time is '修改时间';
comment on table sports_action is '动作表';
--select setval('sports_action_id_seq',1000);