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
	public ModelAndView prezentacjaPoczatek(@RequestParam(value="numberOfWords") int numberOfWords,
											@RequestParam(value="firstFlag") int firstFlag){
		
	
		/*If we start prezentacja  we need to load new words into nauka table.
		 * FirstFlag parameter as 0 loads from nauka page and firstFlag parameter = 1 loads from
		 * prezentacja page. It helps to start prezentacja from the beginnig every time and not in
		 * the middle if we accidentally shut the page.
		 */
		if(firstFlag == 0) {
			List<Slowo> listSlowo = new ArrayList<>();
		 	listSlowo = bazaService.getByNumber(numberOfWords);
		 	
		 	naukaService.deleteNaukaList();
		 	naukaService.saveNaukaList(listSlowo);	 	
		}
		
		Long id = naukaService.getMinId();//if table nauka is empty we set the first id as 1
		if(id == null) {
			id = Long.valueOf(1);
		}
			ModelAndView mav = new ModelAndView("prezentacja");

		 	Nauka nauka = new Nauka();
		 	nauka = naukaService.get(id);
		 	nauka.setCzy_umiem(true);
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
	
}
