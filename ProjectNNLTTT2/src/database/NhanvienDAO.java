package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.NhanVien;

public class NhanvienDAO {
	Connection conn;
	public NhanvienDAO() {
		
	}
	public ArrayList<NhanVien> getNV(){
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
				list.add(nv);
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public boolean UpdateNV(NhanVien nv) {
		try {
			conn = MyDB.getConnection();
			PreparedStatement stmt = conn.prepareStatement("UPDATE nhanvien set diachi = ?,sdt=?,ten =?,chucvu=?,luong=? where id = ?");
			stmt.setString(1, nv.getDiachi());
			stmt.setString(2, nv.getSdt());
			stmt.setString(3, nv.getTen());
			stmt.setString(4, nv.getChucvu());
			stmt.setInt(5, nv.getLuong());
			stmt.setInt(6, nv.getId());
			stmt.execute();
			conn.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean Insert(NhanVien nv) {
		try {
			conn = MyDB.getConnection();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO nhanvien VALUES(?,?,?,?,?,?,?)");
			stmt.setString(1, null);
			stmt.setString(2, nv.getCmnd());
			stmt.setString(3, nv.getTen());
			stmt.setString(4, nv.getDiachi());
			stmt.setString(5, nv.getChucvu());
			stmt.setString(6, nv.getSdt());
			stmt.setInt(7, nv.getLuong());
			stmt.execute();
			conn.close();
			return true;
		} catch (Exception e) {
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
		}
		return true;
	}
	public boolean Delete(int id) {
		try {
			conn = MyDB.getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM nhanvien where id = ?");
			stmt.setInt(1, id);
			stmt.execute();
			return true;
		} catch (Exception e) {
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
				break;
			}
			conn.close();
			return nv;
		} catch (Exception e) {
			return null;
		}
	}
}
