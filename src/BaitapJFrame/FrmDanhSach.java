package BaitapJFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Choice;
import java.awt.TextField;
import java.awt.List;
import java.awt.Label;
import java.awt.Font;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.io.*;
import java.util.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmDanhSach extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	ArrayList ds = new ArrayList();
	int kt = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDanhSach frame = new FrmDanhSach();
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
//
	TextField txtmasv = new TextField();
	TextField txtht = new TextField();
	TextField txtdtb = new TextField();
	List list1 = new List();

	public FrmDanhSach() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Choice Choice1 = new Choice();
		Choice1.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {

				NapList(Choice1.getSelectedItem());

			}
		});
		Choice1.setBounds(121, 31, 173, 18);
		contentPane.add(Choice1);

		txtdtb.setBounds(121, 121, 173, 18);
		contentPane.add(txtdtb);

		txtmasv.setBounds(121, 73, 173, 18);
		contentPane.add(txtmasv);

		txtht.setBounds(121, 97, 173, 18);
		contentPane.add(txtht);

		list1.setBounds(10, 184, 555, 143);
		contentPane.add(list1);

		Label label = new Label("Chon 1 lop:");
		label.setFont(new Font("Dialog", Font.BOLD, 10));
		label.setBounds(28, 28, 75, 21);
		contentPane.add(label);

		Label label_1 = new Label("Masv");
		label_1.setFont(new Font("Dialog", Font.BOLD, 10));
		label_1.setBounds(28, 70, 59, 21);
		contentPane.add(label_1);

		Label label_2 = new Label("Ho va ten");
		label_2.setBounds(28, 94, 87, 21);
		label_2.setFont(new Font("Dialog", Font.BOLD, 10));
		contentPane.add(label_2);

		Label label_3 = new Label("Dtb");
		label_3.setBounds(28, 121, 59, 21);
		label_3.setFont(new Font("Dialog", Font.BOLD, 10));
		contentPane.add(label_3);

		Label label_4 = new Label("Danh sach cac sinh vien");
		label_4.setFont(new Font("Dialog", Font.BOLD, 12));
		label_4.setBounds(28, 145, 192, 21);
		label_4.setFont(new Font("Dialog", Font.BOLD, 10));
		contentPane.add(label_4);

		Button button = new Button("Nhap");
		button.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				int ktma = 0;// Kiểm tra xem masv này đã có chưa
				int n = ds.size();
				for (int i = 0; i < n; i++) {
					SinhVien sv = (SinhVien) ds.get(i);
					if (sv.masv.equals(txtmasv.getText())) {
						ktma = 1;
						break;
					}
				}
				if (ktma == 0) {// nếu chưa có
					SinhVien sv = new SinhVien(txtmasv.getText(), txtht.getText(), Choice1.getSelectedItem(),
							Float.parseFloat(txtdtb.getText()));
					ds.add(sv);
					NapList(Choice1.getSelectedItem());
					JOptionPane.showMessageDialog(null, "Nhập thành công");
				} else
					JOptionPane.showMessageDialog(null, "Mã sinh viên đã có");
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(Choice1.getSelectedItem());
				NapList(Choice1.getSelectedItem());
			}
		});
		button.setBackground(SystemColor.activeCaptionBorder);
		button.setFont(new Font("Dialog", Font.BOLD, 11));
		button.setBounds(350, 31, 84, 21);
		contentPane.add(button);

		Button button_1 = new Button("Luu file");

		button_1.setBackground(SystemColor.activeCaptionBorder);
		button_1.setFont(new Font("Dialog", Font.BOLD, 11));
		button_1.setBounds(461, 31, 87, 21);
		contentPane.add(button_1);

		Button button_2 = new Button("Sua");

		button_2.setBackground(SystemColor.activeCaptionBorder);
		button_2.setFont(new Font("Dialog", Font.BOLD, 11));
		button_2.setBounds(350, 73, 84, 21);
		contentPane.add(button_2);

		Button button_3 = new Button("Tim kiem");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String st = JOptionPane.showInputDialog(this, "Nhap masv can tim");
				System.out.println(st);
				if (st != null) {

					for (int i = 0; i < ds.size(); i++) {
						SinhVien sv = (SinhVien) ds.get(i);
						System.out.println(sv.masv);
						if (sv.masv.equals(st)) {
							System.out.println("found");
							txtmasv.setText(sv.masv);
							txtht.setText(sv.ht);
							txtdtb.setText(String.valueOf(sv.dtb));
							break;
						}
					}
				}

			}
		});
		button_3.setBackground(SystemColor.activeCaptionBorder);
		button_3.setFont(new Font("Dialog", Font.BOLD, 11));
		button_3.setBounds(461, 73, 87, 21);
		contentPane.add(button_3);

		Button button_delete = new Button("Xoa");

		button_delete.setFont(new Font("Dialog", Font.BOLD, 11));
		button_delete.setBackground(SystemColor.activeCaptionBorder);
		button_delete.setBounds(350, 121, 87, 18);
		contentPane.add(button_delete);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					FileInputStream f = new FileInputStream("ds.txt");
					InputStreamReader in = new InputStreamReader(f);
					BufferedReader read = new BufferedReader(in);
					ds.clear();
					do {
						String masv = read.readLine();
						if (masv == null)
							break;
						String ht = read.readLine();
						String tenlop = read.readLine();
						float dtb = Float.parseFloat(read.readLine());
						SinhVien sv = new SinhVien(masv, ht, tenlop, dtb);
						ds.add(sv);// Lưu sv vào ds
					} while (true);
					read.close();
					FileInputStream f2 = new FileInputStream("Khoa.txt");
					InputStreamReader in2 = new InputStreamReader(f2);
					BufferedReader read2 = new BufferedReader(in2);
					do {
						String st = read2.readLine();
						if (st == null)
							break;
						Choice1.add(st);
					} while (true);
				} catch (Exception yy) {
				}
				NapList(Choice1.getSelectedItem());// Nạp dữ liệu vào list1 và các textfield
				kt = 1;// kt =1 đã nạp dữ liệu vào list1

			}

		});
		list1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (kt != 0) {
					String st = list1.getSelectedItem();// Lấy mã sinh viên chọn ở list1
					for (int i = 0; i < ds.size(); i++) {
						SinhVien sv = (SinhVien) ds.get(i);// Lấy ra sinh viên thứ I từ ds
						if (sv.masv.equals(st)) {
							txtmasv.setText(sv.masv);
							txtht.setText(sv.ht);
							txtdtb.setText(String.valueOf(sv.dtb));
						}
					}
				}
			}
		});

		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileOutputStream f = new FileOutputStream("ds.txt");
					OutputStreamWriter out = new OutputStreamWriter(f);
					PrintWriter ghi = new PrintWriter(out);
					for (int i = 0; i < ds.size(); i++) {
						SinhVien sv = (SinhVien) ds.get(i);
						ghi.println(sv.masv);
						ghi.println(sv.ht);
						ghi.println(sv.tenlop);
						ghi.println(sv.dtb);
					}
					ghi.close();
					JOptionPane.showMessageDialog(null, "Lưu thành công");

				} catch (Exception yy) {
					JOptionPane.showMessageDialog(null, "Lưu không thành công");
				}

			}
		});
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int n = ds.size();
				for (int i = 0; i < n; i++) {
					SinhVien sv = (SinhVien) ds.get(i);
					if (sv.masv.equals(txtmasv.getText())) {
						sv.DoiTen(txtht.getText());
						sv.DoiLop(Choice1.getSelectedItem());
						sv.DoiDtb(Float.parseFloat(txtdtb.getText()));
						ds.set(i, sv);
						NapList(Choice1.getSelectedItem());
					}
				}
			}
		});
		button_delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String st = txtmasv.getText();
				if (st.equals("")) {
					JOptionPane.showMessageDialog(null, "Chua nhap ma sinh vien");
				} else {
					if (JOptionPane.showConfirmDialog(null, "Ban co chac chan muon xoa sinh vien nay khong?") == JOptionPane.YES_OPTION) {
						for (int i = 0; i < ds.size(); i++) {
							SinhVien sv = (SinhVien) ds.get(i);
							if (sv.masv.equals(st)) {
								ds.remove(i);
								NapList(Choice1.getSelectedItem());
								break;
							}
						}
						try {
							FileOutputStream f = new FileOutputStream("ds.txt");
							OutputStreamWriter out = new OutputStreamWriter(f);
							PrintWriter ghi = new PrintWriter(out);
							for (int i = 0; i < ds.size(); i++) {
								SinhVien sv = (SinhVien) ds.get(i);
								ghi.println(sv.masv);
								ghi.println(sv.ht);
								ghi.println(sv.tenlop);
								ghi.println(sv.dtb);
							}
							ghi.close();
							JOptionPane.showMessageDialog(null, "Xoa thanh cong");

						} catch (Exception yy) {
							JOptionPane.showMessageDialog(null, "Xoa khong thanh cong");
						}
					}
				}

			}
		});
	}

	public void NapList(String tenlop) {

		list1.removeAll();
		int n = ds.size();

		for (Object t : ds) {

			SinhVien sv = (SinhVien) t;

			if (sv.tenlop.toLowerCase().equals(tenlop.toLowerCase())) {

				txtmasv.setText(sv.masv);
				txtht.setText(sv.ht);
				txtdtb.setText(String.valueOf(sv.dtb));
				list1.add(sv.masv);
				list1.add(sv.ht);
				list1.add(sv.tenlop);
				list1.add(String.valueOf(sv.dtb));
				list1.add("----------------------------------");
			}
		}
	}
}
