package entity;

public class Khach_hang {
	private String id_khach_hang, ten_khach_hang, id_quan;
	// id_quan: FK
	private int sdt;
	
	public Khach_hang(String id_khach_hang, String ten_khach_hang, int sdt, String id_quan) {
		super();
		this.id_khach_hang = id_khach_hang;
		this.ten_khach_hang = ten_khach_hang;
		this.sdt = sdt;
		this.id_quan = id_quan;
	}

	public String getId_khach_hang() {
		return id_khach_hang;
	}

	public String getTen_khach_hang() {
		return ten_khach_hang;
	}

	public String getId_quan() {
		return id_quan;
	}

	public int getSdt() {
		return sdt;
	}

	public void setId_khach_hang(String id_khach_hang) {
		this.id_khach_hang = id_khach_hang;
	}

	public void setTen_khach_hang(String ten_khach_hang) {
		this.ten_khach_hang = ten_khach_hang;
	}

	public void setId_quan(String id_quan) {
		this.id_quan = id_quan;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}

	@Override
	public String toString() {
		return "Khach_hang [id_khach_hang=" + id_khach_hang + ", ten_khach_hang=" + ten_khach_hang + ", id_quan="
				+ id_quan + ", sdt=" + sdt + "]";
	}
}
