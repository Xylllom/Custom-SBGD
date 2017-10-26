package structure.relation;

import java.io.Serializable;

import outils.Type;

public class RelationStruct implements Serializable{
	private RelationSchema rs;
	private int FileId;

	public RelationStruct(int indice, String n, int l, Type[] t) {
		this.rs = new RelationSchema(n,l,t);
		this.FileId = indice;
	}
	
	public RelationSchema getRs() {
		return rs;
	}

	public void setRs(RelationSchema rs) {
		this.rs = rs;
	}

	public int getFileId() {
		return FileId;
	}

	public void setFileId(int fileId) {
		FileId = fileId;
	}

}
