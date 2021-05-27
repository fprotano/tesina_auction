
create table auction_order_status(
id int(11) not null primary key 
,title varchar(40) not null
)engine=innodb;

insert into auction_order_status (id,title) values (1,'Creata');
insert into auction_order_status (id,title) values (2,'Verifica pagamento in corso');
insert into auction_order_status (id,title) values (3,'Pagato');
insert into auction_order_status (id,title) values (4,'Rigettato per scadenza tempi');


create table role(
id int(11) not null primary key 
,title varchar(40) not null
)engine=innodb;


insert into role (id,title) values (1,'Amministratore');
insert into role (id,title) values (2,'Help Desk');


create table staff(
id int(11) not null auto_increment primary key 
,created_at datetime not null
,updated_at datetime not null
,email varchar(70) not null unique
,password varchar(255) not null
,name varchar(30) not null
,surname varchar(40) not null
,role_id int(11) not null 
,next_otp_code_after_date datetime not null
,otp_code varchar(10) unique
,otp_code_expires_at datetime
,foreign key (role_id) references role(id)
)engine=innodb;




create table user(
id int(11) not null auto_increment primary key 
,created_at datetime not null
,updated_at datetime not null
,enabled smallint(1) not null default 0
,email varchar(70) not null unique
,password varchar(255) not null
,name varchar(30) not null
,surname varchar(40) not null
,next_otp_code_after_date datetime  not null
,otp_code varchar(10) unique
,otp_code_expires_at datetime
,question varchar(255) not null
,answer varchar(255) not null
)engine=innodb;

create table user_item (
id int(11) not null auto_increment primary key 
,created_at datetime not null
,updated_at datetime not null
,user_id int(11) not null
,title varchar(255) not null
,description text
,notes text
,picture1 varchar(70) 
,picture2 varchar(70) 
,picture3 varchar(70) 
,picture4 varchar(70) 
,picture5 varchar(70) 
,sold_at datetime
,sold_to_user_id int(11)
,foreign key (user_id) references user(id)
,foreign key (sold_to_user_id) references user(id)
)engine=innodb;


create table auction (
id int(11) not null auto_increment primary key 
,created_at datetime not null
,updated_at datetime not null
,user_item_id int(11) not null
,winner_user_id int(11) 
,start_price decimal(11,2) not null
,current_bid decimal(11,2) 
,shipment_extra_price decimal(11,2) 
,min_earn decimal(11,2) 
,free_bid_every_time smallint(1) default 1
,fixed_bid_every_time decimal(11,2) 
,start_auction_at datetime not null 
,end_auction_at datetime not null 
,closed_auction_at datetime 
,foreign key (user_item_id) references user_item(id)
,foreign key (winner_user_id) references user(id)
)engine=innodb;


create table auction_bid (
id int(11) not null auto_increment primary key 
,created_at datetime not null
,auction_id int(11) not null
,user_id int(11) not null
,bid decimal(11,2) not null
,foreign key (auction_id) references auction(id)
,foreign key (user_id) references user(id)
)engine=innodb;

create table auction_order (
id int(11) not null auto_increment primary key 
,created_at datetime not null
,updated_at datetime not null
,order_no int(11) not null
,auction_id int(11) not null
,amount decimal(11,2) not null
,auction_order_status_id int(11) not null
,payment_verify_expires_at datetime
,paid_at datetime
,transaction_id varchar(255)
,foreign key (auction_order_status_id) references auction_order_status(id)
,foreign key (auction_id) references auction(id)
)engine=innodb;

create table auction_order_transaction_log (
id int(11) not null auto_increment primary key 
,created_at datetime not null
,updated_at datetime not null
,auction_order_id int(11) not null
,param_name varchar(255) not null
,param_value varchar(255) not null
,foreign key (auction_order_id) references auction_order(id)
)engine=innodb;


create table invoice (
id int(11) not null auto_increment primary key 
,created_at datetime not null
,invoice_no int(11) not null
,user_id int(11) not null
,auction_order_id int(11) not null
,amount decimal(11,2)
,iva decimal(4,2)
,total decimal(11,2)
,foreign key (auction_order_id) references auction_order(id)
)engine=innodb;




create table help_center(
id int(11) auto_increment not null primary key 
,created_at datetime not null
,updated_at datetime not null
,closed_at datetime 
,user_id int(11) not null 
,question varchar(255) not null
,assigned_to_id int(11) not null
,foreign key (user_id) references user(id)
,foreign key (assigned_to_id) references staff(id)
)engine=innodb;

create table help_center_thread(
id int(11) auto_increment not null primary key 
,created_at datetime not null
,help_center_id int(11) not null 
,question varchar(255) not null
,answer text 
,foreign key (help_center_id) references help_center(id)
)engine=innodb;


