package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.CarModel;
import model.CustomerModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertCustomerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txt_name;
	private JTextField txt_cmnd;
	private JTextField txt_addr;
	private JTextField txt_phone;

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
	
	
	//processing methods
		public void clearText() {
			txt_name.setText("");
			txt_addr.setText("");
			txt_cmnd.setText("");
			txt_phone.setText("");
		}
		
		public boolean existEmptyField() {
			if(txt_addr.getText().equals("")||txt_cmnd.getText().equals("")||txt_name.getText().equals("")||txt_phone.getText().equals("")) {
				return true;
			} else
				return false;
		}
	
	/**
	 * Create the frame.
	 */
	public InsertCustomerFrame() {
		setTitle("TH\u00D4NG TIN KH\u00C1CH H\u00C0NG");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 319, 188);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_tenkh = new JLabel("T\u00CAN KH\u00C1CH H\u00C0NG:");
		lbl_tenkh.setBounds(32, 11, 93, 14);
		contentPane.add(lbl_tenkh);
		
		JLabel lbl_cmndcccd = new JLabel("CMND/CCCD:");
		lbl_cmndcccd.setBounds(32, 36, 93, 14);
		contentPane.add(lbl_cmndcccd);
		
		JLabel lbl_diachi = new JLabel("\u0110\u1ECAA CH\u1EC8:");
		lbl_diachi.setBounds(32, 61, 93, 14);
		contentPane.add(lbl_diachi);
		
		JLabel lbl_sodienthoai = new JLabel("S\u1ED0 \u0110I\u1EC6N THO\u1EA0I:");
		lbl_sodienthoai.setBounds(32, 86, 93, 14);
		contentPane.add(lbl_sodienthoai);
		
		txt_name = new JTextField();
		txt_name.setBounds(135, 8, 133, 20);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		
		txt_cmnd = new JTextField();
		txt_cmnd.setColumns(10);
		txt_cmnd.setBounds(135, 33, 133, 20);
		contentPane.add(txt_cmnd);
		
		txt_addr = new JTextField();
		txt_addr.setColumns(10);
		txt_addr.setBounds(135, 58, 133, 20);
		contentPane.add(txt_addr);
		
		txt_phone = new JTextField();
		txt_phone.setColumns(10);
		txt_phone.setBounds(135, 83, 133, 20);
		contentPane.add(txt_phone);
		
		JButton btnAdd = new JButton("TH\u00CAM");
		btnAdd.setBounds(36, 114, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnClear = new JButton("H\u1EE6Y");
		btnClear.setBounds(179, 114, 89, 23);
		contentPane.add(btnClear);
		
		
		//Add events for buttons
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Check empty fields
				if(existEmptyField()==true){
					JOptionPane.showMessageDialog(contentPane, "Vui lòng nhập đủ thông tin!");	
				}
				else{
				    CustomerModel cust = new CustomerModel(-1,txt_cmnd.getText(),txt_name.getText(),txt_addr.getText(),txt_phone.getText());
				    CustomerModel.insertCust(cust);
				    JOptionPane.showMessageDialog(contentPane, "Nhập thành công!");
				    clearText();
				}
			}
		});
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearText();
			}
		});
	}

}
