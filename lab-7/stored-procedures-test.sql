use EmployeesDb;
go

--1
declare
@firstName nvarchar(50),
@lastName nvarchar(50),
@experienceYrs int,
@birthday datetime,
@passport nvarchar(20),
@positionId int,
@statusId int,
@degreeId int
set @firstName = 'firstName'
set @lastName = '@lastName'
set @experienceYrs = 5
set @birthday = '12-01-16 12:32'
set @passport = '@passport'
set @positionId = 1
set @statusId = 2
set @degreeId = 3

exec AddEmployee @firstName, @lastName, @experienceYrs, @birthday, @passport, @positionId, @statusId, @degreeId;

select * from Employees;

--2
declare
@employeeId int,
@subjectId int
set @employeeId = 1
set @subjectId = 1

exec InsertIntoEmployeesToSubject @employeeId, @subjectId;

select * from EmployeesToSubjects;

--3
if cursor_status('global','Table_Cursor')>=-1
begin
 deallocate Table_Cursor
end
exec CreateRandTables;