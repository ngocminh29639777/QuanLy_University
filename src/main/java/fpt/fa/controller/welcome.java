package fpt.fa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class welcome {
@RequestMapping("/")
	public ModelAndView wwelcome(Model model) {
		return new ModelAndView("index");
	}
}
