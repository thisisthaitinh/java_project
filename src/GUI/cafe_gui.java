package GUI;

import GUI.Thuc_don_GUI;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;

public class cafe_gui extends JFrame {
	private JLabel title, maKH_l, tenKH_l, sdtKH_l, menu_l;
	private JTextField maKH_t, tenKH_t, sdtKH_t;
	private JButton menuB;
	private JTable table;
	private DefaultTableModel tm;
	
	public cafe_gui() {
		super("Take order from customer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// title
		title = new JLabel("TAKE ORDER FROM CUSTOMER", JLabel.CENTER);
		title.setOpaque(true);
		title.setFont(new Font("Arial", Font.BOLD, 25));
		title.setForeground(Color.BLUE);
		
		Border p = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		title.setBorder(p);
		
		add(title, BorderLayout.NORTH);
		
		// center
		JPanel center = new JPanel(new GridLayout(2, 1, 5, 5));
		// input
		JPanel input = new JPanel(new GridLayout(4, 2, 5, 5));
		
		maKH_l = new JLabel("Mã khách hàng: ");
		maKH_t = new JTextField();
		
		tenKH_l = new JLabel("Tên khách hàng: ");
		tenKH_t = new JTextField();
		
		sdtKH_l = new JLabel("Số điện thoại: ");
		sdtKH_t = new JTextField();
		
		menuB = new JButton("Chọn đồ uống");
		menuB.addActionListener(e -> chonDoUong());
		
		input.add(maKH_l);
		input.add(maKH_t);
		
		input.add(tenKH_l);
		input.add(tenKH_t);
		
		input.add(sdtKH_l);
		input.add(sdtKH_t);
		
		input.add(menuB);
		
		center.add(input);
		
		// table
		String[] cols = {"Mã khách hàng", "Tên khách hàng", "Số điện thoại"};
		tm = new DefaultTableModel(cols, 0);
		
		table = new JTable(tm);
		table.setBounds(30, 40, 200, 50);
		JScrollPane sp = new JScrollPane(table);
		
		Border infoC = BorderFactory.createTitledBorder("Thông tin khách hàng");
		sp.setBorder(infoC);
		
		center.add(sp);
			
		center.setBorder(p);
		add(center, BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
	}
	
	private void chonDoUong() {
		try {
			Thuc_don_GUI td = new Thuc_don_GUI();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
