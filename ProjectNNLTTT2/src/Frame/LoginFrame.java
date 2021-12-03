package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.AccountDAO;
import model.Account;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textPassword;
	AccountDAO accDao = new AccountDAO();
	Account acc = new Account();

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
				if (textUser.getText().trim().length() == 0 || textPassword.getText().trim().length() == 0)
					JOptionPane.showMessageDialog(null, "Username hoặc password còn trống", "Warning",
							JOptionPane.INFORMATION_MESSAGE);
				else {
					acc.setUsername(textUser.getText().trim());
					acc.setPassword(textPassword.getText().trim());
					if (rdbtnManager.isSelected() == true)
						acc.setUsertype("QUANLY");
					else
						acc.setUsertype("SALES");
					try {
						if (accDao.checkLogin(acc) == 1) {
							if (acc.getUsertype() == "QUANLY") {
								EventQueue.invokeLater(new Runnable() {
									public void run() {
										try {
											ManagerFrom frame = new ManagerFrom();
											frame.setVisible(true);
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								});
							}
							else  {
								EventQueue.invokeLater(new Runnable() {
									public void run() {
										try {
											MainFrame frame = new MainFrame( new Account(textUser.getText(),textPassword.getText(),"SALES"));
											frame.setVisible(true);
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								});
							}
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
