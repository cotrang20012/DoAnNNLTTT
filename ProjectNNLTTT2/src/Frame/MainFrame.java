package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.NhanvienDAO;
import model.Account;
import model.NhanVien;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTable tableCar;
	private static NhanvienDAO nvDAO = new NhanvienDAO();
	private static NhanVien nv;
	public MainFrame(Account acc) {
		nv = nvDAO.getNhanVien(acc.getUsername());
		setTitle("QUẢN LÝ CỬA HÀNG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 490, 354);
		contentPane.add(scrollPane);
		
		tableCar = new JTable();
		scrollPane.setViewportView(tableCar);
		
		JButton btnManager = new JButton("QUẢN LÝ");
		btnManager.setBounds(10, 11, 115, 47);
		contentPane.add(btnManager);
		
		JButton btnCar = new JButton("DANH SÁCH XE");
		btnCar.setBounds(135, 11, 137, 47);
		contentPane.add(btnCar);
		
		JButton btnKhchHng = new JButton("KHÁCH HÀNG");
		btnKhchHng.setBounds(282, 11, 115, 47);
		contentPane.add(btnKhchHng);
		
		JButton btnDanhSchHo = new JButton("HOÁ ĐƠN");
		btnDanhSchHo.setBounds(407, 11, 115, 47);
		contentPane.add(btnDanhSchHo);
		
		JButton btnNewButton_3_1 = new JButton("TẠO HOÁ ĐƠN");
		btnNewButton_3_1.setBounds(507, 69, 137, 47);
		contentPane.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_2 = new JButton("ĐỔI MẬT KHẨU");
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ChangePasswordFrame frame = new ChangePasswordFrame(acc);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_3_2.setBounds(507, 127, 137, 47);
		contentPane.add(btnNewButton_3_2);
		
		JButton btnNewButton_3_3 = new JButton("ĐỔI THÔNG TIN");
		btnNewButton_3_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							UpdateInfoEmployee frame = new UpdateInfoEmployee(nv);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_3_3.setBounds(507, 185, 137, 47);
		contentPane.add(btnNewButton_3_3);
		
		JButton btnExti = new JButton("THOÁT");
		btnExti.setForeground(new Color(0, 0, 0));
		btnExti.setBackground(new Color(204, 0, 51));
		btnExti.setBounds(507, 375, 137, 47);
		contentPane.add(btnExti);
	}
}
