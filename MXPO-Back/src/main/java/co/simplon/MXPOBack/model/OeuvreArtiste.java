package co.simplon.MXPOBack.model;

import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class OeuvreArtiste {
	
	@Transient
	private String oeuvre;
	@Transient
	private String artiste;
	@Transient
	private String idMusee;
	
}
