package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;

public class InsertEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textSID;
	private JTextField textAddress;
	private JTextField textPhone;
	private JTextField textSalary;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public InsertEmployee() {
		setTitle("THÊM THÔNG TIN NHÂN VIÊN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 319, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TÊN NHÂN VIÊN:");
		lblNewLabel.setBounds(32, 11, 93, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CMND/CCCD:");
		lblNewLabel_1.setBounds(32, 36, 93, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ĐỊA CHỈ:");
		lblNewLabel_2.setBounds(32, 61, 93, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("SỐ ĐIỆN THOẠI:");
		lblNewLabel_3.setBounds(32, 86, 93, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("LƯƠNG:");
		lblNewLabel_4.setBounds(32, 111, 93, 14);
		contentPane.add(lblNewLabel_4);
		
		JRadioButton rdbtnManager = new JRadioButton("Manager");
		rdbtnManager.setBounds(49, 148, 109, 23);
		contentPane.add(rdbtnManager);
		
		JRadioButton rdbtnSales = new JRadioButton("Sales");
		rdbtnSales.setSelected(true);
		rdbtnSales.setBounds(183, 148, 109, 23);
		contentPane.add(rdbtnSales);
		
		textName = new JTextField();
		textName.setBounds(135, 8, 133, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textSID = new JTextField();
		textSID.setBounds(135, 33, 133, 20);
		contentPane.add(textSID);
		textSID.setColumns(10);
		
		textAddress = new JTextField();
		textAddress.setBounds(135, 58, 133, 20);
		contentPane.add(textAddress);
		textAddress.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setBounds(135, 83, 133, 20);
		contentPane.add(textPhone);
		textPhone.setColumns(10);
		
		textSalary = new JTextField();
		textSalary.setBounds(135, 108, 133, 20);
		contentPane.add(textSalary);
		textSalary.setColumns(10);
		
		JButton btnAdd = new JButton("THÊM ");
		btnAdd.setBounds(179, 191, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnExit = new JButton("THOÁT");
		btnExit.setBounds(36, 191, 89, 23);
		contentPane.add(btnExit);
	}
}
