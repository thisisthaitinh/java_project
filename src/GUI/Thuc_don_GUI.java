package GUI;

import entity.*;
import connectDB.ConnectDB;
import DAO.*;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class Thuc_don_GUI extends JFrame {
	private JTable t;
	private DefaultTableModel tm;
	private JTextArea tong_order;
	private JLabel title;
	private List<Thuc_don> don;
	
	public Thuc_don_GUI() throws SQLException {
		setTitle("Chương trình chọn đồ uống");
		setSize(800, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		Border p = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		
		// title
		title = new JLabel("DANH SÁCH ĐỒ UỐNG", JLabel.CENTER);
		title.setOpaque(true);
		title.setFont(new Font("Inter", Font.BOLD, 20));
		title.setForeground(Color.BLUE);
		
		title.setBorder(p);
		
		add(title, BorderLayout.NORTH);
		
		// drinks table
		String[] cols = {"Mã đồ uống", "Tên đồ uống", "Giá"};
		tm = new DefaultTableModel(cols, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		danhSachDoUong();
		t = new JTable(tm);
		
		// padding
		t.setRowHeight(50);
		
		JScrollPane sp = new JScrollPane(t);
		
		sp.setBorder(p);
		
		add(sp, BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void danhSachDoUong() {
		try (Connection c = ConnectDB.getConnection()) {
			Thuc_don_DAO tdDAO = new Thuc_don_DAO(c);
			List<Thuc_don> td = tdDAO.getAllThucDon();
			
			for (Thuc_don t : td) {
				tm.addRow(new Object[] {
						t.getId_mon(),
						t.getTen_mon(),
						t.getGia(),
				});
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
