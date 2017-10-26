package outils;

import java.io.Serializable;

public enum Type implements Serializable{ INTEGER(4), FLOAT(4), STRING(2); // STRING DOIT VALOIR 2 x LA TAILLE DE LA CHAINE
	private int value;
	
	Type(int i) {
		this.value = i;
	}
}
