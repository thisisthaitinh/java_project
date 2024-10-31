package GUI;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

public class quanCafe_GUI extends JFrame {	
	public quanCafe_GUI() {
		super("Quản lý quán cafe");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// title
		JLabel title = new JLabel("CHƯƠNG TRÌNH QUẢN LÝ QUÁN CAFE", JLabel.CENTER);
		title.setOpaque(true);
		title.setFont(new Font("Arial", Font.BOLD, 35));
		title.setForeground(Color.BLUE);
		
		Border p = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		title.setBorder(p);
		
		add(title, BorderLayout.NORTH);
		
		// center
		JPanel center = new JPanel(new GridLayout(5, 1, 5, 5));
		
		// admin panel
		JLabel employeeManager = header("ADMIN");
		JPanel employeeManagerButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		// admin buttons
		JButton employeeInfoB = new JButton("Danh sách nhân viên");
		employeeInfoB.addActionListener(e -> dsNhanVien());
		JButton menuInfoB = new JButton("Danh sách đồ uống");
		JButton customerInfoB = new JButton("Thông tin khách hàng");
		JButton billInfoB = new JButton("Thông tin hóa đơn");
		JButton paymentInfoB = new JButton("Chi tiết thanh toán");
		
		employeeManagerButtons.add(employeeInfoB);
		employeeManagerButtons.add(menuInfoB);
		employeeManagerButtons.add(customerInfoB);
		employeeManagerButtons.add(billInfoB);
		employeeManagerButtons.add(paymentInfoB);
		
		// employee panel
		JLabel employee_l = header("NHÂN VIÊN");
		JPanel employeeButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		// employee buttons
		JButton takeOrderB = new JButton("Nhận order từ khách hàng");
		takeOrderB.addActionListener(e -> nhanOrder());
		JButton exportBillB = new JButton("Xuất hóa đơn");
		
		employeeButtons.add(takeOrderB);
		employeeButtons.add(exportBillB);
		
		center.add(employeeManager);
		center.add(employeeManagerButtons);
		center.add(employee_l);
		center.add(employeeButtons);
		center.setBorder(p);
		
		add(center, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
	}
	
	// admin methods
	private void dsNhanVien() {
		try {
			dsNhanVien_GUI dsnv = new dsNhanVien_GUI();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// employee methods
	private void nhanOrder() {
		try {
			nhanOrder_GUI td = new nhanOrder_GUI();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// title
	public JLabel header(String s) {
		JLabel t = new JLabel(s);
		t.setOpaque(true);
		t.setFont(new Font("Arial", Font.PLAIN, 25));
		t.setForeground(Color.BLUE);
		return t;
	}
}
