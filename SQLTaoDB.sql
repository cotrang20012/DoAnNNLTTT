
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
    tonghoadon int,
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

DROP procedure IF EXISTS `SEARCHCAR`;SEARCHCAR

DELIMITER $$
USE `projectnnlttt`$$
CREATE PROCEDURE `SEARCHCAR` (IN priceMin int, IN priceMax int,IN Sphankhoi int, IN Smodel varchar(255), IN Smauxe nvarchar(255), IN Sthuonghieu nvarchar(255), IN Sxuatxu nvarchar(255), IN Strangthai nvarchar(255))
BEGIN
	SELECT * FROM xe
	    WHERE (priceMin = -1 OR gia >= priceMin)
 		AND (priceMax = -1 OR gia <= priceMax)
 		AND (Smodel = '-1' OR xe.model like CONCAT('%', Smodel, '%'))
 		AND (Sphankhoi = -1 OR phankhoi like CONCAT('%', Sphankhoi, '%'))
		AND (Smauxe = N'-1' OR xe.mauxe like CONCAT('%', Smauxe, '%'))
		AND (Sthuonghieu = N'-1' OR xe.thuonghieu like CONCAT('%', Sthuonghieu, '%'))
        AND (Sxuatxu = N'-1' OR xe.xuatxu like CONCAT('%', Sxuatxu, '%'))
        AND (Strangthai = N'-1' OR xe.trangthai like CONCAT('%', Strangthai, '%'));
END$$

DELIMITER ;

CALL SEARCHCAR(-1,-1,'-1',-1,'-1','-1','-1','-1')


