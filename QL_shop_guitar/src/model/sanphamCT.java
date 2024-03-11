package model;

public class sanphamCT {
	private int ID;
	private String MaSP;
	private int SoLuong;
	private int Gia;
	public sanphamCT() {
		
	}
	public sanphamCT(int iD, String maSP, int soLuong, int gia) {
		super();
		ID = iD;
		MaSP = maSP;
		SoLuong = soLuong;
		Gia = gia;
	}
	public sanphamCT(String maSP, int soLuong, int gia) {
		super();
		MaSP = maSP;
		SoLuong = soLuong;
		Gia = gia;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getMaSP() {
		return MaSP;
	}
	public void setMaSP(String maSP) {
		MaSP = maSP;
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
	
}
