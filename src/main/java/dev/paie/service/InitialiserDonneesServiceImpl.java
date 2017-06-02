package dev.paie.service;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;

@Service
public class InitialiserDonneesServiceImpl implements InitialiserDonneesService {

	@Autowired ApplicationContext context;
	@PersistenceContext private EntityManager em;
	
	private final BiConsumer<String, Object> PERSIST_OBJECT = (beanName,bean)->em.persist(bean);
	private List<Periode> pTable = new ArrayList<Periode>();
	private LocalDate date = LocalDate.of(2017, 01, 01);
	
	@Override
	@Transactional
	public void initialiser() {
		
		Stream.of(Entreprise.class,Cotisation.class,Grade.class,ProfilRemuneration.class)
		.forEach(classe -> context.getBeansOfType(classe).forEach(PERSIST_OBJECT));
		
		Stream.of(
				new Periode(LocalDate.of(2017, 1, 1),LocalDate.of(2017, 1, 31)),
				new Periode(LocalDate.of(2017, 2, 1),LocalDate.of(2017, 2, 28)),
				new Periode(LocalDate.of(2017, 3, 1),LocalDate.of(2017, 3, 31)),
				new Periode(LocalDate.of(2017, 4, 1),LocalDate.of(2017, 4, 30)),
				new Periode(LocalDate.of(2017, 5, 1),LocalDate.of(2017, 5, 31)),
				new Periode(LocalDate.of(2017, 6, 1),LocalDate.of(2017, 6, 30)),
				new Periode(LocalDate.of(2017, 7, 1),LocalDate.of(2017, 7, 31)),
				new Periode(LocalDate.of(2017, 8, 1),LocalDate.of(2017, 8, 31)),
				new Periode(LocalDate.of(2017, 9, 1),LocalDate.of(2017, 9, 30)),
				new Periode(LocalDate.of(2017, 10, 1),LocalDate.of(2017, 10, 31)),
				new Periode(LocalDate.of(2017, 11, 1),LocalDate.of(2017, 11, 30)),
				new Periode(LocalDate.of(2017, 12, 1),LocalDate.of(2017, 12, 31))
				).forEach( periode -> em.persist(periode) );
	}

}
