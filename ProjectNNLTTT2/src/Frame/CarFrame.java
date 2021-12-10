package Frame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.a.result.ResultsetRowsStatic;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import model.CarModel;
import model.Global;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JComboBox;

public class CarFrame extends JFrame {

	private JPanel contentPane;
	private JTable tableCar;
	private JTextField txt_xuatxu;
	private JTextField txt_model;
	private JTextField txt_mauxe;
	private JTextField txt_thuonghieu;
	private JTextField txt_loai;
	private JTextField txt_phankhoi;
	private JTextField txt_trangthai;
	private JTextField txt_gia;
	private DefaultTableModel model;
	private JTextField txt_id;
	private JTextField txt_searchInfo;
	private JTextField txt_GiaXeMax;
	private JTextField txt_GiaXeMin;
	private JTextField txt_searchPhanKhoi;
	//Tạo element để làm parameter cho proc search null = -1
	private int priceMin = -1;
	private int priceMax = -1;
	private int phanKhoi = -1;
	private String modelXe = "-1";
	private String loaiXe = "-1";
	private String trangThai = "-1";
	private String xuatXu = "-1";
	private String thuongHieu = "-1";
	private String mauXe = "-1";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	private CarModel getCar() {
		CarModel car = new CarModel();
		car.setId(Integer.parseInt(txt_id.getText()));
		car.setGiaXe(Integer.parseInt(txt_gia.getText()));
		car.setPhanKhoi(Integer.parseInt(txt_phankhoi.getText()));
		car.setLoai(txt_loai.getText());
		car.setMauXe(txt_mauxe.getText());
		car.setModelXe(txt_model.getText());
		car.setThuongHieu(txt_thuonghieu.getText());
		car.setTrangThai(txt_trangthai.getText());
		car.setXuatXu(txt_xuatxu.getText());
		return car;
	}

	private void loadData(ArrayList<CarModel> lst) {
		model = new DefaultTableModel();
		// set column headers
		Vector column = new Vector();
		column.add("ID Xe");
		column.add("Model Xe");
		column.add("Mẫu Xe");
		column.add("Thương Hiệu");
		column.add("Loại");
		column.add("Phân Khúc");
		column.add("Xuất Xứ");
		column.add("Trạng Thái");
		column.add("Giá Xe");
		model.setColumnIdentifiers(column);
		ArrayList<CarModel> list = lst;
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
	
	/**
	 * Create the frame.
	 */
	public CarFrame() {
		// Initialize Frame
		setTitle("QU\u1EA2N L\u00DD XE");
		setBounds(100, 100, 999, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Initialize button
		JButton btnAdd = new JButton("THÊM XE");
		btnAdd.setBounds(263, 11, 126, 51);
		contentPane.add(btnAdd);

		JButton btnUpdate = new JButton("SỬA XE");
		btnUpdate.setBounds(399, 11, 126, 51);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("XOÁ XE");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setForeground(Color.RED);
		btnDelete.setBounds(535, 11, 126, 51);
		contentPane.add(btnDelete);

		// Create ScrollPane and Table for data containing
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(211, 73, 502, 348);
		contentPane.add(scrollPane);

		tableCar = new JTable(){
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		scrollPane.setViewportView(tableCar);

		JLabel lbl_xuatxu = new JLabel("Xuất Xứ:");
		lbl_xuatxu.setBounds(723, 107, 54, 14);
		contentPane.add(lbl_xuatxu);

		JLabel lbl_model = new JLabel("Model Xe:");
		lbl_model.setBounds(723, 137, 70, 14);
		contentPane.add(lbl_model);

		JLabel lbl_mauxe = new JLabel("Mẫu Xe:");
		lbl_mauxe.setBounds(723, 167, 70, 14);
		contentPane.add(lbl_mauxe);

		JLabel lbl_thuonghieu = new JLabel("Thương Hiệu:");
		lbl_thuonghieu.setBounds(723, 197, 80, 14);
		contentPane.add(lbl_thuonghieu);

		JLabel lbl_loai = new JLabel("Loại Xe:");
		lbl_loai.setBounds(723, 227, 70, 14);
		contentPane.add(lbl_loai);

		JLabel lbl_phankhoi = new JLabel("Phân Khối:");
		lbl_phankhoi.setBounds(723, 257, 70, 14);
		contentPane.add(lbl_phankhoi);

		JLabel lbl_trangthai = new JLabel("Trạng Thái:");
		lbl_trangthai.setBounds(723, 287, 70, 14);
		contentPane.add(lbl_trangthai);

		JLabel lbl_gia = new JLabel("Giá Xe:");
		lbl_gia.setBounds(723, 317, 70, 14);
		contentPane.add(lbl_gia);

		txt_xuatxu = new JTextField();
		txt_xuatxu.setColumns(10);
		txt_xuatxu.setBounds(803, 104, 170, 20);
		contentPane.add(txt_xuatxu);

		txt_model = new JTextField();
		txt_model.setColumns(10);
		txt_model.setBounds(803, 134, 170, 20);
		contentPane.add(txt_model);

		txt_mauxe = new JTextField();
		txt_mauxe.setColumns(10);
		txt_mauxe.setBounds(803, 164, 170, 20);
		contentPane.add(txt_mauxe);

		txt_thuonghieu = new JTextField();
		txt_thuonghieu.setColumns(10);
		txt_thuonghieu.setBounds(803, 194, 170, 20);
		contentPane.add(txt_thuonghieu);

		txt_loai = new JTextField();
		txt_loai.setColumns(10);
		txt_loai.setBounds(803, 224, 170, 20);
		contentPane.add(txt_loai);

		txt_phankhoi = new JTextField();
		txt_phankhoi.setColumns(10);
		txt_phankhoi.setBounds(803, 254, 170, 20);
		contentPane.add(txt_phankhoi);

		txt_trangthai = new JTextField();
		txt_trangthai.setColumns(10);
		txt_trangthai.setBounds(803, 284, 170, 20);
		contentPane.add(txt_trangthai);

		txt_gia = new JTextField();
		txt_gia.setColumns(10);
		txt_gia.setBounds(803, 314, 170, 20);
		contentPane.add(txt_gia);

		JButton btnExit = new JButton("THOÁT");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setForeground(Color.RED);
		btnExit.setBounds(845, 370, 126, 51);
		contentPane.add(btnExit);

		txt_id = new JTextField();
		txt_id.setEnabled(false);
		txt_id.setColumns(10);
		txt_id.setBounds(803, 71, 170, 20);
		contentPane.add(txt_id);

		JLabel lbl_id = new JLabel("ID Xe:");
		lbl_id.setBounds(723, 74, 54, 14);
		contentPane.add(lbl_id);

		JButton btnReload = new JButton("RELOAD");
		btnReload.setBounds(847, 11, 126, 51);
		contentPane.add(btnReload);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setBounds(10, 11, 191, 410);
		contentPane.add(panelSearch);
		panelSearch.setLayout(null);
		
		txt_searchInfo = new JTextField();
		txt_searchInfo.setBounds(75, 52, 106, 20);
		panelSearch.add(txt_searchInfo);
		txt_searchInfo.setColumns(10);
		
		JLabel lblSearchTitle = new JLabel("Tìm kiếm thông tin xe");
		lblSearchTitle.setBounds(10, 11, 126, 14);
		panelSearch.add(lblSearchTitle);
		
		String[] category = {"XUẤT XỨ", "MODEL XE", "MÀU XE", "THƯƠNG HIỆU"};
		JComboBox cb_searchCategory = new JComboBox(category);
		cb_searchCategory.setBounds(10, 51, 62, 22);
		panelSearch.add(cb_searchCategory);
		
		String[] loai = {"TẤT CẢ", "XE 2 BÁNH", "XE 4 BÁNH" };
		JComboBox cb_searchLoaiXe = new JComboBox(loai);
		cb_searchLoaiXe.setBounds(75, 83, 106, 22);
		panelSearch.add(cb_searchLoaiXe);
		cb_searchLoaiXe.setSelectedIndex(0);
		
		String[] tt = {"TẤT CẢ", "ĐÃ BÁN", "CHƯA BÁN"};
		JComboBox cb_searchTrangThai = new JComboBox(tt);
		cb_searchTrangThai.setBounds(75, 116, 106, 22);
		panelSearch.add(cb_searchTrangThai);
		cb_searchLoaiXe.setSelectedIndex(0);
		
		txt_GiaXeMax = new JTextField();
		txt_GiaXeMax.setColumns(10);
		txt_GiaXeMax.setBounds(121, 189, 60, 20);
		panelSearch.add(txt_GiaXeMax);
		
		JLabel lblSearchLoaiXe = new JLabel("Loại Xe:");
		lblSearchLoaiXe.setBounds(10, 87, 46, 14);
		panelSearch.add(lblSearchLoaiXe);
		
		JLabel lblSearchTrangThai = new JLabel("Thương Hiệu:");
		lblSearchTrangThai.setBounds(10, 120, 62, 14);
		panelSearch.add(lblSearchTrangThai);
		
		JLabel lblSearchGiaXe = new JLabel("Khoản Giá Xe:");
		lblSearchGiaXe.setBounds(10, 154, 99, 14);
		panelSearch.add(lblSearchGiaXe);
		
		JLabel lbl = new JLabel("ĐẾN");
		lbl.setBounds(82, 192, 29, 14);
		panelSearch.add(lbl);
		
		txt_GiaXeMin = new JTextField();
		txt_GiaXeMin.setColumns(10);
		txt_GiaXeMin.setBounds(10, 189, 62, 20);
		panelSearch.add(txt_GiaXeMin);
		
		txt_searchPhanKhoi = new JTextField();
		txt_searchPhanKhoi.setColumns(10);
		txt_searchPhanKhoi.setBounds(75, 233, 106, 20);
		panelSearch.add(txt_searchPhanKhoi);
		
		JLabel lblSearchPhanKhoi = new JLabel("Phân khối:");
		lblSearchPhanKhoi.setBounds(10, 236, 62, 14);
		panelSearch.add(lblSearchPhanKhoi);
		
		JButton btnSearch = new JButton("TÌM KIẾM");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSearch.setBounds(32, 336, 126, 51);
		panelSearch.add(btnSearch);

		loadData(CarModel.viewAllCar());

		// Create events for buttons
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					InsertCarFrame frame = new InsertCarFrame();
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txt_id.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn xe trước khi cập nhật");
				} else {
					if(txt_gia.getText().equals("")|| txt_phankhoi.getText().equals("")|| txt_loai.getText().equals("")|| txt_mauxe.getText().equals("")|| txt_model.getText().equals("")|| txt_thuonghieu.getText().equals("")|| txt_trangthai.getText().equals("")||txt_xuatxu.getText().equals("")) {
						
					}
					else {
						CarModel car = getCar();
						CarModel.updateCar(car);
						JOptionPane.showMessageDialog(contentPane, "Cập Nhật Thành Công");
						loadData(CarModel.viewAllCar());
					}
				}
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txt_id.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn xe trước khi xoá!");
				} else {
					int delConfirmed = JOptionPane.showConfirmDialog(null, "Bạn có chắc xoá xe này ?!!");
					if (delConfirmed == 0) {
						CarModel car = getCar();
						if (CarModel.deleteCar(car)) {
							JOptionPane.showMessageDialog(contentPane, "Xoá Thành Công");
							loadData(CarModel.viewAllCar());
						}
						else {
							JOptionPane.showMessageDialog(contentPane, "Xoá Không Thành Công!!");
						}
					}
				}
			}
		});

		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hide();
			}
		});

		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadData(CarModel.viewAllCar());
			}
		});

		tableCar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// get the model from the jtable
				DefaultTableModel model = (DefaultTableModel) tableCar.getModel();

				// get the selected row index
				int selectedRowIndex = tableCar.getSelectedRow();

				// set the selected row data into jtextfields
				txt_id.setText(model.getValueAt(selectedRowIndex, 0).toString());
				txt_model.setText(model.getValueAt(selectedRowIndex, 1).toString());
				txt_mauxe.setText(model.getValueAt(selectedRowIndex, 2).toString());
				txt_thuonghieu.setText(model.getValueAt(selectedRowIndex, 3).toString());
				txt_loai.setText(model.getValueAt(selectedRowIndex, 4).toString());
				txt_phankhoi.setText(model.getValueAt(selectedRowIndex, 5).toString());
				txt_xuatxu.setText(model.getValueAt(selectedRowIndex, 6).toString());
				txt_trangthai.setText(model.getValueAt(selectedRowIndex, 7).toString());
				txt_gia.setText(model.getValueAt(selectedRowIndex, 8).toString());
			}
		});
//		if (Global.acc.getUsertype().equals("SALES")) {
//			btnUpdate.setEnabled(false);
//			btnDelete.setEnabled(false);
//		}
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//processing texfields
				if(txt_GiaXeMax.getText().isEmpty()) {
					priceMax = -1;
				} else priceMax = Integer.parseInt(txt_GiaXeMax.getText());
				if(txt_GiaXeMin.getText().isEmpty()) {
					priceMin = -1;
				} else priceMin = Integer.parseInt(txt_GiaXeMin.getText());
				if(txt_searchPhanKhoi.getText().isEmpty()) {
					phanKhoi = -1;
				} else phanKhoi = Integer.parseInt(txt_searchPhanKhoi.getText());
				//processing cb category
				if(!txt_searchInfo.getText().isEmpty()) {
					switch (cb_searchCategory.getSelectedIndex()) {
					case 0:
						xuatXu = txt_searchInfo.getText();
						mauXe = "-1";
						thuongHieu = "-1";
						modelXe = "-1";
						break;
						
					case 1:
						modelXe = txt_searchInfo.getText();
						mauXe = "-1";
						thuongHieu = "-1";
						xuatXu = "-1";
						break;
						
					case 2:
						mauXe = txt_searchInfo.getText();
						modelXe = "-1";
						thuongHieu = "-1";
						xuatXu = "-1";
						break;
						
					case 3:
						thuongHieu = txt_searchInfo.getText();
						mauXe = "-1";
						modelXe = "-1";
						xuatXu = "-1";
						break;
						
					default:
						break;
					}
				} else {
					thuongHieu = "-1";
					mauXe = "-1";
					modelXe = "-1";
					xuatXu = "-1";
				}
			//processing cb loai xe
				switch (cb_searchLoaiXe.getSelectedIndex()) {
				case 0:
					loaiXe = "-1";
					break;
				
				case 1:
					loaiXe = "XE 2 BÁNH";
					break;
					
				case 2:
					loaiXe = "XE 4 BÁNH";
					break;
					
				default:
					break;
				}
			//processing cb trang thai
				switch (cb_searchTrangThai.getSelectedIndex()) {
				case 0:
					trangThai = "-1";
					break;
				
				case 1:
					trangThai = "ĐÃ BÁN";
					break;
					
				case 2:
					trangThai = "CHƯA BÁN";
					break;
					
				default:
					break;
				}
			loadData(CarModel.searchCar(priceMin, priceMax, modelXe, phanKhoi, mauXe, thuongHieu, xuatXu, trangThai));
			}
		});
	}
}
