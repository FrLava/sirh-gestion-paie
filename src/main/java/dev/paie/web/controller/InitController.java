package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.paie.service.InitialiserDonneesService;

@Component
public class InitController implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired private InitialiserDonneesService initService;
	private static final Logger LOGGER = LoggerFactory.getLogger(InitController.class);
	
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent ) {
    	LOGGER.info("Initialisation des données");
    	initService.initialiser();
    }
}