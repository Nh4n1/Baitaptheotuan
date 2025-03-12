package Baitaptuan3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
				Napbang();
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
					txtdtb.setText(table.getValueAt(d, 2).toString());
					
				
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
		txtdtb.setBounds(78, 77, 155, 20);
		contentPane.add(txtdtb);
		txtdtb.setColumns(10);
		
		
		
	}
	
	
	public void Napbang(ArrayList ds) {
		DefaultTableModel mh=new DefaultTableModel();
		mh.addColumn("Msv");
		mh.addColumn("Ho ten");
		mh.addColumn("Ten lop");
		mh.addColumn("Dtb");
		
		for (Object t: ds) {
			
		}
		
		table.setModel(mh);
	}
	
}
