package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ManagerFrom extends JFrame {

	private JPanel contentPane;
	private JTable tableEmployee;
	private JTable tableAccount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public ManagerFrom() {
		setTitle("QUẢN LÝ");
		setBounds(100, 100, 844, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddEmployee = new JButton("THÊM NHÂN VIÊN");
		btnAddEmployee.setBounds(10, 11, 126, 51);
		contentPane.add(btnAddEmployee);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 526, 348);
		contentPane.add(scrollPane);
		
		tableEmployee = new JTable();
		scrollPane.setViewportView(tableEmployee);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(551, 73, 267, 348);
		contentPane.add(scrollPane_1);
		
		tableAccount = new JTable();
		scrollPane_1.setViewportView(tableAccount);
		
		JButton btnUpdateEmployee = new JButton("SỬA THÔNG TIN");
		btnUpdateEmployee.setBounds(146, 11, 126, 51);
		contentPane.add(btnUpdateEmployee);
		
		JButton btnDeleteEmployee = new JButton("XOÁ NHÂN VIÊN");
		btnDeleteEmployee.setBounds(282, 11, 126, 51);
		contentPane.add(btnDeleteEmployee);
		
		JButton btnUpdateAccount = new JButton("SỬA TÀI KHOẢN");
		btnUpdateAccount.setBounds(418, 11, 126, 51);
		contentPane.add(btnUpdateAccount);
	}
}
