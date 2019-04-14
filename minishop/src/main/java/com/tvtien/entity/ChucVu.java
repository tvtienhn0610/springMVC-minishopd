package com.tvtien.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "chucvu")
public class ChucVu {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idChucVu;
	String tenChucVu;
	
	public int getIdChucVu() {
		return idChucVu;
	}
	public void setIdChucVu(int idChucVu) {
		this.idChucVu = idChucVu;
	}
	public String getTenChucVu() {
		return tenChucVu;
	}
	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}
	
}
