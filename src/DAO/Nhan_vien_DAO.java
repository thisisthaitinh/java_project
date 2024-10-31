package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import entity.Nhan_vien;

public class Nhan_vien_DAO {
	private Connection c;
	private String id_quan = "QC001";
	
	public Nhan_vien_DAO(Connection co) {
		this.c = co;
	}
	
	// FETCH THONG TIN NHAN VIEN TU DATABASE
	public List<Nhan_vien> danhSachNhanVien() throws SQLException {
		List<Nhan_vien> list = new ArrayList<>();
		String sql = "SELECT * FROM NHAN_VIEN";
		
		try (Statement stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				list.add(new Nhan_vien(rs.getString("ID_NHAN_VIEN"), rs.getString("TEN_NHAN_VIEN"), Integer.parseInt(rs.getString("TUOI")), rs.getString("GIOI_TINH"), rs.getString("DIA_CHI"), Integer.parseInt(rs.getString("SDT")), Double.parseDouble(rs.getString("LUONG")), rs.getString("ID_QUAN")));
			}
		}
		return list;
	}
	
	// THEM THONG TIN NHAN VIEN VAO DATABASE
	public boolean themNhanVien(Nhan_vien nv) {
		String sql = "INSERT INTO NHAN_VIEN(ID_NHAN_VIEN, TEN_NHAN_VIEN, TUOI, GIOI_TINH, DIA_CHI, SDT, LUONG, ID_QUAN) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try (PreparedStatement stmt = c.prepareStatement(sql)) {
			stmt.setString(1, nv.getId_nhan_vien());
			stmt.setString(2, nv.getTen_nhan_vien());
			stmt.setInt(3, nv.getTuoi());
			stmt.setString(4, nv.getGioi_tinh());
			stmt.setString(5, nv.getDia_chi());
			stmt.setInt(6, nv.getSdt());
			stmt.setDouble(7, nv.getLuong());
			stmt.setString(8, id_quan);
			
			int row = stmt.executeUpdate();
			return row > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// XOA THONG TIN NHAN VIEN TRONG DATABASE
	public boolean xoaNhanVien(String id_nv) {
		String sql = "DELETE FROM NHAN_VIEN WHERE ID_NHAN_VIEN = ?";
		try (PreparedStatement stmt = c.prepareStatement(sql)) {
			stmt.setString(1, id_nv);
			int row = stmt.executeUpdate();
			return row > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// CAP NHAT THONG TIN NHAN VIEN
	public boolean suaNhanVien(Nhan_vien nv) {
		String sql = "UPDATE NHAN_VIEN SET TEN_NHAN_VIEN = ?, TUOI = ?, GIOI_TINH = ?, DIA_CHI = ?, SDT = ?, LUONG = ? WHERE ID_NHAN_VIEN = ?";
		try (PreparedStatement stmt = c.prepareStatement(sql)) {
			stmt.setString(1, nv.getTen_nhan_vien());
			stmt.setInt(2, nv.getTuoi());
			stmt.setString(3, nv.getGioi_tinh());
			stmt.setString(4, nv.getDia_chi());
			stmt.setInt(5, nv.getSdt());
			stmt.setDouble(6, nv.getLuong());
			stmt.setString(7, nv.getId_nhan_vien());
			
			int row = stmt.executeUpdate();
			return row > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// TIM THONG TIN NHAN VIEN
	public Nhan_vien timNhanVien(String nvID) {
		String sql = "SELECT * FROM NHAN_VIEN WHERE ID_NHAN_VIEN = ?";
		try (PreparedStatement stmt = c.prepareStatement(sql)) {
			stmt.setString(1, nvID);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Nhan_vien(
							rs.getString("ID_NHAN_VIEN"), 
							rs.getString("TEN_NHAN_VIEN"), 
							Integer.parseInt(rs.getString("TUOI")), 
							rs.getString("GIOI_TINH"), 
							rs.getString("DIA_CHI"), 
							Integer.parseInt(rs.getString("SDT")), 
							Double.parseDouble(rs.getString("LUONG")),
							rs.getString("ID_QUAN"));		
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
