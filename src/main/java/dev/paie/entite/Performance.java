package dev.paie.entite;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Performance {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nomService;
	private LocalDateTime dateHeure;
	private Long tempsExecution;
	
	public Performance() {}
	
	public Performance(String nomService, Long tempsExecution) {
		this.nomService = nomService;
		this.tempsExecution = tempsExecution;
		this.dateHeure = LocalDateTime.now();
	}
	
	public String getNomService() {
		return nomService;
	}
	public LocalDateTime getDateHeure() {
		return dateHeure;
	}
	public Long getTempsExecution() {
		return tempsExecution;
	}
	public void setNomService(String nomService) {
		this.nomService = nomService;
	}
	public void setDateHeure(LocalDateTime dateHeure) {
		this.dateHeure = dateHeure;
	}
	public void setTempsExecution(Long tempsExecution) {
		this.tempsExecution = tempsExecution;
	}



}
