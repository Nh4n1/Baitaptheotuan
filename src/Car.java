import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class Car {
	public ArrayList<String> DsVao = new ArrayList<String>();
	public ArrayList<String> DsRa = new ArrayList<String>();
	public ArrayList<String> DsCuoi = new ArrayList<String>();

	public void LayDanhSach1() {
		try {
			FileInputStream f = new FileInputStream("input1.txt");
			InputStreamReader ir = new InputStreamReader(f);
			BufferedReader r = new BufferedReader(ir);
			while (true) {
				String st = r.readLine();
				if (st == "" || st == null)
					break;
				DsVao.add(st);

			}
			r.close();
		} catch (Exception tt) {
			System.out.println("Loi o ham XuatDanhSach");
		}
	}

	public void LayDanhSach2() {
		try {
			FileInputStream f = new FileInputStream("input2.txt");
			InputStreamReader ir = new InputStreamReader(f);
			BufferedReader r = new BufferedReader(ir);
			while (true) {
				String st = r.readLine();
				if (st == "" || st == null)
					break;
				DsRa.add(st);

			}
			r.close();
		} catch (Exception tt) {
			System.out.println("Loi o ham XuatDanhSach");
		}
	}

	public void xuatDs1() {
//		for(String s:DsVao) {
//			System.out.println(s);
//		}
		for (int i = 0; i < DsVao.size(); i++) {
			System.out.println(DsVao.get(i).split("[;]")[3]);
		}
	}

	public void xuatDs2() {
		for (String s : DsRa) {
			System.out.println(s);
		}
	}

	public int getDay(int i) {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("H:mm dd/MM/yyyy");
		String t1 = DsVao.get(i).split("[;]")[3];
		String t2 = DsRa.get(i).split("[;]")[3];

		int d = 0;
		LocalDateTime time1 = LocalDateTime.parse(t1, f);
		LocalDateTime time2 = LocalDateTime.parse(t2, f);

		Duration duration = Duration.between(time1, time2);

		long days = duration.toDays();
		long hours = duration.toHours() % 24;
		long minutes = duration.toMinutes() % 60;

		d += days;
		long tmp = hours * 60 + minutes;
		if (tmp > 0) {
			d++;
		}

		return (int) d;

	}

	public int getMoneyHours(int i) {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("H:mm dd/MM/yyyy");
		String t1 = DsVao.get(i).split("[;]")[3];
		String t2 = DsRa.get(i).split("[;]")[3];

		long m = 0;
		long h = 0;
		LocalDateTime time1 = LocalDateTime.parse(t1, f);
		LocalDateTime time2 = LocalDateTime.parse(t2, f);

		Duration duration = Duration.between(time1, time2);

		long hours = duration.toHours() % 24;
		long minutes = duration.toMinutes() % 60;
		System.out.println(hours + " " + minutes);
		m = hours * 60 + minutes;
		h += m / 30;
		if (m % 30 > 0) {
			h++;
		}

		return (int) h;
		
		
		

	}

	public void XuatThongTin() {
		for (int i = 0; i < DsVao.size(); i++) {
			String[] ds1 = DsVao.get(i).split("[;]");
			String[] ds2 = DsRa.get(i).split("[;]");
			int tien = 0;
			int scale = 0;
			if (ds1[0].equals("4")) {
				scale = 5000;
				tien = getMoneyHours(i) * scale;

			} else if (ds1[0].equals("2")) {
				scale = 3000;
				tien = getDay(i) * scale;
			} else {
				scale = 1000;
				tien =getDay(i)*scale;
			}
			String fin=ds1[0]+";"+ds1[1]+";"+ds1[2]+";"+ds1[3]+";"+ds2[3]+";"+tien;
			DsCuoi.add(fin);
		}
		try {
			FileOutputStream f = new FileOutputStream("output.txt");
			OutputStreamWriter o = new OutputStreamWriter(f);
			PrintWriter w = new PrintWriter(o);

			for (int i = 0; i <DsCuoi.size(); i++) {
//				w.println("Sv" + i + ";" + m.TaoHoTen() + ";" + m.TaoNgay("01/01/1960", "01/01/2000") + ";" + dtb);
				w.println(DsCuoi.get(i));
			}
			w.close();
			System.out.println("Da tao xong");
		} catch (Exception tt) {
			System.out.println("Loi o ham XuatDanhSach" + tt.getMessage());
		}
	}
}
