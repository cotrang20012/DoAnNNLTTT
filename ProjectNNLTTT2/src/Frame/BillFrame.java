package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class BillFrame extends JFrame {

	private JPanel contentPane;
	private JTable tableBill;

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
		setBounds(100, 100, 796, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdd = new JButton("THÊM HOÁ ĐƠN");
		btnAdd.setBounds(10, 11, 126, 51);
		contentPane.add(btnAdd);
		
		JButton btnView = new JButton("XEM HOÁ ĐƠN");
		btnView.setBounds(146, 11, 126, 51);
		contentPane.add(btnView);
		
		JButton btnDelete = new JButton("XOÁ HOÁ ĐƠN");
		btnDelete.setBounds(282, 11, 126, 51);
		contentPane.add(btnDelete);
		
		JButton btnExit = new JButton("THOÁT");
		btnExit.setBounds(644, 370, 126, 51);
		contentPane.add(btnExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 626, 348);
		contentPane.add(scrollPane);
		
		tableBill = new JTable();
		scrollPane.setViewportView(tableBill);
	}
}
