package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.CarModel;
import model.CustomerModel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ViewBillDetail extends JFrame {

	private JPanel contentPane;
	private JTextField textIDSale;
	private JTextField textNameSale;
	private JTextField textIDCustomer;
	private JTextField textNameCustomer;
	private JTextField textAddresCustomer;
	private JTextField textPhoneCustomer;
	private JTable table;
	private int idSale;
	private int idCustomer;
	private int idBill;
	private int TongHoaDon;
	private JLabel lblTongHoaDon;

	public int getIdBill() {
		return idBill;
	}

	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}

	public int getIdSale() {
		return idSale;
	}

	public void setIdSale(int idSale) {
		this.idSale = idSale;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBillDetail frame = new ViewBillDetail(0,0,0,0);
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
	public ViewBillDetail(int idBill, int idSale,int idCustomer, int TongHoaDon) {
		this.setIdBill(idBill);
		this.setIdCustomer(idCustomer);
		this.setIdSale(idSale);
		this.setTongHoaDon(TongHoaDon);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 652, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID Nhân Viên:");
		lblNewLabel.setBounds(10, 11, 89, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên Nhân Viên:");
		lblNewLabel_1.setBounds(10, 36, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID Khách Hàng:");
		lblNewLabel_2.setBounds(307, 11, 95, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tên Khách Hàng:");
		lblNewLabel_3.setBounds(307, 36, 95, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Địa Chỉ:");
		lblNewLabel_4.setBounds(307, 61, 95, 14);
		contentPane.add(lblNewLabel_4);
		
		textIDSale = new JTextField();
		textIDSale.setEditable(false);
		textIDSale.setBounds(109, 8, 142, 20);
		contentPane.add(textIDSale);
		textIDSale.setColumns(10);
		
		textNameSale = new JTextField();
		textNameSale.setEditable(false);
		textNameSale.setColumns(10);
		textNameSale.setBounds(109, 33, 142, 20);
		contentPane.add(textNameSale);
		
		JLabel lblNewLabel_4_1 = new JLabel("Số Điện Thoai:");
		lblNewLabel_4_1.setBounds(307, 86, 95, 14);
		contentPane.add(lblNewLabel_4_1);
		
		textIDCustomer = new JTextField();
		textIDCustomer.setEditable(false);
		textIDCustomer.setColumns(10);
		textIDCustomer.setBounds(412, 8, 142, 20);
		contentPane.add(textIDCustomer);
		
		textNameCustomer = new JTextField();
		textNameCustomer.setEditable(false);
		textNameCustomer.setColumns(10);
		textNameCustomer.setBounds(412, 33, 142, 20);
		contentPane.add(textNameCustomer);
		
		textAddresCustomer = new JTextField();
		textAddresCustomer.setEditable(false);
		textAddresCustomer.setColumns(10);
		textAddresCustomer.setBounds(412, 58, 142, 20);
		contentPane.add(textAddresCustomer);
		
		textPhoneCustomer = new JTextField();
		textPhoneCustomer.setEditable(false);
		textPhoneCustomer.setColumns(10);
		textPhoneCustomer.setBounds(412, 83, 142, 20);
		contentPane.add(textPhoneCustomer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 616, 324);
		contentPane.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel Carmodel = new DefaultTableModel();
		Carmodel.addColumn("ID");
		Carmodel.addColumn("Model");
		Carmodel.addColumn("Màu Xe");
		Carmodel.addColumn("Thương Hiệu");
		Carmodel.addColumn("Loại");
		Carmodel.addColumn("Phân Khối");
		Carmodel.addColumn("Xuất Xứ");
		Carmodel.addColumn("Giá Xe");
		table.setModel(Carmodel);
		SetDataForTableCar();

		scrollPane.setViewportView(table);
		
		lblTongHoaDon = new JLabel("New label");
		lblTongHoaDon.setBounds(412, 446, 214, 14);
		SetDataForFrame();
		contentPane.add(lblTongHoaDon);
	}
	public int getTongHoaDon() {
		return TongHoaDon;
	}

	public void setTongHoaDon(int tongHoaDon) {
		TongHoaDon = tongHoaDon;
	}

	private void SetDataForTableCar() {
		ArrayList<CarModel> listCar = CarModel.viewCarWithBill(idBill);
		for(CarModel car : listCar) {
			String[] item = { String.valueOf(car.getId()),car.getModelXe(),car.getMauXe(), car.getThuongHieu(), car.getLoai(), String.valueOf(car.getPhanKhoi()),car.getXuatXu(),String.valueOf(car.getGiaXe()) };
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(item);
		}	
	}
	private void SetDataForFrame() {
		textIDCustomer.setText(String.valueOf(idCustomer)); 
		ArrayList<CustomerModel> ListCustomer = CustomerModel.ViewCustomer();
		for(CustomerModel customer : ListCustomer) {
			if(customer.getCustID()==idCustomer) {
				textNameCustomer.setText(customer.getCustName());
				textAddresCustomer.setText(customer.getCustAddr());
				textPhoneCustomer.setText(customer.getCustPhone());
				break;
			}
		}
		textIDSale.setText(String.valueOf(idSale));
		lblTongHoaDon.setText("Tổng hoá đơn: "+TongHoaDon);
	}
	
}
