package Baitaptrongslide;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class BtMang {

	public String TaoNgay(String ngay1, String ngay2) {
		try {
			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
			Date n1 = f.parse(ngay1);
			Date n2 = f.parse(ngay2);
			Random r = new Random();
			while (true) {
				Long t = r.nextLong();
				if (t >= n1.getTime() && t <= n2.getTime()) {
					Date n = new Date(t);
					return f.format(n);
				}
			}
		} catch (Exception tt) {
			System.out.println("Loi: " + tt.getMessage());
			return null;
		}
	}

	public String TaoHoTen() {
		String[] ho = { "Tran", "Le", "Nguyen" };
		String[] chulot = { "Thanh", "Hoang", "Trung", "Van", "My" };
		String[] ten = { "Hung", "Nga", "Tien", "Tam", "Ton", "Giang", "Sy" };
		Random r = new Random();
		String h = ho[r.nextInt(ho.length)];
		String cl = chulot[r.nextInt(chulot.length)];
		String t = ten[r.nextInt(ten.length)];
		return h + " " + cl + " " + t;
	}

	public String TaoGioiTinh() {
		String[] gioitinh = { "Nam", "Nu" };
		Random r = new Random();
		String gt = gioitinh[r.nextInt(gioitinh.length)];
		return gt;
	}
	
	public double TaoDiem() {
		Random r = new Random();
		double d = r.nextDouble() * 10; 
		DecimalFormat df = new DecimalFormat("#.##"); 
		String formatted = df.format(d); 
		double dtb = Double.parseDouble(formatted); //
		return dtb;
	}
	public void HienThi() {
		
		double dtb = TaoDiem();
		String kq = dtb >= 5 ? "Dau" : "Rot";
		String hl = "";
		if (dtb > 8) {
			hl = "Gioi";
		} else if (dtb > 6.5) {
			hl = "Kha";
		} else if (dtb > 5) {
			hl = "Trung binh";
		} else if (dtb > 3.1) {
			hl = "Yeu";
		} else {
			hl = "Kem";
		}
		System.out.println(TaoHoTen() + ";" + TaoNgay("01/01/1960", "01/01/2000") + ";" + TaoGioiTinh() + ";" + dtb
				+ ";" + kq + ";" + hl);

	}

}
