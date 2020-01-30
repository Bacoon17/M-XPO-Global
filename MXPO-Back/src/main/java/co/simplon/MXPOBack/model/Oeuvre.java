package co.simplon.MXPOBack.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity	
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Oeuvre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idOeuvre;
	
	private String numeroInventaire;
	private String nom;
	private String dateCreation;
	private String lieuxExpo;
	
	@ManyToMany
	private Collection<ThemeOeuvre> themesoeuvres;
	
}
