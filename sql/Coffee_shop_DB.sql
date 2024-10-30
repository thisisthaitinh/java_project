CREATE DATABASE QUAN_CAFE_DATABASE;
GO

USE QUAN_CAFE_DATABASE;
GO

CREATE TABLE QUAN_CAFE (
	ID_QUAN NVARCHAR(10) PRIMARY KEY,
	TEN_QUAN NVARCHAR(255) NOT NULL,
	DIA_CHI NVARCHAR(255) NOT NULL);
GO

CREATE TABLE NHAN_VIEN (
	ID_NHAN_VIEN NVARCHAR(10) PRIMARY KEY,
	TEN_NHAN_VIEN NVARCHAR(255) NOT NULL,
	TUOI INT NOT NULL,
	DIA_CHI NVARCHAR(255) NOT NULL,
	SDT INT NOT NULL,
	LUONG FLOAT NOT NULL,
	ID_QUAN NVARCHAR(10),
	FOREIGN KEY (ID_QUAN) REFERENCES QUAN_CAFE(ID_QUAN),
);
GO


INSERT NHAN_VIEN 



CREATE TABLE THUC_DON (
	ID_MON NVARCHAR(10) PRIMARY KEY,
	TEN_MON NVARCHAR(255) NOT NULL,
	GIA FLOAT NOT NULL,
	MO_TA NVARCHAR(255),
	ID_QUAN NVARCHAR(10),
	FOREIGN KEY (ID_QUAN) REFERENCES QUAN_CAFE(ID_QUAN),
);
GO

CREATE TABLE KHACH_HANG (
	ID_KHACH_HANG NVARCHAR(10) PRIMARY KEY,
	TEN_KHACH_HANG NVARCHAR(255) NOT NULL,
	SDT INT NOT NULL,
	ID_QUAN NVARCHAR(10),
	FOREIGN KEY (ID_QUAN) REFERENCES QUAN_CAFE(ID_QUAN),
);
GO


CREATE TABLE THANH_TOAN (
	ID_THANH_TOAN NVARCHAR(10) PRIMARY KEY,
	TONG_SO_TIEN FLOAT NOT NULL,
	PT_THANH_TOAN NVARCHAR(255) NOT NULL,
	NGAY_THANH_TOAN DATE NOT NULL,
	ID_KHACH_HANG NVARCHAR(10),
	FOREIGN KEY (ID_KHACH_HANG) REFERENCES KHACH_HANG(ID_KHACH_HANG),
);
GO


CREATE TABLE HOA_DON (
	ID_HOA_DON NVARCHAR(10) PRIMARY KEY,
	TONG_SO_TIEN FLOAT NOT NULL,
	ID_KHACH_HANG NVARCHAR(10),
	FOREIGN KEY (ID_KHACH_HANG) REFERENCES KHACH_HANG(ID_KHACH_HANG),
	ID_QUAN NVARCHAR(10),
	FOREIGN KEY (ID_QUAN) REFERENCES QUAN_CAFE(ID_QUAN),
);
GO

CREATE TABLE CHI_TIET_HOA_DON (
	ID_HOA_DON NVARCHAR(10),
	FOREIGN KEY (ID_HOA_DON) REFERENCES HOA_DON(ID_HOA_DON),
	TEN_MON NVARCHAR(255) NOT NULL,
	SO_LUONG INT NOT NULL,
	GIA FLOAT NOT NULL,
	ID_MON NVARCHAR(10),
	FOREIGN KEY (ID_MON) REFERENCES THUC_DON(ID_MON)
);
GO

ALTER TABLE THANH_TOAN
ADD ID_HOA_DON NVARCHAR(10);

ALTER TABLE THANH_TOAN
ADD CONSTRAINT ID_HOA_DON FOREIGN KEY (ID_HOA_DON) REFERENCES HOA_DON(ID_HOA_DON);

ALTER TABLE HOA_DON
ADD ID_THANH_TOAN NVARCHAR(10);

ALTER TABLE HOA_DON
ADD CONSTRAINT ID_THANH_TOAN FOREIGN KEY (ID_THANH_TOAN) REFERENCES THANH_TOAN(ID_THANH_TOAN);

/* thong tin quan cafe */
INSERT INTO QUAN_CAFE (ID_QUAN, TEN_QUAN, DIA_CHI) VALUES ('QC001', N'CAFE VỈA HÈ 009', N'109 đường Lạc Long Quân, phường 4, quận 11, TP. HCM')

/* them nhan vien */
INSERT INTO NHAN_VIEN(ID_NHAN_VIEN, TEN_NHAN_VIEN, TUOI, DIA_CHI, SDT, LUONG, ID_QUAN) VALUES ('NV001', N'Trần Thái Tính', 19, N'210 Lê Văn Sỹ, phường 3, quận Tân Bình, TP. HCM', 0591590105, 10000000, 'QC001')
INSERT INTO NHAN_VIEN(ID_NHAN_VIEN, TEN_NHAN_VIEN, TUOI, DIA_CHI, SDT, LUONG, ID_QUAN) VALUES ('NV002', N'Nguyễn Khánh Duy', 19, N'470 Trần Hữu Trang, phường 10, quận Phú Nhuận, TP. HCM', 0389359927, 11000000, 'QC001')
INSERT INTO NHAN_VIEN(ID_NHAN_VIEN, TEN_NHAN_VIEN, TUOI, DIA_CHI, SDT, LUONG, ID_QUAN) VALUES ('NV003', N'Đặng Đình Thành Đạt', 19, N'285/35E4 Cách Mạng Tháng Tám, phường 12, quận 10, TP.HCM', 0349883787, 12000000, 'QC001')

/* danh sach do uong */
INSERT INTO THUC_DON(ID_MON, TEN_MON, GIA, ID_QUAN) VALUES ('TD001', N'Bạc xỉu', 30000, 'QC001')
INSERT INTO THUC_DON(ID_MON, TEN_MON, GIA, ID_QUAN) VALUES ('TD002', N'Cà phê đen đá', 20000, 'QC001')
INSERT INTO THUC_DON(ID_MON, TEN_MON, GIA, ID_QUAN) VALUES ('TD003', N'Cà phê sữa đá', 25000, 'QC001')
INSERT INTO THUC_DON(ID_MON, TEN_MON, GIA, ID_QUAN) VALUES ('TD004', N'Trà sữa trân châu đường đen', 35000, 'QC001')
INSERT INTO THUC_DON(ID_MON, TEN_MON, GIA, ID_QUAN) VALUES ('TD005', N'Trà sữa kem cheese', 35000, 'QC001')
INSERT INTO THUC_DON(ID_MON, TEN_MON, GIA, ID_QUAN) VALUES ('TD006', N'Trà đào cam sả', 32000, 'QC001')
INSERT INTO THUC_DON(ID_MON, TEN_MON, GIA, ID_QUAN) VALUES ('TD007', N'Sữa chua đá bào', 25000, 'QC001')
INSERT INTO THUC_DON(ID_MON, TEN_MON, GIA, ID_QUAN) VALUES ('TD008', N'Sữa chua dâu', 25000, 'QC001')
INSERT INTO THUC_DON(ID_MON, TEN_MON, GIA, ID_QUAN) VALUES ('TD009', N'Sữa chua việt quất', 25000, 'QC001')

/* them thong tin khach hang */