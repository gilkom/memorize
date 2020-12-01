package gilko.marcin.memorize.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gilko.marcin.memorize.model.Slowo;

@Repository
public interface BazaSlowekRepository extends JpaRepository<Slowo, Long>{
	

}
