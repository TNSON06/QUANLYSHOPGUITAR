package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.List;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controler.DAOHD;
import model.hoadon;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Thongke extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textTK;
	private JTable tableDT;
	 private JLabel lblNewLabel_2;
	private List<hoadon> listhd;
	DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Thongke frame = new Thongke();
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
	public Thongke() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 634);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tìm kiếm theo ngày");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(345, 102, 142, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("THỐNG KÊ DOANH THU");
		lblNewLabel.setBounds(113, 11, 272, 28);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		contentPane.add(lblNewLabel);
		
		textTK = new JTextField();
		textTK.setBounds(344, 137, 143, 20);
		contentPane.add(textTK);
		textTK.setColumns(10);
		
		JButton btnTK = new JButton("Tìm kiếm");
		btnTK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ngay = textTK.getText();
				if(ngay.length()>0) {
					listhd = new DAOHD().TKByNgay(ngay);
					model.setRowCount(0);
					for (hoadon hd : listhd) {
						model.addRow(new Object[] {
								hd.getMaHD(),hd.getNgayDat(),hd.getThanhTien()
						});
					}
					
				}
			}
		});
		btnTK.setBounds(243, 136, 89, 23);
		contentPane.add(btnTK);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textTK.setText("");
				showTableDT();
			}
		});
		btnRefresh.setBounds(139, 136, 89, 23);
		contentPane.add(btnRefresh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 176, 477, 360);
		contentPane.add(scrollPane);
		
		tableDT = new JTable();
		scrollPane.setViewportView(tableDT);
		tableDT.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"M\u00E3 h\u00F3a \u0111\u01A1n", "Ng\u00E0y \u0111\u1EB7t", "Th\u00E0nh ti\u1EC1n"
			}
		));
		
		 lblNewLabel_2 = new JLabel("Tổng doanh thu : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(125, 555, 362, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.setVisible(true);
				dispose();
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThoat.setBounds(10, 53, 89, 23);
		contentPane.add(btnThoat);
		setLocationRelativeTo(null);
		model=(DefaultTableModel)tableDT.getModel();
		showTableDT();
		Tong();
	}

	private void Tong() {
		DecimalFormat x = new DecimalFormat("###,###,###");
		int Tong=0;
		for (int i = 0; i <tableDT.getRowCount(); i++) {
			Tong+=Integer.parseInt(tableDT.getValueAt(i, 2).toString());
		}
		lblNewLabel_2.setText("Tổng doanh thu :"+x.format(Tong)+" "+"VND");
		
	}

	private void showTableDT() {
		listhd = new DAOHD().getListHD();
		model.setRowCount(0);
		for (hoadon hd : listhd) {
			model.addRow(new Object[] {
					hd.getMaHD(),hd.getNgayDat(),hd.getThanhTien()
			});
		}
		 
		
		       
	}
}
