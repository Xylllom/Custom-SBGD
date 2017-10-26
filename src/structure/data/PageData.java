package structure.data;

import gestion.disque.PageId;

public class PageData{
	private Bitmap map;
	private PageId pid;
	private int slotsRestants;

	public boolean isComplet() {
		return map.isComplet();
	}
	
	public Bitmap getMap() {
		return map;
	}

	public void setMap(Bitmap map) {
		this.map = map;
	}

	public PageId getPid() {
		return pid;
	}

	public void setPid(PageId pid) {
		this.pid = pid;
	}

	public int getSlotsRestants() {
		return slotsRestants;
	}

	public void setSlotsRestants(int slotsRestants) {
		this.slotsRestants = slotsRestants;
	}
}
