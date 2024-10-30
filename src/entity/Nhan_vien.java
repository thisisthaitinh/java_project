package entity;

public class Nhan_vien {
	private String id_nhan_vien, ten_nhan_vien, dia_chi, id_quan;
	// id_quan: FK
	private int tuoi, sdt;
	private double luong;
	
	public Nhan_vien(String id_nhan_vien, String ten_nhan_vien, String dia_chi,  int tuoi, int sdt,
			double luong, String id_quan) {
		super();
		this.id_nhan_vien = id_nhan_vien;
		this.ten_nhan_vien = ten_nhan_vien;
		this.dia_chi = dia_chi;
		this.tuoi = tuoi;
		this.sdt = sdt;
		this.luong = luong;
		this.id_quan = id_quan;
	}

	public String getId_nhan_vien() {
		return id_nhan_vien;
	}

	public String getTen_nhan_vien() {
		return ten_nhan_vien;
	}

	public String getDia_chi() {
		return dia_chi;
	}

	public String getId_quan() {
		return id_quan;
	}

	public int getTuoi() {
		return tuoi;
	}

	public int getSdt() {
		return sdt;
	}

	public double getLuong() {
		return luong;
	}

	public void setId_nhan_vien(String id_nhan_vien) {
		this.id_nhan_vien = id_nhan_vien;
	}

	public void setTen_nhan_vien(String ten_nhan_vien) {
		this.ten_nhan_vien = ten_nhan_vien;
	}

	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}

	public void setId_quan(String id_quan) {
		this.id_quan = id_quan;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	@Override
	public String toString() {
		return "Nhan_vien [id_nhan_vien=" + id_nhan_vien + ", ten_nhan_vien=" + ten_nhan_vien + ", dia_chi=" + dia_chi
				+ ", id_quan=" + id_quan + ", tuoi=" + tuoi + ", sdt=" + sdt + ", luong=" + luong + "]";
	}
}
