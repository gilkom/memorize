package gilko.marcin.memorize.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gilko.marcin.memorize.model.Nauka;
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
	
	public Long count() {
		return repo.count();
	}
	public List<Slowo> getByNumber(int numberOfWords){
		System.out.println("2.2----------------------------------------------");
		List<Long> lista = getNieNauczone();
		System.out.println("2.3----------------------------------------------");
		Collections.shuffle(lista);
		System.out.println("2.4----------------------------------------------");
		Long[] limitedArray = new Long[numberOfWords];
		System.out.println("2.5----------------------------------------------");
		for(int i = 0; i < limitedArray.length; i++) {
			limitedArray[i] = lista.get(i);
			System.out.println("limitedArray: " + limitedArray[i] );
		}
		System.out.println("limitedArray.toString: " + limitedArray.toString() );
		System.out.println("2.6----------------------------------------------");
		return repo.getByNumber(limitedArray);
		
	}
	
	public List<Long> getNieNauczone(){
		return repo.getNieNauczoneId();
	}
}
