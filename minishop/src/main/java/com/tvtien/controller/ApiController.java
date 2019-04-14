package com.tvtien.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tvtien.entity.giohang;
import com.tvtien.service.NhanVienService;

@Controller
@RequestMapping("api/")
@SessionAttributes({"user","giohang"})
public class ApiController {
	
	@Autowired
	NhanVienService nhanvienService;
	
	
	@GetMapping("kiemtradangnhap")
	@ResponseBody
	public String checkDangNhap(@RequestParam String username , @RequestParam String password , ModelMap modelmap){
		boolean kiemtra = nhanvienService.checkDangNhap(username, password);
		modelmap.addAttribute("user",username);
		
		return ""+kiemtra;
	}
	
	@GetMapping("themgiohang")	
	public void ThemGioHang(@RequestParam int idSanPham ,@RequestParam int idMaMauSanPham , @RequestParam int idSizeSanpham  , @RequestParam String tenSanPham ,  @RequestParam String tenMauSanPham ,  @RequestParam String tenSizeSanPham ,  @RequestParam String giatien , @RequestParam int soluong ,HttpSession httpSession ){
		if( null == httpSession.getAttribute("giohang")){
			List<giohang> giohangs = new ArrayList<giohang>();
			giohang gioHang = new giohang();
			gioHang.setIdSanPham(idSanPham);
			gioHang.setIdMaMauSanPham(idMaMauSanPham);
			gioHang.setIdSizeSanpham(idSizeSanpham);
			gioHang.setTenSanPham(tenSanPham);
			gioHang.setTenMauSanPham(tenMauSanPham);
			gioHang.setTenSizeSanPham(tenSizeSanPham);
			gioHang.setGiatien(giatien);
			gioHang.setSoluong(1);
			
			giohangs.add(gioHang);
			httpSession.setAttribute("giohang", giohangs);
			List<giohang> list = (List<giohang>) httpSession.getAttribute("giohang");
			System.out.println(list.size());
			
		}else{
			int vitri = kiemtrasanpham(idSanPham, idSizeSanpham, idMaMauSanPham, httpSession);
			if(vitri == -1){
				List<giohang> giohangs = (List<giohang>) httpSession.getAttribute("giohang");
				giohang gioHang = new giohang();
				gioHang.setIdSanPham(idSanPham);
				gioHang.setIdMaMauSanPham(idMaMauSanPham);
				gioHang.setIdSizeSanpham(idSizeSanpham);
				gioHang.setTenSanPham(tenSanPham);
				gioHang.setTenMauSanPham(tenMauSanPham);
				gioHang.setTenSizeSanPham(tenSizeSanPham);
				gioHang.setGiatien(giatien);
				gioHang.setSoluong(1);
				
				giohangs.add(gioHang);
				
				System.out.println(giohangs.size());
			}else{
				List<giohang> giohangs = (List<giohang>) httpSession.getAttribute("giohang");
				int soluongcu = giohangs.get(vitri).getSoluong();
				giohangs.get(vitri).setSoluong(soluongcu +1 );
				System.out.println(giohangs.size());
			}
			
		}	
		
	}
	
	private int kiemtrasanpham(int masp , int masize , int mamau ,HttpSession httpSession){
		List<giohang> listgiohang = (List<giohang>) httpSession.getAttribute("giohang");
		for(int i = 0 ;i < listgiohang.size() ;i++){
			if(listgiohang.get(i).getIdSanPham() == masp && listgiohang.get(i).getIdMaMauSanPham() == mamau && listgiohang.get(i).getIdSizeSanpham() == masize){
				return i;
			}
		}
		return -1;
	}
}
