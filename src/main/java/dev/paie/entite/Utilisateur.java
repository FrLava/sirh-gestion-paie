package dev.paie.entite;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilisateur {
	
	
	public enum ROLES {

		ROLE_ADMINISTRATEUR, ROLE_UTILISATEUR

		}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nomUtilisateur;
	private String motDePasse;
	private Boolean estActif;
	
	@Enumerated(EnumType.STRING)
	private ROLES role;
	
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public ROLES getRole() {
		return role;
	}
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public void setRole(ROLES role) {
		this.role = role;
	}

}
