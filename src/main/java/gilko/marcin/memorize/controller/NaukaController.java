package gilko.marcin.memorize.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import gilko.marcin.memorize.service.BazaSlowekService;

@Controller
public class NaukaController {
	
	@Autowired
	private BazaSlowekService bazaService;
	
	@RequestMapping("/nauka")
	public String nauka(Model model) {
		Long count = bazaService.count();
		model.addAttribute("count", count);
		return "nauka";
	}
	
	@RequestMapping("/prezentacja")
		public String prezentacja() {
			return "prezentacja";
		}
	
}
