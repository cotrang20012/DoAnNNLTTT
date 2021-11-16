package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UpdateInfoEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField textAddress;
	private JTextField textPhone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public UpdateInfoEmployee() {
		setTitle("CẬP NHẬT THÔNG TIN");
		setBounds(100, 100, 322, 183);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ĐỊA CHỈ:");
		lblNewLabel.setBounds(35, 11, 89, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SỐ ĐIỆN THOẠI:");
		lblNewLabel_1.setBounds(35, 63, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		textAddress = new JTextField();
		textAddress.setBounds(134, 11, 128, 37);
		contentPane.add(textAddress);
		textAddress.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(134, 60, 128, 20);
		contentPane.add(textPhone);
		
		JButton btnUpdate = new JButton("CẬP NHẬT");
		btnUpdate.setBounds(173, 106, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnExit = new JButton("THOÁT");
		btnExit.setBounds(35, 106, 89, 23);
		contentPane.add(btnExit);
	}
}
