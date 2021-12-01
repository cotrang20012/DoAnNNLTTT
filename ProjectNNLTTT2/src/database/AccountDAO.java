package database;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;

public class AccountDAO {
	Connection conn;
	public AccountDAO() {
	}
	public void Insert() {
		
	}
	public void Delete() {
		
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
}
