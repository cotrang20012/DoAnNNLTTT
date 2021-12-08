package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.MyDB;

public class CustomerModel {
	//elements
	private int custID;
	private String cmnd;
	private String custName;
	private String custAddr;
	private String custPhone;
	
	//constructors
	public CustomerModel() {};
	public CustomerModel(int custID, String cmnd, String custName, String custAddr, String custPhone) {
		super();
		this.custID = custID;
		this.cmnd = cmnd;
		this.custName = custName;
		this.custAddr = custAddr;
		this.custPhone = custPhone;
	}
	
	//getters-setters
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustAddr() {
		return custAddr;
	}
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	
	//business logic layer
	public static void insertCust(CustomerModel cust) {
		Connection conn = MyDB.getConnection();
		String insertQuery = "INSERT INTO khachhang (cmnd , ten , diachi , sdt) VALUES (?,?,?,?);";
	    PreparedStatement pStatement = null;
	    try {
			pStatement = conn.prepareStatement(insertQuery);
			pStatement.setString(1, cust.getCmnd());
			pStatement.setString(2, cust.getCustName());
			pStatement.setString(3, cust.getCustAddr());
			pStatement.setString(4, cust.getCustPhone());

			pStatement.execute();

		} catch (SQLException e) {
			MyDB.closeConnection(conn);
			e.printStackTrace();
		}
	    
	   MyDB.closeConnection(conn);
	}
	
	public static void updateCust(CustomerModel cust) {
		Connection conn = MyDB.getConnection();
		String updateQuery = "UPDATE khachhang SET cmnd=?, ten=?, diachi=?, sdt=? WHERE id=?";
	    PreparedStatement pStatement = null;
	    try {
	    	pStatement =conn.prepareStatement(updateQuery);
	    	pStatement.setString(1, cust.getCmnd());
			pStatement.setString(2, cust.getCustName());
			pStatement.setString(3, cust.getCustAddr());
			pStatement.setString(4, cust.getCustPhone());
			pStatement.setInt(5, cust.getCustID());
			
			pStatement.execute();
	    } catch (SQLException e) {
	    	MyDB.closeConnection(conn);
	    	e.printStackTrace();
		}
	    MyDB.closeConnection(conn);
	}
	
	public static boolean deleteCust(CustomerModel cust) {
		Connection conn = MyDB.getConnection();
		String deleteQuery = "DELETE FROM khachhang WHERE id = ?";
	    PreparedStatement pStatement = null;
	    try {
	    	pStatement =conn.prepareStatement(deleteQuery);
	    	pStatement.setInt(1, cust.getCustID());;
	    	
	    	pStatement.execute();
	    	return true;
	    } catch (SQLException e) {
	    	MyDB.closeConnection(conn);
			e.printStackTrace();
			return false;
		}	    
	}
	
	public static ArrayList<CustomerModel> ViewCustomer() {
		Connection conn = MyDB.getConnection();

		String viewQuery = "SELECT * FROM khachhang;";
		try {
			PreparedStatement pStatement = conn.prepareStatement(viewQuery);
			ResultSet resultSet = pStatement.executeQuery();
			ArrayList<CustomerModel> ListCustomer = new ArrayList<CustomerModel>();
			while (resultSet.next()) {
				CustomerModel newCustomer = new CustomerModel();
				newCustomer.setCustID(resultSet.getInt(1));
				newCustomer.setCmnd(resultSet.getString(2));
				newCustomer.setCustName(resultSet.getString(3));
				newCustomer.setCustAddr(resultSet.getString(4));
				newCustomer.setCustPhone(resultSet.getString(5));
				ListCustomer.add(newCustomer);
			}
			MyDB.closeConnection(conn);
			return ListCustomer;
		} catch (SQLException e) {
			e.printStackTrace();
			MyDB.closeConnection(conn);
			return null;
		}
	}
}
