package gilko.marcin.memorize.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import gilko.marcin.memorize.model.Slowo;

@Repository
public interface BazaSlowekRepository extends JpaRepository<Slowo, Long>{
	@Query("Select id_slowa from Slowo where id_slowa not in (select id_slowa from Nauczone)")
	List<Long> getNieNauczoneId();
	
	
	@Query("Select s from Slowo s where s.id_slowa in (:limitedArray)")
	List<Slowo> getByNumber(Long[] limitedArray);

	@Query("Select min(s.id_slowa) from Slowo s")
	Long getNextId(Long[] limitedArray);
	
	@Query("Select s from Slowo s where s.tlumaczenie like :like and s.tlumaczenie not like :tlumaczenie")
	List<Slowo> searchWordsLike(String like, String tlumaczenie);
	
	@Query("Select s from Slowo s where s.tlumaczenie not like :like and s.tlumaczenie not like :tlumaczenie")
	List<Slowo> searchWordsNotLike(String like, String tlumaczenie);
}
