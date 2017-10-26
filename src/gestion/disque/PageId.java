package gestion.disque;

public class PageId {

	private int FileId;
	private int idX;
	
	public PageId(int fi, int id) {
		this.FileId = fi;
		this.idX = id;
	}
	public int getFileId() {
		return FileId;
	}
	public void setFileId(int fileId) {
		FileId = fileId;
	}
	public int getIdX() {
		return idX;
	}
	public void setIdX(int idX) {
		this.idX = idX;
	}
}
