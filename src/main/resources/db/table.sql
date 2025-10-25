use security_demo;
drop table if exists user;
create table user (
                      id bigint not null PRIMARY KEY AUTO_INCREMENT,
                      username varchar(50) default null unique ,
                      password varchar(100) default null,
                      enable boolean NOT NULL
) engine=innodb default charset=utf8mb4 comment='用户表';

insert into user(username,password,enable)
values ('admin','{bcrypt}$2a$10$GRLdNijSQMUv1/au9ofL.eDwmoohzzS7.rmNSJZ.0Fxo/BTk76klw',TRUE),
       ('mahua','{bcrypt}$2a$10$GRLdNijSQMUv1/au9ofL.eDwmoohzzS7.rmNSJZ.0Fxo/BTk76klw',TRUE),
       ('Leo','{bcrypt}$2a$10$GRLdNijSQMUv1/au9ofL.eDwmoohzzS7.rmNSJZ.0Fxo/BTk76klw',TRUE)