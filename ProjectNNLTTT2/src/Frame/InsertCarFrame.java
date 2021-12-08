package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import database.MyDB;

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
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import model.CarModel;
import javax.swing.JComboBox;

public class InsertCarFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txt_xuatxu;
	private JTextField txt_model;
	private JTextField txt_mauxe;
	private JTextField txt_thuonghieu;
	private JTextField txt_phankhoi;
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
		txt_mauxe.setText("");
		txt_xuatxu.setText("");
		txt_model.setText("");
		txt_phankhoi.setText("");
		txt_thuonghieu.setText("");
	}
	
	public boolean existEmptyField() {
		if(txt_gia.getText()==""||txt_mauxe.getText()==""||txt_model.getText()==""||txt_phankhoi.getText()==""||txt_thuonghieu.getText()==""||txt_xuatxu.getText()=="") {
			return true;
		} else
			return false;
	}
	
	/**
	 * Create the frame.
	 */
	public InsertCarFrame() {
		//Initialize
		setTitle("Nhập Thông Tin Xe");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_id = new JLabel("Xuất xứ:");
		lbl_id.setBounds(10, 34, 54, 14);
		contentPane.add(lbl_id);
		
		JLabel lbl_model = new JLabel("Model Xe:");
		lbl_model.setBounds(10, 64, 70, 14);
		contentPane.add(lbl_model);
		
		JLabel lbl_mauxe = new JLabel("M\u00E0u Xe:");
		lbl_mauxe.setBounds(10, 94, 70, 14);
		contentPane.add(lbl_mauxe);
		
		JLabel lbl_thuonghieu = new JLabel("Th\u01B0\u01A1ng Hi\u1EC7u:");
		lbl_thuonghieu.setBounds(10, 124, 80, 14);
		contentPane.add(lbl_thuonghieu);
		
		JLabel lbl_loai = new JLabel("Lo\u1EA1i Xe:");
		lbl_loai.setBounds(10, 154, 70, 14);
		contentPane.add(lbl_loai);
		
		JLabel lbl_phankhoi = new JLabel("Ph\u00E2n Kh\u1ED1i:");
		lbl_phankhoi.setBounds(10, 184, 70, 14);
		contentPane.add(lbl_phankhoi);
		
		JLabel lbl_gia = new JLabel("Gi\u00E1 Xe:");
		lbl_gia.setBounds(10, 214, 70, 14);
		contentPane.add(lbl_gia);
		
		txt_xuatxu = new JTextField();
		txt_xuatxu.setBounds(90, 31, 170, 20);
		contentPane.add(txt_xuatxu);
		txt_xuatxu.setColumns(10);
		
		txt_model = new JTextField();
		txt_model.setBounds(90, 61, 170, 20);
		contentPane.add(txt_model);
		txt_model.setColumns(10);
		
		txt_mauxe = new JTextField();
		txt_mauxe.setBounds(90, 91, 170, 20);
		contentPane.add(txt_mauxe);
		txt_mauxe.setColumns(10);
		
		txt_thuonghieu = new JTextField();
		txt_thuonghieu.setBounds(90, 121, 170, 20);
		contentPane.add(txt_thuonghieu);
		txt_thuonghieu.setColumns(10);
		
		txt_phankhoi = new JTextField();
		txt_phankhoi.setBounds(90, 181, 170, 20);
		contentPane.add(txt_phankhoi);
		txt_phankhoi.setColumns(10);
		
		txt_gia = new JTextField();
		txt_gia.setBounds(90, 211, 170, 20);
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
		
		String[] loaiXe = {"XE 2 BÁNH", "XE 4 BÁNH"};
		JComboBox<String> cb_loai = new JComboBox(loaiXe);
		cb_loai.setBounds(90, 150, 170, 22);
		contentPane.add(cb_loai);
		cb_loai.setSelectedIndex(0);
			
		//Add events for buttons
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Check empty fields
				if(existEmptyField()==true){
					JOptionPane.showMessageDialog(contentPane, "Vui lòng nhập đủ thông tin!");	
				}
				else{
				    CarModel car = new CarModel(-1,txt_model.getText(),txt_mauxe.getText(),txt_thuonghieu.getText(),cb_loai.getSelectedItem().toString(),Integer.parseInt(txt_phankhoi.getText()),txt_xuatxu.getText(),"CHƯA BÁN",Integer.parseInt(txt_gia.getText()));
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