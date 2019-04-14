package com.tvtien.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvtien.dao.SanPhamDAO;
import com.tvtien.daoimp.sanPhamImp;
import com.tvtien.entity.SanPham;

@Service
public class SanPhamService implements sanPhamImp{
	@Autowired
	SanPhamDAO sanPhamDAO;
	
	public List<SanPham> danhsachsanphamLimit(int spbatdau) {
		
		return sanPhamDAO.danhsachsanphamLimit(spbatdau);
	}

	public SanPham LayDanhSachSanPhamTheoMa(int masanpham) {
		
		return sanPhamDAO.LayDanhSachSanPhamTheoMa(masanpham);
	}

}
