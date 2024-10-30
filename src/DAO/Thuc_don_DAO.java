package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import entity.*;

public class Thuc_don_DAO {
	private Connection c;
	
	public Thuc_don_DAO(Connection c) {
		this.c = c;
	}
	
	// danh sach do uong
	public List<Thuc_don> getAllThucDon() throws SQLException {
		List<Thuc_don> list = new ArrayList<>();
		String sql = "SELECT * FROM THUC_DON";
		
		try (Statement stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				list.add(new Thuc_don(rs.getString("ID_MON"), rs.getString("TEN_MON"), rs.getDouble("GIA"), rs.getString("ID_QUAN")));
			}
		}
		return list;
	}
}
