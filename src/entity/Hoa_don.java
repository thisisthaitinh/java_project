package entity;

public class Hoa_don {
	private String id_hoa_don, id_khach_hang, id_thanh_toan, id_quan;
	// id_khach_hang, id_thanh_toan, id_quan: FKs
	private double tong_so_tien;
	
	public Hoa_don(String id_hoa_don, double tong_so_tien, String id_khach_hang, String id_thanh_toan, String id_quan) {
		super();
		this.id_hoa_don = id_hoa_don;
		this.tong_so_tien = tong_so_tien;
		this.id_khach_hang = id_khach_hang;
		this.id_thanh_toan = id_thanh_toan;
		this.id_quan = id_quan;
	}

	public String getId_hoa_don() {
		return id_hoa_don;
	}

	public String getId_khach_hang() {
		return id_khach_hang;
	}

	public String getId_thanh_toan() {
		return id_thanh_toan;
	}

	public String getId_quan() {
		return id_quan;
	}

	public double getTong_so_tien() {
		return tong_so_tien;
	}

	public void setId_hoa_don(String id_hoa_don) {
		this.id_hoa_don = id_hoa_don;
	}

	public void setId_khach_hang(String id_khach_hang) {
		this.id_khach_hang = id_khach_hang;
	}

	public void setId_thanh_toan(String id_thanh_toan) {
		this.id_thanh_toan = id_thanh_toan;
	}

	public void setId_quan(String id_quan) {
		this.id_quan = id_quan;
	}

	public void setTong_so_tien(double tong_so_tien) {
		this.tong_so_tien = tong_so_tien;
	}

	@Override
	public String toString() {
		return "Hoa_don [id_hoa_don=" + id_hoa_don + ", id_khach_hang=" + id_khach_hang + ", id_thanh_toan="
				+ id_thanh_toan + ", id_quan=" + id_quan + ", tong_so_tien=" + tong_so_tien + "]";
	}	
}
