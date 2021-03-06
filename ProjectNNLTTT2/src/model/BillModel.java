package model;

import java.security.Identity;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import database.MyDB;

public class BillModel {
	private int idbill;
	private int idsale;
	private int idkhachhang;
	private int tonghoadon;
	private Date date;
	public int getIdbill() {
		return idbill;
	}

	public void setIdbill(int idbill) {
		this.idbill = idbill;
	}

	public int getIdsale() {
		return idsale;
	}

	public void setIdsale(int idsale) {
		this.idsale = idsale;
	}

	public int getIdkhachhang() {
		return idkhachhang;
	}

	public void setIdkhachhang(int idkhachhang) {
		this.idkhachhang = idkhachhang;
	}

	public int getTonghoadon() {
		return tonghoadon;
	}

	public void setTonghoadon(int tonghoadon) {
		this.tonghoadon = tonghoadon;
	}

	public static int insertBill(int idsale, int idkhachhang, int tonghoadon, Date date) {
		Connection conn = MyDB.getConnection();
		int id = 0;
		String insertQuery = "INSERT INTO bill (idsale, idkhachhang, tonghoadon, date) VALUES (?,?,?,?);";
	    PreparedStatement pStatement = null;
	    try {
			pStatement = conn.prepareStatement(insertQuery,Statement.RETURN_GENERATED_KEYS);
			pStatement.setInt(1, idsale);
			pStatement.setInt(2, idkhachhang);
			pStatement.setInt(3, tonghoadon);	
			pStatement.setDate(4, date);
			id = pStatement.executeUpdate();
			ResultSet rs = pStatement.getGeneratedKeys();
			int autoIncKeyFromApi = 0;
			if (rs.next()) {
			        autoIncKeyFromApi = rs.getInt(1);
			}
			id = autoIncKeyFromApi;
	    }catch (Exception e) {
	    	MyDB.closeConnection(conn);
			e.printStackTrace();
		}
	    MyDB.closeConnection(conn);
	    return id;
	}
	public static ArrayList<BillModel> viewBillForBillFrame(){
		Connection conn = MyDB.getConnection();

		String viewQuery = "SELECT * FROM bill;";
		try {
			PreparedStatement pStatement = conn.prepareStatement(viewQuery);
			ResultSet resultSet = pStatement.executeQuery();
			ArrayList<BillModel> ListBill = new ArrayList<BillModel>();
			while (resultSet.next()) {
				BillModel newBill = new BillModel();
				newBill.setIdbill(resultSet.getInt(1));
				newBill.setIdsale(resultSet.getInt(2));
				newBill.setIdkhachhang(resultSet.getInt(3));
				newBill.setTonghoadon(resultSet.getInt(4));
				newBill.setDate(resultSet.getDate(5));
				ListBill.add(newBill);
			}
			MyDB.closeConnection(conn);
			return ListBill;
		} catch (SQLException e) {
			e.printStackTrace();
			MyDB.closeConnection(conn);
			return null;
		}
	}
	
	public static ArrayList<BillModel> viewBillForBillFrameWithDate(Date dateStart, Date dateEnd){
		Connection conn = MyDB.getConnection();

		String viewQuery = "SELECT * FROM bill WHERE date BETWEEN ? AND ?;";
		try {
			PreparedStatement pStatement = conn.prepareStatement(viewQuery);
			pStatement.setDate(1, dateStart);
			pStatement.setDate(2, dateEnd);
			ResultSet resultSet = pStatement.executeQuery();
			ArrayList<BillModel> ListBill = new ArrayList<BillModel>();
			while (resultSet.next()) {
				BillModel newBill = new BillModel();
				newBill.setIdbill(resultSet.getInt(1));
				newBill.setIdsale(resultSet.getInt(2));
				newBill.setIdkhachhang(resultSet.getInt(3));
				newBill.setTonghoadon(resultSet.getInt(4));
				newBill.setDate(resultSet.getDate(5));
				ListBill.add(newBill);
			}
			MyDB.closeConnection(conn);
			return ListBill;
		} catch (SQLException e) {
			e.printStackTrace();
			MyDB.closeConnection(conn);
			return null;
		}
	}
	
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static void DeleteBill(int idBill) {
		Connection conn = MyDB.getConnection();
		String deleteQuery = "DELETE FROM bill WHERE idbill = ?";
	    PreparedStatement pStatement = null;
	    try {
	    	pStatement =conn.prepareStatement(deleteQuery);
	    	pStatement.setInt(1, idBill);
	    	
	    	pStatement.executeUpdate();
	    } catch (SQLException e) {
	    	MyDB.closeConnection(conn);
			e.printStackTrace();
		}
	   MyDB.closeConnection(conn);
	}
}
