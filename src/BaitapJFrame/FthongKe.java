package BaitapJFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FthongKe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	ArrayList ds = new ArrayList();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FthongKe frame = new FthongKe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FthongKe() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 289);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(218, 10, 0, 0);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setBounds(10, 10, 416, 233);
		contentPane.add(table_1);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					FileInputStream f = new FileInputStream("ds.txt");
					InputStreamReader in = new InputStreamReader(f);
					BufferedReader read = new BufferedReader(in);
					String st;
					int cntLenLop = 0;
					
					do {
						String masv = read.readLine();
						if (masv == null)
							break;
						String ht = read.readLine();
						String tenlop = read.readLine();
						float dtb = Float.parseFloat(read.readLine());
						
						SinhVien sv = new SinhVien(masv, ht, tenlop, dtb);
						if(sv.dtb >= 5) {
							cntLenLop++;
						};
						ds.add(sv);// Lưu sv vào ds
					} while (true);
					read.close();
					DefaultTableModel model = new DefaultTableModel(0,4);
					Object[] t = new Object[4];
					t[0] = "So sv len lop";
					t[1] = "So sv rot lop";
					t[2] = "Ti le sv len lop";
					t[3] = "Ti le sv rot lop";
					model.addRow(t);
					int n = ds.size();
					t[0] = cntLenLop;
					t[1] = n - cntLenLop;
					t[2] = (float)cntLenLop/n * 100 + "%";
					t[3] = (float)(n - cntLenLop)/n * 100 + "%";
					model.addRow(t);
					table_1.setModel(model);
					
					
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
	}

}
