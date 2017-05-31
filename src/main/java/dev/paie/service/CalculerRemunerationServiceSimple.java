package dev.paie.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtilTest;
import dev.paie.util.PaieUtils;

@Component
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	@Autowired private PaieUtils pUtil;
	
	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		
		ResultatCalculRemuneration rcr = new ResultatCalculRemuneration();
		
		BigDecimal salaireBase = bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase().multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase()); 
		rcr.setSalaireDeBase(pUtil.formaterBigDecimal(salaireBase));
		
		BigDecimal salaireBrut = salaireBase.add(bulletin.getPrimeExceptionnelle());
		rcr.setSalaireBrut(pUtil.formaterBigDecimal(salaireBrut));
		
		BigDecimal totalRetenuSalarial = new BigDecimal(0); 
		
		for (Cotisation c: bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables()){
			if(c.getTauxSalarial()!=null){
				totalRetenuSalarial=totalRetenuSalarial.add(c.getTauxSalarial().multiply(salaireBrut));
			}
			
		}
		
		
		rcr.setTotalRetenueSalarial(pUtil.formaterBigDecimal(totalRetenuSalarial));
		
		BigDecimal totalRetenuPatronal = new BigDecimal(0); 
		
		for (Cotisation c: bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables()){
			if(c.getTauxPatronal()!=null){
				totalRetenuPatronal=totalRetenuPatronal.add(c.getTauxPatronal().multiply(salaireBrut));
			}
			
		}
		
		rcr.setTotalCotisationsPatronales(pUtil.formaterBigDecimal(totalRetenuPatronal));
		
		BigDecimal netImposable = salaireBrut.subtract(totalRetenuSalarial);
		rcr.setNetImposable(pUtil.formaterBigDecimal(netImposable));
		
		BigDecimal somme = new BigDecimal(0);
		
		for (Cotisation c: bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables()){
			if(c.getTauxSalarial()!=null){
				somme=somme.add(c.getTauxSalarial().multiply(salaireBrut));
			}
			
		}
		
		BigDecimal netAPayer = netImposable.subtract(somme);
		
		rcr.setNetAPayer(pUtil.formaterBigDecimal(netAPayer));
		
				
		return rcr;
	}

}
