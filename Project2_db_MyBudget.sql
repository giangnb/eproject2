use master
go
if exists (select name from sysdatabases where name='MyBudget') drop database [MyBudget]
go
create database [MyBudget]
go
use MyBudget
go

create table [Accounts] (
	[AccountId] varchar(64) primary key,
	[Authentication] nvarchar(512) not null default '', -- Auth string = Hash(User + Pass)
	[Info] ntext not null default '',
	[LastChange] datetime not null default CURRENT_TIMESTAMP
)
go

create table [Reasons] (
	[Name] nvarchar(128) primary key,
	[Count] bigint
)
go

create table [Wallets] (
	[WalletId] int primary key identity,
	[AccountId] varchar(64) not null,
	[Info] ntext not null default ''
)
go

create table [Data] (
	[DataId] bigint primary key identity,
	[WalletId] int not null,
	[Reason] nvarchar(128),
	[Amount] varchar(64) not null default '0',
	[Description] ntext,
	[Date] DateTime not null default CURRENT_TIMESTAMP
)
go

alter table [Wallets]
	add constraint FK_Wallets_Accounts foreign key (AccountId) references [Accounts]([AccountId])
go
alter table [Data]
	add constraint FK_Data_Wallets foreign key (WalletId) references [Wallets]([WalletId])
go