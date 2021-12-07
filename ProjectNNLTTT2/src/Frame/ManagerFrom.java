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

import database.AccountDAO;
import database.NhanvienDAO;
import model.Account;
import model.NhanVien;

import java.awt.Button;

import javax.print.attribute.standard.PrinterInfo;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerFrom extends JFrame {

	private JPanel contentPane;
	private static JTable tableEmployee;
	private static JTable tableAccount;
	private static AccountDAO accDAO = new AccountDAO();
	private static ArrayList<Account> listAcc = accDAO.getAccounts();
	private static NhanvienDAO nvDAO = new NhanvienDAO();
	private static ArrayList<NhanVien> listNV = nvDAO.getNV();

	public ManagerFrom() {
		setTitle("QUẢN LÝ");
		setBounds(100, 100, 844, 471);
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
				CusTable();
			}
		});
		btnAddEmployee.setBounds(10, 11, 144, 51);
		contentPane.add(btnAddEmployee);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 526, 348);
		contentPane.add(scrollPane);

		tableEmployee = new JTable(){
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		scrollPane.setViewportView(tableEmployee);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(551, 73, 267, 348);
		contentPane.add(scrollPane_1);

		tableAccount = new JTable(){
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		scrollPane_1.setViewportView(tableAccount);

		JButton btnUpdateEmployee = new JButton("SỬA THÔNG TIN");
		btnUpdateEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableEmployee.getSelectedRow();
				System.out.println(row);
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
				CusTable();
			}
		});
		btnUpdateEmployee.setBounds(164, 11, 126, 51);
		contentPane.add(btnUpdateEmployee);

		JButton btnDeleteEmployee = new JButton("XOÁ NHÂN VIÊN");
		btnDeleteEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row =  tableEmployee.getSelectedRow();
				System.out.println(row != -1);
				if(row != -1) {
					NhanVien nv = listNV.get(tableEmployee.getSelectedRow());
					int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa nhân viên này ?");
					if (dialogResult == 0) {
						if (nvDAO.CheckSale(nv) == true) {
							if (nvDAO.Delete(nv.getId())) {
								accDAO.Delete(nv.getCmnd());
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
		btnDeleteEmployee.setBounds(300, 11, 126, 51);
		contentPane.add(btnDeleteEmployee);

		JButton btnUpdateAccount = new JButton("SỬA TÀI KHOẢN");
		btnUpdateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row =  tableAccount.getSelectedRow();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							if (row != -1) {
								ChangePasswordFrame frame = new ChangePasswordFrame(
										listAcc.get(row));
								frame.setVisible(true);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				CusTable();
			}
		});
		btnUpdateAccount.setBounds(436, 11, 126, 51);
		contentPane.add(btnUpdateAccount);

		CusTable();
	}

	private static void CusTable() {
		listAcc = accDAO.getAccounts();
		listNV = nvDAO.getNV();
		DefaultTableModel dtmAcc = new DefaultTableModel();
		DefaultTableModel dtmNV = new DefaultTableModel();
		String columnNV[] = { "ID", "CMND", "Tên", "Địa chỉ", "Chức vụ", "Số điện thoại", "Lương" };
		dtmAcc.addColumn("Tài khoản");
		dtmAcc.addColumn("Mật khẩu");
		for (int i = 0; i < columnNV.length; i++)
			dtmNV.addColumn(columnNV[i]);
		for (Account acc : listAcc) {
			Object data[] = new Object[2];
			data[0] = acc.getUsername();
			data[1] = acc.getPassword();
			dtmAcc.addRow(data);
		}
		for (NhanVien nv : listNV) {
			Object data[] = new Object[7];
			int i = 0;
			data[i++] = nv.getId();
			data[i++] = nv.getCmnd();
			data[i++] = nv.getTen();
			data[i++] = nv.getDiachi();
			data[i++] = nv.getChucvu();
			data[i++] = nv.getSdt();
			data[i++] = nv.getLuong();
			dtmNV.addRow(data);
		}
		tableAccount.setModel(dtmAcc);
		tableEmployee.setModel(dtmNV);
	}
}
