package model;

import java.security.Identity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

import database.MyDB;

public class BillModel {
	private int idbill;
	private int idsale;
	private int idkhachhang;
	private int tonghoadon;

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

	public static int insertBill(int idsale, int idkhachhang, int tonghoadon) {
		Connection conn = MyDB.getConnection();
		int id = 0;
		String insertQuery = "INSERT INTO bill (idsale, idkhachhang, tonghoadon) VALUES (?,?,?);";
	    PreparedStatement pStatement = null;
	    try {
			pStatement = conn.prepareStatement(insertQuery,Statement.RETURN_GENERATED_KEYS);
			pStatement.setInt(1, idsale);
			pStatement.setInt(2, idkhachhang);
			pStatement.setInt(3, tonghoadon);			
			id = pStatement.executeUpdate();
			ResultSet rs = pStatement.getGeneratedKeys();
			int autoIncKeyFromApi = 0;
			if (rs.next()) {
			        autoIncKeyFromApi = rs.getInt(1);
			}
			id = autoIncKeyFromApi;
	    }catch (Exception e) {
			e.printStackTrace();
		}
	    MyDB.closeConnection(conn);
	    return id;
	}
}
