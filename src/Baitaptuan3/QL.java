package Baitaptuan3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class QL {
	public ArrayList getData(String fname) throws Exception{
		ArrayList ds = new ArrayList();
		FileReader f=new FileReader(fname);
		BufferedReader r=new BufferedReader(f);
		int i=0;
		while(true) {
			i++;
			String st=r.readLine();
			if(st=="" || st==null) {
				break;
			}
			if(isValidData(st,i)) {
				String[] parts = st.split(";");
				String msv=parts[0];
				String hoten=parts[1];
				String ns=parts[2];
				String sdt=parts[3];
				String email=parts[4];
				SinhVien sv=new SinhVien();
				sv.setMsv(msv);
				sv.setHoten(hoten);
				sv.setNs(ns);
				sv.setPhone(sdt);
				sv.setEmail(email);
				ds.add(sv);
			}
		}
		return ds;
		
	}
	public void HienThiThongTin(ArrayList ds) throws Exception{
		for(Object x:ds) {
			System.out.println(x.toString());
		}
	}
	public Boolean isValidData(String data,int idx) {
		String[] parts = data.split(";");
		String msv=parts[0];
		String hoten=parts[1];
		String ns=parts[2];
		String sdt=parts[3];
		String email=parts[4];
		
		int flag=1;
		int a[]= {0,0,0,0,0};
		String b[]= {
				"Ma sinh vien khong hop le","","Ngay sinh khong hop le","So dien thoai khong hop le","Email khong hop le"
		};
		if(!checkMsv(msv)) {
			a[0]=1;
		
			flag=0;
		}
		if(!isValidNs(ns)) {
			a[2]=1;
			
			flag=0;
		}
		if(!isValidSdt(sdt)){
			a[3]=1;
		
			flag=0;
		}
		if(!isValidEmail(email)) {
			a[4]=1;
			flag=0;
		}
		if(flag==0) {
			System.out.println("Loi tai dong thu: "+idx);
			for(int i=0;i<a.length;i++) {
				if(a[i]==1) {
					System.out.println("     "+b[i]);
				}
			}
			return false;
		}
		
		return true;
	}
	public Boolean isValidEmail(String email) {
		int idxA=email.indexOf('@');
		int idxLastDot=email.lastIndexOf('.');
		String username = email.substring(0, idxA);
		String domain=email.substring(idxA+1,idxLastDot);
		if(!isValidPrefixA(username)) {
			return false;
		}
		for (char c : domain.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '-' && c != '.') {
                return false;
            }
        }
		return true;
	}
	public Boolean isValidPrefixA(String prefixA) {
		for(char c:prefixA.toCharArray()) {
			if(!Character.isLetterOrDigit(c)) {
				return false;
			}
		}
		return true;
	}
	
	public Boolean checkMsv(String msv) {
		if(msv.length()!=10) return false;
		if (!Character.isLetter(msv.charAt(2))) {
            return false;
        }
		for (int i = 0; i < 10; i++) {
        	if(i==2) continue;
            if (!Character.isDigit(msv.charAt(i))) {
                return false;
            }
        }
        return true;
	}
	public Boolean isValidNs(String ns) {
		SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
		f.setLenient(false);
		try {
			f.parse(ns);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	public Boolean isValidSdt(String sdt) {
		if(sdt.length()==0) return false;
		if(sdt.length()<10) return false;
		if(sdt.charAt(0)!='0') return false;
		for (int i = 0; i < sdt.length(); i++) {
            if (!Character.isDigit(sdt.charAt(i))) {
                return false;
            }
        }
        return true;
	}
	
}
