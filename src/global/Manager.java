package global;

import outils.Interprete;

import java.util.List;
import java.util.Scanner;

import gestion.acces.HeapFiles;
import gestion.buffer.SystemBuffer;
import gestion.disque.SystemDisk;
import outils.Type;
import structure.basededonnees.DatabaseStruct;
import structure.relation.RelationStruct;

public class Manager {
	private static Scanner sc = new Scanner(System.in);
	private static DatabaseStruct CurrentDataBase;
	private static RelationStruct CurrentRelation;
	private static SystemBuffer CurrentBuffer;
	private static SystemDisk CurrentDisk;
	
	private static List<HeapFiles> CurrentHeapFiles;
	
	/**
	 * Proc�de � l'initialisation du SGBD en r�cup�rant une instance de base de donn�es
	 * Cr�e ou charge tout le n�cessaire au bon fonctionnement du syst�me
	 */
	public void init() {
		CurrentDataBase = this.CurrentDisk.chargerDatabase();
		if (CurrentDataBase == null) {
			CurrentDataBase = new DatabaseStruct();
		}
		this.actualiserHeapFiles(CurrentDataBase);
	}
	
	/**
	 * Cr�ation de la relation avec divers param�tres, suite � la saisie de la commande Create 
	 * @param nom
	 * @param nbColonnes
	 * @param typeColonnes
	 */
	public static void createRelation(String nom, int nbColonnes, Type[] typeColonnes) {
		CurrentRelation = new RelationStruct(CurrentDataBase.getNbRelations(), nom, nbColonnes, typeColonnes);
		CurrentDataBase.setNbRelations(CurrentDataBase.getNbRelations()+1); // A L'ANCIENNE
		CurrentDataBase.getListeRelations().add(CurrentRelation);
		CurrentDisk.creerFichier(CurrentDataBase.getNbRelations());
		
		
	}
		
	/**
	 * Proc�de � l'extinction du syst�me, sauvegardant ce qui doit l'�tre
	 * Nettoie les fichiers temporaires
	 */
	public void end() {
		CurrentDisk.sauvegarderDatabase(CurrentDataBase);
	}
	
	/**
	 * R�actualise les heapfiles disponibles
	 * Parcourt la liste des relations d'une base de donn�es
	 * puis cr�e un heapfile pour chaque relation ainsi trouv�e
	 * @param dbs
	 */
	public void actualiserHeapFiles(DatabaseStruct dbs) {
		List<RelationStruct> lrs = dbs.getListeRelations();
		for (RelationStruct rs : lrs) {
			CurrentHeapFiles.add(new HeapFiles(rs));
		}
	}
	
	public static void main(String[] args) {
		String request, response ="";
		do {
			System.out.print("bdd>> "); 
			request = sc.nextLine();
			response = Interprete.execute(request.toUpperCase());
			System.out.println(response);
			System.out.println("Fin");
		}while (response != "Mise en Veille du service...");
	}
}
