package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.NhanVien;

public class NhanvienDAO {
	Connection conn;

	public NhanvienDAO() {

	}

	public ArrayList<NhanVien> getNV() {
		ArrayList<NhanVien> list = new ArrayList<NhanVien>();
		try {
			conn = MyDB.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM nhanvien");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				NhanVien nv = new NhanVien();
				nv.setId(rs.getInt("id"));
				nv.setCmnd(rs.getString("cmnd"));
				nv.setTen(rs.getString("ten"));
				nv.setDiachi(rs.getString("diachi"));
				nv.setChucvu(rs.getString("chucvu"));
				nv.setSdt(rs.getString("sdt"));
				nv.setLuong(rs.getInt("luong"));
				nv.setPassword(rs.getString("password"));
				list.add(nv);
			}
			conn.close();
		} catch (Exception e) {
			MyDB.closeConnection(conn);
			// TODO: handle exception
		}
		return list;
	}

	public boolean UpdateNV(NhanVien nv) {
		try {
			conn = MyDB.getConnection();
			PreparedStatement stmt = conn.prepareStatement(
					"UPDATE nhanvien set diachi = ?,sdt=?,ten =?,chucvu=?,luong=?,password =? where id = ?");
			stmt.setString(1, nv.getDiachi());
			stmt.setString(2, nv.getSdt());
			stmt.setString(3, nv.getTen());
			stmt.setString(4, nv.getChucvu());
			stmt.setInt(5, nv.getLuong());
			stmt.setString(6, nv.getPassword());
			stmt.setInt(7, nv.getId());
			stmt.execute();
			conn.close();
			return true;
		} catch (Exception e) {
			MyDB.closeConnection(conn);
			return false;
		}
	}

	public boolean Insert(NhanVien nv) {
		try {
			conn = MyDB.getConnection();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO nhanvien VALUES(?,?,?,?,?,?,?,?)");
			stmt.setString(1, null);
			stmt.setString(2, nv.getCmnd());
			stmt.setString(3, nv.getTen());
			stmt.setString(4, nv.getDiachi());
			stmt.setString(5, nv.getChucvu());
			stmt.setString(6, nv.getSdt());
			stmt.setInt(7, nv.getLuong());
			stmt.setString(8, nv.getPassword());
			stmt.execute();
			conn.close();
			return true;
		} catch (Exception e) {
			MyDB.closeConnection(conn);
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
	}

	public boolean CheckSale(NhanVien nv) {
		try {
			conn = MyDB.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bill WHERE idsale = ?");
			stmt.setInt(1, nv.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
				return false;
			conn.close();
		} catch (Exception e) {
			MyDB.closeConnection(conn);
		}
		return true;
	}

	public boolean Delete(int id) {
		try {
			conn = MyDB.getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM nhanvien where id = ?");
			stmt.setInt(1, id);
			stmt.execute();
			MyDB.closeConnection(conn);
			return true;
		} catch (Exception e) {
			MyDB.closeConnection(conn);
			return false;
		}
	}

	public NhanVien getNhanVien(String cmnd) {
		try {
			conn = MyDB.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM nhanvien WHERE cmnd = ?");
			stmt.setString(1, cmnd);
			ResultSet rs = stmt.executeQuery();
			NhanVien nv = new NhanVien();
			while (rs.next()) {
				nv.setId(rs.getInt("id"));
				nv.setCmnd(rs.getString("cmnd"));
				nv.setTen(rs.getString("ten"));
				nv.setDiachi(rs.getString("diachi"));
				nv.setChucvu(rs.getString("chucvu"));
				nv.setSdt(rs.getString("sdt"));
				nv.setLuong(rs.getInt("luong"));
				nv.setPassword(rs.getString("password"));
				break;
			}
			conn.close();
			return nv;
		} catch (Exception e) {
			MyDB.closeConnection(conn);
			return null;
		}
	}

	public static boolean updateNhanVienSalary(int id, int TongHoaDon) {
		int HoaHong = TongHoaDon * 10 / 100;
		Connection conn = MyDB.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE nhanvien set luong = luong + ? where id = ?");
			stmt.setInt(1, HoaHong);
			stmt.setInt(2, id);
			stmt.execute();
			conn.close();
			return true;
		} catch (Exception e) {
			MyDB.closeConnection(conn);
			return false;
		}
	}

	public NhanVien checkLogin(NhanVien nv) throws SQLException {
		try {
			conn = MyDB.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM nhanvien WHERE cmnd = ? and password=? and chucvu=?");
			stmt.setString(1, nv.getCmnd());
			stmt.setString(2, nv.getPassword());
			stmt.setString(3, nv.getChucvu());
			ResultSet rs = stmt.executeQuery();
			nv = new NhanVien();
			if (rs.next()) {
				nv.setId(rs.getInt("id"));
				nv.setCmnd(rs.getString("cmnd"));
				nv.setTen(rs.getString("ten"));
				nv.setDiachi(rs.getString("diachi"));
				nv.setChucvu(rs.getString("chucvu"));
				nv.setSdt(rs.getString("sdt"));
				nv.setLuong(rs.getInt("luong"));
				nv.setPassword(rs.getString("password"));
				conn.close();
				return nv;
			}
			else return null;
			
		} catch (Exception e) {
			e.printStackTrace();
			conn.close();
			return null;
		}
	}
	
}
