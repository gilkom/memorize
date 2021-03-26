package gilko.marcin.memorize.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gilko.marcin.memorize.model.Nauka;
import gilko.marcin.memorize.model.Slowo;
import gilko.marcin.memorize.service.BazaSlowekService;
import gilko.marcin.memorize.service.NaukaService;

@Controller
public class NaukaController {
	
	@Autowired
	private BazaSlowekService bazaService;
	@Autowired
	private NaukaService naukaService;
	
	@RequestMapping("/nauka")
	public String nauka(Model model) {
		Long count = bazaService.count();
		model.addAttribute("count", count);
		return "nauka";
	}
	@RequestMapping(value="/prezentacja/poczatek", method= RequestMethod.POST)
	public String prezentacjaPoczatek(@RequestParam(value="numberOfWords") int numberOfWords) {
		List<Slowo> listSlowo = new ArrayList<>();
	 	listSlowo = bazaService.getByNumber(numberOfWords);
	 	
	 	naukaService.deleteNaukaList();
	 	naukaService.saveNaukaList(listSlowo);	
	 	return "redirect:/prezentacja";
	}
	
	@RequestMapping("/prezentacja")
	public ModelAndView prezentacja(){
			int numberOfWords = naukaService.list().size();
			Long id = naukaService.getMinId();

			ModelAndView mav = new ModelAndView("prezentacja");

		 	Nauka nauka = new Nauka();
		 	nauka = naukaService.get(id);
		 	nauka.setCzy_umiem(true);
		 	nauka.setWspolczynnik_powtorek(1.);
		 	naukaService.save(nauka);
		 	
			Slowo sl = bazaService.get(id);
		 	mav.addObject("sl",sl);
		 	mav.addObject("numberOfWords", numberOfWords);
		 	mav.addObject("id", id);
		 	
		
			return mav;
		
		
	}
	@RequestMapping("/prezentacja/przerwij")
	public String prezentacjaPrzerwij() {
		naukaService.deleteNaukaList();
		return "redirect:/nauka";
	}
	
	@RequestMapping("/prezentacja/koniec")
	public String prezentacjaKoniec() {
		List<Nauka> naukaList = new ArrayList<>();
		naukaList = naukaService.list();
		
		naukaService.setAllCzyUmiemToFalse(naukaList);
		
		return "redirect:/wybierz_tlumaczenie_angielskie";
	}
	@RequestMapping("/wybierz_tlumaczenie_angielskie/poczatek")
	public String wybierzTlumaczenieAngielskiePoczatek() {
		List<Slowo> listSlowo = new ArrayList<>();
	 	listSlowo = bazaService.getByNumber(5);
	 	
	 	
	 	
	 	naukaService.deleteNaukaList();
	 	naukaService.saveNaukaList(listSlowo);
	 	
	 	List<Nauka> naukaList = new ArrayList<>();
	 	naukaList = naukaService.list();
	 	
	 	naukaService.setAllWspolczynnikToOne(naukaList);
	 	return "redirect:/wybierz_tlumaczenie_angielskie";
	}
	
	@RequestMapping("/wybierz_tlumaczenie_angielskie")
	public ModelAndView wybierzTlumaczenieAngielskie() {
			System.out.println("xxx");
			Double minWspolczynnik = naukaService.getMinWspolczynnik();
			int nauczone = naukaService.countCzyUmiem();
			int nauczoneKoniec = nauczone+1;
			Long id = naukaService.getMinIdAndWspolczynnik(minWspolczynnik);
			if(id == null) {
				System.out.println("xxx2");
				prezentacjaKoniec();
			}
			int count = naukaService.list().size();
			ModelAndView mav = new ModelAndView("wybierz_tlumaczenie_angielskie");
		 	Nauka nauka = new Nauka();
		 	nauka = naukaService.get(id);
		 	
		 	Slowo sl = new Slowo();
		 	sl = bazaService.get(id);

		 	//Creating list of 4 words for quiz
		 	List<Slowo> listLikeSlowo = new ArrayList<>();
		 	listLikeSlowo = bazaService.searchWordsLike(sl.getTlumaczenie());

		 	listLikeSlowo.add(sl);

		 	Collections.shuffle(listLikeSlowo);

		 	Slowo pierwszy = listLikeSlowo.get(0);
		 	Slowo drugi = listLikeSlowo.get(1);
		 	Slowo trzeci = listLikeSlowo.get(2);
		 	Slowo czwarty = listLikeSlowo.get(3);

		 	mav.addObject("pierwszy", pierwszy);
		 	mav.addObject("drugi", drugi);
		 	mav.addObject("trzeci", trzeci);
		 	mav.addObject("czwarty", czwarty);
		 	mav.addObject("sl", sl);
		 	mav.addObject("nauka", nauka);
		 	mav.addObject("id", id);
		 	mav.addObject("count", count);
		 	mav.addObject("listLikeSlowo", listLikeSlowo);
		 	mav.addObject("nauczone", nauczone);
		 	mav.addObject("nauczoneKoniec", nauczoneKoniec);
			return mav;
	}
	
	@RequestMapping(value = "/wybierz_tlumaczenie_angielskie/nastepny", method = RequestMethod.POST)
	public String wybierzTlumaczenieAngielskieNastepny(@RequestParam(value = "answer") int answer,
														@RequestParam(value= "id")Long id) {
		Nauka nauka = naukaService.get(id);
		if(answer == 1) {
			nauka.setCzy_umiem(true);
		}else {
			nauka.setWspolczynnik_powtorek(nauka.getWspolczynnik_powtorek()+ 0.01);
		}
		naukaService.save(nauka);
		return "redirect:/wybierz_tlumaczenie_angielskie";
	}
	@RequestMapping("/wybierz_tlumaczenie_angielskie/koniec")
	public String wybierzTlumaczenieAnieglskieKoniec() {
		List<Nauka> naukaList = new ArrayList<>();
		naukaList = naukaService.list();
		
		naukaService.setAllCzyUmiemToFalse(naukaList);
		
		return "redirect:/nauka";
	}
	
}
