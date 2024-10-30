package entity;

public class Quan_cafe {
	private String id_quan, ten_quan, dia_chi;
	// id_quan: PK

	public Quan_cafe(String id_quan, String ten_quan, String dia_chi) {
		super();
		this.id_quan = id_quan;
		this.ten_quan = ten_quan;
		this.dia_chi = dia_chi;
	}

	public String getId_quan() {
		return id_quan;
	}

	public String getTen_quan() {
		return ten_quan;
	}

	public String getDia_chi() {
		return dia_chi;
	}

	public void setId_quan(String id_quan) {
		this.id_quan = id_quan;
	}

	public void setTen_quan(String ten_quan) {
		this.ten_quan = ten_quan;
	}

	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}

	@Override
	public String toString() {
		return "Quan_cafe [id_quan=" + id_quan + ", ten_quan=" + ten_quan + ", dia_chi=" + dia_chi + "]";
	}
}
