package Baitaptuan3;

public class SinhVien {
	private String msv,hoten,ns,phone,email;

	public String getNs() {
		return ns;
	}

	public void setNs(String ns) {
		this.ns = ns;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMsv() {
		return msv;
	}

	public void setMsv(String msv) {
		this.msv = msv;
	}

	

	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "SinhVien [msv=" + msv + ", hoten=" + hoten + ", ns=" + ns + ", phone=" + phone + ", email=" + email
				+ "]";
	}

	
	
}
