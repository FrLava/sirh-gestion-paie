package dev.paie.repository;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = ServicesConfig.class)

//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {
	
	@Autowired private AvantageRepository avantageRepository;
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		
		Avantage a = new Avantage("av-2","OSEF",new BigDecimal (200));
		a.setId(2);
		
	// TODO sauvegarder un nouvel avantage
		//avantageRepository.save(new Avantage("av-1","avantage en nature",new BigDecimal(100.30)));
	// TODO vérifier qu'il est possible de récupérer le nouvel avantage via la méthode findOne
		Avantage av = avantageRepository.findOne(2);
		assertNotNull(av);
	// TODO modifier un avantage
		avantageRepository.save(a);
	// TODO vérifier que les modifications sont bien prises en compte via la méthode findOne

	}

}
