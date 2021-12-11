package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import model.BillModel;
import model.DateLabelFormatter;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

public class StatisticsFrame extends JFrame {

	private JPanel contentPane;
	private JTable tableBill;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatisticsFrame frame = new StatisticsFrame();
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
	public StatisticsFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("THỐNG KÊ");
		setBounds(100, 100, 691, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(456, 362, 209, 14);
		contentPane.add(lblNewLabel_1);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(50,27,220,23);
		contentPane.add(datePicker);
		
		UtilDateModel model2 = new UtilDateModel();
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p);
		contentPane.setLayout(null);
		JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
		datePicker2.setBounds(325, 27, 220, 23);
		contentPane.add(datePicker2);
		
		JLabel lblNewLabel = new JLabel("NGÀY BẮT ĐẦU:");
		lblNewLabel.setBounds(106, 11, 118, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNgyKtThc = new JLabel("NGÀY KẾT THÚC");
		lblNgyKtThc.setBounds(390, 11, 118, 14);
		contentPane.add(lblNgyKtThc);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 59, 655, 299);
		contentPane.add(scrollPane);
		
		tableBill = new JTable(){
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
	

		DefaultTableModel Billmodel = new DefaultTableModel();
		Billmodel.addColumn("ID Bill");
		Billmodel.addColumn("ID Nhân Viên");
		Billmodel.addColumn("ID Khách Hàng");
		Billmodel.addColumn("Tổng giá trị hoá đơn");
		Billmodel.addColumn("Ngày");
		tableBill.setModel(Billmodel);
		tableBill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableBill.rowAtPoint(e.getPoint());
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							int idBill = Integer.parseInt(tableBill.getValueAt(row, 0).toString());
							int idSale = Integer.parseInt(tableBill.getValueAt(row, 1).toString());
							int idCustomer = Integer.parseInt(tableBill.getValueAt(row, 2).toString());
							int TongHoaDon = Integer.parseInt(tableBill.getValueAt(row, 3).toString());
							ViewBillDetail newframe = new ViewBillDetail(idBill, idSale, idCustomer, TongHoaDon);
							newframe.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		scrollPane.setViewportView(tableBill);
		
		JButton btnFind = new JButton("Tìm Kiếm");
		btnFind.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				java.util.Date dateStart = (java.util.Date) datePicker.getModel().getValue();
				java.util.Date dateEnd = (java.util.Date) datePicker2.getModel().getValue();
				Date dateStartSQL = new Date(dateStart.getTime());
				Date dateEndSQL = new Date(dateEnd.getTime());
				SetDataForTableBill(dateStartSQL, dateEndSQL);
				TinhTongHoaDon(lblNewLabel_1);
			}
		});
		btnFind.setBounds(558, 27, 89, 23);
		contentPane.add(btnFind);
		TinhTongHoaDon(lblNewLabel_1);
	}
	
	private void SetDataForTableBill(Date DateStart, Date DateEnd) {
		ArrayList<BillModel> listBill = BillModel.viewBillForBillFrameWithDate(DateStart,DateEnd);
		DefaultTableModel model = (DefaultTableModel) tableBill.getModel();
		model.setRowCount(0);
		for (BillModel bill : listBill) {
			String[] item = { String.valueOf(bill.getIdbill()), String.valueOf(bill.getIdsale()),
					String.valueOf(bill.getIdkhachhang()), String.valueOf(bill.getTonghoadon()),bill.getDate().toString()};
			model.addRow(item);
			model.fireTableDataChanged();
		}
	}
	
	private void TinhTongHoaDon(JLabel lblTongHoaDon) {
		DefaultTableModel model = (DefaultTableModel) tableBill.getModel();
		int TongHoaDon = 0;
		if(model.getRowCount()!=0) {
			for(int i = 0; i < model.getRowCount();i++) {
				int GiaTri =   Integer.parseInt((model.getValueAt(i, 3).toString()));
				TongHoaDon += GiaTri;
			}
		}
		lblTongHoaDon.setText("Tổng: "+String.valueOf(TongHoaDon));		
	}
}
