package dev.paie.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	@Autowired EntrepriseRepository eRepos;
	@Autowired GradeRepository gRepos;
	@Autowired ProfilRemunerationRepository prRepos;
	@Autowired RemunerationEmployeRepository remuRepos;
	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		
		//List<? extends JpaRepository<Object,Integer>> li = {eRepos.getClass(), gRepos, prRepos};
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		
		mv.addObject("entreprise",eRepos.findAll());
		mv.addObject("grade",gRepos.findAll());
		mv.addObject("profil",prRepos.findAll());
		
		return mv;
	
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmployes(){
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmployes");
		
		mv.addObject("listEmpl",remuRepos.findAll());
		
		return mv;
		
	}
	
	@RequestMapping(value="/creer", method=RequestMethod.POST)
	public String form(@RequestParam("matricule") String matricule,
			@RequestParam("grade") Integer gradeId,
			@RequestParam("entreprise") Integer entrepriseId,
			@RequestParam("profil") Integer profilId, Model model){
		
	
		remuRepos.saveAndFlush(new RemunerationEmploye(matricule,
				eRepos.findOne(entrepriseId),
				prRepos.findOne(profilId),
				gRepos.findOne(gradeId)));
		
		return "redirect:lister";
	}

}
