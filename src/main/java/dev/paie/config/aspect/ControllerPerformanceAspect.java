package dev.paie.config.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import dev.paie.entite.Performance;
import dev.paie.repository.PerformanceRepository;

@Configuration
@Aspect
public class ControllerPerformanceAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerPerformanceAspect.class);
	@Autowired PerformanceRepository perfRep;
	
	@Around("execution(* dev.paie.web.controller.*.*(..))")
	public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
		
		String nomService;
		Long tempExec = 0L;
		Long tempDebut = 0L;
		
		nomService = pjp.getSignature().toString();
		tempDebut = System.currentTimeMillis();
		
		LOGGER.debug("Début d'exécution de la méthode " + pjp.getSignature().toString());
		Object resultat = pjp.proceed();
		LOGGER.debug("Fin d'exécution de la méthode");
		
		tempExec = System.currentTimeMillis() - tempDebut;
		perfRep.save(new Performance(nomService,tempExec));
		
		return resultat;
	
	}

}
