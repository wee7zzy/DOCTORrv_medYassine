create database doctorrv;
use doctorrv;

create table users(
id int auto_increment primary key,
username varchar(100) not null unique,
email varchar(100) not null,
phone varchar(50) not null
password varchar(50) not null
);

create table medecin(
id int auto_increment primary key,
username varchar(100) not null unique,
email varchar(100) not null,
phone varchar(50) not null
password varchar(50) not null
);


create table appointents(
id int auto_increment primary key,
patient_id int,
doctor_id int,
appointment_date datetime not null,
motif text,
status enum('CONFIRMED', 'CANCELLED', 'PENDING') DEFAULT 'PENDING',
foreign key (patient_id) references users(id),
foreign key (doctor_id) references medecin(id)
);


