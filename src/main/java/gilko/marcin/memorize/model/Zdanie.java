package gilko.marcin.memorize.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "memo_zdanie")
public class Zdanie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_zdania;
	private String zdanie_angielskie;
	private String zdanie_polskie;
	private String dzwiek;
	@ManyToOne(
			fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_slowa", nullable = false)
	private Slowo slowo;
	
	public Zdanie() {}
	public Zdanie(Long id_zdania, String zdanie_angielskie, String zdanie_polskie, String dzwiek) {
		this.id_zdania = id_zdania;
		this.zdanie_angielskie = zdanie_angielskie;
		this.zdanie_polskie = zdanie_polskie;
		this.dzwiek = dzwiek;
	}
	
	public Long getId_zdania() {
		return id_zdania;
	}
	public void setId_zdania(Long id_zdania) {
		this.id_zdania = id_zdania;
	}
	
	public String getZdanie_angielskie() {
		return zdanie_angielskie;
	}
	public void setZdanie_angielskie(String zdanie_angielskie) {
		this.zdanie_angielskie = zdanie_angielskie;
	}
	public String getZdanie_polskie() {
		return zdanie_polskie;
	}
	public void setZdanie_polskie(String zdanie_polskie) {
		this.zdanie_polskie = zdanie_polskie;
	}
	public String getDzwiek() {
		return dzwiek;
	}
	public void setDzwiek(String dzwiek) {
		this.dzwiek = dzwiek;
	}
}
