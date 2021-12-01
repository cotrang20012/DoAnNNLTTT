package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.MyDB;

public class CarModel {
	//elements
	private int id;
	private String modelXe;
	private String mauXe;
	private String thuongHieu;
	private String loai;
	private int phanKhoi;
	private String xuatXu;
	private String trangThai;
	private int giaXe;
	
	//constructor
	public CarModel() {}
	public CarModel(int id, String modelXe, String mauXe, String thuongHieu, String loai, int phanKhoi, String xuatXu,
			String trangThai, int giaXe) {
		super();
		this.id = id;
		this.modelXe = modelXe;
		this.mauXe = mauXe;
		this.thuongHieu = thuongHieu;
		this.loai = loai;
		this.phanKhoi = phanKhoi;
		this.xuatXu = xuatXu;
		this.trangThai = trangThai;
		this.giaXe = giaXe;
	}
	
	//getters-setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelXe() {
		return modelXe;
	}
	public void setModelXe(String modelXe) {
		this.modelXe = modelXe;
	}
	public String getMauXe() {
		return mauXe;
	}
	public void setMauXe(String mauXe) {
		this.mauXe = mauXe;
	}
	public String getThuongHieu() {
		return thuongHieu;
	}
	public void setThuongHieu(String thuongHieu) {
		this.thuongHieu = thuongHieu;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	public int getPhanKhoi() {
		return phanKhoi;
	}
	public void setPhanKhoi(int phanKhoi) {
		this.phanKhoi = phanKhoi;
	}
	public String getXuatXu() {
		return xuatXu;
	}
	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public int getGiaXe() {
		return giaXe;
	}
	public void setGiaXe(int giaXe) {
		this.giaXe = giaXe;
	}
	
	//Business logic layer
	public static void insertCar(CarModel car) {
		Connection conn = MyDB.getConnection();
		String insertQuery = "INSERT INTO xe (model, mauxe, thuonghieu, loai, phankhoi, xuatxu, trangthai, gia) VALUES (?,?,?,?,?,?,?,?);";
	    PreparedStatement pStatement = null;
	    try {
			pStatement = conn.prepareStatement(insertQuery);
			pStatement.setString(1, car.getModelXe());
			pStatement.setString(2, car.getMauXe());
			pStatement.setString(3, car.getThuongHieu());
			pStatement.setString(4, car.getLoai());
			pStatement.setInt(5, car.getPhanKhoi());
			pStatement.setString(6, car.getXuatXu());
			pStatement.setString(7, car.getTrangThai());
			pStatement.setInt(8, car.getGiaXe());
						
			pStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
	   MyDB.closeConnection(conn);
	}
	
	public static void deleteCar(CarModel car) {
		Connection conn = MyDB.getConnection();
		String deleteQuery = "DELETE FROM xe WHERE id = ?";
	    PreparedStatement pStatement = null;
	    try {
	    	pStatement =conn.prepareStatement(deleteQuery);
	    	pStatement.setInt(1, car.getId());
	    	
	    	pStatement.execute();
	    } catch (SQLException e) {
			e.printStackTrace();
		}
	    
	   MyDB.closeConnection(conn);
	}
	
	public static void updateCar(CarModel car) {
		Connection conn = MyDB.getConnection();
		String updateQuery = "UPDATE xe SET model=?, mauxe=?, thuonghieu=?, loai=?, phankhoi=?, xuatxu=?, trangthai=?, gia=? WHERE id=?";
	    PreparedStatement pStatement = null;
	    try {
	    	pStatement =conn.prepareStatement(updateQuery);
	    	pStatement.setString(1, car.getModelXe());
			pStatement.setString(2, car.getMauXe());
			pStatement.setString(3, car.getThuongHieu());
			pStatement.setString(4, car.getLoai());
			pStatement.setInt(5, car.getPhanKhoi());
			pStatement.setString(6, car.getXuatXu());
			pStatement.setString(7, car.getTrangThai());
			pStatement.setInt(8, car.getGiaXe());
			pStatement.setInt(9, car.getId());
			
			pStatement.execute();
	    } catch (SQLException e) {
	    	e.printStackTrace();
		}
	}
	
	public static ArrayList<CarModel> viewCarNotSales() {
		Connection conn = MyDB.getConnection();
		
		String viewQuery = "SELECT * FROM xe WHERE trangthai = ?; ";
		try {
			PreparedStatement pStatement = conn.prepareStatement(viewQuery);
			pStatement.setString(1, "CHƯA BÁN");
			ResultSet resultSet = pStatement.executeQuery();
			ArrayList<CarModel> ListCar = new ArrayList<CarModel>();
			while(resultSet.next()) {
				CarModel newCar = new CarModel();
				newCar.setId(resultSet.getInt(1));
				newCar.setModelXe(resultSet.getString(2));
				newCar.setMauXe(resultSet.getString(3));
				newCar.setThuongHieu(resultSet.getString(4));
				newCar.setPhanKhoi(resultSet.getInt(6));
				newCar.setLoai(resultSet.getString(5));
				newCar.setXuatXu(resultSet.getString(7));
				newCar.setGiaXe(resultSet.getInt(9));
				ListCar.add(newCar);
			}
			MyDB.closeConnection(conn);
			return ListCar;
		} catch (SQLException e) {		
			e.printStackTrace();
			return null;
		}
	}
}

