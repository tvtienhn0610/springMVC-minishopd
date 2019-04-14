package com.tvtien.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.tvtien.daoimp.sanPhamImp;
import com.tvtien.entity.SanPham;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SanPhamDAO implements sanPhamImp{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<SanPham> danhsachsanphamLimit(int spbatdau) {
		Session session = sessionFactory.getCurrentSession();
		try {
			List<SanPham> listsanpham = (List<SanPham>) session.createQuery("from sanpham").setFirstResult(spbatdau).setMaxResults(16).getResultList();
			return listsanpham;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional
	public SanPham LayDanhSachSanPhamTheoMa(int masanpham) {
		Session session = sessionFactory.getCurrentSession();
		String query = "from sanpham sp where sp.idSanPham = "+masanpham ;
		try {
			SanPham sanpham =(SanPham) session.createQuery(query).getSingleResult();
			return sanpham;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
