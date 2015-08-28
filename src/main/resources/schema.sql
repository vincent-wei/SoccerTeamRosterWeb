DROP TABLE PLAYER IF EXISTS;
DROP TABLE SALARY IF EXISTS;
DROP TABLE STATISTIC IF EXISTS;

create table PLAYER (
	id identity,
	countryOfBirth varchar(20) not null,
	age int(3) not null,
	firstName varchar(20) not null,
	lastName varchar(30) not null,
	field_position varchar(10) not null
);

create table SALARY (
	id identity,
	amount int(10) not null,
	player_id int not null,
        foreign key (player_id) references PLAYER(id)
);

create table STATISTIC(
	id identity,
	numOfBookings int(10) not null,
	numOfGoals int(10) not null,
	player_id int not null,
        foreign key (player_id) references PLAYER(id)
);


