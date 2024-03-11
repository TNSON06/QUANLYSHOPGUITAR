package controler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import model.hoadon;
import model.sanpham;


public class DAOHD {
	private Connection cnn;
	public DAOHD() {
		try {
			String url ="jdbc:mysql://localhost:3306/shopghita";
			String user ="root";
			String password="";
			cnn = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<hoadon> getListHD(){
		ArrayList<hoadon> listhd = new ArrayList<>();
		String query = "SELECT * FROM `hoadon`";
		try {
			PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				hoadon hd = new hoadon();
				hd.setMaHD(rs.getInt("ID"));
				hd.setNgayDat(rs.getDate("NgayDat"));
				
				hd.setThanhTien(rs.getInt("ThanhTien"));
				listhd.add(hd);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listhd;
	}
	public void ThemHD(hoadon hd) {
		String query ="INSERT INTO `hoadon`(`NgayDat`, `ThanhTien`) VALUES (?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(query);
			ps.setDate(1,hd.getNgayDat());
			ps.setInt(2,hd.getThanhTien());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void DelHD(int id) {
		String query = "DELETE FROM `hoadon` WHERE ID=? ";
		try {
			PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<hoadon> TKByNgay(String d){
		ArrayList<hoadon> listhd = new ArrayList<>();
		String query = "SELECT * FROM `hoadon` WHERE NgayDat like ?";
		try {
			PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(query);
			
			ps.setString(1,"%"+d+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				hoadon hd = new hoadon();
				hd.setMaHD(rs.getInt("ID"));
				hd.setNgayDat(rs.getDate("NgayDat"));
				
				hd.setThanhTien(rs.getInt("ThanhTien"));
				listhd.add(hd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listhd;
		
	}
}
