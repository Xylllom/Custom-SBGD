package structure.relation;

import java.io.Serializable;
import java.util.ArrayList;
import outils.Type;

public class RelationSchema implements Serializable{
	private String name;
	private int taille;
	private Type[] contenu;
	
	public RelationSchema(String n, int l, Type[] t) {
		this.name = n;
		this.taille = l;
		this.contenu = t;
	}
}
