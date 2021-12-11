package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import database.NhanvienDAO;

import model.Global;
import model.NhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;
	NhanvienDAO nhanvienDAO = new NhanvienDAO();
	private JPasswordField textPassword;

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
		textUser.setText("0000000000");
		textUser.setBounds(138, 39, 158, 20);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(138, 75, 158, 20);
		contentPane.add(textPassword);

		JRadioButton rdbtnManager = new JRadioButton("QUẢN LÝ");
		rdbtnManager.setSelected(true);
		rdbtnManager.setBounds(85, 125, 109, 23);
		contentPane.add(rdbtnManager);

		JRadioButton rdbtnSales = new JRadioButton("SALES");
		rdbtnSales.setBounds(250, 125, 109, 23);
		contentPane.add(rdbtnSales);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnManager);
		bg.add(rdbtnSales);

		JButton btnExit = new JButton("THOÁT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(49, 167, 102, 23);
		contentPane.add(btnExit);

		JButton btnLogin = new JButton("ĐĂNG NHẬP");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textUser.getText().length() == 0 || textPassword.getText().length() == 0)
					JOptionPane.showMessageDialog(null, "Username hoặc password còn trống", "Warning",
							JOptionPane.INFORMATION_MESSAGE);
				else {
					NhanVien nv = new NhanVien();
					nv.setCmnd(textUser.getText());
					nv.setPassword(textPassword.getText());
					if (rdbtnManager.isSelected() == true)
						nv.setChucvu("QUANLY");
					else
						nv.setChucvu("SALES");
					try {
						nv = nhanvienDAO.checkLogin(nv);
						if (nv != null) {
							Global.nv = nv;
								EventQueue.invokeLater(new Runnable() {
									public void run() {
										try {
											MainFrame frame = new MainFrame();
											frame.setVisible(true);
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								});
		
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Username hoặc password không đúng", "Warning",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		btnLogin.setBounds(250, 167, 102, 23);
		contentPane.add(btnLogin);
	}
}
