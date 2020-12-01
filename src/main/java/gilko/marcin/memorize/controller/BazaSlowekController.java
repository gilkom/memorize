package gilko.marcin.memorize.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import gilko.marcin.memorize.model.Slowo;
import gilko.marcin.memorize.service.BazaSlowekService;

@Controller
public class BazaSlowekController {
	
	@Autowired
	private BazaSlowekService service;
	
	@RequestMapping("/baza_slowek")
	public String bazaSlowek(Model model) {
		List<Slowo> listaSlow = service.list();
		model.addAttribute("listaSlow", listaSlow);
		return "baza_slowek";
	}
}
