# DoAnNNLTTT
Đồ án môn học NNLTTT HCMUTE

1. Nhân viên(id,cmnd,ten,diachi,chucvu,sdt,luong)
+ id nvarchar(255)
+ cmnd nvarchar(255)
+ ten nvarchar(255)
+ diachi nvarchar(255)
+ chucvu nvarchar(255)
+ sdt nvarchar(255)
+ luong int

2. account(username,password,usertype)
+ username varchar(255)
+ password varchar(255)
+ usertype varchar(255)

3. Xe(id,model,thuonghieu,loai,phankhoi,xuatxu,gia)
+ id nvarchar(255)
+ model varchar(255)
+ thuonghieu nvarchar(255)
+ loai nvarchar(255)
+ phankhoi nvarchar(255)
+ xuatxu nvarchar(255)
+ gia int

4. khachhang (id,cmnd,ten,diachi,sdt)
+ id nvarchar(255)
+ cmnd nvarchar(255)
+ ten nvarchar(255)
+ diachi nvarchar(255)
+ sdt nvarchar(255)

5. hoadon (idsale,idxe,tonghoadon)
+ idsale nvarchar(255)
+ idkhachhang nvarchar(255)
+ idxe nvarchar(255)
+ tonghoadon int
