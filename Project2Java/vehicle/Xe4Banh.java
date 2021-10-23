package vehicle;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Xe4Banh extends Xe {
//field
	private int iChair;
//Properties
	public int getChair() {
		return iChair;
	}
	public void setChair(int iChair) {
		this.iChair = iChair;
	}
//constructor
	public Xe4Banh(String model,String brand, double cc,double price,int chair)
	{
		super(model,brand,cc,price);
		setChair(chair);
		setOrigin("VN");
		setType("Oto");
	}
	public Xe4Banh()
	{
		super();
		setOrigin("VN");
		setType("Oto");
	}	
//method
	public double SellPrice()
	{
		double tax=0;
		if (getCC() > 1500) tax += getPrice()*0.5;
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
