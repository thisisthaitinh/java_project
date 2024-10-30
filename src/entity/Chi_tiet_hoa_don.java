package entity;

public class Chi_tiet_hoa_don {
	private String id_hoa_don, ten_mon, id_mon;
	// id_mon: FKs
	private int so_luong;
	private double gia;
	
	public Chi_tiet_hoa_don(String id_hoa_don, String ten_mon, int so_luong, double gia, String id_mon) {
		super();
		this.id_hoa_don = id_hoa_don;
		this.ten_mon = ten_mon;
		this.so_luong = so_luong;
		this.gia = gia;
		this.id_mon = id_mon;
	}
	
	public String getId_hoa_don() {
		return id_hoa_don;
	}
	public String getTen_mon() {
		return ten_mon;
	}
	public String getId_mon() {
		return id_mon;
	}
	public int getSo_luong() {
		return so_luong;
	}
	public double getGia() {
		return gia;
	}
	public void setId_hoa_don(String id_hoa_don) {
		this.id_hoa_don = id_hoa_don;
	}
	public void setTen_mon(String ten_mon) {
		this.ten_mon = ten_mon;
	}
	public void setId_mon(String id_mon) {
		this.id_mon = id_mon;
	}
	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	
	@Override
	public String toString() {
		return "Chi_tiet_hoa_don [id_hoa_don=" + id_hoa_don + ", ten_mon=" + ten_mon + ", id_mon=" + id_mon
				+ ", so_luong=" + so_luong + ", gia=" + gia + "]";
	}
}
