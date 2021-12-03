package Frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.BillDetailModel;
import model.BillModel;
import model.CarModel;
import model.CustomerModel;
import model.Global;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateBillFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textAddress;
	private JTextField textPhone;
	private JTextField textEmployee;
	private JTable tableCar;
	private JTable tableBill;
	private CarModel carModel = new CarModel();
	private BillModel billModel = new BillModel();
	private BillDetailModel billDetailModel = new BillDetailModel();
	private CustomerModel customerModel = new CustomerModel();
	private int ITongHoaDon = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public CreateBillFrame() {
		setTitle("TẠO HOÁ ĐƠN");
		setBounds(100, 100, 881, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTongHoaDon = new JLabel("New label");
		lblTongHoaDon.setBounds(668, 137, 187, 14);
		contentPane.add(lblTongHoaDon);
		
		JLabel lblNewLabel = new JLabel("ID KHÁCH HÀNG:");
		lblNewLabel.setBounds(32, 11, 93, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblTnKhchHng = new JLabel("TÊN KHÁCH HÀNG:");
		lblTnKhchHng.setBounds(32, 36, 93, 14);
		contentPane.add(lblTnKhchHng);
		
		JLabel lblNewLabel_1_1 = new JLabel("ĐỊA CHỈ:");
		lblNewLabel_1_1.setBounds(32, 61, 93, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("SỐ ĐIỆN THOẠI:");
		lblNewLabel_1_2.setBounds(32, 86, 93, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("NHÂN VIÊN:");
		lblNewLabel_1_2_1.setBounds(32, 111, 93, 14);
		contentPane.add(lblNewLabel_1_2_1);
		
		textName = new JTextField();
		textName.setBounds(135, 33, 187, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textAddress = new JTextField();
		textAddress.setColumns(10);
		textAddress.setBounds(135, 58, 187, 20);
		contentPane.add(textAddress);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(135, 83, 187, 20);
		contentPane.add(textPhone);
		
		textEmployee = new JTextField();
		textEmployee.setColumns(10);
		textEmployee.setBounds(135, 108, 187, 20);
		contentPane.add(textEmployee);
		
		JComboBox comboIDCustomer = new JComboBox();
		comboIDCustomer.setBounds(135, 7, 187, 22);
		try {
			ArrayList<CustomerModel> ListCustomer = CustomerModel.ViewCustomer();
			int i = 0;
			for(CustomerModel customer : ListCustomer) {
				if(i == 0) {
					textName.setText(customer.getCustName());
					textAddress.setText(customer.getCustAddr());
					textPhone.setText(customer.getCustPhone());
				}
				comboIDCustomer.addItem(customer.getCustID());
				i = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		comboIDCustomer.addItemListener(new ItemListener() {		
			@Override
			public void itemStateChanged(ItemEvent e) {
				ArrayList<CustomerModel> ListCustomer = CustomerModel.ViewCustomer();
				for(CustomerModel customer : ListCustomer) {
					if(comboIDCustomer.getSelectedItem().toString().equals(String.valueOf(customer.getCustID()))) {
						textName.setText(customer.getCustName());
						textAddress.setText(customer.getCustAddr());
						textPhone.setText(customer.getCustPhone());
						break;
					}
				}
			}
		});
		contentPane.add(comboIDCustomer);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 136, 626, 348);
		contentPane.add(scrollPane);
		
		tableCar = new JTable(){
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	          }
	       };
		DefaultTableModel Carmodel = new DefaultTableModel();
		Carmodel.addColumn("ID");
		Carmodel.addColumn("Model");
		Carmodel.addColumn("Màu Xe");
		Carmodel.addColumn("Thương Hiệu");
		Carmodel.addColumn("Loại");
		Carmodel.addColumn("Phân Khối");
		Carmodel.addColumn("Xuất Xứ");
		Carmodel.addColumn("Giá Xe");
		tableCar.setModel(Carmodel);
		SetDataForTableCar();
		scrollPane.setViewportView(tableCar);
		
		JButton btnExit = new JButton("THOÁT");
		btnExit.setBounds(678, 433, 177, 51);
		contentPane.add(btnExit);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(332, 10, 523, 119);
		contentPane.add(scrollPane_1);
		
		tableBill = new JTable(){
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	          }
	       };
		
		DefaultTableModel Billmodel = new DefaultTableModel();
		Billmodel.addColumn("ID");
		Billmodel.addColumn("Model");
		Billmodel.addColumn("Màu Xe");
		Billmodel.addColumn("Thương Hiệu");
		Billmodel.addColumn("Loại");
		Billmodel.addColumn("Phân Khối");
		Billmodel.addColumn("Xuất Xứ");
		Billmodel.addColumn("Giá Xe");
		tableBill.setModel(Billmodel);
		scrollPane_1.setViewportView(tableBill);
		
		tableCar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row= tableCar.rowAtPoint(e.getPoint());
				String[] item = { tableCar.getValueAt(row,0).toString(),tableCar.getValueAt(row,1).toString(), tableCar.getValueAt(row,2).toString(), tableCar.getValueAt(row,3).toString(), tableCar.getValueAt(row,4).toString(),tableCar.getValueAt(row,5).toString(),tableCar.getValueAt(row,6).toString(),tableCar.getValueAt(row,7).toString()};
				DefaultTableModel modelBill = (DefaultTableModel) tableBill.getModel();
				modelBill.addRow(item);
				modelBill.fireTableDataChanged();
				
				DefaultTableModel modelCar = (DefaultTableModel) tableCar.getModel();
				modelCar.removeRow(row);
				modelCar.fireTableDataChanged();
				
				TinhTongHoaDon(lblTongHoaDon);
			}
		});
		
		tableBill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row= tableBill.rowAtPoint(e.getPoint());
				String[] item = { tableBill.getValueAt(row,0).toString(),tableBill.getValueAt(row,1).toString(), tableBill.getValueAt(row,2).toString(), tableBill.getValueAt(row,3).toString(), tableBill.getValueAt(row,4).toString(),tableBill.getValueAt(row,5).toString(),tableBill.getValueAt(row,6).toString(),tableBill.getValueAt(row,7).toString() };
				DefaultTableModel modelCar = (DefaultTableModel) tableCar.getModel();
				modelCar.addRow(item);
				modelCar.fireTableDataChanged();
				
				DefaultTableModel modelBill = (DefaultTableModel) tableBill.getModel();
				modelBill.removeRow(row);
				modelBill.fireTableDataChanged();
				
				TinhTongHoaDon(lblTongHoaDon);
			}
		});
		
		
		JButton btnCreateBill = new JButton("TẠO HOÁ ĐƠN");
		btnCreateBill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tableBill.getModel().getRowCount()==0) {
					
				}
				else {
					int idBill = BillModel.insertBill(Global.nv.getId(),Integer.parseInt(comboIDCustomer.getSelectedItem().toString()), ITongHoaDon);
					for(int i =0 ; i < tableBill.getModel().getRowCount();i++) {
						BillDetailModel.insertBillDetail(idBill, Integer.parseInt(tableBill.getValueAt(i, 0).toString()), Integer.parseInt(tableBill.getValueAt(i, 7).toString()));
						CarModel.updateCarStatus(Integer.parseInt(tableBill.getValueAt(i, 0).toString()));
					}
					JOptionPane optionPane = new JOptionPane();
					optionPane.showMessageDialog(null, "Thêm hoá đơn thành công", "InfoBox: " + "QUẢN LÝ ĐƠN HÀNG",
							JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
			}
		});
		btnCreateBill.setBounds(678, 343, 177, 51);
		contentPane.add(btnCreateBill);
		
		TinhTongHoaDon(lblTongHoaDon);
	}
	
	private void SetDataForTableCar() {
		ArrayList<CarModel> listCar = CarModel.viewCarNotSales();
		for(CarModel car : listCar) {
			String[] item = { String.valueOf(car.getId()),car.getModelXe(),car.getMauXe(), car.getThuongHieu(), car.getLoai(), String.valueOf(car.getPhanKhoi()),car.getXuatXu(),String.valueOf(car.getGiaXe()) };
			DefaultTableModel model = (DefaultTableModel) tableCar.getModel();
			model.addRow(item);
		}	
	}
	
	private void TinhTongHoaDon(JLabel lblTongHoaDon) {
		DefaultTableModel model = (DefaultTableModel) tableBill.getModel();
		int TongHoaDon = 0;
		if(model.getRowCount()!=0) {
			for(int i = 0; i < model.getRowCount();i++) {
				int GiaTri =   Integer.parseInt((model.getValueAt(i, 7).toString()));
				TongHoaDon += GiaTri;
			}
		}
		TongHoaDon = TongHoaDon + TongHoaDon*10/100;
		ITongHoaDon = TongHoaDon;
		lblTongHoaDon.setText("Tổng: "+String.valueOf(TongHoaDon));		
	}
}
