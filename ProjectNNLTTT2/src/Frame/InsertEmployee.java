package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.AccountDAO;
import database.NhanvienDAO;
import model.Account;
import model.NhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textSID;
	private JTextField textAddress;
	private JTextField textPhone;
	private JTextField textSalary;

	public InsertEmployee() {
		setTitle("THÊM THÔNG TIN NHÂN VIÊN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 319, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TÊN NHÂN VIÊN:");
		lblNewLabel.setBounds(32, 11, 93, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CMND/CCCD:");
		lblNewLabel_1.setBounds(32, 36, 93, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ĐỊA CHỈ:");
		lblNewLabel_2.setBounds(32, 61, 93, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("SỐ ĐIỆN THOẠI:");
		lblNewLabel_3.setBounds(32, 86, 93, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("LƯƠNG:");
		lblNewLabel_4.setBounds(32, 111, 93, 14);
		contentPane.add(lblNewLabel_4);
		
		ButtonGroup bg = new ButtonGroup();
		
		JRadioButton rdbtnManager = new JRadioButton("Manager");
		rdbtnManager.setBounds(49, 148, 109, 23);
		contentPane.add(rdbtnManager);
		
		JRadioButton rdbtnSales = new JRadioButton("Sales");
		rdbtnSales.setSelected(true);
		rdbtnSales.setBounds(183, 148, 109, 23);
		contentPane.add(rdbtnSales);
		bg.add(rdbtnSales);
		bg.add(rdbtnManager);
		
		textName = new JTextField();
		textName.setBounds(135, 8, 133, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textSID = new JTextField();
		textSID.setBounds(135, 33, 133, 20);
		contentPane.add(textSID);
		textSID.setColumns(10);
		
		textAddress = new JTextField();
		textAddress.setBounds(135, 58, 133, 20);
		contentPane.add(textAddress);
		textAddress.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setBounds(135, 83, 133, 20);
		contentPane.add(textPhone);
		textPhone.setColumns(10);
		
		textSalary = new JTextField();
		textSalary.setBounds(135, 108, 133, 20);
		contentPane.add(textSalary);
		textSalary.setColumns(10);
		
		JButton btnAdd = new JButton("THÊM ");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textSID.getText().trim().length() < 10)
					JOptionPane.showMessageDialog(null, "Vui lòng điền đúng CMND/CCCD");
				else {
					NhanVien nv = new NhanVien();
					NhanvienDAO nvDAO = new NhanvienDAO();
					AccountDAO accDAO = new AccountDAO();
					Account acc = new Account();
					nv.setCmnd(textSID.getText());
					nv.setTen(textName.getText());
					nv.setSdt(textPhone.getText());
					nv.setDiachi(textAddress.getText());
					nv.setLuong(Integer.valueOf(textSalary.getText()));
					acc.setUsername(textSID.getText());
					acc.setPassword("1");
					if (rdbtnManager.isSelected()) {
						nv.setChucvu("QUANLY");
						acc.setUsertype("QUANLY");
					}
					else {
						nv.setChucvu("SALES");
						acc.setUsertype("SALES");
					}
					System.out.print(accDAO.Insert(acc));
					System.out.print(nvDAO.Insert(nv));
					//if (accDAO.Insert(acc) && nvDAO.Insert(nv)) JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công");
					//else JOptionPane.showMessageDialog(null, "Thêm nhân viên thất bại");
				}
			}
		});
		btnAdd.setBounds(179, 191, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnExit = new JButton("THOÁT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(36, 191, 89, 23);
		contentPane.add(btnExit);
	}
}
