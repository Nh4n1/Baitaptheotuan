package Baitaptrongslide;
import java.util.Scanner;

public class Mang {
	public static void main(String[] args) {
//		1
//		for(int i=1;i<=10;i++) {
//			BtMang m= new BtMang();
//			System.out.println("HS thu:  "+i );
//			System.out.println(m.TaoHoTen());
//			String ngay1="01/02/1990";
//			String ngay2="12/12/1992";
//			System.out.println(m.TaoNgay(ngay1, ngay2));
//		}
		
		
		//2
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			BtMang m= new BtMang();
			m.HienThi();
		}
				

		
	}
}
