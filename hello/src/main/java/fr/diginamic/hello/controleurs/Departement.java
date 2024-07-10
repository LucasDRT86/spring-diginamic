package fr.diginamic.hello.controleurs;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "departement")
public class Departement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	
	@NotBlank(message ="Le nom de la ville doir être non null")
	@Size(min = 2, message = "Le nom doit avoir au moins 2 caractère")
	private String nom;
	
	private int habitant;
	
	@NotBlank(message ="Le code departement doitn être non null")
	private String code;
	
	@OneToMany(mappedBy="departement")
	@JsonIgnore
	List<Ville> villes = new ArrayList<>();

	/**
	 * 
	 */
	public Departement() {
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
	 * @return the villes
	 */
	public List<Ville> getVilles() {
		return villes;
	}

	/**
	 * @param villes the villes to set
	 */
	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
	
}
