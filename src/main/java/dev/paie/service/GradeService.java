package dev.paie.service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import dev.paie.entite.Grade;

@Component
public interface GradeService {
	
	void sauvegarder(Grade nouveauGrade);
	void mettreAJour(Grade grade);
	List<Grade> lister();

}
