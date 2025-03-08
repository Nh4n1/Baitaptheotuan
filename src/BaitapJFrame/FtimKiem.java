package BaitapJFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.io.*;
import java.util.*;

public class FtimKiem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	ArrayList ds = new ArrayList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FtimKiem frame = new FtimKiem();
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
	public FtimKiem() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Label label = new Label("Nhap ten lop hoc:");
		label.setFont(new Font("Dialog", Font.BOLD, 11));
		label.setBounds(10, 36, 131, 30);
		contentPane.add(label);

		TextField txttenlop = new TextField();

		txttenlop.setBounds(157, 36, 191, 30);
		contentPane.add(txttenlop);

		Button button = new Button("Hien thi tat ca");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DefaultTableModel Tmodel = new DefaultTableModel(0, 5);
				Object[] t = new Object[5];
				t[0] = "Ma sinh vien";
				t[1] = "Ho va ten";
				t[2] = "Ten lop";
				t[3] = "Diem trung binh";
				t[4] = "Ket qua";
				Tmodel.addRow(t);
				int n = ds.size();
				for (int i = 0; i < n; i++) {
					SinhVien sv = (SinhVien) ds.get(i);
					t[0] = sv.masv;
					t[1] = sv.ht;
					t[2] = sv.tenlop;
					t[3] = String.valueOf(sv.dtb);
					t[4] = sv.dtb>=5?"Dau":"Rot";
					Tmodel.addRow(t);
				}
				table.setModel(Tmodel);
			}
		});

		button.setFont(new Font("Dialog", Font.BOLD, 11));
		button.setBackground(SystemColor.activeCaptionBorder);
		button.setBounds(377, 36, 137, 30);
		contentPane.add(button);

		table = new JTable();
		table.setBounds(20, 146, 617, 212);
		contentPane.add(table);
		
		Button button_1 = new Button("Hien thi len lop");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DefaultTableModel Tmodel = new DefaultTableModel(0, 4);
				Object[] t = new Object[4];
				t[0] = "Ma sinh vien";
				t[1] = "Ho va ten";
				t[2] = "Ten lop";
				t[3] = "Diem trung binh";
				Tmodel.addRow(t);
				int n = ds.size();
				for (int i = 0; i < n; i++) {
					SinhVien sv = (SinhVien) ds.get(i);
					if(sv.dtb>=5) {
						
							t[0] = sv.masv;
							t[1] = sv.ht;
							t[2] = sv.tenlop;
							t[3] = String.valueOf(sv.dtb);
							Tmodel.addRow(t);
						
					}
				}
				table.setModel(Tmodel);
				
			}
		});
		
		button_1.setBackground(SystemColor.activeCaptionBorder);
		button_1.setFont(new Font("Dialog", Font.BOLD, 11));
		button_1.setBounds(377, 89, 137, 30);
		contentPane.add(button_1);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {// Mở file ds.txt để đọc dữ liệu vào ds
					FileInputStream f = new FileInputStream("DS.TXT");
					InputStreamReader in = new InputStreamReader(f);
					BufferedReader read = new BufferedReader(in);
					ds.clear();
					do {// Lưu dữ liệu vào ds
						String masv = read.readLine();
						if (masv == null)
							break;
						String ht = read.readLine();
						String tenlop = read.readLine();
						float dtb = Float.parseFloat(read.readLine());
						SinhVien sv = new SinhVien(masv, ht, tenlop, dtb);
						ds.add(sv);
					} while (true);
				} catch (Exception tt) {
					JOptionPane.showMessageDialog(null, "Loi doc file");
				}
				DefaultTableModel Tmodel = new DefaultTableModel(0, 4);
				Object[] t = new Object[4];
				t[0] = "Ma sinh vien";
				t[1] = "Ho va ten";
				t[2] = "Ten lop";
				t[3] = "Diem trung binh";
				Tmodel.addRow(t);// Thêm dòng têu để
				int n = ds.size();
				for (int i = 0; i < n; i++)// Duyệt qua các sinh viên trong ds
				{
					SinhVien sv = (SinhVien) ds.get(i);
					t[0] = sv.masv;
					t[1] = sv.ht;
					t[2] = sv.tenlop;
					t[3] = String.valueOf(sv.dtb);
					Tmodel.addRow(t);
				}
				table.setModel(Tmodel);
			}

		});

		txttenlop.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {// Nếu người dùng nhấn Enter
					DefaultTableModel Tmodel = new DefaultTableModel(0, 4);
					Object[] t = new Object[4];
					t[0] = "Ma sinh vien";
					t[1] = "Ho va ten";
					t[2] = "Ten lop";
					t[3] = "Diem trung binh";
					Tmodel.addRow(t);
					int n = ds.size();
					for (int i = 0; i < n; i++) {
						SinhVien sv = (SinhVien) ds.get(i);
						if (sv.tenlop.equalsIgnoreCase(txttenlop.getText())) {
							t[0] = sv.masv;
							t[1] = sv.ht;
							t[2] = sv.tenlop;
							t[3] = String.valueOf(sv.dtb);
							Tmodel.addRow(t);// Thêm vào bảng 1 dòng
						}
					}
					table.setModel(Tmodel);
					if (Tmodel.getRowCount() == 1)// Không tìm thấy
						JOptionPane.showMessageDialog(null, "Khong tim thay");
				}
			}
		});
		
		

	}
}
