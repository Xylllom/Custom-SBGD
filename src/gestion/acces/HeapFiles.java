package gestion.acces;

import gestion.buffer.SystemBuffer;
import gestion.disque.PageId;
import gestion.disque.SystemDisk;
import structure.relation.RelationStruct;

/**
 * Stocke les données durant l'execution
 * @author Nathan
 *
 */

public class HeapFiles {
	private RelationStruct rs;
	
	public HeapFiles(RelationStruct base) {
		this.rs = base;
	}
	
	public void createHeader() {
		PageId newPage = SystemDisk.ajouterPage(rs.getFileId());
		
	}
}
