package gilko.marcin.memorize.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "memo_nauka")
public class Nauka {
	@Id
	private Long pozycja;
	private Long id_slowa;
	private boolean czy_umiem;
	private Double wspolczynnik_powtorek;
	
	public Nauka() {};
	
	public Nauka(Long pozycja, Long id_slowa, boolean czy_umiem, Double wspolczynnik_powtorek) {
		this.pozycja = pozycja;
		this.id_slowa = id_slowa;
		this.czy_umiem = czy_umiem;
		this.wspolczynnik_powtorek = wspolczynnik_powtorek;
	}
	
	@Override
	public String toString() {
		return "pozycja: " + pozycja + ", id_slowa: " + id_slowa + ", czy_umiem: " + czy_umiem +
				", wspolczynnik_powtorek: " + wspolczynnik_powtorek;
	}
	public Long getPozycja() {
		return pozycja;
	}
	
	public void setPozycja(Long pozycja) {
		this.pozycja = pozycja;
	}

	public Long getId_slowa() {
		return id_slowa;
	}

	public void setId_slowa(Long id_slowa) {
		this.id_slowa = id_slowa;
	}

	public boolean getCzy_umiem() {
		return czy_umiem;
	}

	public void setCzy_umiem(boolean czy_umiem) {
		this.czy_umiem = czy_umiem;
	}

	public Double getWspolczynnik_powtorek() {
		return wspolczynnik_powtorek;
	}

	public void setWspolczynnik_powtorek(Double wspolczynnik_powtorek) {
		this.wspolczynnik_powtorek = wspolczynnik_powtorek;
	}
}
