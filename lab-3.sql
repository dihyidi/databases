create database if not exists koval;
use koval;

drop table if exists patient_diagnosis;
drop table if exists visit;
drop table if exists doctor_schedule;
drop table if exists doctor;
drop table if exists work_schedule;
drop table if exists patient;
drop table if exists diagnosis;
drop table if exists specialization;
drop table if exists work_time;
drop table if exists work_day;

create table specialization (
id bigint auto_increment primary key,
name nvarchar(50) not null);

create table doctor (
id bigint auto_increment primary key,
name nvarchar(50) not null,
experience_yrs int not null,
specialization_id bigint not null);

create table work_day (
id int auto_increment primary key,
name nvarchar(10) not null);

create table work_time (
id bigint auto_increment primary key,
start_time time not null,
end_time time not null);

create table work_schedule (
work_day_id int not null,
work_time_id bigint not null,
primary key(work_day_id, work_time_id));

create table doctor_schedule (
doctor_id bigint not null,
work_day_id int not null,
work_time_id bigint not null);

create table patient (
id bigint auto_increment primary key,
name nvarchar(50) not null,
surname nvarchar(50) not null,
birthday date not null,
address nvarchar(1000) not null);

create table diagnosis (
id bigint auto_increment primary key,
name nvarchar(50) not null,
protocol nvarchar(1000) not null);

create table visit (
id bigint auto_increment primary key,
patient_id bigint not null,
doctor_id bigint not null,
date datetime not null,
price decimal not null);

create table patient_diagnosis (
diagnosis_id bigint not null,
patient_id bigint not null,
primary key(diagnosis_id, patient_id));

alter table doctor
add constraint FK_doctor_specialization foreign key (specialization_id) references specialization (id);

alter table work_schedule
add constraint FK_work_schedule_work_day foreign key (work_day_id) references work_day (id),
add constraint FK_work_schedule_work_time foreign key (work_time_id) references work_time (id);

alter table doctor_schedule
add constraint FK_doctor_schedule_work_schedule foreign key (work_day_id, work_time_id) references work_schedule (work_day_id, work_time_id),
add constraint FK_doctor_schedule_doctor foreign key (doctor_id) references doctor (id);

alter table visit
add constraint FK_visit_patient foreign key (patient_id) references patient (id),
add constraint FK_visit_doctor foreign key (doctor_id) references doctor (id);

alter table patient_diagnosis
add constraint FK_patient_diagnosis_diagnosis foreign key (diagnosis_id) references diagnosis (id),
add constraint FK_patient_diagnosis_patient foreign key (patient_id) references patient (id);

create index name_surname on patient(name, surname);
create index diagnosis on patient_diagnosis(diagnosis_id);

insert into specialization (name) values
('specialization-1'),
('specialization-2'),
('specialization-3'),
('specialization-4'),
('specialization-5'),
('specialization-6');

insert into doctor (name, experience_yrs, specialization_id) values
('doctor-1', 10, 1),
('doctor-2', 7, 2),
('doctor-3', 12, 3),
('doctor-4', 45, 4),
('doctor-5', 1, 5),
('doctor-6', 39, 6);

insert into work_day (name) values
('monday'),
('tuesday'),
('wednesday'),
('thursday'),
('friday'),
('saturday');

insert into work_time (start_time, end_time) values
('10:00:00', '14:00:00'),
('12:00:00', '16:00:00'),
('9:00:00', '13:00:00'),
('8:00:00', '12:00:00'),
('14:00:00', '18:00:00'),
('11:00:00', '15:00:00');

insert into work_schedule (work_day_id, work_time_id) values
(1, 4),
(2, 3),
(5, 1),
(6, 2),
(3, 5),
(4, 6);

insert into doctor_schedule (doctor_id, work_day_id, work_time_id) values
(2, 1, 4),
(5, 2, 3),
(1, 5, 1),
(3, 6, 2),
(4, 3, 5),
(6, 4, 6);

insert into patient (name, surname, birthday, address) values
('name-1', 'surname-1', '2001-01-01', 'address-1'),
('name-2', 'surname-2', '2002-02-02', 'address-2'),
('name-3', 'surname-3', '2003-03-03', 'address-3'),
('name-4', 'surname-4', '2004-04-04', 'address-4'),
('name-5', 'surname-5', '2005-05-05', 'address-5'),
('name-6', 'surname-6', '2006-06-06', 'address-6');

insert into diagnosis (name, protocol) values
('name-1', 'protocol-1'),
('name-2', 'protocol-2'),
('name-3', 'protocol-3'),
('name-4', 'protocol-4'),
('name-5', 'protocol-5'),
('name-6', 'protocol-6');

insert into visit (patient_id, doctor_id, date, price) values
(1, 2, '2020-01-02', 100.00),
(3, 4, '2020-03-04', 400.00),
(2, 6, '2020-02-06', 200.00),
(4, 5, '2020-04-05', 500.00),
(5, 1, '2020-05-01', 300.00),
(6, 3, '2020-06-03', 600.00);

insert into patient_diagnosis (diagnosis_id, patient_id) values
(2, 3),
(1, 6),
(3, 5),
(4, 1),
(5, 2),
(6, 4);