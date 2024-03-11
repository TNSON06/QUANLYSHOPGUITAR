package controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import model.nhanvien;
import model.sanpham;

public class DAONV {
	private Connection cnn;
	public DAONV() {
		try {
			String url ="jdbc:mysql://localhost:3306/shopghita";
			String user ="root";
			String password="";
			cnn = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<nhanvien> getListNV(){
		ArrayList<nhanvien> listnv = new ArrayList<>();
		String query = "SELECT * FROM `nhanvien`";
		try {
			PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				nhanvien nv = new nhanvien();
				nv.setID(rs.getInt("ID"));
				nv.setMaNV(rs.getString("MaNV"));
				nv.setTenNV(rs.getString("TenNV"));
				nv.setChucVu(rs.getString("ChucVu"));
				nv.setNgaySinh(rs.getDate("NgaySinh"));
				nv.setGioiTinh(rs.getBoolean("GioiTinh"));
				nv.setDiaChi(rs.getString("DiaChi"));
				nv.setSDT(rs.getString("SDT"));
				nv.setEmail(rs.getString("Email"));
				nv.setLuong(rs.getInt("Luong"));
				

				
				listnv.add(nv);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listnv;
	}
	public void ThemNV(nhanvien nv) {
		
		String query ="INSERT INTO `nhanvien`( `MaNV`, `TenNV`, `ChucVu`, `NgaySinh`, `GioiTinh`, `DiaChi`, `SDT`, `Email`, `Luong`) VALUES "
				+"(?,?,?,?,?,?,?,?,?)";
		try {
			
			PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(query);
			ps.setString(1,nv.getMaNV());
			ps.setString(2,nv.getTenNV());
			ps.setString(3,nv.getChucVu());
			 ps.setDate(4, new java.sql.Date(nv.getNgaySinh().getTime()));
			ps.setBoolean(5, nv.getGioiTinh());
			ps.setString(6,nv.getDiaChi());
			ps.setString(7,nv.getSDT());
			ps.setString(8,nv.getEmail());
			ps.setInt(9,nv.getLuong());
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void DelNV(int id) {
		String query = "DELETE FROM `nhanvien` WHERE ID=? ";
		try {
			PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void SuaNV(nhanvien nv) {
		String query = "UPDATE `nhanvien` SET `TenNV`=?, `ChucVu`=?, `NgaySinh`=?, `GioiTinh`=?, `DiaChi`=?, `SDT`=?, `Email`=?, `Luong`=? WHERE `MaNV`=?";

	    try {
	    	PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(query);
			
			ps.setString(1,nv.getTenNV());
			ps.setString(2,nv.getChucVu());
			 ps.setDate(3, new java.sql.Date(nv.getNgaySinh().getTime()));
			ps.setBoolean(4, nv.getGioiTinh());
			ps.setString(5,nv.getDiaChi());
			ps.setString(6,nv.getSDT());
			ps.setString(7,nv.getEmail());
			ps.setInt(8,nv.getLuong());
			ps.setString(9,nv.getMaNV());
			ps.executeUpdate();
			
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public ArrayList<nhanvien> TKByTenNV(String tennv){
		ArrayList<nhanvien> listnv = new ArrayList<>();
		String query = "SELECT * FROM `nhanvien` WHERE TenNV like ?";
		try {
			PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(query);
			ps.setString(1,"%"+tennv+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				nhanvien nv = new nhanvien();
				nv.setID(rs.getInt("ID"));
				nv.setMaNV(rs.getString("MaNV"));
				nv.setTenNV(rs.getString("TenNV"));
				nv.setChucVu(rs.getString("ChucVu"));
				nv.setNgaySinh(rs.getDate("NgaySinh"));
				nv.setGioiTinh(rs.getBoolean("GioiTinh"));
				nv.setDiaChi(rs.getString("DiaChi"));
				nv.setSDT(rs.getString("SDT"));
				nv.setEmail(rs.getString("Email"));
				nv.setLuong(rs.getInt("Luong"));
				listnv.add(nv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listnv;
		
	}
}
