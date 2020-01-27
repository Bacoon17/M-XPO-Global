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
public class Departement {
	
	@Id
	private String codeDepartement;
	private String nomDepartement;
	
	private String codeRegion;
	
	@OneToMany
	@JoinColumn(name="codeDepartement")
	private Collection<Ville> villes;
	
}