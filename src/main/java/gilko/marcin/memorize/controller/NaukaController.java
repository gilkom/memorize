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
	
	@RequestMapping(value = "/prezentacja/{id}", method= RequestMethod.POST)
		public ModelAndView prezentacja(@PathVariable(name="id") Long pozycja, @RequestParam(value="numberOfWords") int numberOfWords) {
			System.out.println("1----------------------------------------------");
			ModelAndView mav = new ModelAndView("prezentacja");
			System.out.println("2----------------------------------------------");
		 	List<Slowo> listSlowo = new ArrayList<>();
		 	listSlowo = bazaService.getByNumber(numberOfWords);
		 	System.out.println(listSlowo.toString());
		 	System.out.println("3----------------------------------------------");
		 	mav.addObject("listNauka", listSlowo);
		 	System.out.println("4----------------------------------------------");
		 	
		 	Slowo sl = bazaService.get(pozycja);
		 	System.out.println("----------slowo: " + sl.getSlowo());
		 	System.out.println("----------tlumaczenie: " + sl.getTlumaczenie());
		 	mav.addObject("sl",sl);
		return mav;
		}
	
}
