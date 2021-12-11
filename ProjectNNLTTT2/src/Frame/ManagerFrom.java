package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.result.Row;


import database.NhanvienDAO;

import model.NhanVien;

import java.awt.Button;

import javax.print.attribute.standard.PrinterInfo;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class ManagerFrom extends JFrame {

	private JPanel contentPane;
	private static JTable tableEmployee;
	private static NhanvienDAO nvDAO = new NhanvienDAO();
	private static ArrayList<NhanVien> listNV = nvDAO.getNV();

	public ManagerFrom() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("QUẢN LÝ");
		setBounds(100, 100, 740, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnAddEmployee = new JButton("THÊM NHÂN VIÊN");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							InsertEmployee frame = new InsertEmployee();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnAddEmployee.setBounds(546, 11, 144, 51);
		contentPane.add(btnAddEmployee);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 526, 410);
		contentPane.add(scrollPane);

		tableEmployee = new JTable(){
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		scrollPane.setViewportView(tableEmployee);

		JButton btnUpdateEmployee = new JButton("SỬA THÔNG TIN");
		btnUpdateEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableEmployee.getSelectedRow();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							if (row != -1) {
								UpdateInfoManager frame = new UpdateInfoManager(
										listNV.get(row));
								frame.setVisible(true);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnUpdateEmployee.setBounds(546, 73, 144, 51);
		contentPane.add(btnUpdateEmployee);

		JButton btnDeleteEmployee = new JButton("XOÁ NHÂN VIÊN");
		btnDeleteEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row =  tableEmployee.getSelectedRow();
				if(row != -1) {
					NhanVien nv = listNV.get(tableEmployee.getSelectedRow());
					int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa nhân viên này ?");
					if (dialogResult == 0) {
						if (nvDAO.CheckSale(nv) == true) {
							if (nvDAO.Delete(nv.getId())) {
								JOptionPane.showMessageDialog(null, "Xóa thành công");
								CusTable();
							} else
								JOptionPane.showMessageDialog(null, "Xóa thất bại");
						} else
							JOptionPane.showMessageDialog(null, "Không thể xóa nhân viên này!!!");
					}
				}
			}
		});
		btnDeleteEmployee.setBounds(546, 135, 144, 51);
		contentPane.add(btnDeleteEmployee);
		
		JButton btnClose = new JButton("Thoát");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClose.setBackground(Color.CYAN);
		btnClose.setForeground(Color.RED);
		btnClose.setBounds(546, 378, 114, 43);
		contentPane.add(btnClose);

		CusTable();
	}

	public static void CusTable() {
		listNV = nvDAO.getNV();
		DefaultTableModel dtmNV = new DefaultTableModel();
		String columnNV[] = { "ID", "CMND", "Tên", "Địa chỉ", "Chức vụ", "Số điện thoại", "Lương","Password"};
		for (int i = 0; i < columnNV.length; i++)
			dtmNV.addColumn(columnNV[i]);
		for (NhanVien nv : listNV) {
			Object data[] = new Object[8];
			int i = 0;
			data[i++] = nv.getId();
			data[i++] = nv.getCmnd();
			data[i++] = nv.getTen();
			data[i++] = nv.getDiachi();
			data[i++] = nv.getChucvu();
			data[i++] = nv.getSdt();
			data[i++] = nv.getLuong();
			data[i++] = nv.getPassword();
			dtmNV.addRow(data);
		}
		tableEmployee.setModel(dtmNV);
	}
}
