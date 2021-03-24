package gilko.marcin.memorize.service;

import java.util.ArrayList;
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
		List<Long> lista = getNieNauczone();
		Collections.shuffle(lista);
		Long[] limitedArray = new Long[numberOfWords];
		for(int i = 0; i < limitedArray.length; i++) {
			limitedArray[i] = lista.get(i);
		}
		return repo.getByNumber(limitedArray);
		
	}
	
	public List<Long> getNieNauczone(){
		return repo.getNieNauczoneId();
	}
	
	public Long getNextId(List<Slowo> listSlowo) {
		Long[] limitedArray = new Long[listSlowo.size()];
		for(int i = 0; i < limitedArray.length; i++) {
			limitedArray[i] = listSlowo.get(i).getId_slowa();
		}
		return repo.getNextId(limitedArray);
		
	}
	
	public List<Slowo> searchWordsLike(String tlumaczenie){
		List<Slowo> listOfWordsLike = new ArrayList<>();
		String like = tlumaczenie.substring(0, 1) + "%";
		listOfWordsLike = repo.searchWordsLike(like, tlumaczenie);
		//not the best solution
		if(listOfWordsLike.size() < 3) {
			List<Slowo> listOfAllWords = repo.searchWordsNotLike(like, tlumaczenie);
			Collections.shuffle(listOfAllWords);
			for(int i =0; i < 3-listOfWordsLike.size();i++) {
				listOfWordsLike.add(listOfAllWords.get(i));
			}
			
		}
		
		
		return listOfWordsLike;
	}
}
