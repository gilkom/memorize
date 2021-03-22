package gilko.marcin.memorize.controller;

import java.util.ArrayList;
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
	@RequestMapping(value="/prezentacja", method= RequestMethod.POST)
	public ModelAndView prezentacjaPoczatek(@RequestParam(value="numberOfWords") int numberOfWords) {
		if(naukaService.checkCzyUmiem()!=true) {
			System.out.println("czyUmiem= true");
			List<Slowo> listSlowo = new ArrayList<>();
		 	listSlowo = bazaService.getByNumber(numberOfWords);
		 	
		 	naukaService.deleteNaukaList();
		 	naukaService.saveNaukaList(listSlowo);
		 	
		 	//List<Nauka> listNauka = new ArrayList<>();
		}
		ModelAndView mav = new ModelAndView("prezentacja");
	 	Long id = naukaService.getMinId();
	 	Nauka nauka = new Nauka();
	 	nauka = naukaService.get(id);
	 	nauka.setCzy_umiem(true);
	 	naukaService.save(nauka);
	 	
		
		Slowo sl = bazaService.get(id);
	 	mav.addObject("sl",sl);
	 	mav.addObject("numberOfWords", numberOfWords);
	 	
		return mav;
	}
	
	
	@RequestMapping(value = "/prezentacja/{id}", method= RequestMethod.POST)
		public ModelAndView prezentacja(@PathVariable(name="id") Long pozycja, @RequestParam(value="numberOfWords") int numberOfWords) {
			
		
			ModelAndView mav = new ModelAndView("prezentacja");
			
		 	List<Slowo> listSlowo = new ArrayList<>();
		 	listSlowo = bazaService.getByNumber(numberOfWords);
		 	for(int i = 0; i< listSlowo.size(); i++) {
		 		System.out.println("---i: " + listSlowo.get(i));
		 	}
		 	mav.addObject("listNauka", listSlowo);
		 	
		 	Slowo sl = bazaService.get(pozycja);
		 	mav.addObject("sl",sl);
		return mav;
		}
	
}
