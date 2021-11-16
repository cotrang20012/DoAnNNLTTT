package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class CustomerFrame extends JFrame {

	private JPanel contentPane;
	private JTable tableCustomer;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnXoKhchHng;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerFrame frame = new CustomerFrame();
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
	public CustomerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 626, 348);
		contentPane.add(scrollPane);
		
		tableCustomer = new JTable();
		scrollPane.setViewportView(tableCustomer);
		
		btnAdd = new JButton("THÊM KHÁCH HÀNG");
		btnAdd.setBounds(10, 11, 126, 51);
		contentPane.add(btnAdd);
		
		btnUpdate = new JButton("SỬA KHÁCH HÀNG");
		btnUpdate.setBounds(146, 11, 126, 51);
		contentPane.add(btnUpdate);
		
		btnXoKhchHng = new JButton("XOÁ KHÁCH HÀNG");
		btnXoKhchHng.setBounds(282, 11, 126, 51);
		contentPane.add(btnXoKhchHng);
		
		btnExit = new JButton("THOÁT");
		btnExit.setBounds(644, 370, 126, 51);
		contentPane.add(btnExit);
	}

}
