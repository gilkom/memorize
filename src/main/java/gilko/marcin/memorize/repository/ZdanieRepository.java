package gilko.marcin.memorize.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gilko.marcin.memorize.model.Zdanie;

@Repository
public interface ZdanieRepository extends JpaRepository<Zdanie, Long>{

}
