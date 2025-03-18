package BaitapALvaHDT;

public class SvLy {
	private String maSv, hoTen;
	private double Dm1, Dm2, Dm3, Dm4;
	public static double tongDiem=0;
	public static int soSv = 0;
	public String getMaSv() {
		return maSv;
	}
	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public double getDm1() {
		return Dm1;
	}
	public void setDm1(double dm1) {
		Dm1 = dm1;
	}
	public double getDm2() {
		return Dm2;
	}
	public void setDm2(double dm2) {
		Dm2 = dm2;
	}
	public double getDm3() {
		return Dm3;
	}
	public void setDm3(double dm3) {
		Dm3 = dm3;
	}
	public double getDm4() {
		return Dm4;
	}
	public void setDm4(double dm4) {
		Dm4 = dm4;
	}
	
	public double getDiemTB() {
		return (Dm1 + Dm2 + Dm3 + Dm4) / 4;
	}
	public String getKetQua() {
		return getDiemTB() >= 5 ? "Đậu" : "Rớt";
	}

	public void HienThi() {
		System.out.println(maSv + "|" + hoTen + "|" + Dm1 + "|" + Dm2 + "|" + Dm3 + "|" + Dm4 + "|" + getDiemTB() + "|"
				+ getKetQua());
	}
	
	public String getThongTin() {
		return maSv + "|" + hoTen + "|" + Dm1 + "|" + Dm2 + "|" + Dm3 + "|" + Dm4 + "|" + getDiemTB() + "|" + getKetQua();
	}

}
