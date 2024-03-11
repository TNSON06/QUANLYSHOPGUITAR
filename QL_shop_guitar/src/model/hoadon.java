package model;

import java.sql.Date;

public class hoadon {
	private int MaHD;
	private Date NgayDat;
	private int ThanhTien;
	public hoadon() {
		
	}
	public hoadon(int maHD, Date ngayDat, int thanhTien) {
		super();
		MaHD = maHD;
		NgayDat = ngayDat;
		ThanhTien = thanhTien;
	}
	public hoadon(Date ngayDat, int thanhTien) {
		super();
		NgayDat = ngayDat;
		ThanhTien = thanhTien;
	}
	public int getMaHD() {
		return MaHD;
	}
	public void setMaHD(int maHD) {
		MaHD = maHD;
	}
	public Date getNgayDat() {
		return NgayDat;
	}
	public void setNgayDat(Date ngayDat) {
		NgayDat = ngayDat;
	}
	public int getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien(int thanhTien) {
		ThanhTien = thanhTien;
	}
	
}
