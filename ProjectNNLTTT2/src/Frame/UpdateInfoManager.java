package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.NhanvienDAO;
import model.NhanVien;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateInfoManager extends JFrame {

	private JPanel contentPane;

	public UpdateInfoManager(NhanVien nv) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(35, 64, 29, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Địa chỉ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(35, 90, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Chức vụ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(35, 171, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Lương");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(35, 140, 46, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("SĐT");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(35, 115, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Chỉnh sửa thông tin nhân viên");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(35, 11, 263, 38);
		contentPane.add(lblNewLabel_5);
		
		JTextPane textTen = new JTextPane();
		textTen.setBounds(89, 64, 172, 20);
		contentPane.add(textTen);
		
		JTextPane textDiachi = new JTextPane();
		textDiachi.setBounds(89, 90, 172, 20);
		contentPane.add(textDiachi);
		
		JTextPane textSDT = new JTextPane();
		textSDT.setBounds(89, 115, 172, 20);
		contentPane.add(textSDT);
		
		JTextPane textLuong = new JTextPane();
		textLuong.setBounds(89, 140, 172, 20);
		contentPane.add(textLuong);
		
		JRadioButton rdbtnManager = new JRadioButton("Manager");
		rdbtnManager.setBounds(87, 168, 88, 23);
		contentPane.add(rdbtnManager);
		
		JRadioButton rdbtnSales = new JRadioButton("Sale");
		rdbtnSales.setBounds(182, 168, 109, 23);
		contentPane.add(rdbtnSales);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnManager);
		bg.add(rdbtnSales);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nv.setTen(textTen.getText());
				nv.setDiachi(textDiachi.getText());
				nv.setLuong(Integer.parseInt(textLuong.getText()));
				nv.setSdt(textSDT.getText());
				if (rdbtnManager.isSelected()) nv.setChucvu("QUANLY");
				else nv.setChucvu("SALES");
				NhanvienDAO nvDAO = new NhanvienDAO();
				nvDAO.UpdateNV(nv);
			}
		});
		btnUpdate.setBounds(35, 208, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnExit = new JButton("Thoát");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(172, 208, 89, 23);
		contentPane.add(btnExit);
	}
}
