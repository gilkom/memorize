package gilko.marcin.memorize.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gilko.marcin.memorize.model.Zdanie;
import gilko.marcin.memorize.repository.ZdanieRepository;

@Service
@Transactional
public class ZdanieService {
	@Autowired
	private ZdanieRepository repo;
	
	public List<Zdanie> list(){
		return repo.findAll();
	}
	
	public void save(Zdanie zdanie) {
		repo.save(zdanie);
	}
	
	public Zdanie get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
