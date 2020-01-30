package co.simplon.MXPOBack.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Artiste {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idArtiste;
	private String nomArtiste;
	private String prenomArtiste;
	private String naissanceArtiste;
	private String decesArtiste;
	
	@ManyToMany(cascade=CascadeType.MERGE, fetch = FetchType.LAZY)
	private Collection<Oeuvre> oeuvres;
	
}
