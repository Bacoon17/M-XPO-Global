package co.simplon.MXPOBack.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class User {

	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idUser;

	private String nom;
	private String prenom;
	private String mail;
	private String voie;
	private String codePostal;
	private String ville;
	private String mdp;
	private boolean admin;

//	@ManyToMany(cascade = CascadeType.REMOVE , fetch = FetchType.LAZY)
	@ManyToMany
	private Collection<Musee> musee;
	
}
