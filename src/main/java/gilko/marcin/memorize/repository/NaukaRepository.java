package gilko.marcin.memorize.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import gilko.marcin.memorize.model.Nauka;

public interface NaukaRepository extends JpaRepository<Nauka, Long> {

	@Query("Select id_slowa from Slowo where id_slowa not in (select id_slowa from Nauczone)")
	List<Long> getNieNauczoneId();
	
	@Query("Select s from Slowo s where s.id_slowa in (:limitedArray)")
	List<Nauka> getByNumber(Long[] limitedArray);

	@Query("Select min(n.pozycja) from Nauka n where n.czy_umiem = false")
	Long getMinId();
	
	//@Query("Select n.czy_umiem from Nauka n where n.czy_umiem = true")
	@Query("SELECT CASE WHEN COUNT(n) > 0 THEN true ELSE false END FROM Nauka n WHERE n.czy_umiem = true")
	boolean checkCzyUmiem();
	
}
