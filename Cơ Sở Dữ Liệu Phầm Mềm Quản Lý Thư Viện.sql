CREATE DATABASE QuanLyThuVien
Go
USE QuanLyThuVien
Go



---------------------------------------- Category ----------------------------------------
Create Table Category(
Id int Primary Key Identity,
Name nvarchar(200) Not Null unique,
[Description] nvarchar(200) Null,
[Status] bit Null,
)
Go
		--==================== PROC ====================--
Create Proc getAllCategory
AS
	SELECT * FROM  Category
GO
Create Proc getOneCategory
@Name nvarchar(250)
AS
	SELECT * FROM  Category Where Name = @Name
GO
Create Proc CreateCategory
@Name nvarchar(200),
@Description nvarchar(200),
@Status bit
AS
	Insert Into Category(Name,[Description],[Status]) Values(@Name,@Description,@Status)
GO

Create Proc UpdateCategory
@Id int,
@Name nvarchar(200),
@Description nvarchar(200),
@Status bit
AS
	Update Category Set Name = @Name, [Description] = @Description, [Status] = @Status Where Id = @Id
GO
Create Proc DeleteCategory
@Id int
AS
	Delete From Category Where Id = @Id
GO
--********************************************-----********************************************--


---------------------------------------- Book ----------------------------------------
Create Table Book(
Id int Primary Key Identity,
Name nvarchar(200) Not Null,
DateAdded datetime Not Null,
Price float Not Null,
Quantity int Not Null,
QuantityRemain int Null,
Category_Id int Foreign Key References Category(Id) Not Null,
[Description] nvarchar(200) Null,
[Status] bit Null,
NumberofIssue int default(0)
)
Go
	--==================== PROC ====================--
Create Proc getAllBook
AS
	SELECT * FROM  Book
GO
Create Proc getOneBook
@Name nvarchar(250)
AS
	SELECT * FROM  Book Where Name = @Name
GO
Create Proc CreateBook
@Name nvarchar(200) ,
@DateAdded datetime ,
@Price float ,
@Quantity int ,
@QuantityRemain int ,
@Category_Id int,
@Description nvarchar(200) ,
@Status bit 
AS
	Insert Into Book(Category_Id,Name,DateAdded,Price,Quantity,QuantityRemain,[Description],[Status])
				Values(@Category_Id,@Name,@DateAdded,@Price,@Quantity,@QuantityRemain,@Description,@Status)
GO
Create Proc UpdateBook
@Id int,
@Category_Id int,
@Name nvarchar(200) ,
@DateAdded datetime ,
@Price float ,
@Quantity int ,
@QuantityRemain int ,
@Description nvarchar(200) ,
@Status bit 
AS
	Update Book Set		Category_Id = @Category_Id,
						Name = @Name,
						DateAdded = @DateAdded,
						Price = @Price,
						Quantity = @Quantity,
						QuantityRemain = @QuantityRemain,					
						[Description] = @Description, 
						[Status] = @Status 
						Where Id = @Id
GO
Create Proc UpdateQuantityRemainBook
@Id int,
@QuantityRemain int 
AS
	Update Book Set	QuantityRemain = @QuantityRemain Where Id = @Id
GO
Create Proc UpdateNumberofIssueBook
@Id int,
@NumberofIssue int 
AS
	Update Book Set	NumberofIssue = @NumberofIssue Where Id = @Id
GO
Create Proc DeleteBook
@Id int
AS
	Delete From Book Where Id = 4
GO
--***************************************-----********************************************--



---------------------------------------- Author ----------------------------------------
Create Table Author(
Id int Primary Key Identity,
Pseudonym nvarchar(200) Null,
Name nvarchar(200) Not Null,
DateBirth datetime Not Null,
DateLost datetime Null,
[Address] nvarchar(250) Not Null,
[Description] nvarchar(200) Null,
[Status] bit Null,
)
Go

		--==================== PROC ====================--

Create Proc getAllAuthor
AS
	SELECT * FROM  Author
GO
Create Proc getIdAuthor
AS
	SELECT Author.Name 
	FROM  Author 
	Inner JOIN Book On Author.Id = Book.Id
GO
Create Proc getOneAuthor
@Name nvarchar(250)
AS
	SELECT * FROM  Author Where Name = @Name
GO
Create Proc CreateAuthor
@Pseudonym nvarchar(200),
@Name nvarchar(200),
@DateBirth datetime,
@DateLost datetime,
@Address nvarchar(250),
@Description nvarchar(200),
@Status bit 
AS
	Insert Into Author(Pseudonym,Name,DateBirth,DateLost,[Address],[Description],[Status])
				Values(@Pseudonym,@Name,@DateBirth,@DateLost,@Address,@Description,@Status)
GO
Create Proc UpdateAuthor
@Id int,
@Pseudonym nvarchar(200) ,
@Name nvarchar(200),
@DateBirth datetime,
@DateLost datetime,
@Address nvarchar(250),
@Description nvarchar(200),
@Status bit 
AS
	Update Author Set	Pseudonym = @Pseudonym,
						Name = @Name,
						DateBirth = @DateBirth,
						DateLost = @DateLost,
						[Address] = @Address,					
						[Description] = @Description, 
						[Status] = @Status 
						Where Id = @Id
GO
Create Proc DeleteAuthor
@Id int
AS
	Delete From Author Where Id = @Id
GO
--***************************************-----********************************************--



---------------------------------------- [Type] ----------------------------------------
Create Table [Type](
Id int Primary Key Identity,
Name nvarchar(200) Not Null unique,
[Description] nvarchar(200) Null,
[Status] bit Null,
)
Go
		--==================== PROC ====================--
Create Proc getAllType
AS
	SELECT * FROM  [Type]
GO
Create Proc getOneType
@Name nvarchar(250)
AS
	SELECT * FROM  [Type] Where Name = @Name
GO
Create Proc CreateType
@Name nvarchar(200),
@Description nvarchar(200),
@Status bit
AS
	Insert Into [Type](Name,[Description],[Status]) Values(@Name,@Description,@Status)
GO

Create Proc UpdateType
@Id int,
@Name nvarchar(200),
@Description nvarchar(200),
@Status bit
AS
	Update [Type] Set Name = @Name, [Description] = @Description, [Status] = @Status Where Id = @Id
GO
Create Proc DeleteType
@Id int
AS
	Delete From [Type] Where Id = @Id
GO
--***************************************-----********************************************--

---------------------------------------- Translator ----------------------------------------
Create Table Translator(
Id int Primary Key Identity,
Name nvarchar(200) Not Null,
DateBirth datetime Not Null,
[Address] nvarchar(250) Not Null,
[Description] nvarchar(200) Null,
[Status] bit Null,
)
Go
		--==================== PROC ====================--
Create Proc getAllTranslator
AS
	SELECT * FROM  Translator
GO
Create Proc getOneTranslator
@Name nvarchar(250)
AS
	SELECT * FROM  Translator Where Name = @Name
GO
Create Proc CreateTranslator
@Name nvarchar(200),
@DateBirth datetime,
@Address nvarchar(250),
@Description nvarchar(200),
@Status bit 
AS
	Insert Into Translator(Name,DateBirth,[Address],[Description],[Status])
				Values(@Name,@DateBirth,@Address,@Description,@Status)
GO
Create Proc UpdateTranslator
@Id int,
@Name nvarchar(200),
@DateBirth datetime,
@Address nvarchar(250),
@Description nvarchar(200),
@Status bit 
AS
	Update Translator Set Name = @Name,
						DateBirth = @DateBirth,
						[Address] = @Address,					
						[Description] = @Description, 
						[Status] = @Status 
						Where Id = @Id
GO
Create Proc DeleteTranslator
@Id int
AS
	Delete From Translator Where Id = @Id
GO
--***************************************-----********************************************--

---------------------------------------- Publisher ----------------------------------------
Create Table Publisher(
Id int Primary Key Identity,
Name nvarchar(200) Not Null,
DateEstablished datetime Null,
[Address] nvarchar(250) Not Null,
[Description] nvarchar(200) Null,
[Status] bit Null,
)
Go
			--==================== PROC ====================--
Create Proc getAllPublisher
AS
	SELECT * FROM  Publisher
GO
Create Proc getOnePublisher
@Name nvarchar(250)
AS
	SELECT * FROM  Publisher Where Name = @Name
GO
Create Proc CreatePublisher
@Name nvarchar(200),
@DateEstablished datetime,
@Address nvarchar(250),
@Description nvarchar(200),
@Status bit 
AS
	Insert Into Publisher(Name,DateEstablished,[Address],[Description],[Status])
				Values(@Name,@DateEstablished,@Address,@Description,@Status)
GO
Create Proc UpdatePublisher
@Id int,
@Name nvarchar(200),
@DateEstablished datetime,
@Address nvarchar(250),
@Description nvarchar(200),
@Status bit 
AS
	Update Publisher Set Name = @Name,
						DateEstablished = @DateEstablished,
						[Address] = @Address,					
						[Description] = @Description, 
						[Status] = @Status 
						Where Id = @Id
GO
Create Proc DeletePublisher
@Id int
AS
	Delete From Publisher Where Id = @Id
GO

--*************************************** Detail ********************************************--

---------------------------------------- BookDetail ----------------------------------------

Create Table BookDetail(
Id int PRIMARY KEY Identity,
Id_Book int Foreign Key References Book(Id) Not Null,
Id_Author int Foreign Key References Author(Id) Not Null,
Id_Type int Foreign Key References Type(Id) Not Null,
Id_Translator int Foreign Key References Translator(Id) Not Null,
Id_Publisher int Foreign Key References Publisher(Id) Not Null,
)
Go
Create Proc getAllBookDetail
AS
	SELECT * FROM  BookDetail
GO
Create Proc CreateBookDetail
@Id_Book int ,
@Id_Author int ,
@Id_Type int ,
@Id_Translator int ,
@Id_Publisher int 
AS
	Insert Into BookDetail(Id_Book,Id_Author,Id_Type,Id_Translator,Id_Publisher)
				Values(@Id_Book,@Id_Author,@Id_Type,@Id_Translator,@Id_Publisher)
GO
Create Proc UpdateBookDetail
@Id int,
@Id_Book int ,
@Id_Author int ,
@Id_Type int ,
@Id_Translator int ,
@Id_Publisher int 
AS
	Update BookDetail Set Id_Book = @Id_Book,
						Id_Author = @Id_Author,
						Id_Type = @Id_Type,
						Id_Translator = @Id_Translator,
						Id_Publisher = @Id_Publisher
						Where Id = @Id
GO
Create Proc DeleteBookDetail
@Id int
AS
	Delete From BookDetail Where Id = @Id
Go
create proc getListAuthorDetail
@idBook int
as select bd.Id_Author from BookDetail bd
join Author a
on a.Id = bd.Id_Author
where bd.Id_Book = @idBook
group by bd.Id_Author
Go
create proc getListTypeDetail
@idBook int
as select bd.Id_Type from BookDetail bd
join Type t
on t.Id = bd.Id_Type
where bd.Id_Book = @idBook
group by bd.Id_Type
Go
--***************************************-----********************************************--
---------------------------------------- Reader ----------------------------------------
Create Table Reader(
Id int Primary Key Identity,
Name nvarchar(200) Not Null,
Email nvarchar(200) Not Null unique,
Phone nvarchar(200) Not Null unique,
[Address] nvarchar(200) Not Null,
[Status] bit Null,
)
Go
		--==================== PROC ====================--
Create Proc getAllReader
AS
	SELECT * FROM  Reader
GO
Create Proc getOneReader
@Name nvarchar(250)
AS
	SELECT * FROM  Reader Where Name = @Name 
GO
Create Proc getNamePhoneReader
@Name nvarchar(250),
@Phone nvarchar(250)
AS
	SELECT * FROM  Reader Where Name = @Name AND Phone = @Phone
GO
Create Proc CreateReader
@Name nvarchar(200),
@Email nvarchar(200),
@Phone nvarchar(200),
@Address nvarchar(200),
@Status bit
AS
	Insert Into Reader(Name,Email,Phone,[Address],[Status]) Values(@Name,@Email,@Phone,@Address,@Status)
GO

Create Proc UpdateReader
@Id int,
@Name nvarchar(200),
@Email nvarchar(200),
@Phone nvarchar(200),
@Address nvarchar(200),
@Status bit
AS
	Update Reader Set Name = @Name, Email = @Email,Phone = @Phone,[Address] = @Address , [Status] = @Status Where Id = @Id
GO
Create Proc DeleteReader
@Id int
AS
	Delete From Reader Where Id = @Id
GO
--***************************************-----********************************************--

---------------------------------------- Bill ----------------------------------------
Create Table Bill(
Id int Primary Key Identity,
Id_Reader int Foreign Key References Reader(Id) Not Null,
DateIssue datetime Not Null,
DateReturn datetime Not Null,
[Status] bit Not Null,
)
Go

Create Proc getAllBill
AS
	SELECT * FROM  Bill
GO
Create Proc getOneBill
@Id_Reader int
AS
	SELECT * FROM  Bill Where Id_Reader = @Id_Reader
GO

Create Proc CreateBill
@Id_Reader int,
@DateIssue datetime ,
@DateReturn datetime ,
@Status bit
AS
	Insert Into Bill(Id_Reader,DateIssue,DateReturn,[Status]) 
			Values(@Id_Reader,@DateIssue,@DateReturn,@Status)
GO
Create Proc UpdateBill
@Id int,
@Status bit
AS
	Update Bill SET [Status] = @Status Where Id = @Id
GO
--***************************************-----********************************************--
---------------------------------------- BillDetail ----------------------------------------
Create Table BillDetail(
Id int Primary Key Identity,
Id_Bill int Foreign Key References Bill(Id) Not Null,
Id_BookDetail int Foreign Key References BookDetail(Id) Not Null,
DateReturn datetime null,
[Status] bit
)
Go

Create Proc getAllBillDetail
AS
	SELECT * FROM  BillDetail
GO
Create Proc getOneBillDetail
@Id_Bill int,
@Id_BookDetail int
AS
	SELECT * FROM  BillDetail Where  Id_Bill = @Id_Bill AND Id_BookDetail = @Id_BookDetail
GO
Create Proc CreateBillDetail
@Id_Bill int ,
@Id_BookDetail int,
@DateReturn datetime,
@Status bit
AS
	Insert Into BillDetail(Id_Bill,Id_BookDetail,DateReturn,[Status])
		   Values(@Id_Bill,@Id_BookDetail,@DateReturn,@Status)
GO
Create Proc UpdateBillDetail
@Id int,
@DateReturn datetime,
@Status bit
AS
	Update BillDetail SET DateReturn = @DateReturn ,[Status] = @Status Where Id = @Id
GO

--***************************************-----********************************************--

---------------------------------------- [User] ----------------------------------------
Create Table [User](
Id int Primary Key Identity,
UserName nvarchar(200) Not Null,
[Password] varchar(20) Not Null,
[Status] int Not Null,
)
Go
Insert Into [User](UserName,[Password],[Status]) Values('admin','1','1');
Go
Create Proc CheckUser
@UserName nvarchar(200),
@Password varchar(20)
AS
	SELECT * FROM [User] WHERE UserName = @UserName AND [Password] = @Password
GO
--***************************************-----********************************************--

--***************************************--proc for select detail book--********************************************--



