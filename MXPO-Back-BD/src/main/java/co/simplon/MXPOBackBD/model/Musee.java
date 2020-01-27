package co.simplon.MXPOBackBD.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
	
}
