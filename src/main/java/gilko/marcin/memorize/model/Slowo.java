package gilko.marcin.memorize.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "memo_slowo")
public class Slowo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_slowa;
	
	private String slowo;
	private String tlumaczenie;
	private String rodzaj;
	private String dzwiek;
	
	public Slowo() {};
	
	public Slowo(Long id_slowa, String slowo, String tlumaczenie, String rodzaj, String dzwiek) {
		this.id_slowa = id_slowa;
		this.slowo = slowo;
		this.tlumaczenie = tlumaczenie;
		this.rodzaj = rodzaj;
		this.dzwiek = dzwiek;
		
	}
	
	@Override
	public String toString() {
		return "id_slowa: " + id_slowa + ", slowo: " + slowo + ", tlumaczenie: " + tlumaczenie + ", rodzaj: " +
				rodzaj + ", dzwiek: " + dzwiek;
	}
	
	public Long getId_slowa() {
		return id_slowa;
	}
	public void setId_slowa(Long id_slowa) {
		this.id_slowa = id_slowa;
	}
	
	public String getSlowo() {
		return slowo;
	}
	public void setSlowo(String slowo) {
		this.slowo = slowo;
	}
	public String getTlumaczenie() {
		return tlumaczenie;
	}
	public void setTlumaczenie(String tlumaczenie) {
		this.tlumaczenie = tlumaczenie;
	}
	public String getRodzaj() {
		return rodzaj;
	}
	public void setRodzaj(String rodzaj) {
		this.rodzaj = rodzaj;
	}
	public String getDzwiek() {
		return dzwiek;
	}
	public void setDzwiek(String dzwiek) {
		this.dzwiek = dzwiek;
	}
}
