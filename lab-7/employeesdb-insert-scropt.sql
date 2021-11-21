use EmployeesDb;
go

insert into ReceptionForm
values
('form1'), ('form2'), ('form3');

insert into Positions
values
('po1'), ('po2'), ('pos3');

insert into Statuses
values
('st1'), ('st2'), ('st3');

insert into Degrees
values
('deg1'), ('deg2'), ('deg3');

insert into Subjects
values
('sub1', 3, 322, 2),
('sub2', 4, 143, 1),
('sub3', 6, 722, 3);

insert into Employees 
values
('fname1', 'lname1', 1, '1998-12-12', 'pass1', 1, 1, 1),
('fname2', 'lname2', 2, '1998-02-22', 'pass2', 2, 2, 2),
('fname3', 'lname3', 3, '1998-03-13', 'pass3', 3, 3, 3);

insert into EmployeesToSubjects
values
(1, 1),
(2, 2),
(3, 3);
