package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.NhanvienDAO;
import model.Account;
import model.Global;
import model.NhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateInfoEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField textAddress;
	private JTextField textPhone;

	public UpdateInfoEmployee() {
		setTitle("CẬP NHẬT THÔNG TIN");
		setBounds(100, 100, 322, 182);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ĐỊA CHỈ:");
		lblNewLabel.setBounds(35, 11, 89, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SỐ ĐIỆN THOẠI:");
		lblNewLabel_1.setBounds(35, 63, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		textAddress = new JTextField();
		textAddress.setBounds(134, 11, 128, 37);
		contentPane.add(textAddress);
		textAddress.setColumns(10);
		textAddress.setText(Global.nv.getDiachi());
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(134, 60, 128, 20);
		contentPane.add(textPhone);
		textPhone.setText(Global.nv.getSdt());
		
		JButton btnUpdate = new JButton("CẬP NHẬT");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textAddress.getText().equals("")|| textPhone.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					if (textAddress.getText() != Global.nv.getDiachi() || textPhone.getText() != Global.nv.getSdt()) {
						NhanvienDAO nvDAO = new NhanvienDAO();
						Global.nv.setDiachi(textAddress.getText());
						Global.nv.setSdt(textPhone.getText());
						if (nvDAO.UpdateNV(Global.nv)) JOptionPane.showMessageDialog(null, "Cập nhật thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						else JOptionPane.showMessageDialog(null, "Cập nhật thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						}
				}
			}
		});
		btnUpdate.setBounds(173, 104, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnExit = new JButton("THOÁT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(35, 104, 89, 23);
		contentPane.add(btnExit);
	}
}
