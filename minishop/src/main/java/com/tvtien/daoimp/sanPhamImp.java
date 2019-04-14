package com.tvtien.daoimp;

import java.util.List;

import com.tvtien.entity.SanPham;

public interface sanPhamImp {
	
	List<SanPham> danhsachsanphamLimit(int spbatdau);
	SanPham LayDanhSachSanPhamTheoMa(int masanpham);
}
