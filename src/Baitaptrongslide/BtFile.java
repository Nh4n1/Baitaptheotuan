package Baitaptrongslide;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class BtFile {
	public void TaoDanhSach(int n) {
		try {
			FileOutputStream f = new FileOutputStream("sv.txt");
			OutputStreamWriter o = new OutputStreamWriter(f);
			PrintWriter w = new PrintWriter(o);

			Random r = new Random();
			BtMang m = new BtMang();
			for (int i = 1; i <= n; i++) {
				double dtb = m.TaoDiem();
				w.println("Sv" + i + ";" + m.TaoHoTen() + ";" + m.TaoNgay("01/01/1960", "01/01/2000") + ";" + dtb);

			}
			w.close();
			System.out.println("Da tao xong");
		} catch (Exception tt) {
			System.out.println("Loi o ham TaoDanhSach" + tt.getMessage());
		}
	}

	public void XuatDanhSach() {
		try {
			FileInputStream f = new FileInputStream("sv.txt");
			InputStreamReader ir = new InputStreamReader(f);
			BufferedReader r = new BufferedReader(ir);
			while (true) {
				String st = r.readLine();
				if (st == "" || st == null)
					break;
				String[] ds = st.split("[;]");
				System.out.println(ds[0] + "\n" + ds[1] + "\n" + ds[2] + "\n" + ds[3] + "\n\n");

			}
			r.close();
		} catch (Exception tt) {
			System.out.println("Loi o ham XuatDanhSach");
		}
	}

	public void SimpleFind(String name) {
		try {
			FileInputStream f = new FileInputStream("sv.txt");
			InputStreamReader ir = new InputStreamReader(f);
			BufferedReader r = new BufferedReader(ir);
			Boolean flag=false;
			while (true) {
				String st = r.readLine();
				if (st == "" || st == null)
					break;
				String[] ds = st.split("[;]");
				if (ds[1].equals(name)) {
					flag=true;
					System.out.println(ds[0] + "\n" + ds[1] + "\n" + ds[2] + "\n" + ds[3] + "\n\n");
				}

			}
			if(!flag) {
				System.out.println("Khong tim thay");
			}
			r.close();
		} catch (Exception tt) {
			System.out.println("Loi o ham Tim Kiem");
		}
	}

	public void Count() {
		try {
			FileInputStream f= new FileInputStream("sv.txt");
			InputStreamReader ir= new InputStreamReader(f);
			BufferedReader r = new BufferedReader(ir);
			int cnt1=0;
			int cnt2=0;
			while(true) {
				String st=r.readLine();
				if(st==""||st==null) break;
				String[] ds= st.split("[;]");
				System.out.println(ds[0]+"\n"+ds[1]+"\n"+ds[2]+"\n"+ds[3]+"\n\n");
				if(Double.parseDouble(ds[3])>=5) {
					cnt1++;
				}
				else cnt2++;
			}
			
			System.out.println("Hs dau: "+cnt1);
			System.out.println("Hs rot: "+cnt2);
			
			r.close();
		}
		catch(Exception tt) {
			System.out.println("Loi o ham Count");
		}
	}

	
	public double CalcAverage() {
		double sum=0;
		int n=0;
		try {
			FileInputStream f= new FileInputStream("sv.txt");
			InputStreamReader ir= new InputStreamReader(f);
			BufferedReader r = new BufferedReader(ir);
			while(true) {
				String st=r.readLine();
				if(st==""||st==null) break;
				String[] ds= st.split("[;]");
				sum+=Double.parseDouble(ds[3]);
				n++;
			}
		
			
			r.close();

		}
		catch(Exception tt){
			System.out.println("Loi o ham CalcAverage");

		}
		double ans=sum/n;
		
		return ans;
		
		
	}
	public boolean isDate(String date) {
		 if (date.length() != 10) return false; // Must be exactly 10 characters (dd/MM/yyyy)

	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	        sdf.setLenient(false); // Ensure strict date parsing
	        try {
	            sdf.parse(date);
	            return true;
	        } catch (ParseException e) {
	            return false;
	        }
	}
	public boolean isScore(String d) {
		double diem=Double.parseDouble(d);
		return diem>=0&&diem<=10;
	}
	public void checkValid() {
		try {
			FileInputStream f= new FileInputStream("sv.txt");
			InputStreamReader ir= new InputStreamReader(f);
			BufferedReader r = new BufferedReader(ir);
			while(true) {
				String st=r.readLine();
				if(st==""||st==null) break;
				String[] ds= st.split("[;]");
				if(!isDate(ds[2])) {
					System.out.println(ds[2]+"\n");
				}
				else if(!isScore(ds[3])) {
					System.out.println(ds[3]+"\n");
				}
				
			}
			r.close();
		}
		catch(Exception tt) {
			System.out.println("Loi o ham XuatDanhSach");
		}
	}

}

