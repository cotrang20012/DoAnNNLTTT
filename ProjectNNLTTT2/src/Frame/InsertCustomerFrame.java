package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class InsertCustomerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textSID;
	private JTextField textAddress;
	private JTextField textPhone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertCustomerFrame frame = new InsertCustomerFrame();
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
	public InsertCustomerFrame() {
		setTitle("THÔNG TIN KHÁCH HÀNG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 319, 188);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl = new JLabel("TÊN KHÁCH HÀNG:");
		lbl.setBounds(32, 11, 93, 14);
		contentPane.add(lbl);
		
		JLabel lblCmndcccd = new JLabel("CMND/CCCD:");
		lblCmndcccd.setBounds(32, 36, 93, 14);
		contentPane.add(lblCmndcccd);
		
		JLabel lblaCh = new JLabel("ĐỊA CHỈ:");
		lblaCh.setBounds(32, 61, 93, 14);
		contentPane.add(lblaCh);
		
		JLabel lblSinThoi = new JLabel("SỐ ĐIỆN THOẠI:");
		lblSinThoi.setBounds(32, 86, 93, 14);
		contentPane.add(lblSinThoi);
		
		textName = new JTextField();
		textName.setBounds(135, 8, 133, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textSID = new JTextField();
		textSID.setColumns(10);
		textSID.setBounds(135, 33, 133, 20);
		contentPane.add(textSID);
		
		textAddress = new JTextField();
		textAddress.setColumns(10);
		textAddress.setBounds(135, 58, 133, 20);
		contentPane.add(textAddress);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(135, 83, 133, 20);
		contentPane.add(textPhone);
		
		JButton btnAdd = new JButton("THÊM");
		btnAdd.setBounds(179, 114, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnExit = new JButton("XOÁ");
		btnExit.setBounds(36, 114, 89, 23);
		contentPane.add(btnExit);
	}

}
