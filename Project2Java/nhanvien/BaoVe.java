package nhanvien;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class BaoVe extends Nhanvien {
//Field
	private int iOvertime;
//Properties
	public int getOvertime() {
		return iOvertime;
	}
	public void setOvertime(int iOvertime) {
		this.iOvertime = iOvertime;
	}
//Constructor
	public BaoVe()
	{
		super();
	}
	public BaoVe(String name,String cmnd, double luongcb,int overtime)
	{
		super(name,cmnd,luongcb);
		setOvertime(overtime);
	}
//Method
	public void Nhap(Scanner sc) throws UnsupportedEncodingException, IOException
	{
		while (true)
		try {
			super.Nhap(sc);
			System.out.print("Nhập số ca làm thêm: ");
			setOvertime(sc.nextInt());
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
		System.out.println("Bảo vệ: ");
		super.Xuat();
		System.out.println("Ca làm thêm: " + getOvertime());
		System.out.printf("Salary: %.0f",Salary());
		System.in.read();
	}
	public double Salary()
	{
		return getLuongCB() + getOvertime()*185000;
	}
	
}
