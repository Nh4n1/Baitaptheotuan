import java.util.Scanner;

public class Baitaptuan2 {
	public static void main(String[] args) {
	       String[] dssv={"24T102;Le van teo;K48;CNTT;23",
	               "24T103;Le van Ty;K45;CNTT;20",
	               "24T103;Le van Nam;K48;Toan;17",
	               "24T103;Le van Tung;K48;Ly;25"
	       };
	       Scanner sc=new Scanner(System.in);
	       //Cau 1: Xuat ra ds sinh vien
	       for(String x : dssv) {
	    	   System.out.println(x);
	       }
	       //Cau 2: Nhap vao masv, in ra diem dau vao cua sinh do
	       
//	       String masv=sc.nextLine();
//	       for(String x:dssv) {
//	    	   if(x.split(";")[0].equals(masv)) {
//	    		   System.out.println(x.split(";")[4]);
//	    	   }
//	       }
	       //Cau 3. Nhap vao key (ho, ten, chu lot) xuat ra sv co key nay
//	       String k=sc.nextLine();
//	       for(String x:dssv) {
//	    	   if(x.split(";")[1].toLowerCase().contains(k.toLowerCase())) {
//	    		   System.out.println(x);
//	    	   }
//	       }
	       //Cau 4. Nhap vao 1 ten Khoa, xuat ra ds sv cua khoa do
//	       String khoa=sc.nextLine();
//	       for(String x:dssv) {
//	    	   if(x.split(";")[3].toLowerCase().contains(khoa) ){
//	    		   System.out.println(x);
//	    	   }
//	       }
	       //Cau 5. Cho biet moi khoa co bao nhieu sv va TBC cua diem dau vao
	       
	   }
	
}
