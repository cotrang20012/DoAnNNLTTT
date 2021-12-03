package database;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Account;

public class AccountDAO {
	Connection conn;
	public AccountDAO() {
		
	}
	public int checkLogin(Account acc) throws SQLException {
		conn = MyDB.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM account WHERE username = ? AND password = ? AND usertype = ?");
		stmt.setString(1, acc.getUsername());
		stmt.setString(2, acc.getPassword());
		stmt.setString(3, acc.getUsertype());
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) { 
			conn.close();
			return 1;
		}
		conn.close();
		return 0;	
	}
	public ArrayList<Account> getAccounts() {
		ArrayList<Account> list = new ArrayList<Account>();
		conn = MyDB.getConnection();
		try {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM account");
		ResultSet rs = stmt.executeQuery();
		
			while (rs.next()) {
				Account acc = new Account();
				acc.setUsername(rs.getString("username"));
				acc.setPassword(rs.getString("password"));
				acc.setUsertype("SALES");
				list.add(acc);
				
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean Update(Account acc) {
		try {
			conn = MyDB.getConnection();
			PreparedStatement stmt = conn.prepareStatement("UPDATE account SET password = ? WHERE username = ?");
			stmt.setString(1, acc.getPassword());
			stmt.setString(2, acc.getUsername());
			stmt.execute();
			conn.close();
			return true;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}
	public boolean Insert(Account acc) {
		try {
			conn = MyDB.getConnection();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO account VALUES(?,?,?)");
			stmt.setString(1, acc.getUsername());
			stmt.setString(2, acc.getPassword());
			stmt.setString(3, acc.getUsertype());
			stmt.execute();
			conn.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
	}
	public boolean Delete(String user) {
		try {
			conn = MyDB.getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM account where username = ?");
			stmt.setString(1, user);
			stmt.execute();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
