package dev.paie.service;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
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
	
	@Override
	@Transactional
	public void initialiser() {
		
		final BiConsumer<String, Object> PERSIST_OBJECT = (beanName,bean)->em.persist(bean);
		LocalDate date = LocalDate.of(LocalDate.now().getYear(), 1, 1);
		
		Stream.of(Entreprise.class,Cotisation.class,Grade.class,ProfilRemuneration.class)
		.forEach(classe -> context.getBeansOfType(classe).forEach(PERSIST_OBJECT));
		
		for(int i=0;i<12;i++){
			em.persist(new Periode(date.plusMonths(i),date.plusMonths(i).with(TemporalAdjusters.lastDayOfMonth())));
		}

	}

}
