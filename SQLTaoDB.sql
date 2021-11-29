

CREATE DATABASE ProjectNNLTTT;
USE ProjectNNLTTT;

CREATE TABLE nhanvien(
	id int NOT NULL AUTO_INCREMENT,
    cmnd varchar(255),
    ten nvarchar(255),
    diachi nvarchar(255),
    chucvu nvarchar(255),
    sdt varchar(255),
    luong int,
    PRIMARY KEY(id)
);

CREATE TABLE account(
	username varchar(255),
    password varchar(255),
    usertype varchar(255)
);

CREATE TABLE xe(
	id int NOT NULL AUTO_INCREMENT,
    model varchar(255),
    mauxe nvarchar(255),
    thuonghieu nvarchar(255),
    loai nvarchar(255),
    phankhoi int,
    xuatxu nvarchar(255),
    trangthai nvarchar(255),
    gia int,
    PRIMARY KEY(id)
);

CREATE TABLE khachhang(
	id int NOT NULL AUTO_INCREMENT,
    cmnd varchar(255),
    ten nvarchar(255),
    diachi nvarchar(255),
    sdt varchar(255),
    PRIMARY KEY(id)
);

CREATE TABLE bill(
	idbill int NOT NULL auto_increment,
    idsale int,
    idkhachhang int,
    thonghoadon int,
	FOREIGN KEY (idsale) REFERENCES nhanvien(id),
    FOREIGN KEY (idkhachhang) REFERENCES khachhang(id),
    PRIMARY KEY(idbill)
);

CREATE TABLE billdetail(
	idbill int,
    idxe int,
    gia int,
    FOREIGN KEY(idbill) REFERENCES bill(idbill),
    FOREIGN KEY(idxe) REFERENCES xe(id)
);


