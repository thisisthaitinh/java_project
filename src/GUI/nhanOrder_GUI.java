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

public class nhanOrder_GUI extends JFrame {
	private JLabel title, maKH_l, tenKH_l, sdtKH_l, doUong_l, thanhToan_l, soLuong_l, total_l;
	private JTextField maKH_t, tenKH_t, sdtKH_t, soLuong_t, total_t;
	private JComboBox<String> thanhToan_combo;
	private JTable t;
	private DefaultTableModel tm;
	private JTextArea tong_order;
	private List<Thuc_don> don;
	
	public nhanOrder_GUI() throws SQLException {
		setTitle("^_^");
		setSize(1000, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		Border p = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		
		// title
		title = new JLabel("NHẬN ORDER TỪ KHÁCH HÀNG", JLabel.CENTER);
		title.setOpaque(true);
		title.setFont(new Font("Inter", Font.BOLD, 20));
		title.setForeground(Color.BLUE);
		
		title.setBorder(p);
		
		add(title, BorderLayout.NORTH);
		
		// center
		JPanel center = new JPanel(new GridLayout(2, 1, 5, 5));
		// input
		JPanel input = new JPanel(new GridLayout(4, 2, 5, 5));
		
		maKH_l = new JLabel("Mã khách hàng");
		maKH_t = new JTextField();
		
		tenKH_l = new JLabel("Tên khách hàng");
		tenKH_t = new JTextField();
		
		sdtKH_l = new JLabel("Số điện thoại");
		sdtKH_t = new JTextField();
		
		thanhToan_l = new JLabel("Chọn phương thức thanh toán");
		String[] tt_combo = {"Tiền mặt", "Quét mã QR", "Thẻ tín dụng"};
		thanhToan_combo = new JComboBox<String>(tt_combo);
		
		input.add(maKH_l);
		input.add(maKH_t);
		input.add(tenKH_l);
		input.add(tenKH_t);
		input.add(sdtKH_l);
		input.add(sdtKH_t);
		input.add(thanhToan_l);
		input.add(thanhToan_combo);
	
		// drinks table
		Border tb = BorderFactory.createTitledBorder("Danh sách đồ uống");
		
		String[] cols = {"Tên đồ uống", "Giá (VND)"};
		tm = new DefaultTableModel(cols, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		danhSachDoUong();
		
		t = new JTable(tm);
		
		// mouse listener
		t.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int sel = t.getSelectedRow();
					if (sel != -1) {
						double price = (double) tm.getValueAt(sel, 1);
						soLuongDoUong(price);
					}
				}
			}
		}); 
		// padding
		t.setRowHeight(50);
		
		JScrollPane sp = new JScrollPane(t);
		sp.setBorder(tb);
		
		center.add(input);
		center.add(sp);
		
		center.setBorder(p);
		
		add(center, BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void danhSachDoUong() {
		try (Connection c = ConnectDB.getConnection()) {
			Thuc_don_DAO tdDAO = new Thuc_don_DAO(c);
			List<Thuc_don> td = tdDAO.getAllThucDon();
			
			for (Thuc_don t : td) {
				tm.addRow(new Object[] {
						t.getTen_mon(),
						t.getGia(),
				});
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// so luong do uong can order
	private static void soLuongDoUong(double price) {
		JDialog jd = new JDialog();
		jd.setTitle("Nhập số lượng");
		
		Border p = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		
		JPanel jp = new JPanel(new GridLayout(4, 2, 5, 5));
		
		JLabel sl = new JLabel("Số lượng");
		JTextField sl_f = new JTextField();
		
		JLabel tt = new JLabel("Tổng số tiền: 0 VND");
		sl_f.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					int so_luong = Integer.parseInt(sl_f.getText());
					double total = price * so_luong;
					tt.setText("Tổng số tiền: " + total + " VND");
				} catch (NumberFormatException ex) {
					tt.setText("Số lượng không hợp lệ.");
				}
			}
		});
		
		// button layout
		JPanel bl = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton okB = new JButton("OK");
		okB.addActionListener(e -> jd.dispose());
		JButton ccB = new JButton("Hủy");
		ccB.addActionListener(e -> jd.dispose());
		
		bl.add(okB);
		bl.add(ccB);
		
		jp.add(sl);
		jp.add(sl_f);
		jp.add(tt);
		jp.add(bl);
		jd.add(jp);
		
		jp.setBorder(p);
		
		jd.setSize(400, 200);
		jd.setLocationRelativeTo(null);
		jd.setVisible(true);
	}
	
}
