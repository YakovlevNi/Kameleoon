create sequence hibernate_sequence start 1 increment 1;

 create table quote {
  id integer not null,
  text varchar(255),
  user_id integer,
  primary key (id)
  engine=InnoDB
 };
 create table quote_seq {
 (next_val bigint) engine=InnoDB
 };

  create table user {
  id integer not null,
  activation_code varchar(255),
  login varchar(255) not null,
  mail varchar(255) not null,
  password varchar(255),
  username VARCHAR(255),
  primary key (id)
  engine=InnoDB
 };
  create table user_role {
  user_id integer not null,
  roles varchar(255)
  engine=InnoDB
 };
  create table user_seq {
  (next_val bigint) engine=InnoDB
 };
  insert into user_seq values ( 1 );
  alter table quote add constraint FKmc4aq5ngrmytr53brbl9061md foreign key (user_id) references user (id);
  alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (id);