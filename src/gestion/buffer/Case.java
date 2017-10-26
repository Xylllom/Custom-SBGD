package gestion.buffer;

import java.nio.ByteBuffer;

/**
 * Frame composant le buffer, contient de quoi identifier une page et plusieurs informations
 * /!\ Possède les données récupérées par le SystemBuffer depuis le SystemDisk 
 * @author Nathan
 */

public class Case {
	private int CaseId;
	private int PageId;
	private int pin_count;
	private byte[] contenu = null; 
	private boolean dirty;
	
	
	public boolean isUsed() {
		return this.pin_count != 0 ? true : false;
	}

	public int getCaseId() {
		return CaseId;
	}

	public void setCaseId(int caseId) {
		CaseId = caseId;
	}

	public int getPageId() {
		return PageId;
	}

	public void setPageId(int pageId) {
		PageId = pageId;
	}
	
	public int getPin_count() {
		return pin_count;
	}

	public void setPin_count(int pin_count) {
		this.pin_count = pin_count;
	}

	public boolean isDirty() {
		return dirty;
	}

	public void setDirty(boolean dirty) {
		this.dirty = dirty;
	}
	
	public byte[] getContenu() {
		return this.contenu;
	}
	
	public void setContenu(byte[] b) {
		this.contenu = b;
	}
	
}
