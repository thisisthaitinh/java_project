package DAO;

import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
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
}
