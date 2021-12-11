package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;
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
	private JLabel lbl_title;
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
		column.add("ID KhÃ¡ch HÃ ng");
		column.add("TÃªn KhÃ¡ch HÃ ng");
		column.add("CMND/CCCD");
		column.add("Ä�á»‹a Chá»‰");
		column.add("Sá»‘ Ä�iá»‡n Thoáº¡i");
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
		setTitle("QUáº¢N LÃ� KHÃ�CH HÃ€NG");
		setBounds(100, 100, 796, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 137, 604, 284);
		contentPane.add(scrollPane);
		
		tableCustomer = new JTable(){
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		scrollPane.setViewportView(tableCustomer);
		
		btnAdd = new JButton("TH\u00CAM KH\u00C1CH H\u00C0NG");
		btnAdd.setBounds(624, 246, 146, 51);
		contentPane.add(btnAdd);
		
		btnUpdate = new JButton("S\u1EECA KH\u00C1CH H\u00C0NG");		
		btnUpdate.setBounds(624, 308, 146, 51);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("X\u00D3A KH\u00C1CH H\u00C0NG");
		btnDelete.setForeground(Color.RED);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setBounds(624, 370, 146, 51);
		contentPane.add(btnDelete);
		
		btnExit = new JButton("THO\u00C1T");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setForeground(Color.RED);
		btnExit.setBounds(644, 11, 126, 51);
		contentPane.add(btnExit);
		
		lbl_tenkh = new JLabel("TÃŠN KHÃ�CH HÃ€NG:");
		lbl_tenkh.setBounds(54, 73, 93, 14);
		contentPane.add(lbl_tenkh);
		
		lbl_cmndcccd = new JLabel("CMND/CCCD:");
		lbl_cmndcccd.setBounds(54, 98, 93, 14);
		contentPane.add(lbl_cmndcccd);
		
		lbl_diachi = new JLabel("Ä�á»ŠA CHá»ˆ:");
		lbl_diachi.setBounds(363, 49, 93, 14);
		contentPane.add(lbl_diachi);
		
		lbl_sodienthoai = new JLabel("Sá»� Ä�Iá»†N THOáº I:");
		lbl_sodienthoai.setBounds(363, 74, 93, 14);
		contentPane.add(lbl_sodienthoai);
		
		txt_name = new JTextField();
		txt_name.setColumns(10);
		txt_name.setBounds(157, 70, 133, 20);
		contentPane.add(txt_name);
		
		txt_cmnd = new JTextField();
		txt_cmnd.setColumns(10);
		txt_cmnd.setBounds(157, 95, 133, 20);
		contentPane.add(txt_cmnd);
		
		txt_addr = new JTextField();
		txt_addr.setColumns(10);
		txt_addr.setBounds(466, 46, 133, 20);
		contentPane.add(txt_addr);
		
		txt_phone = new JTextField();
		txt_phone.setColumns(10);
		txt_phone.setBounds(466, 71, 133, 20);
		contentPane.add(txt_phone);
		
		txt_id = new JTextField();
		txt_id.setEnabled(false);
		txt_id.setColumns(10);
		txt_id.setBounds(157, 46, 133, 20);
		contentPane.add(txt_id);
		
		lbl_id = new JLabel("ID KHÃ�CH HÃ€NG:");
		lbl_id.setBounds(54, 49, 93, 14);
		contentPane.add(lbl_id);
		
		btnReload = new JButton("RELOAD");
		btnReload.setBounds(624, 184, 146, 51);
		contentPane.add(btnReload);
		
		lbl_title = new JLabel("TH\u00D4NG TIN KH\u00C1CH H\u00C0NG:");
		lbl_title.setBounds(10, 11, 133, 14);
		contentPane.add(lbl_title);
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
				if(txt_id.getText().equals("")){
					JOptionPane.showMessageDialog(contentPane, "Vui lÃ²ng chá»�n KH Ä‘á»ƒ cáº­p nháº­t!");	
				}
				else {
					if(txt_id.getText().equals("") || txt_name.getText().equals("") || txt_cmnd.getText().equals("") || txt_addr.getText().equals("") || txt_phone.getText().equals("")) {
						JOptionPane.showMessageDialog(contentPane, "Vui lÃ²ng Ä‘iá»�n Ä‘áº§y Ä‘á»§ thÃ´ng tin!");
						loadData();
					}
					else {
						CustomerModel cust = getCust();
						CustomerModel.updateCust(cust);
						JOptionPane.showMessageDialog(contentPane, "Cáº­p nháº­t thÃ nh cÃ´ng!");
						loadData();
					}
				}	
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txt_id.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Vui lÃ²ng chá»�n KH Ä‘á»ƒ xÃ³a!");	
				}
				else {
					int delConfirmed = JOptionPane.showConfirmDialog(null, "Báº¡n cÃ³ cháº¯c cháº¯n muá»‘n xÃ³a khÃ´ng?");
					if (delConfirmed == 0) {
						CustomerModel cust = getCust();
						CustomerModel.deleteCust(cust);
						JOptionPane.showMessageDialog(contentPane, "XÃ³a thÃ nh cÃ´ng!");
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
