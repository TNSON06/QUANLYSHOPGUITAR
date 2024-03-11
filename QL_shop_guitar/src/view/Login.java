package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;



public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtUser;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Username :");
		lblNewLabel_1.setForeground(new Color(0, 51, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(61, 84, 82, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Cửa hàng Guitar S");
		lblNewLabel.setBounds(115, 23, 176, 24);
		lblNewLabel.setForeground(new Color(0, 0, 153));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password :");
		lblNewLabel_1_1.setForeground(new Color(0, 51, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(61, 130, 82, 36);
		contentPane.add(lblNewLabel_1_1);
		
		txtUser = new JPasswordField();
		txtUser.setForeground(new Color(0, 51, 153));
		txtUser.setToolTipText("");
		txtUser.setBounds(176, 92, 139, 20);
		contentPane.add(txtUser);
		
		txtPass = new JPasswordField();
		txtPass.setForeground(new Color(0, 51, 102));
		txtPass.setBounds(176, 139, 139, 20);
		contentPane.add(txtPass);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(0, 255, 0));
		btnLogin.setBackground(new Color(102, 153, 153));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtUser.getText().equals("admin")&&txtPass.getText().equals("admin")) {
					dispose();
					Home home = new Home();
					home.setVisible(true);
					}
				else if (txtUser.getText().equals("")&&txtPass.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Hãy nhập mật khẩu và tài khoản");
				}
				else {
					JOptionPane.showMessageDialog(null,"Sai mật khẩu và tài khoản");
					txtUser.setText(null);
					txtPass.setText(null);
				}
			}
		});
		btnLogin.setBounds(86, 209, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(new Color(255, 0, 0));
		btnCancel.setBackground(new Color(102, 153, 153));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(216, 209, 89, 23);
		contentPane.add(btnCancel);
	}
}
