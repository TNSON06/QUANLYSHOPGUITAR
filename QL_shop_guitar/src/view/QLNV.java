package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

import controler.DAONV;
import controler.DAOSP;
import model.nhanvien;
import model.sanpham;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QLNV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtDiaChi;
	private JTextField txtEmail;
	private JTextField txtSDT;
	private JTextField txtLuong;
	private JTable tableNV;
	
	private List<nhanvien> listnv;
	private DefaultTableModel model;
	int selectedIndex;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLNV frame = new QLNV();
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
	public QLNV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1178, 641);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblNewLabel.setBounds(456, 11, 269, 26);
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(65, 48, 1049, 166);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên :");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 11, 107, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Họ và tên :");
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(10, 66, 107, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Giới tính :");
		lblNewLabel_1_2.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(10, 118, 107, 14);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Chức vụ  :");
		lblNewLabel_1_3.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_1_3.setBounds(369, 12, 107, 14);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Ngày sinh :");
		lblNewLabel_1_4.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_1_4.setBounds(369, 66, 107, 18);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Địa chỉ :");
		lblNewLabel_1_5.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_1_5.setBounds(369, 118, 107, 14);
		panel.add(lblNewLabel_1_5);
		
		JDateChooser dateChooserCV = new JDateChooser();
		dateChooserCV.setBounds(452, 66, 151, 20);
		panel.add(dateChooserCV);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Email :");
		lblNewLabel_1_5_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_1_5_1.setBounds(678, 12, 107, 14);
		panel.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_5_2 = new JLabel("Số điện thoại :");
		lblNewLabel_1_5_2.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_1_5_2.setBounds(678, 67, 107, 14);
		panel.add(lblNewLabel_1_5_2);
		
		JLabel lblNewLabel_1_5_3 = new JLabel("Lương :");
		lblNewLabel_1_5_3.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_1_5_3.setBounds(678, 119, 107, 17);
		panel.add(lblNewLabel_1_5_3);
		
		txtMaNV = new JTextField();
		txtMaNV.setBounds(114, 9, 128, 20);
		panel.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(114, 64, 128, 20);
		panel.add(txtTenNV);
		
		JComboBox cbbChucVu = new JComboBox();
		cbbChucVu.setModel(new DefaultComboBoxModel(new String[] {"(BH) Bán Hàng", "(QL) Quản Lý", "(BV) Bảo Vệ"}));
		cbbChucVu.setBounds(452, 8, 151, 22);
		panel.add(cbbChucVu);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(452, 116, 128, 20);
		panel.add(txtDiaChi);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(777, 9, 128, 20);
		panel.add(txtEmail);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(777, 64, 128, 20);
		panel.add(txtSDT);
		
		txtLuong = new JTextField();
		txtLuong.setColumns(10);
		txtLuong.setBounds(777, 116, 128, 20);
		panel.add(txtLuong);
		
		JRadioButton rbtnNam = new JRadioButton("Nam");
		rbtnNam.setBounds(115, 115, 62, 23);
		panel.add(rbtnNam);
		
		JRadioButton rbtnNu = new JRadioButton("Nữ");
		rbtnNu.setBounds(180, 115, 62, 23);
		panel.add(rbtnNu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 244, 1049, 275);
		contentPane.add(scrollPane);
		
		tableNV = new JTable();
		tableNV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedIndex = tableNV.getSelectedRow();
				nhanvien nv = listnv.get(selectedIndex);
				txtMaNV.setText(nv.getMaNV());
				txtTenNV.setText(nv.getTenNV());
				txtDiaChi.setText(nv.getDiaChi());
				boolean gt = nv.getGioiTinh();
				if(gt==true) {
					rbtnNam.setSelected(true);
				}
				else {
					rbtnNu.setSelected(true);
				}
				cbbChucVu.setSelectedItem(nv.getChucVu());
				txtEmail.setText(nv.getEmail());
				txtSDT.setText(nv.getSDT());
				txtLuong.setText(nv.getLuong()+"");
				dateChooserCV.setDate(nv.getNgaySinh());
				
			}
		});
		scrollPane.setViewportView(tableNV);
		tableNV.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "M\u00E3 nh\u00E2n vi\u00EAn", "H\u1ECD v\u00E0 t\u00EAn", "Ch\u1EE9c v\u1EE5", "Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "\u0110\u1ECBa ch\u1EC9", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "Email", "L\u01B0\u01A1ng"
			}
		));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(146, 540, 873, 32);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nhanvien nv = new nhanvien();
				nv.setMaNV(txtMaNV.getText());
				nv.setTenNV(txtTenNV.getText());
				nv.setChucVu(cbbChucVu.getSelectedItem().toString());
				java.sql.Date selectedDate = new java.sql.Date(dateChooserCV.getDate().getTime());
				if (selectedDate != null) {
				    if (selectedDate instanceof java.util.Date) {
				        nv.setNgaySinh( selectedDate);
				    } else {
				        System.out.println("Lỗi: Không phải kiểu java.util.Date.");
				    }
				} else {
				    System.out.println("Không có ngày được chọn.");
				}
				
				nv.setDiaChi(txtDiaChi.getText());
				nv.setSDT(txtSDT.getText());
				nv.setEmail(txtEmail.getText());
				boolean gt=false;
				if(rbtnNam.isSelected())
				{
					gt = true;
				}
				else {
					gt = false;
				}
				nv.setGioiTinh(gt);
				boolean isOK=true;
				try {
					nv.setLuong(Integer.parseInt(txtLuong.getText()));
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Hãy nhập lương là số");
					isOK=false;
				}
				System.out.println(nv.getNgaySinh());
				if(isOK) {
					new DAONV().ThemNV(nv);
					showTable();
					JOptionPane.showMessageDialog(null, "Thêm thành công");
				}
				txtMaNV.setText("");
				txtTenNV.setText("");
				txtDiaChi.setText("");
				txtEmail.setText("");
				txtSDT.setText("");
				txtLuong.setText("");
				cbbChucVu.setSelectedIndex(0);
				rbtnNam.setSelected(false);
				rbtnNu.setSelected(false);
				dateChooserCV.setDate(null);
				
			}
		});
		btnThem.setForeground(Color.BLACK);
		btnThem.setBackground(new Color(102, 204, 204));
		panel_1.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (listnv.isEmpty()) {
				        JOptionPane.showMessageDialog(null, "Không có sản phẩm để sửa");
				    } else {
				        selectedIndex = tableNV.getSelectedRow();
				        if(selectedIndex < 0 || selectedIndex >= listnv.size()) {
				            JOptionPane.showMessageDialog(null, "Không có sản phẩm để sửa");
				        } else {
				            nhanvien nv = listnv.get(selectedIndex);
				            if(nv != null && nv.getMaNV().equals(txtMaNV.getText())) {
				            nhanvien n = new nhanvien();
				            nv.setMaNV(txtMaNV.getText());
							nv.setTenNV(txtTenNV.getText());
							nv.setChucVu(cbbChucVu.getSelectedItem().toString());
							java.sql.Date selectedDate = new java.sql.Date(dateChooserCV.getDate().getTime());
							if (selectedDate != null) {
							    if (selectedDate instanceof java.util.Date) {
							        nv.setNgaySinh( selectedDate);
							    } else {
							        System.out.println("Lỗi: Không phải kiểu java.util.Date.");
							    }
							} else {
							    System.out.println("Không có ngày được chọn.");
							}
							
							nv.setDiaChi(txtDiaChi.getText());
							nv.setSDT(txtSDT.getText());
							nv.setEmail(txtEmail.getText());
							boolean gt=false;
							if(rbtnNam.isSelected())
							{
								gt = true;
							}
							else {
								gt = false;
							}
							nv.setGioiTinh(gt);
							boolean isOK=true;
							try {
								nv.setLuong(Integer.parseInt(txtLuong.getText()));
								
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "Hãy nhập lương là số");
								isOK=false;
							}
							
							if(isOK) {
								new DAONV().SuaNV(nv);
								showTable();
								JOptionPane.showMessageDialog(null, "Sửa thành công");
							}
							txtMaNV.setText("");
							txtTenNV.setText("");
							txtDiaChi.setText("");
							txtEmail.setText("");
							txtSDT.setText("");
							txtLuong.setText("");
							cbbChucVu.setSelectedIndex(0);
							rbtnNam.setSelected(false);
							rbtnNu.setSelected(false);
							dateChooserCV.setDate(null);
							
							}
				        }
				    }
			}
		});
		btnSua.setForeground(new Color(0, 0, 0));
		
		btnSua.setBackground(new Color(102, 204, 204));
		panel_1.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedIndex = tableNV.getSelectedRow();
				nhanvien nv = listnv.get(selectedIndex);
				JOptionPane.showMessageDialog(null, "Bạn có chắc muốn xóa?");
				new DAONV().DelNV(nv.getID());
				showTable();
			}
		});
		btnXoa.setForeground(new Color(0, 0, 0));
		btnXoa.setBackground(new Color(102, 204, 204));
		panel_1.add(btnXoa);
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaNV.setText("");
				txtTenNV.setText("");
				txtDiaChi.setText("");
				txtEmail.setText("");
				txtSDT.setText("");
				txtLuong.setText("");
				cbbChucVu.setSelectedIndex(0);
				rbtnNam.setSelected(false);
				rbtnNu.setSelected(false);
				dateChooserCV.setDate(null);
				showTable();
			}
		});
		btnLamMoi.setForeground(Color.BLACK);
		btnLamMoi.setBackground(new Color(102, 204, 204));
		panel_1.add(btnLamMoi);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tennv = txtTenNV.getText();
				if(tennv.length()>0) {
					listnv = new DAONV().TKByTenNV(tennv);
					model.setRowCount(0);
					for (nhanvien nv : listnv) {
						model.addRow(new Object[] {
								nv.getID(),nv.getMaNV(),nv.getTenNV(),nv.getChucVu(),nv.getNgaySinh(),nv.getGioiTinh(),nv.getDiaChi(),nv.getSDT(),nv.getEmail(),nv.getLuong()
						});
					}
				}
			}
		});
		btnTimKiem.setForeground(Color.BLACK);
		btnTimKiem.setBackground(new Color(102, 204, 204));
		panel_1.add(btnTimKiem);
		
		JButton btnNewButton = new JButton("Thoát");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home ();
				home.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(21, 14, 89, 23);
		contentPane.add(btnNewButton);
		
		this.setLocationRelativeTo(null);
		model = (DefaultTableModel)tableNV.getModel();
		showTable();
	}

	private void showTable() {
		listnv = new DAONV().getListNV();		
		model.setRowCount(0);
		for (nhanvien nv : listnv) {
			model.addRow(new Object[] {
					nv.getID(),nv.getMaNV(),nv.getTenNV(),nv.getChucVu(),nv.getNgaySinh(),nv.getGioiTinh(),nv.getDiaChi(),nv.getSDT(),nv.getEmail(),nv.getLuong()
			});
			
		}
	}
}
