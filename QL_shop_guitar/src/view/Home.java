package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1043, 532);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnQLNV = new JButton("QUẢN LÝ NHÂN VIÊN");
		btnQLNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QLNV qlnv = new QLNV();
				qlnv.setVisible(true);
				dispose();
			}
		});
		btnQLNV.setBackground(new Color(0, 250, 154));
		btnQLNV.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnQLNV.setIcon(new ImageIcon("D:\\Downloads\\Global-Manager-icon.png"));
		btnQLNV.setBounds(69, 87, 398, 151);
		contentPane.add(btnQLNV);
		
		JLabel lblNewLabel = new JLabel("TRANG CHỦ");
		lblNewLabel.setBounds(434, 11, 180, 32);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setForeground(new Color(0, 51, 102));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setToolTipText("");
		contentPane.add(lblNewLabel);
		
		JButton btnQLSP = new JButton("QUẢN LÝ SẢN PHẨM");
		btnQLSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QLSP qlsp = new QLSP();
				qlsp.setVisible(true);
				dispose();
			}
		});
		btnQLSP.setForeground(new Color(0, 0, 0));
		btnQLSP.setIcon(new ImageIcon("D:\\Downloads\\restricted-manager-lock-icon.png"));
		btnQLSP.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnQLSP.setBackground(new Color(0, 153, 204));
		btnQLSP.setBounds(585, 87, 398, 151);
		contentPane.add(btnQLSP);
		
		JButton btnQLDH = new JButton("QUẢN LÝ ĐƠN HÀNG");
		btnQLDH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				capnhatdonhang cndh = new capnhatdonhang();
				cndh.setVisible(true);
				dispose();
			}
		});
		btnQLDH.setIcon(new ImageIcon("D:\\Downloads\\order-history-icon.png"));
		btnQLDH.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnQLDH.setBackground(new Color(102, 255, 204));
		btnQLDH.setBounds(69, 280, 398, 151);
		contentPane.add(btnQLDH);
		
		JButton btnTK = new JButton("THỐNG KÊ");
		btnTK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thongke tk = new Thongke();
				tk.setVisible(true);
				dispose();
			}
		});
		btnTK.setIcon(new ImageIcon("D:\\Downloads\\chart-icon.png"));
		btnTK.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTK.setBackground(new Color(255, 51, 102));
		btnTK.setBounds(585, 280, 398, 151);
		contentPane.add(btnTK);
		
		JButton btnDX = new JButton("Đăng xuất");
		btnDX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnDX.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDX.setBounds(877, 447, 106, 23);
		contentPane.add(btnDX);
	}

}
