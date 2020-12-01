package gilko.marcin.memorize.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gilko.marcin.memorize.model.Slowo;
import gilko.marcin.memorize.repository.BazaSlowekRepository;

@Service
@Transactional
public class BazaSlowekService {
	@Autowired
	private BazaSlowekRepository repo;
	
	public List<Slowo> list(){
		return repo.findAll();
	}
	
	public void save(Slowo slowo) {
		repo.save(slowo);
	}
	
	public Slowo get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
