package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import entity.*;

public class Quan_cafe_DAO {
	private Connection c;
	
	public Quan_cafe_DAO(Connection c) {
		this.c = c;
	}
	
	public void them_QuanCafe(Quan_cafe qc) throws SQLException {
		String sql = "INSERT INTO QUAN_CAFE (ID_QUAN, TEN_QUAN, DIA_CHI) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = c.prepareStatement(sql)) {
			stmt.setString(1, qc.getId_quan());
			stmt.setString(2, qc.getTen_quan());
			stmt.setString(3, qc.getDia_chi());
			stmt.executeUpdate();
		}
	}
	
	// them nhan vien
	public void them_NhanVien(Nhan_vien nv) throws SQLException {
		String sql = "INSERT INTO NHAN_VIEN (ID_NHAN_VIEN, TEN_NHAN_VIEN, TUOI, DIA_CHI, SDT, LUONG, ID_QUAN) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = c.prepareStatement(sql)) {
			stmt.setString(1, nv.getId_nhan_vien());
			stmt.setString(2, nv.getTen_nhan_vien());
			stmt.setInt(3, nv.getTuoi());
			stmt.setString(4, nv.getDia_chi());
			stmt.setInt(5, nv.getSdt());
			stmt.setDouble(6, nv.getLuong());
			stmt.setString(7, nv.getId_quan());
			
			stmt.executeUpdate();
		}
	}
	
	// xoa nhan vien
	public void xoa_NhanVien(String id_nv) throws SQLException {
		String sql = "DELETE FROM NHAN_VIEN WHERE ID_NHAN_VIEN = ?";
		try (PreparedStatement stmt = c.prepareStatement(sql)) {
			stmt.setString(1, id_nv);
			stmt.executeUpdate();
		}
	}
	
	// 
}
