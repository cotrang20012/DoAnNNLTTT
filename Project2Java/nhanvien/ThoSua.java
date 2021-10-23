package nhanvien;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class ThoSua extends Nhanvien {
//field
	private int iKPI;
//Properties
	public int getKPI() {
		return iKPI;
	}
	public void setKPI(int iKPI) {
		this.iKPI = iKPI;
	}
//constructor
	public ThoSua()
	{
		super();
	}
	public ThoSua(String name,String cmnd, double luongcb,int kpi)
	{
		super(name,cmnd,luongcb);
		setKPI(kpi);
	}
//method
	public void Nhap(Scanner sc) throws UnsupportedEncodingException, IOException
	{
		while (true)
		try {
			super.Nhap(sc);
			System.out.print("Nhập số xe sửa được: ");
			setKPI(sc.nextInt());
			break;
		}
		catch (Exception e)
		{
			System.out.println("Error!");
			System.out.println("Nhập lại");
			sc.nextLine();
		}
	}
	public void Xuat() throws IOException
	{
		System.out.println("Thợ sửa xe: ");
		super.Xuat();
		System.out.println("KPI: " + getKPI());
		System.out.printf("Salary: %.0f",Salary());
		System.in.read();
	}
	public double Salary()
	{
		return getLuongCB() + getKPI()*100000;
	}
}
