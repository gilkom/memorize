package gilko.marcin.memorize.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import gilko.marcin.memorize.service.BazaSlowekService;

@Controller
public class NaukaController {
	
	@Autowired
	private BazaSlowekService bazaService;
	
	@RequestMapping("/nauka")
	public String nauka() {
		return "nauka";
	}
}
