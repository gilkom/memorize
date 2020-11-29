package gilko.marcin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BazaSlowekRepository extends JpaRepository<Slowo, Long>{
	

}
