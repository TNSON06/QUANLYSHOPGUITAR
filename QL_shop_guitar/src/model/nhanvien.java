package model;

import java.sql.Date;


public class nhanvien {
	private int ID,Luong;
	private String MaNV,TenNV,ChucVu,DiaChi,SDT,Email;
	private Date NgaySinh;
	private boolean GioiTinh ;
	public nhanvien() {
	
	}
	public nhanvien(int iD, int luong, String maNV, String tenNV, String chucVu, String diaChi, String sDT,
			String email, Date ngaySinh, boolean gioiTinh) {
		
		ID = iD;
		Luong = luong;
		MaNV = maNV;
		TenNV = tenNV;
		ChucVu = chucVu;
		DiaChi = diaChi;
		SDT = sDT;
		Email = email;
		NgaySinh = ngaySinh;
		GioiTinh = gioiTinh;
	}
	public nhanvien(int luong, String maNV, String tenNV, String chucVu, String diaChi, String sDT, String email,
			Date ngaySinh, boolean gioiTinh) {
		super();
		Luong = luong;
		MaNV = maNV;
		TenNV = tenNV;
		ChucVu = chucVu;
		DiaChi = diaChi;
		SDT = sDT;
		Email = email;
		NgaySinh = ngaySinh;
		GioiTinh = gioiTinh;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getLuong() {
		return Luong;
	}
	public void setLuong(int luong) {
		Luong = luong;
	}
	public String getMaNV() {
		return MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	public String getTenNV() {
		return TenNV;
	}
	public void setTenNV(String tenNV) {
		TenNV = tenNV;
	}
	public String getChucVu() {
		return ChucVu;
	}
	public void setChucVu(String chucVu) {
		ChucVu = chucVu;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Date getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public boolean getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		GioiTinh = gioiTinh;
	}
	
	
}
