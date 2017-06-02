package dev.paie.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	@Autowired EntrepriseRepository eRepos;
	@Autowired GradeRepository gRepos;
	@Autowired ProfilRemunerationRepository prRepos;
	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		
		//List<? extends JpaRepository<Object,Integer>> li = {eRepos.getClass(), gRepos, prRepos};
		
		List<Entreprise> lEntreprise = new ArrayList<>();
		List<ProfilRemuneration> lpr = new ArrayList<>();
		List<Grade> lGrade = new ArrayList<>();
		
		lEntreprise = eRepos.findAll();
		lpr = prRepos.findAll();
		lGrade = gRepos.findAll();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		
		mv.addObject("entreprise",lEntreprise);
		mv.addObject("grade",lGrade);
		mv.addObject("profil",lpr);
		
		return mv;
	
	}

}
