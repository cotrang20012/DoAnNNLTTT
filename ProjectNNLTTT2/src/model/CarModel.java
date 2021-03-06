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
			MyDB.closeConnection(conn);
			e.printStackTrace();
		}
	   MyDB.closeConnection(conn);
	}
	
	public static boolean deleteCar(CarModel car) {
		Connection conn = MyDB.getConnection();
		String deleteQuery = "DELETE FROM xe WHERE id = ?";
	    PreparedStatement pStatement = null;
	    try {
	    	pStatement =conn.prepareStatement(deleteQuery);
	    	pStatement.setInt(1, car.getId());
	    	
	    	pStatement.execute();
	    	MyDB.closeConnection(conn);
	    	return true;
	    } catch (SQLException e) {
	    	MyDB.closeConnection(conn);
			return false;
		}
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
	    MyDB.closeConnection(conn);
	}
	
	public static ArrayList<CarModel> viewCarNotSales() {
		Connection conn = MyDB.getConnection();
		
		String viewQuery = "SELECT * FROM xe WHERE trangthai = ?; ";
		try {
			PreparedStatement pStatement = conn.prepareStatement(viewQuery);
			pStatement.setString(1, "CH??A B??N");
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
	
	public static ArrayList<CarModel> viewAllCar() {
        try {           
            Connection con = MyDB.getConnection();
            String sqlString = "SELECT * FROM xe";
            PreparedStatement stmt = con.prepareStatement(sqlString);
            ArrayList<CarModel> lst = new ArrayList<CarModel>();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	CarModel car = new CarModel();
				car.setId(rs.getInt("id"));
				car.setModelXe(rs.getString("model"));
				car.setMauXe(rs.getString("mauxe"));
				car.setLoai(rs.getString("loai"));
				car.setPhanKhoi(rs.getInt("phankhoi"));
				car.setXuatXu(rs.getString("xuatxu"));
				car.setTrangThai(rs.getString("trangthai"));
				car.setGiaXe(rs.getInt("gia"));
				car.setThuongHieu(rs.getString("thuonghieu"));
                lst.add(car);
            }
            MyDB.closeConnection(con);
            return lst;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
	}
	
	public static ArrayList<CarModel> searchCar(int priceMin, int priceMax, String model, int phankhoi, String mauxe, String thuonghieu, String xuatxu, String trangthai, String loaixe) {
        try {
            Connection con = MyDB.getConnection();
            String searchQuery = "CALL SEARCHCAR(?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(searchQuery);
            stmt.setInt(1, priceMin);
            stmt.setInt(2, priceMax);
            stmt.setInt(3, phankhoi);
            stmt.setString(4, model);
            stmt.setString(5, mauxe);
            stmt.setString(6, thuonghieu);
            stmt.setString(7, xuatxu);
            stmt.setString(8, trangthai);
            stmt.setString(9, loaixe);
            ArrayList<CarModel> lst = new ArrayList<CarModel>();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CarModel car = new CarModel();
                car.setId(rs.getInt("id"));
                car.setModelXe(rs.getString("model"));
                car.setMauXe(rs.getString("mauxe"));
                car.setLoai(rs.getString("loai"));
                car.setPhanKhoi(rs.getInt("phankhoi"));
                car.setXuatXu(rs.getString("xuatxu"));
                car.setTrangThai(rs.getString("trangthai"));
                car.setGiaXe(rs.getInt("gia"));
                car.setThuongHieu(rs.getString("thuonghieu"));
                lst.add(car);
            }
            MyDB.closeConnection(con);
            return lst;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
	
	public static void updateCarStatus(int carID) {
		Connection conn = MyDB.getConnection();
		String updateQuery = "UPDATE xe SET trangthai= ? WHERE id= ?";
	    PreparedStatement pStatement = null;
	    try {
	    	pStatement =conn.prepareStatement(updateQuery);
	    	pStatement.setString(1, "???? B??N");
			pStatement.setInt(2, carID);
				
			pStatement.executeUpdate();
	    } catch (SQLException e) {
	    	e.printStackTrace();
		}
	    MyDB.closeConnection(conn);
	}
	public static void updateCarStatusAfterDeleteBill(int carID) {
		Connection conn = MyDB.getConnection();
		String updateQuery = "UPDATE xe SET trangthai= ? WHERE id= ?";
	    PreparedStatement pStatement = null;
	    try {
	    	pStatement =conn.prepareStatement(updateQuery);
	    	pStatement.setString(1, "CH??A B??N");
			pStatement.setInt(2, carID);
				
			pStatement.executeUpdate();
	    } catch (SQLException e) {
	    	e.printStackTrace();
		}
	    MyDB.closeConnection(conn);
	}
	
	public static ArrayList<CarModel> viewCarWithBill(int idBill) {
		Connection conn = MyDB.getConnection();
		
		String viewQuery = "SELECT id, model, mauxe, thuonghieu, loai, phankhoi, xuatxu, xe.gia FROM xe INNER JOIN billdetail ON xe.id = billdetail.idxe INNER JOIN bill on billdetail.idbill = bill.idbill WHERE bill.idbill = ?; ";
		try {
			PreparedStatement pStatement = conn.prepareStatement(viewQuery);
			pStatement.setInt(1, idBill);
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
				newCar.setGiaXe(resultSet.getInt(8));
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

