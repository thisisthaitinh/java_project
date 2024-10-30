package entity;

public class Thuc_don {
	private String id_mon, ten_mon, id_quan;
	// id_quan: FK
	private double gia;
	
	public Thuc_don(String id_mon, String ten_mon, double gia, String id_quan) {
		super();
		this.id_mon = id_mon;
		this.ten_mon = ten_mon;
		this.gia = gia;
		this.id_quan = id_quan;
	}

	public String getId_mon() {
		return id_mon;
	}

	public String getTen_mon() {
		return ten_mon;
	}

	public double getGia() {
		return gia;
	}
	
	public String getId_quan() {
		return id_quan;
	}

	public void setId_mon(String id_mon) {
		this.id_mon = id_mon;
	}

	public void setTen_mon(String ten_mon) {
		this.ten_mon = ten_mon;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}
	
	public void setId_quan(String id_quan) {
		this.id_quan = id_quan;
	}

	@Override
	public String toString() {
		return ten_mon + " " + gia + " VND.";
	}
}
