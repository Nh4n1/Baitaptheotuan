package BaitapALvaHDT;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


//SKIP  
//SKIP
//SKIP
public class QL extends JFrame {
	public ArrayList<Object> ds1 = new ArrayList<Object>();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField khoaTextField;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QL frame = new QL();
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
	public QL() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		khoaTextField = new JTextField();
		khoaTextField.setBounds(141, 42, 182, 19);
		contentPane.add(khoaTextField);
		khoaTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Khoa");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(63, 43, 45, 13);
		contentPane.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(61, 96, 319, 157);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel svTextField = new JLabel("Ho ten");
		svTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		svTextField.setBounds(63, 73, 205, 13);
		contentPane.add(svTextField);
		
		textField = new JTextField();
		textField.setBounds(141, 70, 182, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnDisplay = new JButton("Hien thi");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaoBang(ds1);
			}
		});
		btnDisplay.setBounds(340, 41, 85, 21);
		contentPane.add(btnDisplay);
		
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {// Mở file
					FileInputStream fr = new FileInputStream("src/dataSource/sv.txt");
					InputStreamReader ir = new InputStreamReader(fr);
					BufferedReader br = new BufferedReader(ir);
					
					while (true) {
						String st = br.readLine();// Đọc 1 dòng
						if (st == null || st == "")
							break;
						String[] t = st.split("[|]");
						if (t.length == 4) {// nếu sv Khoa CNtt
							SvCntt sv = new SvCntt();// Tạo ra 1 sv
							sv.setMaSv(t[0]);
							sv.setHoTen(t[1]);
							sv.setDm1(Double.parseDouble(t[2]));
							sv.setDm2(Double.parseDouble(t[3]));
							
							ds1.add(sv);// Lưu vào mảng
						}
						if (t.length == 5) {// nếu sv Khoa Toan
							SvToan sv = new SvToan();
							sv.setMaSv(t[0]);
							sv.setHoTen(t[1]);
							sv.setDm1(Double.parseDouble(t[2]));
							sv.setDm2(Double.parseDouble(t[3]));
							sv.setDm3(Double.parseDouble(t[4]));
							ds1.add(sv);// Lưu vào mảng
						}
						if (t.length == 6) {/// nếu sv Khoa Ly
							SvLy sv = new SvLy();
							sv.setMaSv(t[0]);
							sv.setHoTen(t[1]);
							sv.setDm1(Double.parseDouble(t[2]));
							sv.setDm2(Double.parseDouble(t[3]));
							sv.setDm3(Double.parseDouble(t[4]));
							sv.setDm4(Double.parseDouble(t[5]));
							ds1.add(sv);// Lưu vào mảng
						}
					}
					br.close();// Đóng file
				} catch (Exception ttt) {
					System.out.print(ttt);
				}
			}
		});
	}
	public void TaoBang(ArrayList<Object> ds) {
		try {
			String khoa=khoaTextField.getText().toUpperCase();
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Ma SV");
			model.addColumn("Ho Ten");
			int i=0;
			if (khoa.equals("CNTT")) {
				i=2;
			}
			if (khoa.equals("TOAN")) {
				i = 3;
			}
			if (khoa.equals("LY")) {
				i = 4;
			}
			for(int id=1;id<=i;id++) {
				model.addColumn("Diem "+id);
			}
			String fileName="";
			
			if (khoa.equals("CNTT")) {
				fileName = "src/dataSource/f1.txt";
			}
			if (khoa.equals("TOAN")) {
				fileName = "src/dataSource/f2.txt";
			}
			if (khoa.equals("LY")) {
				fileName = "src/dataSource/f3.txt";
			}
			FileInputStream fr = new FileInputStream(fileName);
			InputStreamReader ir = new InputStreamReader(fr);
			BufferedReader br = new BufferedReader(ir);
			while (true) {
				String st = br.readLine();
				if (st == null || st == "")
					break;
				String[] t = st.split("[|]");
				Object[] row = new Object[t.length];
				for (int j = 0; j < t.length; j++) {
					row[j] = t[j];
				}
				model.addRow(row);
			}
			table.setModel(model);
			br.close();
			
			
		} catch (Exception e) {
			
		}
		
		
		
		
	
	}
}
