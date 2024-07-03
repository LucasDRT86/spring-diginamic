package fr.diginamic.hello.controleurs;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ville {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private int habitant;
	
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
		return habitant;
	}
	/**
	 * @param habitant the habitant to set
	 */
	public void setHabitant(int habitant) {
		this.habitant = habitant;
	}
	/**
	 * @param id
	 * @param nom
	 * @param habitant
	 */
	public Ville(int id, String nom, int habitant) {
		this.id = id;
		this.nom = nom;
		this.habitant = habitant;
	}
	

	
	
	
}
