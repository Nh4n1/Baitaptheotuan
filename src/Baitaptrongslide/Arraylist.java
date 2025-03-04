package Baitaptrongslide;
import java.util.ArrayList;

public class Arraylist {
	public static void main(String[] args) {
		BtArraylist arl= new BtArraylist();
		arl.TaoDanhSach();
		arl.XuatDanhSach();
		ArrayList<String> dsSinhVien=new ArrayList<String>();
		dsSinhVien=arl.TimKiemSinhVien("Le Trung Giang", 0.9);
//		if (dsSinhVien.isEmpty()) {
//            System.out.println("No matching students found.");
//        } else {
//        	System.out.println("Danh sach sinh vien tim: ");
//            for (String student : dsSinhVien) {
//                System.out.println(student); 
//                
//            }
//        }
		int[] slSinhVien=arl.Statistics();
		System.out.println("So sinh vien dau: "+slSinhVien[0]);
		System.out.println("So sinh vien rot: "+slSinhVien[1]);
		System.out.println("Diem trung binh cong: "+String.format("%.2f", arl.calcAverage()));
	}
}