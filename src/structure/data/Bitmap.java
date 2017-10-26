package structure.data;

// CREE LA BITMAP COMPORTANT LE NOMBRE DE SLOT ET UN BOOLEAN POUR SAVOIR SI IL EST PLEIN OU VIDE
public class Bitmap {
	private int nbSlot;
	private int[] etatSlot;
	
	public boolean isComplet() {
		for (int e: etatSlot) {
			if (e != 0) return false; 
		}
		return true;
	}
	public int getNbSlot() {
		return nbSlot;
	}
	public void setNbSlot(int nbSlot) {
		this.nbSlot = nbSlot;
	}
	public int[] getEtatSlot() {
		return etatSlot;
	}
	public void setEtatSlot(int[] etatSlot) {
		this.etatSlot = etatSlot;
	}
}
