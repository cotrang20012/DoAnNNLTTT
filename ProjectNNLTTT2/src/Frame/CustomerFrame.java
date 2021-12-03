package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.CarModel;
import model.CustomerModel;
import model.Global;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;


public class CustomerFrame extends JFrame {

	private JPanel contentPane;
	private JTable tableCustomer;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnExit;
	private JLabel lbl_tenkh;
	private JLabel lbl_cmndcccd;
	private JLabel lbl_diachi;
	private JLabel lbl_sodienthoai;
	private JTextField txt_name;
	private JTextField txt_cmnd;
	private JTextField txt_addr;
	private JTextField txt_phone;
	private JTextField txt_id;
	private JLabel lbl_id;
	private DefaultTableModel model;
	private JButton btnReload;
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

	private CustomerModel getCust() {
		CustomerModel cust = new CustomerModel();
		cust.setCustID(Integer.parseInt(txt_id.getText()));
		cust.setCmnd(txt_cmnd.getText());
		cust.setCustName(txt_name.getText());
		cust.setCustPhone(txt_phone.getText());
		cust.setCustAddr(txt_addr.getText());
		return cust;
	}
	
	private void loadData() {
		model = new DefaultTableModel();
		//set column headers
		Vector column = new Vector();
		column.add("ID Khách Hàng");
		column.add("Tên Khách Hàng");
		column.add("CMND/CCCD");
		column.add("Địa Chỉ");
		column.add("Số Điện Thoại");
		model.setColumnIdentifiers(column);
		ArrayList<CustomerModel> list = CustomerModel.ViewCustomer();
        for (int i = 0; i < list.size(); i++) {
        	CustomerModel cust = (CustomerModel)list.get(i);
        	Vector row = new Vector();
            row.add(cust.getCustID());
            row.add(cust.getCustName());
            row.add(cust.getCmnd());
            row.add(cust.getCustAddr());
            row.add(cust.getCustPhone());
            model.addRow(row);
        }
       tableCustomer.setModel(model);
	}
	
	/**
	 * Create the frame.
	 */
	public CustomerFrame() {
		setBounds(100, 100, 796, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 514, 348);
		contentPane.add(scrollPane);
		
		tableCustomer = new JTable();
		scrollPane.setViewportView(tableCustomer);
		
		btnAdd = new JButton("TH\u00CAM KH\u00C1CH H\u00C0NG");
		btnAdd.setBounds(10, 11, 146, 51);
		contentPane.add(btnAdd);
		
		btnUpdate = new JButton("S\u1EECA KH\u00C1CH H\u00C0NG");		
		btnUpdate.setBounds(166, 11, 126, 51);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("X\u00D3A KH\u00C1CH H\u00C0NG");
		btnDelete.setForeground(Color.RED);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setBounds(302, 11, 140, 51);
		contentPane.add(btnDelete);
		
		btnExit = new JButton("THO\u00C1T");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setForeground(Color.RED);
		btnExit.setBounds(644, 370, 126, 51);
		contentPane.add(btnExit);
		
		lbl_tenkh = new JLabel("TÊN KHÁCH HÀNG:");
		lbl_tenkh.setBounds(534, 131, 93, 14);
		contentPane.add(lbl_tenkh);
		
		lbl_cmndcccd = new JLabel("CMND/CCCD:");
		lbl_cmndcccd.setBounds(534, 156, 93, 14);
		contentPane.add(lbl_cmndcccd);
		
		lbl_diachi = new JLabel("ĐỊA CHỈ:");
		lbl_diachi.setBounds(534, 181, 93, 14);
		contentPane.add(lbl_diachi);
		
		lbl_sodienthoai = new JLabel("SỐ ĐIỆN THOẠI:");
		lbl_sodienthoai.setBounds(534, 206, 93, 14);
		contentPane.add(lbl_sodienthoai);
		
		txt_name = new JTextField();
		txt_name.setColumns(10);
		txt_name.setBounds(637, 128, 133, 20);
		contentPane.add(txt_name);
		
		txt_cmnd = new JTextField();
		txt_cmnd.setColumns(10);
		txt_cmnd.setBounds(637, 153, 133, 20);
		contentPane.add(txt_cmnd);
		
		txt_addr = new JTextField();
		txt_addr.setColumns(10);
		txt_addr.setBounds(637, 178, 133, 20);
		contentPane.add(txt_addr);
		
		txt_phone = new JTextField();
		txt_phone.setColumns(10);
		txt_phone.setBounds(637, 203, 133, 20);
		contentPane.add(txt_phone);
		
		txt_id = new JTextField();
		txt_id.setEnabled(false);
		txt_id.setColumns(10);
		txt_id.setBounds(637, 104, 133, 20);
		contentPane.add(txt_id);
		
		lbl_id = new JLabel("ID KHÁCH HÀNG:");
		lbl_id.setBounds(534, 107, 93, 14);
		contentPane.add(lbl_id);
		
		btnReload = new JButton("RELOAD");
		btnReload.setBounds(644, 11, 126, 51);
		contentPane.add(btnReload);
		loadData();
		//add events
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					InsertCustomerFrame frame = new InsertCustomerFrame();
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txt_id.getText()=="") {
					JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn KH để cập nhật!");	
				}
				else {
					CustomerModel cust = getCust();
					CustomerModel.updateCust(cust);
					JOptionPane.showMessageDialog(contentPane, "Cập nhật thành công!");
					loadData();
				}	
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txt_id.getText()=="") {
					JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn KH để xóa!");	
				}
				else {
					int delConfirmed = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa không?");
					if (delConfirmed == 0) {
						CustomerModel cust = getCust();
						CustomerModel.deleteCust(cust);
						JOptionPane.showMessageDialog(contentPane, "Xóa thành công!");
						loadData();
					}
				}
			}
		});
		
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadData();
			}
		});
		
		tableCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        // get the model from the jtable
			       DefaultTableModel model = (DefaultTableModel)tableCustomer.getModel();

			        // get the selected row index
			       int selectedRowIndex = tableCustomer.getSelectedRow();
			       
			        // set the selected row data into jtextfields
			       txt_id.setText(model.getValueAt(selectedRowIndex, 0).toString());
			       txt_name.setText(model.getValueAt(selectedRowIndex, 1).toString());
			       txt_cmnd.setText(model.getValueAt(selectedRowIndex, 2).toString());
			       txt_addr.setText(model.getValueAt(selectedRowIndex, 3).toString());
			       txt_phone.setText(model.getValueAt(selectedRowIndex, 4).toString());			       
			}
		});
		if(Global.acc.getUsertype().equals("SALES")) {
			btnUpdate.setEnabled(false);
			btnDelete.setEnabled(false);
		}
	}
}
