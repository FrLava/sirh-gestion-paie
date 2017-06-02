package dev.paie.service;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;
import dev.paie.service.CotisationService;

@ContextConfiguration(classes = {DataSourceMySQLConfig.class,ServicesConfig.class} )
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {
	
	@Autowired private CotisationService cotisationService;
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		
	Cotisation cotis = new Cotisation("cotis-n1","URSS",new BigDecimal(0.2),new BigDecimal(0.3));
	cotis.setId(1);
	// TODO sauvegarder une nouvelle cotisation
	//cotisationService.sauvegarder(cotis);
		
	// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation via laméthode lister

	// TODO modifier une cotisation
	cotisationService.mettreAJour(cotis);
	// TODO vérifier que les modifications sont bien prises en compte via la méthode lister

	}
}
