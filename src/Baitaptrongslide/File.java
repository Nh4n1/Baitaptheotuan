package Baitaptrongslide;
import java.util.Scanner;

public class File {
	public static void main(String[] args) {
		BtFile fi = new BtFile();
		fi.TaoDanhSach(5);
		fi.XuatDanhSach();
//		System.out.print("Hs can tim: ");
//		Scanner sc= new Scanner(System.in);
//		String name=sc.nextLine();
//		fi.SimpleFind(name);
//		fi.Count();
//		fi.CalcAverage();
		System.out.println("");
		fi.checkValid();
		
	}
}