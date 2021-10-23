package vehicle;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Xe {
//field
	protected String sModel;
	protected String sBrand;
	protected String sType;
	protected double dCC;
	protected String sOrigin;
	protected double dPrice;
//properties
	//set
	public void setType(String type)
	{
		this.sType=type;
	}
	public void setModel(String model)
	{
		this.sModel=model;
	}
	public void setBrand(String brand)
	{
		this.sBrand=brand;
	}
	public void setCC(double cc)
	{
		this.dCC=cc;
	}
	public void setOrigin(String origin)
	{
		this.sOrigin=origin;
	}
	public void setPrice(double price)
	{
		this.dPrice=price;
	}
	//get
	public String getType()
	{
		return this.sType;
	}
	public String getModel()
	{
		return this.sModel;
	}
	public String getBrand()
	{
		return this.sBrand;
	}
	public double getCC()
	{
		return this.dCC;
	}
	public String getOrigin()
	{
		return this.sOrigin;
	}
	public double getPrice()
	{
		return this.dPrice;
	}
//constructors
	public Xe()
	{
		super();
	}
	public Xe(String model,String brand, double cc,double price)
	{
		super();
		setModel(model);
		setBrand(brand);
		setCC(cc);
		setPrice(price);
	}
//method
		public void Nhap(Scanner sc) throws UnsupportedEncodingException, IOException
		{
			while (true)
			try {
				System.out.print("Nhập Model: ");
				sc.nextLine();
				setModel(sc.nextLine());
				System.out.print("Nhập thương hiệu: ");
				setBrand(sc.nextLine());
				System.out.print("Nhập dung tích động cơ: ");
				setCC(sc.nextInt());
				System.out.print("Nhập giá: ");
				setPrice(sc.nextDouble());
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
		System.out.println("Model: " + getModel());
		System.out.println("Brand: " + getBrand());
		System.out.println("Cubic Centimetres: " + getCC());
		System.out.println("Origin: " + getOrigin());
		System.out.printf("Default Price: %.0f",getPrice());
		System.out.println();
	}
	public double SellPrice()
	{
		return 0;
	}
}
