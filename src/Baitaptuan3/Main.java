package Baitaptuan3;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		try {
			QL ql=new QL();
			ArrayList ds=ql.getData("dulieu.txt");
			System.out.println("Du lieu sau khi luu");
			ql.HienThiThongTin(ds);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
