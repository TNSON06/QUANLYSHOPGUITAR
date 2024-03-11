package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controler.DAOHD;
import controler.DAOSP;
import controler.DAOSPCT;
import model.hoadon;
import model.sanpham;
import model.sanphamCT;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class capnhatdonhang extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTextField txtSoLuong;
	private JTextField txtGia;
	private JTable table;
	private JTable tableDSSP;
	private JTable tableDSHD;
	private JTable tableCTSP;
	private List<hoadon> listhd;
	private List<sanpham> listsp;
	private List<sanphamCT> listspct;
	
	private DefaultTableModel modelHD;
	private DefaultTableModel modelSP;
	private DefaultTableModel modelSPCT;
	int selectedIndex;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					capnhatdonhang frame = new capnhatdonhang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public capnhatdonhang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1170, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ ĐƠN HÀNG");
		lblNewLabel.setBounds(457, 10, 239, 30);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 23));
		lblNewLabel.setBackground(Color.WHITE);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 68, 468, 135);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tên khách hàng :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 22, 110, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(10, 84, 110, 22);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Địa chỉ :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(257, 22, 61, 22);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Ngày đặt :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_3.setBounds(257, 84, 72, 22);
		panel.add(lblNewLabel_1_3);
		
		txtTenKH = new JTextField();
		txtTenKH.setBounds(130, 24, 120, 20);
		panel.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(130, 86, 120, 20);
		panel.add(txtSDT);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(328, 24, 120, 20);
		panel.add(txtDiaChi);
		
		JDateChooser dateChooserNgayDat = new JDateChooser();
		dateChooserNgayDat.setBounds(328, 84, 120, 20);
		panel.add(dateChooserNgayDat);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(488, 68, 656, 135);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("Mã sản phẩm :");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_4.setBounds(10, 22, 99, 22);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Tên sản phẩm :");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_5.setBounds(10, 82, 110, 22);
		panel_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Loại :");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_6.setBounds(261, 22, 48, 22);
		panel_1.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Số lượng:");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_7.setBounds(264, 82, 66, 22);
		panel_1.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("Giá :");
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_8.setBounds(464, 22, 38, 22);
		panel_1.add(lblNewLabel_1_8);
		
		txtMaSP = new JTextField();
		txtMaSP.setColumns(10);
		txtMaSP.setBounds(113, 24, 120, 20);
		panel_1.add(txtMaSP);
		
		txtTenSP = new JTextField();
		txtTenSP.setColumns(10);
		txtTenSP.setBounds(113, 84, 120, 20);
		panel_1.add(txtTenSP);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(333, 84, 120, 20);
		panel_1.add(txtSoLuong);
		
		txtGia = new JTextField();
		txtGia.setColumns(10);
		txtGia.setBounds(512, 24, 120, 20);
		panel_1.add(txtGia);
		
		JComboBox cbbLoai = new JComboBox();
		cbbLoai.setModel(new DefaultComboBoxModel(new String[] {"Acoustic", "Classic", "Điện", "Bass", "Silent", "Resonator", "Torres", "Flamenco", "Hawaii", "Pocket", "Harp", "Multi_Neck"}));
		cbbLoai.setBounds(333, 23, 121, 22);
		panel_1.add(cbbLoai);
		
		JButton btnThemHD = new JButton("Thêm hóa đơn");
		btnThemHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTenKH.setText("");
				txtDiaChi.setText("");
				txtSDT.setText("");
				txtMaSP.setText("");
				txtTenSP.setText("");
				txtSoLuong.setText("");
				txtGia.setText("");
				cbbLoai.setSelectedItem(null);
				dateChooserNgayDat.setDate(null);
				
			}
		});
		btnThemHD.setBounds(34, 214, 109, 30);
		contentPane.add(btnThemHD);
		
		JButton btnThemSP = new JButton("Thêm sản phẩm");
		btnThemSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String masp="";
				int soluong=0;
				int gia=0;
				soluong = Integer.parseInt(txtSoLuong.getText());
				masp = txtMaSP.getText();
				gia = Integer.parseInt(txtGia.getText());
				int giasau = soluong *gia;
				sanphamCT sp =new sanphamCT(masp,soluong,giasau);
				new DAOSPCT().ThemSPCT(sp);
				showTableSPCT();
			}
		});
		btnThemSP.setBounds(170, 214, 109, 30);
		contentPane.add(btnThemSP);
		
		JButton btnXoaHD = new JButton("Xóa hóa đơn");
		btnXoaHD.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 selectedIndex=tableDSHD.getSelectedRow();
				 hoadon hd =listhd.get(selectedIndex);
				 JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?");
				 new DAOHD().DelHD(hd.getMaHD());
				 
				 showTableHD();
				
				 JOptionPane.showMessageDialog(null, "Xóa hóa đơn thành công!");
				 
			}
		});
		btnXoaHD.setBounds(847, 214, 109, 30);
		contentPane.add(btnXoaHD);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.util.Date utilDate = dateChooserNgayDat.getDate();
				 java.sql.Date selectedDate =null;
				if (utilDate != null) {
				   selectedDate = new java.sql.Date(utilDate.getTime());
					int gia =0;
					for (int i = 0; i < tableCTSP.getRowCount(); i++) {
						gia+=Integer.parseInt(tableCTSP.getValueAt(i, 3).toString());
					}
					hoadon hd =new hoadon(selectedDate,gia);
					new DAOHD().ThemHD(hd);
					showTableHD();
					JOptionPane.showMessageDialog(null, "Lưu hóa đơn thành công!");
				}
				else {
					JOptionPane.showMessageDialog(null, "Hãy chọn ngày đặt");
				}
			
			}
		});
		btnLuu.setBounds(992, 214, 109, 30);
		contentPane.add(btnLuu);
		
		table = new JTable();
		table.setBounds(90, 317, 1, 1);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 276, 468, 179);
		contentPane.add(scrollPane);
		
		tableDSSP = new JTable();
		tableDSSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedIndex = tableDSSP.getSelectedRow();
				sanpham sp = listsp.get(selectedIndex);
				txtMaSP.setText(sp.getMaSP());
				txtTenSP.setText(sp.getTenSP());
				cbbLoai.setSelectedItem(sp.getLoai());
				txtGia.setText(sp.getGia()+"");
				
			}
		});
		scrollPane.setViewportView(tableDSSP);
		tableDSSP.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "Lo\u1EA1i", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1"
			}
		));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Danh sách sản phẩm");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(10, 253, 151, 22);
		contentPane.add(lblNewLabel_1_1_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(488, 274, 656, 353);
		contentPane.add(scrollPane_1);
		
		tableDSHD = new JTable();
		scrollPane_1.setViewportView(tableDSHD);
		tableDSHD.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"M\u00E3 h\u00F3a \u0111\u01A1n", "Ng\u00E0y \u0111\u1EB7t", "Th\u00E0nh ti\u1EC1n"
			}
		));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Danh sách hóa đơn");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1_1.setBounds(488, 253, 151, 22);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 484, 468, 143);
		contentPane.add(scrollPane_2);
		
		tableCTSP = new JTable();
		tableCTSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedIndex = tableCTSP.getSelectedRow();
				sanphamCT sp = listspct.get(selectedIndex);
				new DAOSPCT().DelSP(sp.getID());
				showTableSPCT();
			}
		});
		scrollPane_2.setViewportView(tableCTSP);
		tableCTSP.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"ID", "M\u00E3 s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1"
			}
		));
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Chi tiết sản phẩm");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1_2.setBounds(10, 463, 151, 22);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.setVisible(true);
				dispose();
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThoat.setBounds(10, 10, 89, 23);
		contentPane.add(btnThoat);
		modelHD=(DefaultTableModel)tableDSHD.getModel();
		modelSP=(DefaultTableModel)tableDSSP.getModel();
		modelSPCT=(DefaultTableModel)tableCTSP.getModel();
		showTableHD();
		showTableSP();
		showTableSPCT();
		
	}

	private void showTableSPCT() {
		listspct = new DAOSPCT().getListSPCT();
		modelSPCT.setRowCount(0);
		for (sanphamCT sp : listspct) {
			modelSPCT.addRow(new Object[] {
					sp.getID(),sp.getMaSP(),sp.getSoLuong(),sp.getGia()
			});
		}
	}

	private void showTableSP() {
		listsp = new DAOSP().getListSP();
		modelSP.setRowCount(0);
		for (sanpham sp : listsp) {
			modelSP.addRow(new Object [] {
					sp.getID(),sp.getMaSP(),sp.getTenSP(),sp.getLoai(),sp.getSoLuong(),sp.getGia()
			});
		}
		
	}

	private void showTableHD() {
		listhd = new DAOHD().getListHD();
		modelHD.setRowCount(0);
		for (hoadon hd : listhd) {
			modelHD.addRow(new Object[] {
					hd.getMaHD(),hd.getNgayDat(),hd.getThanhTien()			});
		}
	}
}
