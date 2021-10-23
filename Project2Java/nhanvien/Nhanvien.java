package nhanvien;
import java.io.*;
import java.util.Scanner;
public class Nhanvien {
//field
	protected String sName;
	protected String sCMND;
	protected double dLuongCB;
//Properties
	//set
	public void setName(String name)
	{
		this.sName=name;
	}
	public void setCMND(String cmnd)
	{
		this.sCMND=cmnd;
	}
	public void setLuongCB(double luongcb)
	{
		this.dLuongCB=luongcb;
	}
	//set
	public String getName()
	{
		return this.sName;
	}
	public String getCMND()
	{
		return this.sCMND;
	}
	public double getLuongCB()
	{
		return this.dLuongCB;
	}
//constructor
	public Nhanvien()
	{
		super();
	}
	public Nhanvien(String name, String cmnd, double luongcb)
	{
		super();
		setName(name);
		setCMND(cmnd);
		setLuongCB(luongcb);
	}
//method
	public void Nhap(Scanner sc) throws UnsupportedEncodingException, IOException
	{
		while (true)
		try {
			System.out.print("Nhập họ tên: ");
			sc.nextLine();
			setName(sc.nextLine());
			System.out.print("Nhập CMND: ");
			setCMND(sc.nextLine());
			System.out.print("Nhập Lương: ");
			setLuongCB(sc.nextDouble());
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
		System.out.println("Họ tên: " + getName());
		System.out.println("CMND: " + getCMND());
		System.out.printf("Lương cơ bản: %.0f",getLuongCB());
		System.out.println();
	}
	public double Salary()
	{
		return 0;
	}
}
