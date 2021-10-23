package nhanvien;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Sale extends Nhanvien {
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
	public Sale()
	{
		super();
	}
	public Sale(String name, String cmnd, double luongcb,int kpi)
	{
		super(name,cmnd,luongcb);
		setKPI(kpi);
	}
//method
	public void Xuat() throws IOException
	{
		System.out.println("Sale: ");
		super.Xuat();
		System.out.println("KPI: " + getKPI());
		System.out.printf("Salary: %.0f",Salary());
		System.in.read();
	}
	public void Nhap(Scanner sc) throws UnsupportedEncodingException, IOException
	{
		while (true)
		try {
			super.Nhap(sc);
			System.out.print("Nhập số xe bán được: ");
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
	public double Salary()
	{
		return getLuongCB() + getKPI()*500000;
	}
}
