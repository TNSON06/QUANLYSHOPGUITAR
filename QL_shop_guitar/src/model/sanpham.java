package model;

public class sanpham {
	private int ID,SoLuong,Gia;
	private String MaSP,TenSP,Loai;
	public sanpham() {
		
	}
	public sanpham(int soLuong, int gia, String maSP, String tenSP, String loai) {
		
		this.SoLuong = soLuong;
		this.Gia = gia;
		this.MaSP = maSP;
		this.TenSP = tenSP;
		this.Loai = loai;
	}
	public sanpham(int iD, int soLuong, int gia, String maSP, String tenSP, String loai) {
		this.ID = iD;
		this.SoLuong = soLuong;
		this.Gia = gia;
		this.MaSP = maSP;
		this.TenSP = tenSP;
		this.Loai = loai;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public int getGia() {
		return Gia;
	}
	public void setGia(int gia) {
		Gia = gia;
	}
	public String getMaSP() {
		return MaSP;
	}
	public void setMaSP(String maSP) {
		MaSP = maSP;
	}
	public String getTenSP() {
		return TenSP;
	}
	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}
	public String getLoai() {
		return Loai;
	}
	public void setLoai(String loai) {
		Loai = loai;
	}
	
	
}
