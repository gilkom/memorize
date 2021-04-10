package gilko.marcin.memorize.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gilko.marcin.memorize.model.Zdanie;

@Repository
public interface ZdanieRepository extends JpaRepository<Zdanie, Long>{

	@Query("Select z from Zdanie z where z.slowo.id_slowa = :id")
	List<Zdanie> listByIdSlowa(Long id);
}
