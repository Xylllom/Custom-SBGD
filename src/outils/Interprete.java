package outils;

import outils.Commande;

import java.util.ArrayList;

import gestion.disque.SystemDisk;
import global.Manager;
import structure.relation.RelationSchema;

public class Interprete {

	// A REFAIRE ET A SIMPLIFIER
	
	
	public static String execute(String request){
		String[] args = request.split(" ");
		try {
			Commande principale = Commande.valueOf(args[0]);
			System.out.println("Début "+principale);
			switch (principale){
			case INSERT : 
			case CREATE : 
				Type[] temp = new Type[Integer.parseInt(args[2])];
				for (int i = 3; i < args.length; i ++) {
					temp[i-3] = (Type.valueOf(args[i]));
				}
				Manager.createRelation((String)args[1],Integer.parseInt(args[2]),temp);
				return "CREATED";
			case EXIT : return "Mise en Veille du service...";
			/*case SHOW : RelationSchema temp = (RelationSchema) ActionDisque.charger("/users/licence/ij00351/database/data.tmp");
				System.out.println(temp);
				return "FIN AFFICHAGE";*/
			case DELETE:
				break;
			case DROP:
				break;
			case UPDATE:
				break;
			default:
				break;	
			}
		}
		catch(IllegalArgumentException e){
			return "Syntaxe erronée";
		}
		return "\n";
	}
	
	// REDONDANT DE OUF, ON FAIT DEJA LA DISTINCTION DE LA COMMANDE AU DESSUS
	private static ArrayList convertir(String[] arguments, Commande ordre) {
		ArrayList<Object> param = new ArrayList<Object>();
		switch (ordre) {
		case CREATE :
			param.add((String)arguments[1]);
			param.add(Integer.parseInt(arguments[2]));
			for (int i = 3; i < arguments.length; i ++) {
				param.add(Type.valueOf(arguments[i]));
			}
		}
		return param;	
	}
}