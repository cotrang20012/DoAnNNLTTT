package vehiclestore;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import vehicle.*;
import nhanvien.*;

class Sortbysalary implements Comparator<Nhanvien> 
{
    public int compare(Nhanvien a, Nhanvien b) 
    { 
    	if (a.Salary()>b.Salary()) return 1;
    	return -1;
    } 
} 
class Sortbyprice implements Comparator<Xe> 
{
    public int compare(Xe a, Xe b) 
    { 
    	if (a.getPrice()>b.getPrice()) return 1;
    	return -1;
    } 
} 
public class menu {
	private static void Cls() throws InterruptedException, IOException
	{
		for (int i=0;i<13;i++)
			System.out.println();
	}
	public static int Run(Scanner sc) throws IOException, InterruptedException
	{
		int choose=1;
		while (choose!=0)
			try
			{
				menu.Cls();
				System.out.println("1. Thêm");
				System.out.println("2. Xuất");
				System.out.println("3. Tìm kiếm xe theo model");
				System.out.println("4. Tìm kiếm nhân viên theo tên");
				System.out.println("5. Sắp xếp danh sách xe theo giá tiền");
				System.out.println("6. Sắp xếp nhân viên theo lương");
				System.out.println("7. Danh sách xe 2 bánh đang bán");
				System.out.println("8. Danh sách xe 4 bánh đang bán");
				System.out.println("0. Thoát");
				System.out.println("Danh sách xe đang bán");
				menu.Table();
				menu.TableNV();
				System.out.println("");
				System.out.print("Lựa chọn: ");
				choose=sc.nextInt();
				if (choose <0 || choose > 8) throw new Exception("Error");
				switch (choose)
				{
					case 1:
						Them(sc);
						break;
					case 2:
						Xuat(sc);
						break;
					case 3:
						TimKiemXe(sc);
						break;
					case 4:
						TimKiemNhanVien(sc);
						break;
					case 5:
						Collections.sort(VehicleStore.listXe,new Sortbyprice());
						break;
					case 6:
						Collections.sort(VehicleStore.listNV,new Sortbysalary());
						break;
					case 7:
						DanhSachXe(sc,VehicleStore.listX2B);
						break;
					case 8:
						DanhSachXe(sc,VehicleStore.listX4B);
						break;
					case 0:
						return 0;
				}
			}
		catch (Exception e)
		{
			System.out.println("Nhập lại");
			sc.nextLine();
			sc.nextLine();
		}
		return 0;
	}
	public static void Them(Scanner sc)
	{
		  int choose;
          try
          {
        	  System.out.println("1.Xe");
        	  System.out.println("2.Nhân viên");
        	  System.out.print("Lựa chọn = ");
              choose=sc.nextInt();
              switch (choose)
              {
                  case 1:
                      int choose1;
                      System.out.println("1.Xe 2 bánh ");
                      System.out.println("2.Xe 2 bánh nhập khẩu");
                      System.out.println("3.Xe 4 bánh");
                      System.out.println("4.Xe 4 bánh nhập khẩu");
                      System.out.print("Lựa chọn = ");
                      choose1=sc.nextInt();
                      switch (choose1)
                      {
                          case 1:
                              Xe2Banh newX2B = new Xe2Banh();
                              newX2B.Nhap(sc);
                              VehicleStore.listXe.add(newX2B);
                              VehicleStore.listX2B.add(newX2B);
                              break;
                          case 2:
                              Xe2BanhNhapKhau newX2BNK = new Xe2BanhNhapKhau();
                              newX2BNK.Nhap(sc);
                              VehicleStore.listXe.add(newX2BNK);
                              VehicleStore.listX2B.add(newX2BNK);
                              break;
                          case 3:
                              Xe4Banh newX4B = new Xe4Banh();
                              newX4B.Nhap(sc);
                              VehicleStore.listXe.add(newX4B);
                              VehicleStore.listX4B.add(newX4B);
                              break;
                          case 4:
                              Xe4BanhNhapKhau newX4BNK = new Xe4BanhNhapKhau();
                              newX4BNK.Nhap(sc);
                              VehicleStore.listXe.add(newX4BNK);
                              VehicleStore.listX2B.add(newX4BNK);
                              break;
                      }
                      break;
                  case 2:
                      int choose2;
                      System.out.println("1.Sale");
                      System.out.println("2.Bảo vệ");
                      System.out.println("3.Thợ sửa xe");
                      System.out.print("Lựa chọn = ");
                      choose2=sc.nextInt();
                      switch(choose2)
                      {
                          case 1:
                              Sale newSale = new Sale();
                              newSale.Nhap(sc);
                              VehicleStore.listNV.add(newSale);
                              break;
                          case 2:
                              BaoVe newBaoVe = new BaoVe();
                              newBaoVe.Nhap(sc);
                              VehicleStore.listNV.add(newBaoVe);
                              break;
                          case 3:
                              ThoSua newThoSuaXe = new ThoSua();
                              newThoSuaXe.Nhap(sc);
                              VehicleStore.listNV.add(newThoSuaXe);
                              break;
                      }
                      break;
              }
          }
          catch (Exception e)
          {
        	  System.out.println("Nhập sai, vui lòng thử lại!!!");
              Them(sc);
          }
      }
	public static void Xuat(Scanner sc) throws IOException
	{
		int choose;
		System.out.println("1.Xuất thông tin nhân viên");
		System.out.println("2.Xuất thông tin xe");
		System.out.print("Lựa chon = ");
        choose = sc.nextInt();
        switch (choose)
        {
            case 1:
                int choose2;
                System.out.println("ID nhân viên cần xuất thông tin = ");
                choose2 = sc.nextInt();
                VehicleStore.listNV.get(choose2-1).Xuat();
                break;
            case 2:
                int choose3;
                System.out.println("ID xe cần xuất thông tin = ");
                choose3 = sc.nextInt();
                VehicleStore.listXe.get(choose3 - 1).Xuat();
                break;
        }
	}
	public static void TimKiemXe(Scanner sc) throws IOException
    {
        String FindModel;
        System.out.print("Nhập mẫu xe cần tìm = ");
        FindModel = sc.next();
        int found =0;
        for (Xe obj : VehicleStore.listXe)
        	if (obj.getModel().toLowerCase().contains(FindModel.toLowerCase())) 
        	{
        		obj.Xuat();
        		found++;
        		System.out.println();
        	}
        if (found == 0) System.out.print("Không tìm thấy mẫu xe cần tìm");
        System.in.read();
    }
	public static void TimKiemNhanVien(Scanner sc) throws IOException
    {
        String FindName;
        int found = 0;
        System.out.print("Nhập họ tên nhân viên cần tìm = ");
        FindName=sc.next();
        System.out.println(FindName);
        for(Nhanvien obj : VehicleStore.listNV)
        {
            if(obj.getName().toLowerCase().contains(FindName.toLowerCase()))
            {
                obj.Xuat();
                System.out.println();
                found++;
            }
        }
        if(found == 0)
        {
        	System.out.println("Không tìm thấy nhân viên cần tìm");
        }
        System.in.read();
    }
	public static void Table()
    {
        char c = '║';
        System.out.print("╔══╦");
        for (int i = 0; i < 12; i++) System.out.print('═');
        System.out.print('╦');
        for (int i = 0; i < 20; i++) System.out.print('═');
        System.out.print('╦');
        for (int i = 0; i < 15; i++) System.out.print('═');
        System.out.println('╗');
        System.out.println(c + "ID" + c + " THƯƠNG HIỆU" + c + "\tMẪU XE\t     " + c + "   GIÁ TIỀN    " + c);
        System.out.print("╠══╬");
        for (int i = 0; i < 12; i++) System.out.print('═');
        System.out.print('╬');
        for (int i = 0; i < 20; i++) System.out.print('═');
        System.out.print('╬');
        for (int i = 0; i < 15; i++) System.out.print('═');
        System.out.println('╣');
        for (int i = 0; i < VehicleStore.listXe.size(); i++)
        {
        	System.out.printf(c+"%2d"+c,i+1);
        	System.out.printf(" %-11s"+c,VehicleStore.listXe.get(i).getBrand());
        	System.out.printf(" %-19s"+c,VehicleStore.listXe.get(i).getModel());
        	System.out.printf(" %14.0f"+c,VehicleStore.listXe.get(i).SellPrice());
        	System.out.println();
        }
        System.out.print("╠══╩");
        for (int i = 0; i < 12; i++) System.out.print('═');
        System.out.print('╩');
        for (int i = 0; i < 20; i++) System.out.print('═');
        System.out.print('╬');
        for (int i = 0; i < 15; i++) System.out.print('═');
        System.out.println('╣');
        System.out.printf(c + "\t\tTỔNG TIỀN\t     " + c +" %14.0f" + c,VehicleStore.TinhTongGiaTriKhoHang(VehicleStore.listXe));
        System.out.println();
        System.out.print("╚");
        for (int i = 0; i < 36; i++) System.out.print('═');
        System.out.print('╩');
        for (int i = 0; i < 15; i++) System.out.print('═');
        System.out.println('╝');
    }
    public static void Table2(List<Xe> lXTV)
    {
        char c = '║';
        System.out.print("╔══╦");
        for (int i = 0; i < 12; i++) System.out.print('═');
        System.out.print('╦');
        for (int i = 0; i < 20; i++) System.out.print('═');
        System.out.print('╦');
        for (int i = 0; i < 15; i++) System.out.print('═');
        System.out.println('╗');
        System.out.println(c + "ID" + c + " THƯƠNG HIỆU" + c + "\tMẪU XE\t     " + c + "   GIÁ TIỀN    " + c);
        System.out.print("╠══╬");
        for (int i = 0; i < 12; i++) System.out.print('═');
        System.out.print('╬');
        for (int i = 0; i < 20; i++) System.out.print('═');
        System.out.print('╬');
        for (int i = 0; i < 15; i++) System.out.print('═');
        System.out.println('╣');
        for (int i = 0; i < lXTV.size(); i++)
        {
        	System.out.printf(c+"%2d"+c,i+1);
        	System.out.printf(" %-11s"+c,lXTV.get(i).getBrand());
        	System.out.printf(" %-19s"+c,lXTV.get(i).getModel());
        	System.out.printf(" %14.0f"+c,lXTV.get(i).SellPrice());
        	System.out.println();
        }
        System.out.print("╠══╩");
        for (int i = 0; i < 12; i++) System.out.print('═');
        System.out.print('╩');
        for (int i = 0; i < 20; i++) System.out.print('═');
        System.out.print('╬');
        for (int i = 0; i < 15; i++) System.out.print('═');
        System.out.println('╣');
        System.out.printf(c + "\t\tTỔNG TIỀN\t     " + c +" %14.0f" + c,VehicleStore.TinhTongGiaTriKhoHang(lXTV));
        System.out.println();
        System.out.print("╚");
        for (int i = 0; i < 36; i++) System.out.print('═');
        System.out.print('╩');
        for (int i = 0; i < 15; i++) System.out.print('═');
        System.out.println('╝');
    }
    public static void TableNV()
    {
        char c = '║';
        System.out.println("Danh sách nhân viên");
        System.out.print("╔══╦");

        for (int i = 0; i < 20; i++) System.out.print('═');
        System.out.print('╦');
        for (int i = 0; i < 15; i++) System.out.print('═');
        System.out.println('╗');
        System.out.println(c + "ID" + c + "       HỌ TÊN       " + c + "     LƯƠNG     " + c);
        System.out.print("╠══╬");
        for (int i = 0; i < 20; i++) System.out.print('═');
        System.out.print('╬');
        for (int i = 0; i < 15; i++) System.out.print('═');
        System.out.println('╣');
        for (int i = 0; i < VehicleStore.listNV.size(); i++)
        {
            System.out.printf(c+"%2d" + c,i+1);
            System.out.printf(" %-19s" + c,VehicleStore.listNV.get(i).getName());
            System.out.printf(" %14.0f" + c,VehicleStore.listNV.get(i).Salary());
            System.out.println();
        }
        System.out.print("╚══╩");
        for (int i = 0; i < 20; i++) System.out.print('═');
        System.out.print('╩');
        for (int i = 0; i < 15; i++) System.out.print('═');
        System.out.println('╝');    
    }
    public static void DanhSachXe(Scanner sc,List<Xe> listTV)
    {
        int choose;
        while (true)
        try
        {
        	menu.Cls();
        	System.out.println("1. Xuất");
            System.out.println("0. Thoát");
            Table2(listTV);
            System.out.print("Lựa chọn : ");
        	choose = sc.nextInt();
        	switch(choose)
        	{
        		case 1:
        			System.out.print("Nhập ID xe 2 bánh cần xuất thông tin = ");
        			int index = sc.nextInt();
        			listTV.get(index-1).Xuat();
        			sc.next();
        			break;
        		case 0:
        			break;
        	}
        	break;
        }
        catch (Exception e)
        {
        	System.out.println("Nhập lại");
        }
    }
    public static void DefaultData()
    {
        Xe2Banh X2B1 = new Xe2Banh("Winner X", "Honda", 150, 41000000);
        Xe2BanhNhapKhau X2BNK1 = new Xe2BanhNhapKhau("Ninja ZX10-RR", "Kawasaki",1000, 500000000, "NHẬT BẢN");
        Xe4Banh X4B1 = new Xe4Banh("Fadil", "Vinfast", 1400, 300000000,4);
        Xe4BanhNhapKhau X4BNK1 = new Xe4BanhNhapKhau("Santafe", "Huyndai", 2000, 650000000, 7,"HÀN QUỐC");
        VehicleStore.listXe.add(X4B1);  VehicleStore.listXe.add(X2B1);  VehicleStore.listXe.add(X4BNK1);  VehicleStore.listXe.add(X2BNK1);
        VehicleStore.listX2B.add(X2BNK1);VehicleStore.listX2B.add(X2B1);
        VehicleStore.listX4B.add(X4B1);VehicleStore.listX4B.add(X4BNK1);
        Sale nvSale1 = new Sale("Nguyễn Duy Cương", "0138998780", 7000000, 5);
        BaoVe nvBaoVe1 = new BaoVe("Trần Văn Lâm", "0132498579", 6000000, 2);
        ThoSua nvThoSuaXe1 = new ThoSua("Đặng Văn Thiệu", "0132958491", 6200000, 15);
        VehicleStore.listNV.add(nvSale1);VehicleStore.listNV.add(nvBaoVe1);
        VehicleStore.listNV.add(nvThoSuaXe1);
    }
}

