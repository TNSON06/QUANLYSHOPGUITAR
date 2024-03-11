package controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import model.sanpham;

public class DAOSP {
	private Connection cnn;
	public DAOSP() {
		try {
			String url ="jdbc:mysql://localhost:3306/shopghita";
			String user ="root";
			String password="";
			cnn = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<sanpham> getListSP(){
		ArrayList<sanpham> listsp = new ArrayList<>();
		String query = "SELECT * FROM `sanpham`";
		try {
			PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				sanpham sp = new sanpham();
				sp.setID(rs.getInt("ID"));
				sp.setMaSP(rs.getString("MaSP"));
				sp.setTenSP(rs.getString("TenSP"));
				sp.setLoai(rs.getString("Loai"));
				sp.setSoLuong(rs.getInt("SoLuong"));
				sp.setGia(rs.getInt("Gia"));
				listsp.add(sp);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listsp;
	}
	public void ThemSP(sanpham sp) {
		String query ="INSERT INTO `sanpham`(`MaSP`,`TenSP`,`Loai`,`SoLuong`,`Gia`) VALUES"+"(?,?,?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(query);
			ps.setString(1,sp.getMaSP());
			ps.setString(2,sp.getTenSP());
			ps.setString(3,sp.getLoai());
			ps.setInt(4,sp.getSoLuong());
			ps.setInt(5,sp.getGia());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void SuaSP(sanpham sp) {
	    String query = "UPDATE `sanpham` SET `TenSP`=?, `Loai`=?, `SoLuong`=?, `Gia`=? WHERE `MaSP`=?";
	    try {
	        PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(query);
	        ps.setString(1, sp.getTenSP());
	        ps.setString(2, sp.getLoai());
	        ps.setInt(3, sp.getSoLuong());
	        ps.setInt(4, sp.getGia());
	        ps.setString(5, sp.getMaSP());
	        ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void DelSP(int id) {
		String query = "DELETE FROM `sanpham` WHERE ID=? ";
		try {
			PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<sanpham> TKByTenSP(String tensp){
		ArrayList<sanpham> listsp = new ArrayList<>();
		String query = "SELECT * FROM `sanpham` WHERE TenSP like ?";
		try {
			PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(query);
			ps.setString(1,"%"+tensp+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				sanpham sp = new sanpham();
				sp.setID(rs.getInt("ID"));
				sp.setMaSP(rs.getString("MaSP"));
				sp.setTenSP(rs.getString("TenSP"));
				sp.setLoai(rs.getString("Loai"));
				sp.setSoLuong(rs.getInt("SoLuong"));
				sp.setGia(rs.getInt("Gia"));
				listsp.add(sp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listsp;
		
	}
	public static void main(String[] args) {
		new DAOSP() ;
	}
}
 