USE master
GO

IF NOT EXISTS (SELECT 1 FROM sys.databases WHERE name = 'test')
BEGIN
	PRINT 'MSG: Database test is not exist, so we create it.'
	CREATE DATABASE [test]
END

IF OBJECT_ID('test.DBO.users') IS NULL
BEGIN
	PRINT 'MSG: table users is not exist, so we create it.'
	CREATE TABLE [dbo].[users](
		[user_id] [varchar](50) NULL,
		[first_name] [varchar](50) NULL,
		[last_name] [varchar](50) NULL,
		[phone_num] [varchar](50) NULL
	)
END
