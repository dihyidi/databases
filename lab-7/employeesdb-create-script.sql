if not exists(select * from sys.databases where name = 'EmployeesDb') 
begin
create database EmployeesDb;
end

go
use EmployeesDb;

drop table if exists ReceptionForm;
drop table if exists Employees;
drop table if exists Subjects;
drop table if exists EmployeesToSubjects;
drop table if exists Positions;
drop table if exists Statuses;
drop table if exists Degrees;

create table ReceptionForm 
(
	Id int identity primary key,
	Name nvarchar(50) not null unique
);

create table Subjects 
(
	Id int identity primary key,
	Name nvarchar(50) not null,
	Semester int not null,
	Code int not null unique,
	ReceptionFormId int not null
);

create table Employees 
(
	Id int identity primary key,
	FirstName nvarchar(50) not null,
	LastName nvarchar(50) not null,
	ExperienceYrs int not null,
	Birthday datetime not null,
	Passport nvarchar(20) not null unique,
	PositionId int not null,
	StatusId int not null,
	DegreeId int not null,
);

create table EmployeesToSubjects 
(
	EmployeeId int not null,
	SubjectId int not null,
	primary key(EmployeeId, SubjectId)
);

create table Positions 
(
	Id int identity primary key,
	Name nvarchar(50) not null unique
);

create table Statuses 
(
	Id int identity primary key,
	Name nvarchar(50) not null unique
);

create table Degrees 
(
	Id int identity primary key,
	Name nvarchar(50) not null unique
);

create table EmployeesJournal 
(
	Id int identity primary key,
	EmployeeId int not null unique,
	WhenInserted datetime not null
);
