package controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import model.sanpham;
import model.sanphamCT;

public class DAOSPCT {
	private Connection cnn;
	public DAOSPCT() {
		try {
			String url ="jdbc:mysql://localhost:3306/shopghita";
			String user ="root";
			String password="";
			cnn = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<sanphamCT> getListSPCT(){
		ArrayList<sanphamCT> listspct = new ArrayList<>();
		String query = "SELECT * FROM `ctsanpham`";
		try {
			PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				sanphamCT sp = new sanphamCT();
				sp.setID(rs.getInt("ID"));
				sp.setMaSP(rs.getString("MaSP"));
				
				sp.setSoLuong(rs.getInt("SoLuong"));
				sp.setGia(rs.getInt("Gia"));
				listspct.add(sp);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listspct;
	}
	public void DelSP(int id) {
		String query = "DELETE FROM `ctsanpham` WHERE ID=? ";
		try {
			PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void ThemSPCT(sanphamCT sp) {
		String query ="INSERT INTO `ctsanpham`(`MaSP`, `SoLuong`, `Gia`) VALUES (?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(query);
			ps.setString(1,sp.getMaSP());
			ps.setInt(2,sp.getSoLuong());
			ps.setInt(3,sp.getGia());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
