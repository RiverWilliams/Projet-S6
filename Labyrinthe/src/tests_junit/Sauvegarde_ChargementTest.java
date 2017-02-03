package tests_junit;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;

import jeu.Personnage;
import sauvegarde.*;

public class Sauvegarde_ChargementTest {

	@Test
	public void test() throws IOException {
		String joueurA = "nomJoueurDejaExistantTest";
		boolean a = Sauvegarde_Chargement.nouvelle_sauvegarde(joueurA);
		System.out.println(a);
		
		String joueurB = "nomJoueurTest";
		boolean b = Sauvegarde_Chargement.nouvelle_sauvegarde(joueurB);
		System.out.println(b);
		
		Personnage perso = new Personnage(80, 20, 5);
		boolean c = Sauvegarde_Chargement.sauvegarde(joueurA, perso);
		System.out.println(c);
		
		//ici à voir car l'affichage est dans la fonction
		String test_visualisation = Sauvegarde_Chargement.visualisation_sauvegarde();
		
		Personnage perso_charge = Sauvegarde_Chargement.chargement("nomJoueurDejaExistantTest.txt");
		System.out.println("Chargement réussi:\n"+perso_charge.pointsVie+"\n"+perso_charge.exp+"\n"+perso_charge.level);
		
	}

}
