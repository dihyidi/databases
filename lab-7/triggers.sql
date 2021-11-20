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
begin 
if ((select Id from inserted) != (select Id from deleted) and (select Id from deleted) in ((select Id from Degrees)))  
raiserror('not found',16,1)
end 

drop trigger if exists DegreeDelete;
go
create trigger DegreeDelete
on Degrees
after delete 
as
begin 
if ((select Id from deleted) in (select DegreeId from Employees)) 
raiserror('there is at least one person with such data, you cannot delete it',16,1)
end

--POSITIONS
drop trigger if exists PositionUpdate;
go
create trigger PositionUpdate
on Positions
after update
as
begin 
if ((select Id from inserted) != (select Id from deleted) and (select Id from deleted) in ((select Id from Positions)))  
raiserror('not found',16,1)
end 

drop trigger if exists PositionDelete;
go
create trigger PositionDelete
on Positions
after delete 
as
begin 
if ((select Id from deleted) in (select PositionId from Employees)) 
raiserror('there is at least one person with such data, you cannot delete it',16,1)
end

--STATUSES
drop trigger if exists StatusUpdate;
go
create trigger StatusUpdate
on Statuses
after update
as
begin 
if ((select Id from inserted) != (select Id from deleted) and (select Id from deleted) in ((select Id from Statuses)))  
raiserror('not found',16,1)
end 

drop trigger if exists StatusDelete;
go
create trigger StatusDelete
on Statuses
after delete 
as
begin 
if ((select Id from deleted) in (select StatusId from Employees)) 
raiserror('there is at least one person with such data, you cannot delete it',16,1)
end

--RECEPTION_FORM
drop trigger if exists ReceptionFormUpdate;
go
create trigger ReceptionFormUpdate
on ReceptionForm
after update
as
begin 
if ((select Id from inserted) != (select Id from deleted) and (select Id from deleted) in ((select Id from ReceptionForm)))  
raiserror('not found',16,1)
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
begin 
if ((select Id from inserted) != (select Id from deleted) and (select Id from deleted) in ((select Id from Employees)))  
raiserror('not found',16,1)
end 

drop trigger if exists EmployeeDelete;
go
create trigger EmployeeDelete
on Employees
after delete 
as
begin 
if ((select Id from deleted) in (select EmployeeId from EmployeesToSubjects)) 
raiserror('there is at least one subject with such data, you cannot delete it',16,1)
end

drop trigger if exists EmployeeInsert;
go
create trigger EmployeeInsert
on Employees
after insert 
as
begin 
if ((select PositionId from inserted) not in (select Id from Positions)) 
raiserror('fk error. not found',16,1)
if ((select StatusId from inserted) not in (select Id from Statuses)) 
raiserror('fk error. not found',16,1)
if ((select DegreeId from inserted) not in (select Id from Degrees)) 
raiserror('fk error. not found',16,1)
end

--SUBJECTS
drop trigger if exists SubjectUpdate;
go
create trigger SubjectUpdate
on Subjects
after update
as
begin 
if ((select Id from inserted) != (select Id from deleted) and (select Id from deleted) in ((select Id from Subjects)))  
raiserror('not found',16,1)
end 

drop trigger if exists SubjectDelete;
go
create trigger SubjectDelete
on Subjects
after delete 
as
begin 
if ((select Id from deleted) in (select SubjectId from EmployeesToSubjects)) 
raiserror('there is at least one subject with such data, you cannot delete it',16,1)
end

drop trigger if exists SubjectInsert;
go
create trigger SubjectInsert
on Subjects
after insert 
as
begin 
if ((select ReceptionFormId from inserted) not in (select Id from ReceptionForm)) 
raiserror('fk error. not found',16,1)
end


--EMPLOYEES TO SUBJECTS
drop trigger if exists EmployeesToSubjectInsert;
go
create trigger EmployeesToSubjectInsert
on EmployeesToSubjects
after insert 
as
begin 
if ((select EmployeeId from inserted) not in (select Id from Employees)) 
raiserror('fk error. not found',16,1)
if ((select SubjectId from inserted) not in (select Id from Subjects)) 
raiserror('fk error. not found',16,1)
end


--2
drop trigger if exists ConstraintOnExperience
go
create trigger ConstraintOnExperience
on Employees
after insert
as
begin
if((select ExperienceYrs from inserted) > (datediff(year, (select Birthday from inserted), getdate())))
raiserror('invalid data',16,1)
end


--3
drop trigger if exists ConstraintOnSemester
go
create trigger ConstraintOnSemester
on Subjects
after insert
as
begin
if((select Semester from inserted) not between 1 and 10)
raiserror('invalid data',16,1)
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