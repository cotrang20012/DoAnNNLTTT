package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import database.MyDB;

public class BillDetailModel {
	private int idbill;
	private int idxe;
	private int gia;
	public int getIdbill() {
		return idbill;
	}
	public void setIdbill(int idbill) {
		this.idbill = idbill;
	}
	public int getIdxe() {
		return idxe;
	}
	public void setIdxe(int idxe) {
		this.idxe = idxe;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	
	public static void insertBillDetail(int idbill, int idxe, int gia) {
		Connection conn = MyDB.getConnection();
		int id = 0;
		String insertQuery = "INSERT INTO billdetail (idbill, idxe, gia) VALUES (?,?,?);";
	    PreparedStatement pStatement = null;
	    try {
			pStatement = conn.prepareStatement(insertQuery);
			pStatement.setInt(1, idbill);
			pStatement.setInt(2, idxe);
			pStatement.setInt(3, gia);			
			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    MyDB.closeConnection(conn);
	}
	
	public static void deleteBillDetailAfterDeleteBill(int idbill) {
		Connection conn = MyDB.getConnection();
		String deleteQuery = "DELETE FROM billdetail WHERE idbill = ?";
	    PreparedStatement pStatement = null;
	    try {
	    	pStatement =conn.prepareStatement(deleteQuery);
	    	pStatement.setInt(1, idbill);
	    	
	    	pStatement.executeUpdate();
	    } catch (SQLException e) {
			e.printStackTrace();
		}
	   MyDB.closeConnection(conn);
	}
}
