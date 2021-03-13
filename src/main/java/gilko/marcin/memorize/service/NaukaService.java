package gilko.marcin.memorize.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gilko.marcin.memorize.model.Nauka;
import gilko.marcin.memorize.repository.NaukaRepository;

@Service
@Transactional
public class NaukaService {

	@Autowired
	private NaukaRepository repo;
	
	public List<Nauka> list(){
		return repo.findAll();
	}
	
	public void save(Nauka nauka) {
		repo.save(nauka);
	}
	
	public Nauka get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
