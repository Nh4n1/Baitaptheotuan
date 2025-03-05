package Baitaptuan3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Choice;
import java.awt.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class tb4 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	QL ql = new QL();
	ArrayList ds;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tb4 frame = new tb4();
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
	public tb4() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 572);
		contentPane = new JPanel();
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Choice choice = new Choice();
		choice.setBounds(63, 32, 167, 38);
		contentPane.add(choice);
		
		List list = new List();
		list.setBounds(63, 67, 641, 363);
		contentPane.add(list);
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					ds=ql.getData("dulieu.txt");
					choice.add("Sinh Vien");
					choice.add("Nhan Vien");
					for(Object t:ds) {
						list.add(t.toString());
					}
				}catch(Exception e2) {
					e2.printStackTrace();
				}
			}
		});
	}

}
