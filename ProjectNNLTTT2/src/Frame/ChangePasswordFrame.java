package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.AccountDAO;
import model.Account;
import model.Global;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePasswordFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textCurPass;
	private JTextField textNewPass;
	private JTextField textRepeatPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the frame.
	 */
	public ChangePasswordFrame() {
		setTitle("ĐỔI MẬT KHẨU");
		setBounds(100, 100, 381, 176);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("MẬT KHẨU HIỆN TẠI:");
		lblNewLabel.setBounds(30, 21, 112, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("MẬT KHẨU MỚI");
		lblNewLabel_1.setBounds(30, 46, 112, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("NHẬP LẠI MẬT KHẨU:");
		lblNewLabel_2.setBounds(30, 71, 112, 14);
		contentPane.add(lblNewLabel_2);

		textCurPass = new JTextField();
		textCurPass.setBounds(152, 18, 155, 20);
		contentPane.add(textCurPass);
		textCurPass.setColumns(10);

		textNewPass = new JTextField();
		textNewPass.setBounds(152, 43, 155, 20);
		contentPane.add(textNewPass);
		textNewPass.setColumns(10);

		textRepeatPass = new JTextField();
		textRepeatPass.setBounds(152, 68, 155, 20);
		contentPane.add(textRepeatPass);
		textRepeatPass.setColumns(10);

		JButton btnChangePass = new JButton("ĐỔI MẬT KHẨU");
		btnChangePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Global.acc.getPassword().equals(textCurPass.getText())) {
					if (textNewPass.getText().equals(textRepeatPass.getText()) && textNewPass.getText().trim().length() != 0) {
						AccountDAO accountDAO = new AccountDAO();
						Global.acc.setPassword(textNewPass.getText());
						if (accountDAO.Update(Global.acc)) JOptionPane.showMessageDialog(null, "Cập nhật thành công");
						else JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
					}
					else JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại password mới");
				}
				else JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại mật khẩu cũ");
			}
		});
		btnChangePass.setBounds(218, 99, 107, 23);
		contentPane.add(btnChangePass);

		JButton btnExit = new JButton("THOÁT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(67, 99, 107, 23);
		contentPane.add(btnExit);
	}

}
