package structure.basededonnees;

import java.io.Serializable;
import java.util.ArrayList;
import structure.relation.RelationStruct;

public class DatabaseStruct implements Serializable{
	private ArrayList<RelationStruct> listeRelations;
	private int nbRelations;
	
	public DatabaseStruct() {
		this.listeRelations = new ArrayList<RelationStruct>();
		this.nbRelations = 0;
	}

	public ArrayList<RelationStruct> getListeRelations() {
		return listeRelations;
	}

	public void setListeRelations(ArrayList<RelationStruct> listeRelations) {
		this.listeRelations = listeRelations;
	}

	public int getNbRelations() {
		return nbRelations;
	}

	public void setNbRelations(int nbRelations) {
		this.nbRelations = nbRelations;
	}
}
