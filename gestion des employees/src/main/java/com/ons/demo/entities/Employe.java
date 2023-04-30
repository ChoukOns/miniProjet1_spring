package com.ons.demo.entities;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmploye;
	private String nomEmploye;
	private String prenomEmploye;
	private Double salaire;
	private Date dateNaissance;
	
	public Employe() {
		super();
		}
	
	public Employe(String nomEmploye, String prenomEmploye,Double salaire, Date dateNaissance) {
		super();
		this.nomEmploye = nomEmploye;
		this.prenomEmploye = prenomEmploye;
		this.salaire = salaire;
		this.dateNaissance = dateNaissance;
		}
	
	public Long getIdEmploye() {
		return idEmploye;
		}
	public void setIdEmploye(Long idEmploye) {
		this.idEmploye = idEmploye;
		}
		
		
		public String getNomEmploye() {
		return nomEmploye;
		}
		public void setNomEmploye(String nomEmploye) {
			this.nomEmploye = nomEmploye;
			}
		
		public String getPreomEmploye() {
			return prenomEmploye;
			}
		public void setPrenomEmploye(String prenomEmploye) {
		this.prenomEmploye = prenomEmploye;
		}
		
			
		public Double getSalaire() {
		return salaire;
		}
		public void setSalaire(Double salaire) {
		this.salaire = salaire;
		}
		
		
		public Date getDateNaissance() {
		return dateNaissance;
		}
		public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
		}
		
		@Override
		public String toString() {
		return "Employee [idEmploye=" + idEmploye + ", nomEmploye=" + nomEmploye + ", prenomEmploye=" + prenomEmploye + ", salaire=" + salaire
		+ ", dateNaissance=" + dateNaissance + "]";
		}

}
