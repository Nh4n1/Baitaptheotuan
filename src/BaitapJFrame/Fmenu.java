package BaitapJFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fmenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fmenu frame = new Fmenu();
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
	public Fmenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu quanLyMenu = new JMenu("Quan ly");
		menuBar.add(quanLyMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Quan ly sinh vien");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmDanhSach f = new FrmDanhSach();
				 f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				f.setVisible(true);
			}
		});
		quanLyMenu.add(mntmNewMenuItem);
		
		JMenu timKiemMenu = new JMenu("Tim kiem");
		menuBar.add(timKiemMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Tim kiem theo lop");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FtimKiem f = new FtimKiem();
				 f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				f.setVisible(true);
			}
		});
		timKiemMenu.add(mntmNewMenuItem_1);
		
		JMenu thongKeMenu = new JMenu("Thong ke");
		menuBar.add(thongKeMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Thong ke sinh vien");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FthongKe f = new FthongKe();
				 f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				f.setVisible(true);
			}
		});
		thongKeMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
