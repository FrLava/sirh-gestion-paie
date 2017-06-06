package dev.paie.web.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.BulletinRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/bulletins")
public class BulletinController {
	
	@Autowired BulletinRepository bRepos;
	@Autowired PeriodeRepository pRepos;
	@Autowired RemunerationEmployeRepository reRepos;
	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerBulletin() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		
		mv.addObject("periode",pRepos.findAll());
		mv.addObject("remunerationEmploye",reRepos.findAll());
		
		return mv;
	
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmployes(){
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listerBulletins");
		
		mv.addObject("listBull",bRepos.findAll());
		
		return mv;
		
	}
	
	@RequestMapping(value="/creer", method=RequestMethod.POST)
	public String form(@RequestParam("remunerationEmploye") Integer remEmplId,
			@RequestParam("periode") Integer periodeId,
			@RequestParam("primeExceptionnelle") double prime, Model model){
		
	
		bRepos.saveAndFlush(new BulletinSalaire(reRepos.findOne(remEmplId),
				pRepos.findOne(periodeId),
				new BigDecimal(prime)));
		
		return "redirect:lister";
	}
	
}
