package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.BillDetailModel;
import model.BillModel;
import model.CarModel;
import model.CustomerModel;
import model.Global;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class BillFrame extends JFrame {

	private JPanel contentPane;
	private JTable tableBill;
	private CarModel carModel = new CarModel();
	private BillModel billModel = new BillModel();
	private BillDetailModel billDetailModel = new BillDetailModel();
	private BillModel billModel2 = new BillModel();
	private CustomerModel customerModel = new CustomerModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public BillFrame() {
		setTitle("QUẢN LÝ HOÁ ĐƠN");
		setBounds(100, 100, 796, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(491, 427, 145, 14);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 626, 348);
		contentPane.add(scrollPane);

		tableBill = new JTable() {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};

		DefaultTableModel Billmodel = new DefaultTableModel();
		Billmodel.addColumn("ID Bill");
		Billmodel.addColumn("ID Nhân Viên");
		Billmodel.addColumn("ID Khách Hàng");
		Billmodel.addColumn("Tổng giá trị hoá đơn");
		Billmodel.addColumn("Ngày");
		tableBill.setModel(Billmodel);
		SetDataForTableBill();
		scrollPane.setViewportView(tableBill);

		tableBill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableBill.rowAtPoint(e.getPoint());
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							int idBill = Integer.parseInt(tableBill.getValueAt(row, 0).toString());
							int idSale = Integer.parseInt(tableBill.getValueAt(row, 1).toString());
							int idCustomer = Integer.parseInt(tableBill.getValueAt(row, 2).toString());
							int TongHoaDon = Integer.parseInt(tableBill.getValueAt(row, 3).toString());
							ViewBillDetail newframe = new ViewBillDetail(idBill, idSale, idCustomer, TongHoaDon);
							newframe.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		JButton btnAdd = new JButton("THÊM HOÁ ĐƠN");
		btnAdd.addMouseListener(new MouseAdapter() {
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
				RefreshBillTable();
			}
		});
		btnAdd.setBounds(10, 11, 126, 51);
		contentPane.add(btnAdd);

		JButton btnDelete = new JButton("XOÁ HOÁ ĐƠN");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableBill.getSelectedRow();
				if (row == -1) {

				} else {
					String idBill = tableBill.getValueAt(row, 0).toString();
					JOptionPane optionPane = new JOptionPane();
					int result = optionPane.showConfirmDialog(null, "Bạn có chắc muốn xoá Bill với ID = "+idBill,
							"Swing Tester", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.YES_OPTION) {
						ArrayList<CarModel> listCar = CarModel.viewCarWithBill(Integer.parseInt(idBill));
						for(CarModel car : listCar) {
							CarModel.updateCarStatusAfterDeleteBill(car.getId());
						}	
						BillDetailModel.deleteBillDetailAfterDeleteBill(Integer.parseInt(idBill));
						BillModel.DeleteBill(Integer.parseInt(idBill));
						RefreshBillTable();
						TinhTongHoaDon(lblNewLabel);
						JOptionPane optionPane1 = new JOptionPane();
						optionPane1.showMessageDialog(null, "Xoá Hoá Đơn Thành Công", "InfoBox: " + "QUẢN LÝ HOÁ ĐƠN",
								JOptionPane.INFORMATION_MESSAGE);
					} else if (result == JOptionPane.NO_OPTION) {
					}
				}
			}
		});
		btnDelete.setBounds(146, 11, 126, 51);
		contentPane.add(btnDelete);

		JButton btnExit = new JButton("THOÁT");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(644, 370, 126, 51);
		contentPane.add(btnExit);
		
		JButton btnRefresh = new JButton("LÀM MỚI");
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RefreshBillTable();
				TinhTongHoaDon(lblNewLabel);
			}
		});
		btnRefresh.setBounds(510, 11, 126, 51);
		contentPane.add(btnRefresh);
		if(Global.acc.getUsertype().equals("SALES")) {
			btnDelete.setEnabled(false);
		}
		TinhTongHoaDon(lblNewLabel);
	}

	private void SetDataForTableBill() {
		ArrayList<BillModel> listBill = BillModel.viewBillForBillFrame();
		for (BillModel bill : listBill) {
			String[] item = { String.valueOf(bill.getIdbill()), String.valueOf(bill.getIdsale()),
					String.valueOf(bill.getIdkhachhang()), String.valueOf(bill.getTonghoadon()),bill.getDate().toString()};
			DefaultTableModel model = (DefaultTableModel) tableBill.getModel();
			model.addRow(item);
			model.fireTableDataChanged();
		}
	}
	private void RefreshBillTable() {
		DefaultTableModel model = (DefaultTableModel) tableBill.getModel();
		model.setRowCount(0);
		ArrayList<BillModel> listBill = BillModel.viewBillForBillFrame();
		for (BillModel bill : listBill) {
			String[] item = { String.valueOf(bill.getIdbill()), String.valueOf(bill.getIdsale()),
					String.valueOf(bill.getIdkhachhang()), String.valueOf(bill.getTonghoadon()) };
			model.addRow(item);
		}
		model.fireTableDataChanged();
	}
	
	private void TinhTongHoaDon(JLabel lblTongHoaDon) {
		DefaultTableModel model = (DefaultTableModel) tableBill.getModel();
		int TongHoaDon = 0;
		if(model.getRowCount()!=0) {
			for(int i = 0; i < model.getRowCount();i++) {
				int GiaTri =   Integer.parseInt((model.getValueAt(i, 3).toString()));
				TongHoaDon += GiaTri;
			}
		}
		lblTongHoaDon.setText("Tổng: "+String.valueOf(TongHoaDon));		
	}
}
