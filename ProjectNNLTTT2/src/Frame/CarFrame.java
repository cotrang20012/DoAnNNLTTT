package Frame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.List;

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

	/**
	 * Create the frame.
	 */
	public CarFrame() {
		// Initialize Frame
		setTitle("QU\u1EA2N L\u00DD XE");
		setBounds(100, 100, 796, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Initialize button
		JButton btnAdd = new JButton("TH\u00CAM XE");
		btnAdd.setBounds(10, 11, 126, 51);
		contentPane.add(btnAdd);

		JButton btnUpdate = new JButton("S\u1EECA XE");
		btnUpdate.setBounds(146, 11, 126, 51);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("X\u00D3A XE");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setForeground(Color.RED);
		btnDelete.setBounds(282, 11, 126, 51);
		contentPane.add(btnDelete);

		// Create ScrollPane and Table for data containing
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 502, 348);
		contentPane.add(scrollPane);

		tableCar = new JTable(){
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		scrollPane.setViewportView(tableCar);

		JLabel lbl_xuatxu = new JLabel("Xuất xứ:");
		lbl_xuatxu.setBounds(522, 107, 54, 14);
		contentPane.add(lbl_xuatxu);

		JLabel lbl_model = new JLabel("Model Xe:");
		lbl_model.setBounds(522, 137, 70, 14);
		contentPane.add(lbl_model);

		JLabel lbl_mauxe = new JLabel("Màu Xe:");
		lbl_mauxe.setBounds(522, 167, 70, 14);
		contentPane.add(lbl_mauxe);

		JLabel lbl_thuonghieu = new JLabel("Thương Hiệu:");
		lbl_thuonghieu.setBounds(522, 197, 80, 14);
		contentPane.add(lbl_thuonghieu);

		JLabel lbl_loai = new JLabel("Loại Xe:");
		lbl_loai.setBounds(522, 227, 70, 14);
		contentPane.add(lbl_loai);

		JLabel lbl_phankhoi = new JLabel("Phân Khối:");
		lbl_phankhoi.setBounds(522, 257, 70, 14);
		contentPane.add(lbl_phankhoi);

		JLabel lbl_trangthai = new JLabel("Trạng Thái:");
		lbl_trangthai.setBounds(522, 287, 70, 14);
		contentPane.add(lbl_trangthai);

		JLabel lbl_gia = new JLabel("Giá Xe:");
		lbl_gia.setBounds(522, 317, 70, 14);
		contentPane.add(lbl_gia);

		txt_xuatxu = new JTextField();
		txt_xuatxu.setColumns(10);
		txt_xuatxu.setBounds(602, 104, 170, 20);
		contentPane.add(txt_xuatxu);

		txt_model = new JTextField();
		txt_model.setColumns(10);
		txt_model.setBounds(602, 134, 170, 20);
		contentPane.add(txt_model);

		txt_mauxe = new JTextField();
		txt_mauxe.setColumns(10);
		txt_mauxe.setBounds(602, 164, 170, 20);
		contentPane.add(txt_mauxe);

		txt_thuonghieu = new JTextField();
		txt_thuonghieu.setColumns(10);
		txt_thuonghieu.setBounds(602, 194, 170, 20);
		contentPane.add(txt_thuonghieu);

		txt_loai = new JTextField();
		txt_loai.setColumns(10);
		txt_loai.setBounds(602, 224, 170, 20);
		contentPane.add(txt_loai);

		txt_phankhoi = new JTextField();
		txt_phankhoi.setColumns(10);
		txt_phankhoi.setBounds(602, 254, 170, 20);
		contentPane.add(txt_phankhoi);

		txt_trangthai = new JTextField();
		txt_trangthai.setColumns(10);
		txt_trangthai.setBounds(602, 284, 170, 20);
		contentPane.add(txt_trangthai);

		txt_gia = new JTextField();
		txt_gia.setColumns(10);
		txt_gia.setBounds(602, 314, 170, 20);
		contentPane.add(txt_gia);

		JButton btnExit = new JButton("THO\u00C1T");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setForeground(Color.RED);
		btnExit.setBounds(644, 370, 126, 51);
		contentPane.add(btnExit);

		txt_id = new JTextField();
		txt_id.setEnabled(false);
		txt_id.setColumns(10);
		txt_id.setBounds(602, 71, 170, 20);
		contentPane.add(txt_id);

		JLabel lbl_id = new JLabel("ID Xe:");
		lbl_id.setBounds(522, 74, 54, 14);
		contentPane.add(lbl_id);

		JButton btnReload = new JButton("RELOAD");
		btnReload.setBounds(646, 11, 126, 51);
		contentPane.add(btnReload);

		loadData();

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
					JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn xe để cập nhật!");
				} else {
					if(txt_gia.getText().equals("")|| txt_phankhoi.getText().equals("")|| txt_loai.getText().equals("")|| txt_mauxe.getText().equals("")|| txt_model.getText().equals("")|| txt_thuonghieu.getText().equals("")|| txt_trangthai.getText().equals("")||txt_xuatxu.getText().equals("")) {
						
					}
					else {
						CarModel car = getCar();
						CarModel.updateCar(car);
						JOptionPane.showMessageDialog(contentPane, "Cập nhật thành công!");
						loadData();
					}
				}
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txt_id.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn xe để xóa!");
				} else {
					int delConfirmed = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa không?");
					if (delConfirmed == 0) {
						CarModel car = getCar();
						if (CarModel.deleteCar(car)) {
							JOptionPane.showMessageDialog(contentPane, "Xóa thành công!");
							loadData();
						}
						else {
							JOptionPane.showMessageDialog(contentPane, "Xóa không thành công!");
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
				loadData();
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
		if (Global.acc.getUsertype().equals("SALES")) {
			btnUpdate.setEnabled(false);
			btnDelete.setEnabled(false);
		}
	}
}
