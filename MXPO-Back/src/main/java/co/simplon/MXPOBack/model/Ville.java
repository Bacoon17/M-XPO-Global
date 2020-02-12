package co.simplon.MXPOBack.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties("musees")
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