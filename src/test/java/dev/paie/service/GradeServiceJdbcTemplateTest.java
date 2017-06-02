package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;
import dev.paie.util.JeuxDeDonnesConfig;

@ContextConfiguration(classes = {DataSourceMySQLConfig.class,ServicesConfig.class} )
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {
	
	@Autowired private GradeService gradeService;
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		Grade grade = new Grade("grade-4",new BigDecimal(151.67),new BigDecimal(12.32));
		// TODO sauvegarder un nouveau grade
		//gradeService.sauvegarder(grade);

		// TODO vérifier qu'il est possible de récupérer le nouveau grade via la méthode lister
		List<Grade> lgd= gradeService.lister();
		System.out.println();
		// TODO modifier un grade
		gradeService.mettreAJour(grade);

		// TODO vérifier que les modifications sont bien prises en compte via la méthode lister

	}

}
	

