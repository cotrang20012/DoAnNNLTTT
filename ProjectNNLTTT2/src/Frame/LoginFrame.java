package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("ĐĂNG NHẬP");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TÀI KHOẢN:");
		lblNewLabel.setBounds(47, 42, 81, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MẬT KHẨU:");
		lblNewLabel_1.setBounds(47, 78, 81, 14);
		contentPane.add(lblNewLabel_1);
		
		textUser = new JTextField();
		textUser.setBounds(138, 39, 158, 20);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setBounds(138, 75, 158, 20);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		JRadioButton rdbtnManager = new JRadioButton("QUẢN LÝ");
		rdbtnManager.setSelected(true);
		rdbtnManager.setBounds(85, 125, 109, 23);
		contentPane.add(rdbtnManager);
		
		JRadioButton rdbtnSales = new JRadioButton("SALES");
		rdbtnSales.setBounds(250, 125, 109, 23);
		contentPane.add(rdbtnSales);
		
		JButton btnExit = new JButton("THOÁT");
		btnExit.setBounds(49, 167, 102, 23);
		contentPane.add(btnExit);
		
		JButton btnLogin = new JButton("ĐĂNG NHẬP");
		btnLogin.setBounds(250, 167, 102, 23);
		contentPane.add(btnLogin);
	}
}
