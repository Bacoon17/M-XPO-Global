package co.simplon.MXPOBack.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
@JsonIgnoreProperties("themes")
public class Musee {

	@Id
	private String idMusee;
	private String nomMusee;
	private String adresse;
	private String ville;
	private String siteWeb;
	private String geolocalisation;
	@Column(length = 5000)
	private String description;
	
	private String codeVille;
	
	@ManyToMany
	private Collection<Theme> themes;
}