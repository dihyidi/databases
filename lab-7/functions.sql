use EmployeesDb;
go

--1
drop function if exists dbo.GetAvgExperience;
go
create function GetAvgExperience()
returns decimal
as
begin
return(select avg(ExperienceYrs) from Employees);
end
go

select * from Employees where ExperienceYrs > dbo.GetAvgExperience()


--2
drop function if exists dbo.GetReceptionFormName;
go
create function GetReceptionFormName(@subjectId int)
returns nvarchar(50)
begin
return(select Name from ReceptionForm where Id=(select ReceptionFormId from Subjects where id=@subjectId))
end
go

select Id, Name, Semester, Code, dbo.GetReceptionFormName(id) as GetReceptionFormName from Subjects;