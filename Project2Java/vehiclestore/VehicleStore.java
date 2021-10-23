package vehiclestore;

import vehicle.*;
import nhanvien.*;
import java.util.ArrayList;
import java.util.List;
public class VehicleStore {
		static public List<Xe> listX2B = new ArrayList<Xe>();
		static public List<Xe> listX4B = new ArrayList<Xe>();
		static public List<Xe> listXe = new ArrayList<Xe>();
		static public List<Nhanvien> listNV = new ArrayList<Nhanvien>();
		static public double TinhTongGiaTriKhoHang(List<Xe> ListTV)
		{
			double s=0;
			for (Xe obj : ListTV)
			{
				s += obj.SellPrice();
			}
			return s;
		}
	}