package BaitapJFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class testb5 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtmsv;
	private JTextField txthoten;
	private JTextField txtdtb;

	/**
	 * Launch the application.
	 */
	ArrayList<SinhVien> ds = new ArrayList<SinhVien>();
	SinhVien sv = new SinhVien();
	private JTextField txttenlop;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testb5 frame = new testb5();
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
	public testb5() {
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
				} catch (Exception ex) {

				}
				Napbang(ds);
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 126, 414, 183);
		contentPane.add(tabbedPane);

		JScrollPane scrollPane = new JScrollPane();

		tabbedPane.addTab("New tab", null, scrollPane, null);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int d = table.getSelectedRow();
				txtmsv.setText(table.getValueAt(d, 0).toString());
				txthoten.setText(table.getValueAt(d, 1).toString());
				txtdtb.setText(table.getValueAt(d, 3).toString());
				txttenlop.setText(table.getValueAt(d, 2).toString());

			}
		});
		scrollPane.setViewportView(table);

		txtmsv = new JTextField();
		txtmsv.setBounds(78, 11, 155, 20);
		contentPane.add(txtmsv);
		txtmsv.setColumns(10);

		txthoten = new JTextField();
		txthoten.setBounds(78, 42, 155, 20);
		contentPane.add(txthoten);
		txthoten.setColumns(10);

		txtdtb = new JTextField();
		txtdtb.setBounds(78, 106, 155, 20);
		contentPane.add(txtdtb);
		txtdtb.setColumns(10);

		txttenlop = new JTextField();
		txttenlop.setBounds(78, 73, 155, 20);
		contentPane.add(txttenlop);
		txttenlop.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=JOptionPane.showInputDialog("Nhap ten");
				ArrayList newSv = new ArrayList();
				 boolean found = false;
	                for(SinhVien s : ds) {
	                	if(s.getHt().toLowerCase().contains(name.toLowerCase())) {
	                		newSv.add(s);
	                	}
	                }
	             Napbang(newSv);
			}
		});
	
	
		btnSearch.setBounds(243, 10, 89, 23);
		contentPane.add(btnSearch);

		JButton btnAdd = new JButton("Add new sv");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBounds(243, 41, 89, 23);
		contentPane.add(btnAdd);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
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
                    
                   
                    JOptionPane.showMessageDialog(null, "Data saved successfully!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error saving data.");
                }
			}
		});
		btnSave.setBounds(243, 72, 89, 23);
		contentPane.add(btnSave);

		JButton btnDisplayAll = new JButton("All");
		btnDisplayAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Napbang(ds);
			}
		});
		btnDisplayAll.setBounds(243, 105, 89, 23);
		contentPane.add(btnDisplayAll);

		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msv = txtmsv.getText();
				String hoten = txthoten.getText();
				String tenlop = txttenlop.getText();
				float dtb= Float.parseFloat(txtdtb.getText());
				SinhVien newSv = new SinhVien(msv, hoten, tenlop, dtb);
				ds.add(newSv);
				Napbang(ds);
			}
		});
		
	}

	public void Napbang(ArrayList ds) {
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("msv");
		mh.addColumn("hoten");
		mh.addColumn("tenlop");
		mh.addColumn("dtb");
		for (Object x : ds) {
			Object[] t = new Object[4];
			String[] d = x.toString().split("[;]");
			t[0] = d[0];
			t[1] = d[1];
			t[2] = d[2];
			t[3] = d[3];
			mh.addRow(t);
		}

		table.setModel(mh);
	}
}
