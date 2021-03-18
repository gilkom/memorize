package gilko.marcin.memorize.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import gilko.marcin.memorize.model.Nauka;

public interface NaukaRepository extends JpaRepository<Nauka, Long> {

	@Query("Select id_slowa from Slowo where id_slowa not in (select id_slowa from memo_nauczone)")
	List<Long> getNieNauczoneId();
	
	@Query("Select s from Slowo s where id_slowa in :limitedArray")
	List<Nauka> getByNumber(Long[] limitedArray);

	

}
