package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class MyDB {
	
	public static Connection getConnection() {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
		Connection conn = null;
		
		try {
		    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectnnlttt","root","1234");
		    
		  /*  String prepareSQL = "SELECT * FROM testdb.laptop";
		    PreparedStatement pStatement = conn.prepareStatement(prepareSQL);
		    ResultSet productResultSet = pStatement.executeQuery();
		    productResultSet.next();
		    System.out.println(productResultSet.getString(1));*/
		    
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		return conn;
	}
	
	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}