package vehicle;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Xe2Banh extends Xe {
//field
//Properties
//constructor
	public Xe2Banh(String model,String brand, double cc,double price)
	{
		super(model,brand,cc,price);
		setOrigin("VN");
		setType("Xe máy");
	}
	public Xe2Banh()
	{
		super();
		setOrigin("VN");
		setType("Xe máy");
	}
//method
	public double SellPrice()
	{
		double tax=0;
		if (getCC() > 175) tax = getPrice()*0.2;
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
		super.Nhap(sc);
	}
}
