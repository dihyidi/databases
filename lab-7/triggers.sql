use EmployeesDb;
go

--1
-- DEGREES
drop trigger if exists DegreeUpdate;
go
create trigger DegreeUpdate
on Degrees
after update
as
declare @newId int, @oldId int
select @newId=Id from inserted
select @oldId=Id from deleted
if (@newId != @oldId and @oldId in ((select Id from Degrees))) 
begin
print 'not found'
rollback transaction
end 

drop trigger if exists DegreeDelete;
go
create trigger DegreeDelete
on Degrees
after delete 
as
declare @oldId int
select @oldId=Id from deleted
if (@oldId in (select DegreeId from Employees)) 
begin
print 'there is at least one person with such data, you cannot delete it'
rollback transaction
end

--POSITIONS
drop trigger if exists PositionUpdate;
go
create trigger PositionUpdate
on Positions
after update
as
declare @newId int, @oldId int
select @newId=Id from inserted
select @oldId=Id from deleted
if (@newId != @oldId and @oldId in ((select Id from Positions)))  
begin
print 'not found'
rollback transaction
end 

drop trigger if exists PositionDelete;
go
create trigger PositionDelete
on Positions
after delete 
as
declare @oldId int
select @oldId=Id from deleted
if (@oldId in (select PositionId from Employees)) 
begin
print 'there is at least one person with such data, you cannot delete it'
rollback transaction
end 

--STATUSES
drop trigger if exists StatusUpdate;
go
create trigger StatusUpdate
on Statuses
after update
as
declare @newId int, @oldId int
select @newId=Id from inserted
select @oldId=Id from deleted
if (@newId != @oldId and @oldId in ((select Id from Statuses)))  
begin
print 'not found'
rollback transaction
end 

drop trigger if exists StatusDelete;
go
create trigger StatusDelete
on Statuses
after delete 
as
declare @oldId int
select @oldId=Id from deleted
if (@oldId in (select StatusId from Employees)) 
begin
print 'there is at least one person with such data, you cannot delete it'
rollback transaction
end

--RECEPTION_FORM
drop trigger if exists ReceptionFormUpdate;
go
create trigger ReceptionFormUpdate
on ReceptionForm
after update
as
declare @newId int, @oldId int
select @newId=Id from inserted
select @oldId=Id from deleted
if (@newId != @oldId and @oldId in ((select Id from ReceptionForm)))  
begin
print 'not found'
rollback transaction
end 

drop trigger if exists ReceptionFormDelete;
go
create trigger ReceptionFormDelete
on ReceptionForm
after delete 
as
begin 
if ((select Id from deleted) in (select ReceptionFormId from Subjects)) 
raiserror('there is at least one subject with such data, you cannot delete it',16,1)
end

--EMPLOYEES
drop trigger if exists EmployeeUpdate;
go
create trigger EmployeeUpdate
on Employees
after update
as
declare @newId int, @oldId int
select @newId=Id from inserted
select @oldId=Id from deleted
if (@newId != @oldId and @oldId in ((select Id from Employees)))  
begin
print 'not found'
rollback transaction
end 

drop trigger if exists EmployeeDelete;
go
create trigger EmployeeDelete
on Employees
after delete 
as
declare @oldId int
select @oldId=Id from deleted
if (@oldId in (select EmployeeId from EmployeesToSubjects)) 
begin
print 'there is at least one person with such data, you cannot delete it'
rollback transaction
end

drop trigger if exists EmployeeInsert;
go
create trigger EmployeeInsert
on Employees
after insert 
as
declare @amount int

select @amount=count(*) from inserted where PositionId not in (select Id from Positions)
if (@amount != 0) 
begin
print 'fk error. positionId not found'
rollback transaction
end

select @amount=count(*) from inserted where StatusId not in (select Id from Statuses)
if (@amount != 0) 
begin
print 'fk error. StatusId not found'
rollback transaction
end

select @amount=count(*) from inserted where DegreeId not in (select Id from Degrees)
if (@amount != 0) 
begin
print 'fk error. DegreeId not found'
rollback transaction
end


--SUBJECTS
drop trigger if exists SubjectUpdate;
go
create trigger SubjectUpdate
on Subjects
after update
as
declare @newId int, @oldId int
select @newId=Id from inserted
select @oldId=Id from deleted
if (@newId != @oldId and @oldId in ((select Id from Subjects)))  
begin
print 'not found'
rollback transaction
end 

drop trigger if exists SubjectDelete;
go
create trigger SubjectDelete
on Subjects
after delete 
as
declare @oldId int
select @oldId=Id from deleted
if (@oldId in (select SubjectId from EmployeesToSubjects)) 
begin
print 'there is at least one person with such data, you cannot delete it'
rollback transaction
end

drop trigger if exists SubjectInsert;
go
create trigger SubjectInsert
on Subjects
after insert 
as
declare @amount int
select @amount=count(*) from inserted where ReceptionFormId not in (select Id from ReceptionForm)
if (@amount != 0) 
begin
print 'fk error. ReceptionFormId not found'
rollback transaction
end


--EMPLOYEES TO SUBJECTS
drop trigger if exists EmployeesToSubjectInsert;
go
create trigger EmployeesToSubjectInsert
on EmployeesToSubjects
after insert 
as
declare @amount int
select @amount=count(*) from inserted where EmployeeId not in (select Id from Employees)
if (@amount != 0) 
begin
print 'fk error. EmployeeId not found'
rollback transaction
end

select @amount=count(*) from inserted where SubjectId not in (select Id from Subjects)
if (@amount != 0) 
begin
print 'fk error. SubjectId not found'
rollback transaction
end


--2
drop trigger if exists ConstraintOnExperience
go
create trigger ConstraintOnExperience
on Employees
after insert
as
declare @amount int
select @amount=count(*) from inserted where ExperienceYrs > datediff(year, Birthday, getdate())
if (@amount != 0) 
begin
print 'invalid data'
rollback transaction
end


--3
drop trigger if exists ConstraintOnSemester
go
create trigger ConstraintOnSemester
on Subjects
after insert
as
declare @amount int
select @amount=count(*) from inserted where Semester not between 1 and 10
if (@amount != 0) 
begin
print 'invalid data'
rollback transaction
end


--4
drop trigger if exists EmployeesLogs
go
create trigger EmployeesLogs
on Employees
after insert
as
begin
insert into EmployeesJournal(EmployeeId, WhenInserted) values ((select Id from inserted), getdate());
end