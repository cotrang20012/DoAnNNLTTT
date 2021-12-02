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
			PreparedStatement stmt = conn.prepareStatement("UPDATE nhanvien set diachi = ?,sdt=? where id = ?");
			stmt.setString(1, nv.getDiachi());
			stmt.setString(2, nv.getSdt());
			stmt.setInt(3, nv.getId());
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
}
