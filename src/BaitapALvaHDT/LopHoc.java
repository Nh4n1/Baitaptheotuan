package BaitapALvaHDT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class LopHoc {
	public static ArrayList<Object> ds1 = new ArrayList<Object>();

	public void TaoLop(String tf) {
		try {// Mở file
			FileInputStream fr = new FileInputStream(tf);
			InputStreamReader ir = new InputStreamReader(fr);
			BufferedReader br = new BufferedReader(ir);
			while (true) {
				String st = br.readLine();// Đọc 1 dòng
				if (st == null || st == "")
					break;
				String[] t = st.split("[|]");
				if (t.length == 4) {// nếu sv Khoa CNtt
					SvCntt sv = new SvCntt();// Tạo ra 1 sv
					sv.setMaSv(t[0]);
					sv.setHoTen(t[1]);
					sv.setDm1(Double.parseDouble(t[2]));
					sv.setDm2(Double.parseDouble(t[3]));
					
					ds1.add(sv);// Lưu vào mảng
				}
				if (t.length == 5) {// nếu sv Khoa Toan
					SvToan sv = new SvToan();
					sv.setMaSv(t[0]);
					sv.setHoTen(t[1]);
					sv.setDm1(Double.parseDouble(t[2]));
					sv.setDm2(Double.parseDouble(t[3]));
					sv.setDm3(Double.parseDouble(t[4]));
					ds1.add(sv);// Lưu vào mảng
				}
				if (t.length == 6) {/// nếu sv Khoa Ly
					SvLy sv = new SvLy();
					sv.setMaSv(t[0]);
					sv.setHoTen(t[1]);
					sv.setDm1(Double.parseDouble(t[2]));
					sv.setDm2(Double.parseDouble(t[3]));
					sv.setDm3(Double.parseDouble(t[4]));
					sv.setDm4(Double.parseDouble(t[5]));
					ds1.add(sv);// Lưu vào mảng
				}
			}
			br.close();// Đóng file
		} catch (Exception ttt) {
			System.out.print(ttt);
		}
	}

	public void HienThi() {
		System.out.println("Danh sach sv Khoa CNTT");
		for (Object sv : ds1) {// Duyệt qua tất cả các sinh viên
			if (sv instanceof SvCntt) {
				SvCntt sv1 = (SvCntt) sv;
				sv1.HienThi();
			}
		}
		System.out.println("Danh sach sv Khoa Toan");
		for (Object sv : ds1) {
			if (sv instanceof SvToan) {
				SvToan sv1 = (SvToan) sv;
				sv1.HienThi();
			}
		}
		System.out.println("Danh sach sv Khoa Ly");
		for (Object sv : ds1) {
			if (sv instanceof SvLy) {
				SvLy sv1 = (SvLy) sv;
				sv1.HienThi();
			}
		}

	}

	public void HienThiSvTheoKhoa(String khoa) {
		if(khoa.equals("CNTT")) {
			System.out.println("Danh sach sv Khoa CNTT");
			for (Object sv : ds1) {// Duyệt qua tất cả các sinh viên
				if (sv instanceof SvCntt) {
					SvCntt sv1 = (SvCntt) sv;
					sv1.HienThi();
				}
			}
		}
		if (khoa.equals("Toan")) {
			System.out.println("Danh sach sv Khoa Toan");
			for (Object sv : ds1) {
				if (sv instanceof SvToan) {
					SvToan sv1 = (SvToan) sv;
					sv1.HienThi();
				}
			}
		}
		if (khoa.equals("Ly")) {
			System.out.println("Danh sach sv Khoa Ly");
			for (Object sv : ds1) {
				if (sv instanceof SvLy) {
					SvLy sv1 = (SvLy) sv;
					sv1.HienThi();
				}
			}
		}
		
		
	}
	


	public void LuuThongTinTungKhoa() {
		try {
			FileWriter fw = new FileWriter("src/dataSource/f1.txt");
			FileWriter fw1 = new FileWriter("src/dataSource/f2.txt");
			FileWriter fw2 = new FileWriter("src/dataSource/f3.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			BufferedWriter bw1 = new BufferedWriter(fw1);
			BufferedWriter bw2 = new BufferedWriter(fw2);
			for (Object sv : ds1) {
				if (sv instanceof SvCntt) {
					SvCntt sv1 = (SvCntt) sv;
					bw.write(sv1.getThongTin() + "\n");
					
				}
			}
			for (Object sv : ds1) {
				if (sv instanceof SvToan) {
					SvToan sv1 = (SvToan) sv;
					bw1.write(sv1.getThongTin() + "\n");
				}
			}
			for (Object sv : ds1) {
				if (sv instanceof SvLy) {
					SvLy sv1 = (SvLy) sv;
					bw2.write(sv1.getThongTin()+ "\n");
				}
			}
			bw.close();
			bw1.close();
			bw2.close();
			
		} catch (Exception tt) {
			System.out.println("Loi ghi file");
		}
	}
	
	public void timKiem(String name,String khoa) {
		if (khoa.toUpperCase().equals("CNTT")) {
			for (Object sv : ds1) {
				if (sv instanceof SvCntt) {
					SvCntt sv1 = (SvCntt) sv;
					if (sv1.getHoTen().toLowerCase().contains(name.toLowerCase())) {
						sv1.HienThi();
					}
				}
			}
		}
		if (khoa.toUpperCase().equals("Toan")) {
			for (Object sv : ds1) {
				if (sv instanceof SvToan) {
					SvToan sv1 = (SvToan) sv;
					if (sv1.getHoTen().toLowerCase().contains(name.toLowerCase())) {
						sv1.HienThi();
					}
				}
			}
		}
		if (khoa.toUpperCase().equals("Ly")) {
			for (Object sv : ds1) {
				if (sv instanceof SvLy) {
					SvLy sv1 = (SvLy) sv;
					if (sv1.getHoTen().toLowerCase().contains(name.toLowerCase())) {
						sv1.HienThi();
					}
				}
			}
		}
		
	}

	public static void main(String[] args) {
		LopHoc lh = new LopHoc();
		lh.TaoLop("src/dataSource/sv.txt");
		lh.HienThi();
		lh.LuuThongTinTungKhoa();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ten");
		String name = sc.nextLine();
		System.out.println("Nhap khoa");
		String khoa = sc.nextLine();
		
		lh.timKiem(name, khoa);
	}


}
