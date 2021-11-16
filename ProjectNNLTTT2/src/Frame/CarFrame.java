package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class CarFrame extends JFrame {

	private JPanel contentPane;
	private JTable tableCar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarFrame frame = new CarFrame();
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
	public CarFrame() {
		setTitle("QUẢN LÝ XE");
		setBounds(100, 100, 796, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdd = new JButton("THÊM XE");
		btnAdd.setBounds(10, 11, 126, 51);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("SỬA XE");
		btnUpdate.setBounds(146, 11, 126, 51);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("XOÁ XE");
		btnDelete.setBounds(282, 11, 126, 51);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 626, 348);
		contentPane.add(scrollPane);
		
		tableCar = new JTable();
		scrollPane.setViewportView(tableCar);
		
		JButton btnExit = new JButton("THOÁT");
		btnExit.setBounds(648, 370, 126, 51);
		contentPane.add(btnExit);
	}
}
