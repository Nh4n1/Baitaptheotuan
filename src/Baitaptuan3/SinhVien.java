package Baitaptuan3;

public class SinhVien {
	private String msv,ns,phone;

	public String getNs() {
		return ns;
	}

	public void setNs(String ns) {
		this.ns = ns;
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
		return "SinhVien [msv=" + msv + ", ns=" + ns + ", phone=" + phone + "]";
	}

	
	
}
