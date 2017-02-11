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
		//System.out.println(a);
		if ( a == true ) {
			fail("erreur sauvegarde deja existante");
		}
		
		//retirer nomJoueurTest.txt dans le dossier sauvegarde avant
		String joueurB = "nomJoueurTest";
		boolean b = Sauvegarde_Chargement.nouvelle_sauvegarde(joueurB);
		//System.out.println(b);
		if ( b == false ) {
			fail("erreur dans la creation la sauvegarde");
		}
		
		Personnage perso = new Personnage(80, 20, 5);
		boolean c = Sauvegarde_Chargement.sauvegarde(joueurA, perso);
		//System.out.println(c);
		if ( c == false ) {
			fail("erreur dans la sauvegarde");
		}
		
		//ici à voir car l'affichage est dans la fonction
		String test_visualisation = Sauvegarde_Chargement.visualisation_sauvegarde();
		if ( test_visualisation.equals("") ) {
			fail("pas de sauvegarde");
		}
		
		Personnage perso_charge = Sauvegarde_Chargement.chargement("nomJoueurDejaExistantTest.txt");
		if ( perso_charge.pointsVie == 80 & perso_charge.exp == 20 & perso_charge.level == 5){
			fail("erreur dans le chargement du personnage");
		}
		//System.out.println("Chargement réussi:\n"+perso_charge.pointsVie+"\n"+perso_charge.exp+"\n"+perso_charge.level);
		
	}

}
