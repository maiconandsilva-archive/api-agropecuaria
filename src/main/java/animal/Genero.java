package animal;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum Genero {
	F("FEMEA"),
	M("MACHO");

	@Getter private String value;
}