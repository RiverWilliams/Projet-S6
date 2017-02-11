package sauvegarde;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import java.util.StringTokenizer;

import jeu.Personnage;

public class Sauvegarde_Chargement {

	public static boolean nouvelle_sauvegarde(String nomJoueur) throws IOException{
		File file = new File("src//sauvegarde");
		try {
			for(File nom : file.listFiles()){
				System.out.print("\t" + ((nom.isDirectory()) ? nom.getName()+"/" : nom.getName())+"\n");
				if(nom.getName().equals(nomJoueur+".txt")){
					System.out.println("Nom du joueur deja pris");
					return false;
				}
			}
			try {
				BufferedWriter save = new BufferedWriter(new FileWriter(new File("src//sauvegarde//"+nomJoueur+".txt")));
				save.close();
			} catch (FileNotFoundException e){
				System.out.println("Erreur fonction nouvelle_sauvegarde");
			}
		} catch (NullPointerException e) {
		}
		return true;
	}

	public static boolean sauvegarde(String nom, Personnage perso) throws IOException{
		// On sauvegarde ligne par ligne les caractéristiques du personnage
		String nomSauvegarde = nom;
		try {
			BufferedWriter save = new BufferedWriter(new FileWriter(new File("src//sauvegarde//"+nomSauvegarde+".txt")));
			save.write("\n"+String.valueOf(perso.pointsVie)+"\n"+String.valueOf(perso.exp)+"\n"+String.valueOf(perso.level)+"\n");
			save.close();
			return true;
		} catch (FileNotFoundException e){
			System.out.println("Erreur fonction sauvegarde");
		}
		return false;
	}

	public static String visualisation_sauvegarde(){
		System.out.println("Sauvegarde disponible:");
		File file = new File("src//sauvegarde");
		try {
			for(File nom : file.listFiles()){
				System.out.print("\t" + ((nom.isDirectory()) ? nom.getName()+"/" : nom.getName())+"\n");
			}
			System.out.println("\n");
		} catch (NullPointerException e) {
			System.out.println("Erreur fonction visualisation_sauvegarde");
		}
		return "";
	}

	public static Personnage chargement(String nomFichier) throws IOException {
		System.out.println(nomFichier);
		Personnage perso = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("src//sauvegarde//"+nomFichier)));
			StringTokenizer line = new StringTokenizer(br.readLine());
			int pointsVie = Integer.parseInt(br.readLine());
			int exp = Integer.parseInt(br.readLine());
			int level = Integer.parseInt(br.readLine());
			perso = new Personnage(pointsVie, exp, level);
			br.close();
		} catch (FileNotFoundException e){
			System.out.println("Erreur fonction chargement");
		}
		return perso;
	}
}
