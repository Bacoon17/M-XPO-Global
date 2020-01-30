package co.simplon.MXPOBack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ThemeOeuvre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idThemeOeuvre;
	private String type;
	
}