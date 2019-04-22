--/*
--use [HR_Management ];
--create table Department(DepID int primary key identity(1,1),DepName not null varchar(20),DepHead not null varchar(20) );

--create table Location(LocID int primary key identity(1,1),LocName not null varchar(20),LocAddress not null varchar(100));

--create table Skills(SkillID int primary key identity(1,1),Skill not null varchar(10));
--*/

--use [HR_Management ];

--create table Employee(
--EmpID int primary key identity(1,1),
--EmpFirstName varchar(40) not null,
--EmpLastName varchar(40) not null,
--DepID int foreign key references Department(DepID),
--ManagerID int ,
----check((ManagerID is Null) or(select * from Employee where EmpID = ManagerID)=1 ),
--Email varchar(50) not null,
--PhoneNo int not null,
--PrimarySkill_1 int not null foreign key references Skills(SkillID),
--PrimarySkill_2 int not null foreign key references Skills(SkillID),
--PrimarySkill_3 int not null foreign key references Skills(SkillID),
--Location int foreign key references Location(LocID),
--Category varchar(20) not null check( Category in ('Built','UnBuilt')),
--Assignment_status varchar(20) not null check(Assignment_status in ('active','terminated')),
--HireDate date not null,
--TerminationDate date,
--Constraint td check((Assignment_status='active' and TerminationDate is Null) or (Assignment_status='terminated' and TerminationDate is Not NULL)));

--Drop Function MGID;

--CREATE FUNCTION MGID (
--    @ID INT
--)
--RETURNS VARCHAR(10)
--AS
--BEGIN
--    IF EXISTS (SELECT EmpID FROM Employee WHERE EmpID = @ID)
--        return 'True'
--    return 'False'
--END

--alter table Employee with check add constraint mid check([dbo].MGID(ManagerID)='True' or ManagerID is null)

--create table EmployeeHistory(
--ChangeID int primary key identity(1,1),
--EmpID int not null,
--EmpFirstName varchar(30) not null,
--EmpLastName varchar(30) not null,
--DepID int not null,
--ManagerID int not null,
--Email varchar(30) not null,
--PhoneNo int not null,
--PrimarySkill_1 int not null,
--PrimarySkill_2 int not null,
--PrimarySkill_3 int not null,
--Location int not null,
--Category varchar(20) not null,
--Assignment_status varchar(20) not null,
--HireDate date not null,
--TerminationDate date null,
--OldEmpFirstName varchar(30) ,
--OldEmpLastName varchar(30) ,
--OldDepID int ,
--OldManagerID int ,
--OldEmail varchar(30) ,
--OldPhoneNo int ,
--OldPrimarySkill_1 int ,
--OldPrimarySkill_2 int ,
--OldPrimarySkill_3 int ,
--OldLocation int ,
--OldCategory varchar(20),
--OldAssignment_status varchar(20),
--ChangeType varchar(20) check(ChangeType in ('INSERT','UPDATE','DELETE'))
--);




use [HR_Management ];
create trigger trigger_insert
on Employee
After insert
as
Insert into  EmployeeHistory values ((select i.EmpID from inserted as i),(select i.EmpFirstName from inserted as i),(select i.EmpLastName from inserted as i),(select i.DepID from inserted as i),(select i.ManagerID from inserted as i),(select i.Email from inserted as i),(select i.PhoneNo from inserted as i),(select i.PrimarySkill_1 from inserted as i),(select i.PrimarySkill_2 from inserted as i),(select i.PrimarySkill_3 from inserted as i),(select i.Location from inserted as i),(select i.Category from inserted as i),(select i.Assignment_status from inserted as i),(select i.HireDate from inserted as i),(select i.TerminationDate from inserted as i),NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'INSERT')
GO
