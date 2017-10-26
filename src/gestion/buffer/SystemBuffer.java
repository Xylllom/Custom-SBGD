package gestion.buffer;

import gestion.acces.SystemAccess;
import gestion.disque.PageId;
import gestion.disque.SystemDisk;
import structure.data.Header;

public class SystemBuffer {
	private static Case[] pool;
	private int[] listeRemplacement;
	private Header tete;
	
	public SystemBuffer() {
		this.pool = new Case[outils.Tools.NOMBRE_CASE];
		this.listeRemplacement = new int[outils.Tools.NOMBRE_CASE];
		this.tete = new Header();
	}
	
	public void getPage(PageId pid) {
			for (Case c : pool) {
				if (!c.isUsed()) {
					c.setContenu(SystemDisk.lire(pid));
					c.setPageId(pid.getIdX());
					c.setDirty(false);
					c.setPin_count(c.getPin_count()+1);
				}
			}
		}
	
	public void freePage(PageId pid, boolean modified) {
		for (Case c : pool) {
			if (c.getPageId() == pid.getIdX()) {
				c.setPin_count(c.getPin_count()-1);
			}
			if (modified) {
				SystemDisk.ecrire(pid,c.getContenu()); // a modifier
				c.setDirty(false);
			}
		}
	}

}
