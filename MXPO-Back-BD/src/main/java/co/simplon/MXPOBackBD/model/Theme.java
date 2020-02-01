package co.simplon.MXPOBackBD.model;

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
public class Theme {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTheme;
	private String nomTheme;
	
	@ManyToMany
	private Collection<Musee> musees;
	
}