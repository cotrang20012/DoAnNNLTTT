package model;

public class NhanVien {
	private int id;
	private String cmnd;
	private String ten;
	private String diachi;
	private String chucvu;
	private String sdt;
	private int luong;
	public NhanVien() {
		
	}
	public NhanVien(int id,String cmnd, String ten,String diachi,String chucvu,String sdt,int luong) {
		this.id = id;
		this.cmnd = cmnd;
		this.ten = ten;
		this.diachi = diachi;
		this.chucvu = chucvu;
		this.sdt =sdt;
		this.luong=luong;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getChucvu() {
		return chucvu;
	}
	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public int getLuong() {
		return luong;
	}
	public void setLuong(int luong) {
		this.luong = luong;
	}
	
}
