create table chucvu(
	idChucVu integer AUTO_INCREMENT,
    tenChucVu nvarchar(20),
    primary key (idChucVu)
);
create table nhanvien(
	idNhanVien integer AUTO_INCREMENT,
    hoten nvarchar(25),
    diachi nvarchar(100),
    gioitinh bit,
    cmnd char(14),
    idChucVu integer,
    email varchar(50),
    tendangnhap varchar(50),
    matkhau varchar(50),
    primary key (idNhanVien),
    constraint FK_NhanVien_ChucVu foreign key( idChucVu) references chucvu( idChucVu)
);

create table danhmucsanpham(
	idDanhMuc integer AUTO_INCREMENT,
    tenDanhMuc nvarchar(100),
    hinhDanhMuc text,
    primary key (idDanhMuc)
);

create table sanpham(
	idSanPham integer AUTO_INCREMENT,
    idDanhMuc integer,
    tenSanPham nvarchar(100),
    giatien varchar(50),
    mota text,
    hinhSanPham text,
    primary key (idSanPham),
    constraint FK_SanPham_DanhMuc foreign key( idDanhMuc) references danhmucsanpham( idDanhMuc)
);

create table mausanpham(
	idMauSanPham integer AUTO_INCREMENT,
    tenMauSanPham nvarchar(25),
    primary key (idMauSanPham)
);

create table sizesanpham(
	idSizeSanPham integer AUTO_INCREMENT,
    tenSizeSanPham nvarchar(50),
    primary key (idSizeSanPham)
);

create table chitietsanpham(
	idChiTietSanPham integer AUTO_INCREMENT,
    idSanPham integer,
    idSizeSanPham integer,
    idMauSanPham integer,
    soluong integer,
    ngaynhap varchar(50),
    primary key (idChiTietSanPham),
    constraint FK_ChiTiet_SanPham foreign key( idSanPham) references sanpham( idSanPham),
	constraint FK_ChiTiet_Size foreign key( idSizeSanPham) references sizesanpham( idSizeSanPham),
	constraint FK_ChiTiet_MauSP foreign key( idMauSanPham) references mausanpham( idMauSanPham)
);

create table khuyenmai(
	idKhuyenMai integer AUTO_INCREMENT,
    tenKhuyenMai nvarchar(200),
    thoigianbatdau nvarchar(50),
    thoigianketthuc nvarchar(50),
    mota text,
    giagiam integer,
    hinhKhuyenMai text,
    primary key (idKhuyenMai)
);

create table chitietkhuyenmai(
	idKhuyenMai integer,
    idSanPham integer,
    primary key (idKhuyenMai , idSanPham),
    constraint FK_ChiTietkhuyenmai_sanpham foreign key( idSanPham) references sanpham( idSanPham)
);

create table hoadon(
	idHoaDon integer AUTO_INCREMENT,
    tenKhacHang nvarchar(100),
    sodt char(12),
    diachigiaohang nvarchar(200),
    tinhtrang bit,
    ngaylap varchar(50),
    primary key (idHoaDon)
);

create table chitiethoahon(
	idHoaDon integer,
    idChiTietSanPham integer,
    soluong integer,
    giatien varchar(100),
    primary key(idHoaDon,idChiTietSanPham),
	constraint FK_ChiTietHoaDon foreign key( idHoaDon) references hoadon(idHoaDon),
	constraint FK_ChiTiet_chitietSP foreign key( idChiTietSanPham) references chitietsanpham(idChiTietSanPham)
);





