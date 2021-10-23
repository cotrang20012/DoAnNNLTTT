package vehicle;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Xe4BanhNhapKhau extends Xe {
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
	public Xe4BanhNhapKhau(String model,String brand, double cc,double price,int chair,String origin)
	{
		super(model,brand,cc,price);
		setChair(chair);
		setOrigin(origin);
		setType("Oto");
	}
	public Xe4BanhNhapKhau()
	{
		super();
		setType("Oto");
	}
//method
	public double SellPrice()
	{
		double tax=getPrice()*0.7;
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

