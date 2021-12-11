package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import database.NhanvienDAO;
import model.CarModel;
import model.Global;
import model.NhanVien;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTable tableCar;
	private static NhanvienDAO nvDAO = new NhanvienDAO();
	private DefaultTableModel model;
	private static NhanVien nv;
	
	public MainFrame() {
		Global.nv =  nvDAO.getNhanVien(Global.acc.getUsername());
		setTitle("QUẢN LÝ CỬA HÀNG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 707, 354);
		contentPane.add(scrollPane);
		
		tableCar = new JTable();
		scrollPane.setViewportView(tableCar);
		
		
		JButton btnManager = new JButton("QUẢN LÝ");
		btnManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		btnManager.setBounds(10, 11, 115, 47);
		contentPane.add(btnManager);
		if (Global.acc.getUsertype() == "SALES") btnManager.setEnabled(false);
		
		JButton btnCar = new JButton("DANH SÁCH XE");
		btnCar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CarFrame frame = new CarFrame();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnCar.setBounds(135, 11, 137, 47);
		contentPane.add(btnCar);
		
		JButton btnKhchHng = new JButton("KHÁCH HÀNG");
		btnKhchHng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CustomerFrame frame = new CustomerFrame();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnKhchHng.setBounds(282, 11, 115, 47);
		contentPane.add(btnKhchHng);
		
		JButton btnDanhSchHo = new JButton("HOÁ ĐƠN");
		btnDanhSchHo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							BillFrame frame = new BillFrame();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnDanhSchHo.setBounds(407, 11, 115, 47);
		contentPane.add(btnDanhSchHo);
		
		JButton btnNewButton_3_1 = new JButton("TẠO HOÁ ĐƠN");
		btnNewButton_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CreateBillFrame frame = new CreateBillFrame();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_3_1.setBounds(727, 69, 137, 47);
		contentPane.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_2 = new JButton("ĐỔI MẬT KHẨU");
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ChangePasswordFrame frame = new ChangePasswordFrame();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_3_2.setBounds(727, 128, 137, 47);
		contentPane.add(btnNewButton_3_2);
		
		JButton btnNewButton_3_3 = new JButton("ĐỔI THÔNG TIN");
		btnNewButton_3_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							UpdateInfoEmployee frame = new UpdateInfoEmployee();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_3_3.setBounds(727, 186, 137, 47);
		contentPane.add(btnNewButton_3_3);
		
		JButton btnExti = new JButton("THOÁT");
		btnExti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnExti.setForeground(new Color(0, 0, 0));
		btnExti.setBackground(new Color(204, 0, 51));
		btnExti.setBounds(727, 375, 137, 47);
		contentPane.add(btnExti);
		
		JButton btnStatistics = new JButton("THỐNG KÊ");
		btnStatistics.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							StatisticsFrame frame = new StatisticsFrame();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});	
			}
		});
		btnStatistics.setBounds(727, 244, 137, 47);
		contentPane.add(btnStatistics);
		loadData();
		if(Global.acc.getUsertype().equals("SALES")) {
			btnManager.setEnabled(false);	
		}
	}
	
	private void loadData() {
		model = new DefaultTableModel();
		// set column headers
		Vector column = new Vector();
		column.add("ID Xe");
		column.add("Model Xe");
		column.add("Màu Xe");
		column.add("Thương Hiệu");
		column.add("Loại");
		column.add("Phân Khối");
		column.add("Xuất Xứ");
		column.add("Trạng Thái");
		column.add("Giá Xe");
		model.setColumnIdentifiers(column);
		ArrayList<CarModel> list = CarModel.viewAllCar();
		for (int i = 0; i < list.size(); i++) {
			CarModel car = (CarModel) list.get(i);
			Vector row = new Vector();
			row.add(car.getId());
			row.add(car.getModelXe());
			row.add(car.getMauXe());
			row.add(car.getThuongHieu());
			row.add(car.getLoai());
			row.add(car.getPhanKhoi());
			row.add(car.getXuatXu());
			row.add(car.getTrangThai());
			row.add(car.getGiaXe());
			model.addRow(row);
		}
		tableCar.setModel(model);
	}
	
}
