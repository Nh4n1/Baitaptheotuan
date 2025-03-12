package BaitapJFrame;

public class SinhVien {
	public String ht, tenlop, masv;
	public float dtb;
	
	public SinhVien() {
		
	}
	public SinhVien(String masv, String ht, String tenlop, float dtb) {
		this.masv = masv;
		this.ht = ht;
		this.tenlop = tenlop;
		this.dtb = dtb;
	}

	public void DoiTen(String ht)// Đổi lại họ tên sinh viên
	{
		this.ht = ht;
	}

	public void DoiDtb(float dtb)// Thay đổi điểm trung bình
	{
		this.dtb = dtb;
	}



	public void DoiLop(String TenLop)// Thay đổi tên lớp
	{
		this.tenlop = TenLop;
	}

	public String getHt() {
		return ht;
	}

	public void setHt(String ht) {
		this.ht = ht;
	}

	public String getTenlop() {
		return tenlop;
	}

	public void setTenlop(String tenlop) {
		this.tenlop = tenlop;
	}

	public String getMasv() {
		return masv;
	}

	public void setMasv(String masv) {
		this.masv = masv;
	}

	public float getDtb() {
		return dtb;
	}

	public void setDtb(float dtb) {
		this.dtb = dtb;
	}
	@Override
	public String toString() {
		return masv+";"+ht+";"+tenlop+";"+dtb;
	}
}
