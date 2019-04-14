$(document).ready(function(){
	$("#btn_dangnhap").click(function(){
		var username = $("#username").val();
		var password = $("#password").val();
		$.ajax({
			url:"/minishop/api/kiemtradangnhap",
			type:"GET",
			data:{
				username : username,
				password : password
			},
			success: function(value){
				if(value == "true"){
					$("#ketqua").text("thanh cong")
//					chuyen sang trang chu
					duongdanhientai = window.location.href;
					duongDan = duongdanhientai.replace("dangnhap/","");
					window.location = duongDan;
				}
				else{
					$("#ketqua").text("that bai")
				}
			}
		})
	});
	
	
	$("#login").click(function(){
		$(this).addClass("actived");
		$("#sigup").removeClass("actived");
		$("#container_dangnhap").show();
		$("#container_sigup").hide();
	});
	

	$("#sigup").click(function(){
		$(this).addClass("actived");
		$("#login").removeClass("actived");
		$("#container_dangnhap").hide();
		$("#container_sigup").show();
	});
	
	$(".btn_themgiohang").click(function(){
		var mamau = $(this).closest("tr").find(".mau").attr("data_idmau");
		var tenmau =  $(this).closest("tr").find(".mau").text();
		var masize = $(this).closest("tr").find(".size").attr("data_idsize");
		var tensize = $(this).closest("tr").find(".size").text();
		var tensanpham = $("#tensanpham").text();
		var giatien = $("#giatien").text();
		var masanpham = $("#tensanpham").attr("data_idsanpham");
		var soluong = $(this).closest("tr").find(".soluong").text();
		
		$.ajax({
			url:"/minishop/api/themgiohang",
			type:"GET",
			data:{
				idSanPham : masanpham,
				idMaMauSanPham : mamau,
				idSizeSanpham : masize,
				tenSanPham : tensanpham,
				tenMauSanPham : tenmau ,
				tenSizeSanPham : tensize,
				giatien : giatien ,
				soluong : soluong
			},
			success: function(value){
				
			}
		})
	});
})