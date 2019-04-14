package com.tvtien.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tvtien.entity.DanhMucSanPham;
import com.tvtien.entity.SanPham;
import com.tvtien.service.DanhMucSevice;
import com.tvtien.service.SanPhamService;

@Controller
@RequestMapping("/chitiet")
public class ChitietController {
	@Autowired
	SanPhamService sanphamSevice;
	@Autowired
	DanhMucSevice danhmucSevice;
	
	@GetMapping("/{masanpham}")
	public String Default(@PathVariable int masanpham ,ModelMap modelmap ,HttpSession httpSession){
		if(httpSession.getAttribute("user") != null){
			String username = (String)httpSession.getAttribute("user");
			String chucaidau = username.substring(0,1);
			modelmap.addAttribute("chudau",chucaidau);
		}
		
		SanPham sanPham = sanphamSevice.LayDanhSachSanPhamTheoMa(masanpham);
		List<DanhMucSanPham> listdanhmuc = danhmucSevice.Laydanhmuc();
		
		modelmap.addAttribute("sanpham",sanPham);
		modelmap.addAttribute("listdanhmuc",listdanhmuc);
		
		return "chitiet";
	}
}
