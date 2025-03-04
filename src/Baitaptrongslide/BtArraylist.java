package Baitaptrongslide;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class BtArraylist {
	public ArrayList<String> DsHoTen = new ArrayList<String>();
	public ArrayList<Double> DsDtb = new ArrayList<Double>();

	public void TaoDanhSach() {
		try {
			FileInputStream f = new FileInputStream("sv.txt");
			InputStreamReader ir = new InputStreamReader(f);
			BufferedReader r = new BufferedReader(ir);
			while (true) {
				String st = r.readLine();
				if (st == "" || st == null)
					break;
				String[] ds = st.split("[;]");
				DsHoTen.add(ds[1]);
				DsDtb.add(Double.parseDouble(ds[3]));

			}
			r.close();

		} catch (Exception tt) {
			System.out.println("Loi o ham XuatDanhSach: " + tt.getMessage());

		}
	}
	
	public void XuatDanhSach() {
		int ss=DsHoTen.size();
		for(int i=0;i<ss;i++) {
			System.out.println(DsHoTen.get(i)+":"+DsDtb.get(i));
		}
	}
	public static double levenshteinSimilarity(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= str2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                int cost = (str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0 : 1;
                dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + cost);
            }
        }

        int distance = dp[str1.length()][str2.length()];
        int maxLength = Math.max(str1.length(), str2.length());

        if (maxLength == 0) {
            return 1.0; 
        }

        return 1.0 - (double) distance / maxLength;
    }
	public ArrayList<String> TimKiemSinhVien(String name,double threshold){
		ArrayList<String> results=new ArrayList<String>();
		System.out.println(DsHoTen.size());
		for (int i=0;i<DsHoTen.size();i++) {
            double similarity = levenshteinSimilarity(DsHoTen.get(i).toLowerCase(), name.toLowerCase());
            if (similarity >= threshold) {
            	
                results.add(DsHoTen.get(i));
            }
		}
		return results;
	}
	public int[] Statistics() {
		int cnt1,cnt2;
		cnt1=cnt2=0;
		for(double d : DsDtb) {
			if(d>=5) {
				cnt1++;
			}
			else cnt2++;
		}
		return new int[] {cnt1,cnt2};
	}
	public double calcAverage() {
		double sum=0;
		int n=DsDtb.size();
		for(double d : DsDtb) {
			sum+=d;
		}
		return sum/n;
	}
}