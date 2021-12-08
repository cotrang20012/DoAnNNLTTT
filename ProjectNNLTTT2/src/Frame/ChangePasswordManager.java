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

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePasswordManager extends JFrame {

	private JPanel contentPane;

	public ChangePasswordManager(Account acc) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 345, 164);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mật khẩu mới");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(35, 24, 106, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nhập lại mật khẩu mới");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(31, 49, 155, 27);
		contentPane.add(lblNewLabel_1);
		
		JTextPane textNewPwd = new JTextPane();
		textNewPwd.setBounds(179, 24, 115, 20);
		contentPane.add(textNewPwd);
		
		JTextPane textRepeatPwd = new JTextPane();
		textRepeatPwd.setBounds(179, 49, 115, 20);
		contentPane.add(textRepeatPwd);
		
		JButton btnChange = new JButton("Đổi mật khẩu");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textNewPwd.getText().equals(textRepeatPwd.getText())) {
					acc.setPassword(textNewPwd.getText());
					AccountDAO accountDAO = new AccountDAO();
					if (accountDAO.Update(acc)) {JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công");
					ManagerFrom.CusTable();
					}
				}
			}
		});
		btnChange.setBounds(41, 87, 115, 23);
		contentPane.add(btnChange);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setBounds(179, 87, 89, 23);
		contentPane.add(btnThoat);
	}
}
