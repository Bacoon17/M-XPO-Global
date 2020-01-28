package co.simplon.MXPOBackBD.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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
public class Ville {
	
	@Id
	private String codeVille;
	private String codePostal;
	private String nomVille;
	
	private String codeDepartement;

	@OneToMany
	@JoinColumn(name="codeVille")
	private Collection<Musee> musees;
	
}
