package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.management.loading.PrivateClassLoader;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import model.CarModel;

public class InsertCarFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txt_xuatxu;
	private JTextField txt_model;
	private JTextField txt_mauxe;
	private JTextField txt_thuonghieu;
	private JTextField txt_loai;
	private JTextField txt_phankhoi;
	private JTextField txt_trangthai;
	private JTextField txt_gia;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertCarFrame frame = new InsertCarFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//processing methods
	public void clearText() {
		txt_gia.setText("");
		txt_loai.setText("");
		txt_mauxe.setText("");
		txt_xuatxu.setText("");
		txt_model.setText("");
		txt_phankhoi.setText("");
		txt_thuonghieu.setText("");
		txt_trangthai.setText("");
	}
	
	public boolean existEmptyField() {
		if(txt_gia.getText()==""||txt_loai.getText()==""||txt_mauxe.getText()==""||txt_model.getText()==""||txt_phankhoi.getText()==""||txt_thuonghieu.getText()==""||txt_trangthai.getText()=="") {
			return true;
		} else
			return false;
	}
	/**
	 * Create the frame.
	 */
	public InsertCarFrame() {
		//Initialize
		setTitle("Nhap Thong Tin Xe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_id = new JLabel("Xuất xứ:");
		lbl_id.setBounds(10, 45, 54, 14);
		contentPane.add(lbl_id);
		
		JLabel lbl_model = new JLabel("Model Xe:");
		lbl_model.setBounds(10, 75, 70, 14);
		contentPane.add(lbl_model);
		
		JLabel lbl_mauxe = new JLabel("M\u00E0u Xe:");
		lbl_mauxe.setBounds(10, 105, 70, 14);
		contentPane.add(lbl_mauxe);
		
		JLabel lbl_thuonghieu = new JLabel("Th\u01B0\u01A1ng Hi\u1EC7u:");
		lbl_thuonghieu.setBounds(10, 135, 80, 14);
		contentPane.add(lbl_thuonghieu);
		
		JLabel lbl_loai = new JLabel("Lo\u1EA1i Xe:");
		lbl_loai.setBounds(10, 165, 70, 14);
		contentPane.add(lbl_loai);
		
		JLabel lbl_phankhoi = new JLabel("Ph\u00E2n Kh\u1ED1i:");
		lbl_phankhoi.setBounds(10, 195, 70, 14);
		contentPane.add(lbl_phankhoi);
		
		JLabel lbl_trangthai = new JLabel("Tr\u1EA1ng Th\u00E1i:");
		lbl_trangthai.setBounds(10, 225, 70, 14);
		contentPane.add(lbl_trangthai);
		
		JLabel lbl_gia = new JLabel("Gi\u00E1 Xe:");
		lbl_gia.setBounds(10, 255, 70, 14);
		contentPane.add(lbl_gia);
		
		txt_xuatxu = new JTextField();
		txt_xuatxu.setBounds(90, 42, 170, 20);
		contentPane.add(txt_xuatxu);
		txt_xuatxu.setColumns(10);
		
		txt_model = new JTextField();
		txt_model.setBounds(90, 72, 170, 20);
		contentPane.add(txt_model);
		txt_model.setColumns(10);
		
		txt_mauxe = new JTextField();
		txt_mauxe.setBounds(90, 102, 170, 20);
		contentPane.add(txt_mauxe);
		txt_mauxe.setColumns(10);
		
		txt_thuonghieu = new JTextField();
		txt_thuonghieu.setBounds(90, 132, 170, 20);
		contentPane.add(txt_thuonghieu);
		txt_thuonghieu.setColumns(10);
		
		txt_loai = new JTextField();
		txt_loai.setBounds(90, 162, 170, 20);
		contentPane.add(txt_loai);
		txt_loai.setColumns(10);
		
		txt_phankhoi = new JTextField();
		txt_phankhoi.setBounds(90, 192, 170, 20);
		contentPane.add(txt_phankhoi);
		txt_phankhoi.setColumns(10);
		
		txt_trangthai = new JTextField();
		txt_trangthai.setBounds(90, 222, 170, 20);
		contentPane.add(txt_trangthai);
		txt_trangthai.setColumns(10);
		
		txt_gia = new JTextField();
		txt_gia.setBounds(90, 252, 170, 20);
		contentPane.add(txt_gia);
		txt_gia.setColumns(10);
		
		JButton btnAdd = new JButton("TH\u00CAM");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.setBounds(30, 283, 80, 42);
		contentPane.add(btnAdd);
		
		JButton btnClear = new JButton("H\u1EE6Y");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.setBounds(175, 283, 80, 42);
		contentPane.add(btnClear);
		
		
		
		//Add events for buttons
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Check empty fields
				if(existEmptyField()==true){
					JOptionPane.showMessageDialog(contentPane, "Vui lòng nhập đủ thông tin!");	
				}
				else{
				    CarModel car = new CarModel(-1,txt_model.getText(),txt_mauxe.getText(),txt_thuonghieu.getText(),txt_loai.getText(),Integer.parseInt(txt_phankhoi.getText()),txt_xuatxu.getText(),txt_trangthai.getText(),Integer.parseInt(txt_gia.getText()));
				    CarModel.insertCar(car);
				    JOptionPane.showMessageDialog(contentPane, "Nhập thành công!");
				    clearText();
				}
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearText();
			}
		});
	}
}