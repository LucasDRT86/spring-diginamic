package fr.diginamic.hello.controleurs;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ville")
public class Ville {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message ="Le nom de la ville doir être non null")
	@Size(min = 2, message = "Le nom doit avoir au moins 2 caractère")
	private String nom;
	
	@Min(value = 1, message = "Le nombre d'habitants doit être supérieur ou égal à 1")
	private int nbHabitant;
	
	@ManyToOne
	@JoinColumn(name = "id_departement")
	private Departement departement;
	
	public Ville() {
		super();
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the habitant
	 */
	public int getHabitant() {
		return nbHabitant;
	}
	/**
	 * @param habitant the habitant to set
	 */
	public void setHabitant(int habitant) {
		this.nbHabitant = habitant;
	}
	/**
	 * @param id
	 * @param nom
	 * @param habitant
	 */
	public Ville(int id, String nom, int habitant) {
		this.id = id;
		this.nom = nom;
		this.nbHabitant = habitant;
	}
	/**
	 * @return the departement
	 */
	public Departement getDepartement() {
		return departement;
	}
	
	/**
	 * @param departement the departement to set
	 */
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}	
	
}
