package GUI;

import entity.*;
import connectDB.ConnectDB;
import DAO.*;

import java.sql.*;
import java.text.*;
import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.regex.Pattern;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.border.*;

public class dsNhanVien_GUI extends JFrame {
	private JTable table;
	private String id_quan = "QC001";
	private DefaultTableModel tableModel;
	private JPanel centerLayout, inputLayout;
	private JComboBox<String> gioitinhNV_combo;
	private DecimalFormat df = new DecimalFormat("#,###");
	private JTextField maNV_field, tenNV_field, tuoiNV_field, dcNV_field, sdtNV_field, luongNV_field, timNV_field;
	private JLabel title, maNV_label, tenNV_label, tuoiNV_label, gioitinhNV_label, dcNV_label, sdtNV_label, luongNV_label, timNV_label;
	
	public dsNhanVien_GUI() throws SQLException {
		setTitle("Quản lý thông tin nhân viên");
		setSize(1000, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		Border p = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		
		// north (title)
		title = new JLabel("THÔNG TIN NHÂN VIÊN", JLabel.CENTER);
		title.setOpaque(true);
		title.setFont(new Font("Arial", Font.BOLD, 20));
		title.setForeground(Color.BLUE);
		title.setBorder(p);
		add(title, BorderLayout.NORTH);
		
		// center
		// center layout (inputs and table)
		centerLayout = new JPanel(new GridLayout(2, 1, 5, 5));
		
		// padding for center
		centerLayout.setBorder(p);
		
		inputLayout = new JPanel(new GridLayout(7, 2, 5, 5));
		
		maNV_label = new JLabel("Mã nhân viên: ");
		maNV_field = new JTextField();
		
		maNV_field.addActionListener(e -> themNhanVien());
		
		tenNV_label = new JLabel("Tên nhân viên: ");
		tenNV_field = new JTextField();
		
		tenNV_field.addActionListener(e -> themNhanVien());
		
		tuoiNV_label = new JLabel("Tuổi: ");
		tuoiNV_field = new JTextField();
		
		tuoiNV_field.addActionListener(e -> themNhanVien());
		
		gioitinhNV_label = new JLabel("Giới tính: ");
		String gioitinh[] = {"Nam", "Nữ", "Giới tính khác"};
		gioitinhNV_combo = new JComboBox<String>(gioitinh);
		
//		gioitinhNV_combo.addActionListener(e -> themNhanVien());
//		gioitinhNV_combo.setBounds(100, 50, 150, 20);
		
		dcNV_label = new JLabel("Địa chỉ: ");
		dcNV_field = new JTextField();
		
		dcNV_field.addActionListener(e -> themNhanVien());
		
		sdtNV_label = new JLabel("Số điện thoại: ");
		sdtNV_field = new JTextField();
		
		sdtNV_field.addActionListener(e -> themNhanVien());
		
		luongNV_label = new JLabel("Lương: ");
		luongNV_field = new JTextField();
		
		luongNV_field.addActionListener(e -> themNhanVien());
		
		inputLayout.add(maNV_label);
		inputLayout.add(maNV_field);
		
		inputLayout.add(tenNV_label);
		inputLayout.add(tenNV_field);

		inputLayout.add(tuoiNV_label);
		inputLayout.add(tuoiNV_field);
		
		inputLayout.add(gioitinhNV_label);
		inputLayout.add(gioitinhNV_combo);
		
		inputLayout.add(dcNV_label);
		inputLayout.add(dcNV_field);
		
		inputLayout.add(sdtNV_label);
		inputLayout.add(sdtNV_field);
		
		inputLayout.add(luongNV_label);
		inputLayout.add(luongNV_field);
		
		centerLayout.add(inputLayout);
				
		// table
		String[] cols = {"Mã nhân viên", "Tên nhân viên", "Tuổi", "Giới tính", "Địa chỉ", "Số điện thoại", "Lương (VND)"};
		tableModel = new DefaultTableModel(cols, 0) {
			@Override
			public boolean isCellEditable(int row, int col) {
				return false; // k sua duoc cot ma nhan vien
			}
		};
		
		// LOAD EMPLOYEE DATA FROM THE DATABASE
		dsNhanVien();
		
		table = new JTable(tableModel);
		table.setRowHeight(30);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int sel = table.getSelectedRow();
				if (sel != -1) {
					maNV_field.setText((String) tableModel.getValueAt(sel, 0));
					tenNV_field.setText((String) tableModel.getValueAt(sel, 1));
					tuoiNV_field.setText((String) tableModel.getValueAt(sel, 2).toString());
					gioitinhNV_combo.setSelectedItem(tableModel.getValueAt(sel, 3));
					dcNV_field.setText((String) tableModel.getValueAt(sel, 4));
					sdtNV_field.setText((String) unformatNum(tableModel.getValueAt(sel, 5).toString()));
					luongNV_field.setText((String) unformatNum(tableModel.getValueAt(sel, 6).toString()));
				}
			}
		});
		
//		adjustTableColSize(table);
		
		JScrollPane sp = new JScrollPane(table);
		Border b1 = BorderFactory.createTitledBorder("Danh sách nhân viên");
		sp.setBorder(b1);
		
		centerLayout.add(sp);
		
		add(centerLayout, BorderLayout.CENTER);
		
		// south layout (find eID and buttons)
		JPanel southLayout = new JPanel(new GridLayout(1, 2, 5, 5));
		
		// find eID
		JPanel findLayout = new JPanel();
		timNV_label = new JLabel("Nhập mã số cần tìm: ");
		timNV_field = new JTextField(20);
		timNV_field.addActionListener(e -> timNhanVien());
		
		JButton findB = new JButton("Tìm");
		findB.addActionListener(e -> timNhanVien());
		
		findLayout.add(timNV_label);
		findLayout.add(timNV_field);
		findLayout.add(findB);
		
		southLayout.add(findLayout);
		
		// buttons
		JPanel bLayout = new JPanel();
		JButton addB = new JButton("Thêm");
		
		addB.addActionListener(e -> themNhanVien());
		
		JButton clearB = new JButton("Xóa trắng");
		clearB.addActionListener(e -> xoaInput());
	
		JButton deleteB = new JButton("Xóa");
		deleteB.addActionListener(e -> xoaNhanVien());
		
		JButton updateB = new JButton("Cập nhật");
		updateB.addActionListener(e -> capNhatNhanVien());
		
		bLayout.add(addB);
		bLayout.add(clearB);
		bLayout.add(deleteB);
		bLayout.add(updateB);
		
		southLayout.add(bLayout);
				
		add(southLayout, BorderLayout.SOUTH);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	// HIEN THI DANH SACH NHAN VIEN
	private void dsNhanVien() {
		try (Connection c = ConnectDB.getConnection()) {
			Nhan_vien_DAO nvDAO = new Nhan_vien_DAO(c);
			List<Nhan_vien> nv = nvDAO.danhSachNhanVien();
			
			for (Nhan_vien n : nv) {
				tableModel.addRow(new Object[] {
						n.getId_nhan_vien(),
						n.getTen_nhan_vien(),
						n.getTuoi(),
						n.getGioi_tinh(),
						n.getDia_chi(),
						formatNum(n.getSdt()),
						df.format(n.getLuong())
				});
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// KIEM TRA THONG TIN NHAN VIEN CO HOP LE?
	private boolean kiemTraThongTin(String nvID, String nvTen, String nvTuoi, String nvGT, String nvDC, String nvSDT, String nvLuong) {
		// REGULAR EXPRESSIONS
		String nvID_p = "^[A-Z]{2}[\\d]{3}$";
//		String nvTen_p = "^[A-Za-z\\s']+$";
		
		Pattern nvID_r = Pattern.compile(nvID_p);
//		Pattern nvTen_r = Pattern.compile(nvTen_p);
		
		// KIEM TRA INPUT
		if (kiemTraInput(nvID, nvTen, nvTuoi, nvDC, nvSDT, nvLuong)) {
			JOptionPane.showMessageDialog(this, "Thông tin nhân viên không được để trống.");
			return false;
		} else {
			// KIEM TRA MA NHAN VIEN
			if (!nvID_r.matcher(nvID).matches()) {
				JOptionPane.showMessageDialog(this, "Mã nhân viên phải ở dạng NV-XXX.");
				return false;
			} else if (kiemTraTrungNVID(nvID)) {
				JOptionPane.showMessageDialog(this, "Mã nhân viên bạn đã nhập đã có trong database. Hãy thử lại.");
				return false;
			}
			
//			// KIEM TRA TEN NHAN VIEN
//			if (!nvTen_r.matcher(nvTen).matches()) {
//				JOptionPane.showMessageDialog(this, "Sai định dạng tên. Hãy thử lại.");
//				return false;
//			}
			
			// KIEM TRA TUOI NHAN VIEN
			if (!isInteger(nvTuoi)) {
				JOptionPane.showMessageDialog(this, "Sai định dạng tuổi. Hãy thử lại.");
				return false;
			} else if (!kiemTraTuoiNV(nvTuoi)) {
				JOptionPane.showMessageDialog(this, "Nhân viên phải từ 18 đến 60 tuổi.");
				return false;
			}
			
			// KIEM TRA SO DIEN THOAI NHAN VIEN
			if (!isInteger(nvSDT)) {
				JOptionPane.showMessageDialog(this, "Sai định dạng số điện thoại. Hãy thử lại.");
				return false;
			}
			
			// KIEM TRA LUONG NHAN VIEN
			if (!isInteger(nvLuong)) {
				JOptionPane.showMessageDialog(this, "Sai định dạng lương. Hãy thử lại.");
				return false;
			} 
		}
		return true;
	}
	
	// KIEM TRA TUOI NHAN VIEN
	private boolean kiemTraTuoiNV(String nvTuoi) {
		int age = Integer.parseInt(nvTuoi);
		return (age >= 18 && age <= 60) ? true : false;
	}
	
	// KIEM TRA THONG TIN CO BO TRONG KHONG?
	private boolean kiemTraInput(String nvID, String nvTen, String nvTuoi, String nvDC, String nvSDT, String nvLuong) {
		return (nvID.isEmpty() || nvTen.isEmpty() || nvTuoi.isEmpty() || nvDC.isEmpty() || nvSDT.isEmpty() || nvLuong.isEmpty()) ? true : false;
	}
	
	// KIEM TRA MA NHAN VIEN CO TRUNG HAY KHONG?
	private boolean kiemTraTrungNVID(String nvID) {
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			if (tableModel.getValueAt(i, 0).equals(nvID)) {
				return true;
			}
		}
		return false;
	}
	
	// THEM THONG TIN NHAN VIEN
	private void themNhanVien() {				
		String nvID = maNV_field.getText();
		String nvTen = tenNV_field.getText();
		String nvTuoi = tuoiNV_field.getText();
		String nvDC = dcNV_field.getText();
		String nvSDT = sdtNV_field.getText();
		String nvLuong = luongNV_field.getText();
		String nvGT = gioitinhNV_combo.getSelectedItem().toString();
		
		
		if (kiemTraThongTin(nvID, nvTen, nvTuoi, nvGT, nvDC, nvSDT, nvLuong)) {
			int sdt = Integer.parseInt(nvSDT);
			double luong = Double.parseDouble(nvLuong);
			
			try (Connection c = ConnectDB.getConnection()) {
				Nhan_vien_DAO nvDAO = new Nhan_vien_DAO(c);
				Nhan_vien nv = new Nhan_vien(nvID, nvTen, Integer.parseInt(nvTuoi), nvGT, nvDC, sdt, luong, id_quan);
				boolean success = nvDAO.themNhanVien(nv);
				
				if (success) {
					String[] employeeData = {
							nv.getId_nhan_vien(),
							nv.getTen_nhan_vien(),
							String.valueOf(nv.getTuoi()),
							nv.getGioi_tinh(),
							nv.getDia_chi(),
							formatNum(nv.getSdt()),
							df.format(nv.getLuong())
					};
					tableModel.addRow(employeeData);
					JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công!");
					xoaInput();
				} else {
					JOptionPane.showMessageDialog(this, "Không thêm được nhân viên. Hãy thử lại.");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	
	// XOA INPUT
	private void xoaInput() {
		maNV_field.setText("");
		tenNV_field.setText("");
		tuoiNV_field.setText("");
		dcNV_field.setText("");
		sdtNV_field.setText("");
		luongNV_field.setText("");
		gioitinhNV_combo.setSelectedIndex(0);
		
		maNV_field.requestFocus();
	}
	
	// XOA THONG TIN NHAN VIEN
	private void xoaNhanVien() {
		int sel = table.getSelectedRow();
		if (sel != -1) {
			int conf = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa chứ?", "Xóa thông tin nhân viên", JOptionPane.YES_NO_OPTION);
			if (conf == JOptionPane.YES_OPTION) {
				String nvID = (String)tableModel.getValueAt(sel, 0);
				try (Connection c = ConnectDB.getConnection()) {
					Nhan_vien_DAO nvDAO = new Nhan_vien_DAO(c);
					boolean success = nvDAO.xoaNhanVien(nvID);
					
					if (success) {
						tableModel.removeRow(sel);
						JOptionPane.showMessageDialog(this, "Xóa thông tin nhân viên thành công!");
						xoaInput();
					} else {
						JOptionPane.showMessageDialog(this, "Không xóa được nhân viên. Hãy thử lại.");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần xóa.");
		}
	}
	
	// CAP NHAT THONG TIN NHAN VIEN
	private void capNhatNhanVien() {
		int sel = table.getSelectedRow();
		
		if (sel != -1) {
			String nvID = maNV_field.getText();
			String nvTen = tenNV_field.getText();
			String nvTuoi = tuoiNV_field.getText();
			String nvDC = dcNV_field.getText();
			String nvSDT = sdtNV_field.getText();
			String nvLuong = luongNV_field.getText();
			String nvGT = gioitinhNV_combo.getSelectedItem().toString();
						
			int tuoi = Integer.parseInt(nvTuoi);
			int sdt = Integer.parseInt(nvSDT);
			double luong = Double.parseDouble(nvLuong);
			
			try (Connection c = ConnectDB.getConnection()) {
				Nhan_vien_DAO nvDAO = new Nhan_vien_DAO(c);
				Nhan_vien nv = new Nhan_vien(nvID, nvTen, tuoi, nvGT, nvDC, sdt, luong, id_quan);
				boolean success = nvDAO.suaNhanVien(nv);
				
				if (success) {
					tableModel.setValueAt(nvTen, sel, 1);
					tableModel.setValueAt(nvTuoi, sel, 2);
					tableModel.setValueAt(nvGT, sel, 3);
					tableModel.setValueAt(nvDC, sel, 4);
					tableModel.setValueAt(formatNum(sdt), sel, 5);
					tableModel.setValueAt(df.format(luong), sel, 6);
					
					JOptionPane.showMessageDialog(this, "Cập nhật thông tin nhân viên thành công.");
					xoaInput();
				} else {
					JOptionPane.showMessageDialog(this, "Không cập nhật được nhân viên. Hãy thử lại.");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần cập nhật thông tin.");
		}
	}
	
	// TIM THONG TIN NHAN VIEN
	private void timNhanVien() {
		String nvID = timNV_field.getText();
		boolean found = false;
		if (nvID.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên bạn cần tìm.");
			return;
		} else {
			try (Connection c = ConnectDB.getConnection()) {
				Nhan_vien_DAO nvDAO = new Nhan_vien_DAO(c);
				Nhan_vien nv = nvDAO.timNhanVien(nvID);
				
				if (nv != null) {
					String[] employeeData = {
							nv.getId_nhan_vien(),
							nv.getTen_nhan_vien(),
							String.valueOf(nv.getTuoi()),
							nv.getGioi_tinh(),
							nv.getDia_chi(),
							formatNum(nv.getSdt()),
							df.format(nv.getLuong())
					};
					tableModel.setRowCount(0);
					tableModel.addRow(employeeData);
					found = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!found) {
			JOptionPane.showMessageDialog(this, "Không có thông tin nhân viên bạn đang tìm kiếm.");
			
			timNV_field.setText("");
			timNV_field.requestFocus();
			
			tableModel.setRowCount(0);
			dsNhanVien();			
		}
	}
	
	
	// CAC FORMAT KHAC
	// CHINH KICH THUOC TABLE
//	private void adjustTableColSize(JTable table) {
//		int[] size = {5, 50, 1, 1, 100, 10, 10};
//		
//		for (int i = 0; i < tableModel.getColumnCount(); i++) {
//			table.getColumnModel().getColumn(i).setPreferredWidth(size[i]);
//		}
//	}
	
	// FORMAT SO DIEN THOAI
	private static String formatNum(int num) {
		String num_str = String.format("%010d", num);
		return num_str.substring(0, 4) + " " + num_str.substring(4, 7) + " " + num_str.substring(7);
	}
	
	// REMOVE SPACE FROM PHONE NUMBER
	private static String unformatNum(String num) {
		return num.replaceAll("[\\s\\.]", "");
	}
	
	// KIEM TRA SDT VA LUONG NHAN VIEN
	private static boolean isInteger(String num) {
		try {
			Integer.parseInt(num);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
