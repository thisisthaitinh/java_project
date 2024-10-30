package entity;

public class Thanh_toan {
	private String id_thanh_toan, id_khach_hang, id_hoa_don, pt_thanh_toan, ngay_thanh_toan;
	// id_khach_hang, id_hoa_don: FKs
	private double tong_so_tien;
	
	public Thanh_toan(String id_thanh_toan, double tong_so_tien, String pt_thanh_toan,
			String ngay_thanh_toan, String id_khach_hang, String id_hoa_don) {
		super();
		this.id_thanh_toan = id_thanh_toan;
		this.tong_so_tien = tong_so_tien;
		this.pt_thanh_toan = pt_thanh_toan;
		this.ngay_thanh_toan = ngay_thanh_toan;
		this.id_khach_hang = id_khach_hang;
		this.id_hoa_don = id_hoa_don;
	}

	public String getId_thanh_toan() {
		return id_thanh_toan;
	}

	public String getId_khach_hang() {
		return id_khach_hang;
	}

	public String getId_hoa_don() {
		return id_hoa_don;
	}

	public String getPt_thanh_toan() {
		return pt_thanh_toan;
	}

	public String getNgay_thanh_toan() {
		return ngay_thanh_toan;
	}

	public double getTong_so_tien() {
		return tong_so_tien;
	}

	public void setId_thanh_toan(String id_thanh_toan) {
		this.id_thanh_toan = id_thanh_toan;
	}

	public void setId_khach_hang(String id_khach_hang) {
		this.id_khach_hang = id_khach_hang;
	}

	public void setId_hoa_don(String id_hoa_don) {
		this.id_hoa_don = id_hoa_don;
	}

	public void setPt_thanh_toan(String pt_thanh_toan) {
		this.pt_thanh_toan = pt_thanh_toan;
	}

	public void setNgay_thanh_toan(String ngay_thanh_toan) {
		this.ngay_thanh_toan = ngay_thanh_toan;
	}

	public void setTong_so_tien(double tong_so_tien) {
		this.tong_so_tien = tong_so_tien;
	}

	@Override
	public String toString() {
		return "Thanh_toan [id_thanh_toan=" + id_thanh_toan + ", id_khach_hang=" + id_khach_hang + ", id_hoa_don="
				+ id_hoa_don + ", pt_thanh_toan=" + pt_thanh_toan + ", ngay_thanh_toan=" + ngay_thanh_toan
				+ ", tong_so_tien=" + tong_so_tien + "]";
	}
}
