package gilko.marcin.memorize.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "memo_nauczone")
public class Nauczone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_slowa;
	private Date pierwsza_nauka;
	private Date ostatnia_nauka;
	private Date nastepna_nauka;
	private int ilosc_powtorzen;
	
	public Nauczone() {};
	public Nauczone(Long id_slowa, Date pierwsza_nauka, Date ostatnia_nauka, Date nastepna_nauka,
						int ilosc_powtorzen) {
		this.id_slowa = id_slowa;
		this.pierwsza_nauka = pierwsza_nauka;
		this.ostatnia_nauka = ostatnia_nauka;
		this.nastepna_nauka = nastepna_nauka;
		this.ilosc_powtorzen = ilosc_powtorzen;
	};
	
	@Override
	public String toString() {
		return "id_slowa: " + id_slowa + ", pierwsza_nauka: " + pierwsza_nauka + ", ostatnia_nauka: " + 
				 ostatnia_nauka + ", nastepna_nauka: " + nastepna_nauka + ", ilosc_powtorzen: " +
				ilosc_powtorzen;
	}
	
	public Long getId_slowa() {
		return id_slowa;
	}
	public void setId_slowa(Long id_slowa) {
		this.id_slowa = id_slowa;
	}
	
	public Date getPierwsza_nauka() {
		return pierwsza_nauka;
	}
	public void setPierwsza_nauka(Date pierwsza_nauka) {
		this.pierwsza_nauka = pierwsza_nauka;
	}
	
	public Date getOstatnia_nauka() {
		return ostatnia_nauka;
	}
	
	public void setOstatnia_nauka(Date ostatnia_nauka) {
		this.ostatnia_nauka = ostatnia_nauka;
	}
	
	public Date getNastepna_nauka() {
		return nastepna_nauka;
	}
	
	public void setNastepna_nauka(Date nastepna_nauka) {
		this.nastepna_nauka = nastepna_nauka;
	}
	
	public int getIlosc_powtorzen() {
		return ilosc_powtorzen;
	}
	public void setIlosc_powtorzen(int ilosc_powtorzen) {
		this.ilosc_powtorzen = ilosc_powtorzen;
	}
	
}
