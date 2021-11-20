use EmployeesDb;
go

-- 1 
drop procedure if exists dbo.AddEmployee
go
create proc AddEmployee
@firstName nvarchar(50),
@lastName nvarchar(50),
@experienceYrs int,
@birthday datetime,
@passport nvarchar(20),
@positionId int,
@statusId int,
@degreeId int
as
begin
insert into Employees(FirstName, LastName, ExperienceYrs, Birthday, Passport, PositionId, StatusId, DegreeId)
values(@firstName, @lastName, @experienceYrs, @birthday, @passport, @positionId, @statusId, @degreeId)
end

go
-- 2
drop procedure if exists dbo.InsertIntoEmployeesToSubject
go
create proc InsertIntoEmployeesToSubject
@employeeId int,
@subjectId int
as
begin
if exists (select * from Employees where Id = @employeeId)
if exists (select * from Subjects where Id = @subjectId)
insert into EmployeesToSubjects(EmployeeId, SubjectId)
values(@employeeId, @subjectId)
end

go
-- 3
drop procedure if exists dbo.CreateRandTables
go
create proc CreateRandTables
as
begin
declare @firstName nvarchar(50), @lastName nvarchar(50), @tableName nvarchar(50), @sqlString nvarchar(max), @idx int, @tableCount int;
declare Table_Cursor cursor for select FirstName, LastName from Employees
open Table_Cursor
fetch next from Table_Cursor into @firstName, @lastName
while @@fetch_status=0
begin 
set @tableName=concat(@firstName, @lastName)
set @sqlString='create table ' + @tableName
execute(@sqlString)
set @idx=0
set @tableCount = rand() * 10
while @idx < @tableCount
begin
set @sqlString='alter table ' + @tableName + 'add ' + @tableName + @idx + ' int not null'
set @idx = @idx + 1
execute(@sqlString)
end
execute(@sqlString)
print @tableName
fetch next from Table_Cursor into @firstName, @lastName
end
close Table_Cursor
deallocate Table_Cursor;
end
