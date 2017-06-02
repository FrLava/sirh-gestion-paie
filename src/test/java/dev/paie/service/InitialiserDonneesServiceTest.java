package dev.paie.service;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Entreprise;

@ContextConfiguration(classes = {ServicesConfig.class} )
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class InitialiserDonneesServiceTest implements InitialiserDonneesService {

	@Autowired ApplicationContext context;
	@PersistenceContext private EntityManager em;
	
	@Override
	@Test
	@Transactional
	public void initialiser() {
		Map<String,Entreprise> mapEntreprise = new HashMap<>();
		
		mapEntreprise = context.getBeansOfType(Entreprise.class);
		assertTrue(mapEntreprise.size()==3);
		for(Entreprise e: mapEntreprise.values()){
			em.persist(e);
		}
		//em.persist(mapEntreprise);

	}

}
