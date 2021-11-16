package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class CreateBillFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textAddress;
	private JTextField textPhone;
	private JTextField textEmployee;
	private JTable tableCar;
	private JTable tableBill;

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
		setBounds(100, 100, 830, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		contentPane.add(comboIDCustomer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 136, 626, 348);
		contentPane.add(scrollPane);
		
		tableCar = new JTable();
		scrollPane.setViewportView(tableCar);
		
		JButton btnExit = new JButton("THOÁT");
		btnExit.setBounds(678, 433, 126, 51);
		contentPane.add(btnExit);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(332, 10, 472, 119);
		contentPane.add(scrollPane_1);
		
		tableBill = new JTable();
		scrollPane_1.setViewportView(tableBill);
		
		JButton btnCreateBill = new JButton("TẠO HOÁ ĐƠN");
		btnCreateBill.setBounds(678, 343, 126, 51);
		contentPane.add(btnCreateBill);
		
		JButton btnDeleteRow = new JButton("XOÁ");
		btnDeleteRow.setBounds(678, 135, 126, 51);
		contentPane.add(btnDeleteRow);
	}
}
