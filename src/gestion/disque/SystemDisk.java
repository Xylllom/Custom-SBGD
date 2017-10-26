package gestion.disque;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import outils.Tools;
import structure.basededonnees.DatabaseStruct;

public class SystemDisk{

	public static void creerFichier(int FileId){
		if (FileId != 0)new File("Data_"+FileId+".rf");
	}
	
	/**
	 * Ajoute une page de taille PAGE_SIZE avec des bytes à 0, à la suite du contenu déjà existant
	 * @param FileId, identifie le fichier (equivalent nom)
	 * @return l'indice où se trouve la nouvelle page (techniquement inutile)
	 */
	public static PageId ajouterPage(int FileId){
		byte buffer[] = new byte[Tools.PAGE_SIZE];
		int indicePage = 0;
		try {
			RandomAccessFile file = new RandomAccessFile(Tools.PATH+"Data_"+FileId+".rf","rw");
			Long length = file.length();
			file.seek(length);
			file.write(buffer);
			System.out.println( (int) file.length()/Tools.PAGE_SIZE);
			indicePage = (int) file.length()/Tools.PAGE_SIZE;
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// pas compris
		return new PageId(FileId,indicePage);
	}
	
	/**
	 * Méthode pour la lecture de données utilisable uniquement par une instance de SystemDisk
	 * @param FileId, identifie un fichier sur le disque
	 * @param PageId, identifie une page dans ce fichier (chaque page fait la taille d'un PAGE.SIZE)
	 * @return tableau de byte correspondant aux données de la page
	 */
	public static byte[] lire(PageId pid){
		byte buffer[] = new byte[Tools.PAGE_SIZE];
		try{
			RandomAccessFile file = new RandomAccessFile(Tools.PATH+"Data_"+pid.getFileId()+".rf","r");
			file.seek(pid.getIdX()*Tools.PAGE_SIZE);
			file.read(buffer, 0, Tools.PAGE_SIZE);
		} catch (IOException e){
			e.printStackTrace();
		}
		return buffer;	
	}
	
	public static void clean(int FileId, int PageId){
		
	}
	
	/**
	 * Méthode pour l'écriture de données utilisable uniquement par une instance de SystemDisk
	 * @param FileId
	 * @param PageId
	 * @param buffer
	 */
	public static void ecrire(PageId pid, byte[] buffer){
		try{
			RandomAccessFile file = new RandomAccessFile(Tools.PATH+"Data_"+pid.getFileId()+".rf","w");
			file.seek(pid.getIdX()*Tools.PAGE_SIZE);
			file.write(buffer);
			file.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static void sauvegarderDatabase(DatabaseStruct dbs) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(outils.Tools.PATH+File.separator+"Catalog.df")));
			oos.writeObject(dbs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static DatabaseStruct chargerDatabase() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(outils.Tools.PATH+File.separator+"Catalog.df")));
			return (DatabaseStruct) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	/*
	public static void main(String[] args){
		//ajouterPage(1);
		String s = "A sept sur un mec";
		byte buffer[] = s.getBytes();
		SystemDisk.ecrire(1,0,buffer);
		byte lol[] = SystemDisk.lire(1,0);
		String str = new String(lol, StandardCharsets.UTF_8);
		System.out.println(str);
	}*/
}
