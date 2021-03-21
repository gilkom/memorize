package gilko.marcin.memorize.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gilko.marcin.memorize.controller.nauka;
import gilko.marcin.memorize.model.Nauka;
import gilko.marcin.memorize.model.Slowo;
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
	public List<Nauka> getByNumber(int numberOfWords){
		List<Long> lista = getNieNauczone();
		Collections.shuffle(lista);
		Long[] limitedArray = new Long[numberOfWords];
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
	
	public void saveNaukaList(List<Slowo> listSlowo) {
List<Nauka> listNauka = new ArrayList<>();
	 	
	 	for(int i = 0; i < listSlowo.size(); i++) {
	 		Nauka nauka = new Nauka(i, listSlowo.get(i).);
	 		nauka.setPozycja(i);
	 		nauka.
	 		
	 	}
	}
}
