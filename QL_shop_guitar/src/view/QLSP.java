package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import controler.DAOSP;
import model.sanpham;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QLSP extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTextField txtSoLuong;
	private JTextField txtGia;
	private JTable table;
	private JTable tableSP;
	
	private List<sanpham> listsp;
	private DefaultTableModel model;
	int selectedIndex;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSP frame = new QLSP();
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
	public QLSP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1182, 639);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ SẢN PHẨM");
		lblNewLabel.setBounds(471, 25, 243, 29);
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(103, 65, 888, 164);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã sản phẩm :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(111, 29, 94, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên sản phẩm :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(111, 83, 127, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Loại :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(111, 139, 127, 14);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Số lượng :");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1_1.setBounds(543, 29, 127, 14);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Giá :");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1_2.setBounds(543, 83, 127, 14);
		panel.add(lblNewLabel_1_1_1_2);
		
		txtMaSP = new JTextField();
		txtMaSP.setBounds(215, 27, 219, 20);
		panel.add(txtMaSP);
		txtMaSP.setColumns(10);
		
		txtTenSP = new JTextField();
		txtTenSP.setColumns(10);
		txtTenSP.setBounds(215, 81, 219, 20);
		panel.add(txtTenSP);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(639, 27, 219, 20);
		panel.add(txtSoLuong);
		
		txtGia = new JTextField();
		txtGia.setColumns(10);
		txtGia.setBounds(639, 81, 219, 20);
		panel.add(txtGia);
		
		JComboBox cbbLoai = new JComboBox();
		cbbLoai.setModel(new DefaultComboBoxModel(new String[] {"Acoustic", "Classic", "Điện", "Bass", "Silent", "Resonator", "Torres", "Flamenco", "Hawaii", "Pocket", "Harp", "Multi_Neck"}));
		cbbLoai.setToolTipText("");
		cbbLoai.setBounds(215, 136, 127, 22);
		panel.add(cbbLoai);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(47, 525, 1085, 42);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sanpham sp = new sanpham();
				sp.setMaSP(txtMaSP.getText());
				sp.setTenSP(txtTenSP.getText());
				sp.setLoai(cbbLoai.getSelectedItem().toString());
				boolean isOK =true;
				try {
					sp.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
					sp.setGia(Integer.parseInt(txtGia.getText()));
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Hãy nhập số vào ô Số lượng và Giá không phải kí tự");
					isOK = false;
				}
			
				if(isOK) {
					new DAOSP().ThemSP(sp);
					showTable();
					JOptionPane.showMessageDialog(null, "Thêm thành công!");
				}
				
			}
			
		});
		btnThem.setBackground(new Color(102, 204, 204));
		panel_1.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (listsp.isEmpty()) {
				        JOptionPane.showMessageDialog(null, "Không có sản phẩm để sửa");
				    } else {
				        selectedIndex = tableSP.getSelectedRow();
				        if(selectedIndex < 0 || selectedIndex >= listsp.size()) {
				            JOptionPane.showMessageDialog(null, "Không có sản phẩm để sửa");
				        } else {
				            sanpham S = listsp.get(selectedIndex);
				            if(S != null && S.getMaSP().equals(txtMaSP.getText())) {

				           
				            sanpham sp = new sanpham();
				            sp.setMaSP(txtMaSP.getText());
				            sp.setTenSP(txtTenSP.getText());
				            sp.setLoai(cbbLoai.getSelectedItem().toString());
				            boolean isOK = true;
				            try {
				                sp.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
				                sp.setGia(Integer.parseInt(txtGia.getText()));
				            } catch (Exception e2) {
				                JOptionPane.showMessageDialog(null, "Hãy nhập số vào ô Số lượng và Giá không phải kí tự");
				                isOK = false;
				            }

				            if (isOK) {
				                new DAOSP().SuaSP(sp);
				                showTable();
				                JOptionPane.showMessageDialog(null, "Sửa thành công!");
				            }
				        	txtMaSP.setText("");
							txtTenSP.setText("");
							txtSoLuong.setText("");
							txtGia.setText("");
							cbbLoai.setSelectedIndex(0);
				            }
				            else {
				            	   JOptionPane.showMessageDialog(null, "Không sửa mã sản phẩm");
				            }
				        }
				    }
			}
		});
		btnSua.setBackground(new Color(102, 204, 204));
		panel_1.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedIndex = tableSP.getSelectedRow();
				sanpham sp = listsp.get(selectedIndex);
				JOptionPane.showMessageDialog(null, "Bạn có chắc chắn muốn xóa?");
				new DAOSP().DelSP(sp.getID());
				showTable();
			}
		});
		btnXoa.setBackground(new Color(102, 204, 204));
		panel_1.add(btnXoa);
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaSP.setText("");
				txtTenSP.setText("");
				txtSoLuong.setText("");
				txtGia.setText("");
				cbbLoai.setSelectedIndex(0);
				showTable();
			}
		});
		btnLamMoi.setBackground(new Color(102, 204, 204));
		panel_1.add(btnLamMoi);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTimKiem.setBackground(new Color(102, 204, 204));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tensp = txtTenSP.getText();
				if(tensp.length()>0) {
					listsp = new DAOSP().TKByTenSP(tensp);
					model.setRowCount(0);
					for (sanpham sp : listsp) {
						model.addRow(new Object[] {
								tableSP.getRowCount()+1,sp.getMaSP(),sp.getTenSP(),sp.getLoai(),sp.getSoLuong(),sp.getGia()
								});
						
					}
				}
			}
		});
		panel_1.add(btnTimKiem);
		
		table = new JTable();
		table.setBounds(91, 289, 1, 1);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 240, 1101, 274);
		contentPane.add(scrollPane);
		
		tableSP = new JTable();
		tableSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedIndex = tableSP.getSelectedRow();
				sanpham sp = listsp.get(selectedIndex);
				txtMaSP.setText(sp.getMaSP());
				txtTenSP.setText(sp.getTenSP());
				cbbLoai.setSelectedItem(sp.getLoai());
				txtSoLuong.setText(sp.getSoLuong()+"");
				txtGia.setText(sp.getGia()+"");
			}
		});
		scrollPane.setViewportView(tableSP);
		tableSP.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Mã sản phẩm", "Tên sản phẩm", "Loại", "Số lượng", "Giá"
			}
		));
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.setVisible(true);
				dispose();
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThoat.setBounds(10, 11, 89, 23);
		contentPane.add(btnThoat);
		tableSP.getColumnModel().getColumn(4).setPreferredWidth(76);
		this.setLocationRelativeTo(null);
		model = (DefaultTableModel)tableSP.getModel();
		showTable();
	}

	private void showTable() {
	listsp = new DAOSP().getListSP();
	model.setRowCount(0);
	for (sanpham sanpham : listsp) {
		model.addRow(new Object[] {
			sanpham.getID(),sanpham.getMaSP(),sanpham.getTenSP(),sanpham.getLoai(),sanpham.getSoLuong(),sanpham.getGia()	
		});
	}
		
	}
}
