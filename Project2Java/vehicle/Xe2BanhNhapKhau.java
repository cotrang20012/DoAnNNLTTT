package vehicle;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Xe2BanhNhapKhau extends Xe {
//field
//Properties
//constructor
	public Xe2BanhNhapKhau(String model,String brand, double cc,double price,String origin)
	{
		super(model,brand,cc,price);
		setOrigin(origin);
		setType("Xe máy");
	}
	public Xe2BanhNhapKhau()
	{
		super();
		setType("Xe máy");
	}
//method
	public double SellPrice()
	{
		double tax=getPrice()*0.35;
		if (getCC() > 175) tax += getPrice()*0.2;
		return getPrice() + tax;
	}
	public void Xuat() throws IOException 
	{
		super.Xuat();
		System.out.printf("Sell Price: %.0f",SellPrice());
		System.in.read();
	}
	public void Nhap(Scanner sc) throws UnsupportedEncodingException, IOException
	{
		while (true)
		try {
			super.Nhap(sc);
			System.out.print("Nhập xuất xứ: ");
			sc.nextLine();
			setOrigin(sc.nextLine());
			break;
		}
		catch (Exception e)
		{
			System.out.println("Error!");
			System.out.println("Nhập lại");
			sc.nextLine();
		}
	}
}
