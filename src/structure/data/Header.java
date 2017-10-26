package structure.data;

import java.util.ArrayList;

public class Header{
	private ArrayList<PageData> listePages;
	// private int nombrePage INUTILE VU QU'ON A L'ARRAY LIST
	
		
	public PageData getPageById(int i) {
		for (PageData p : listePages) {
			if (p.getPid().getIdX() == i) { // je suis perdu
				return p;
			}
		}
		return null;
	}
	
	public boolean isPageComplete(int i) {
		return getPageById(i).isComplet();
	}
}
