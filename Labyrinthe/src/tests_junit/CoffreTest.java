package tests_junit;

import static org.junit.Assert.*;

import org.junit.Test;

import jeu.Coffre;
import jeu.NiveauJeu;
import jeu.Personnage;

public class CoffreTest {

	@Test
	public void test() {

		Coffre c1 = new Coffre(new NiveauJeu(1));
		Personnage p1 = new Personnage(3, 50, 1);
		c1.contientPV(p1);
		if (p1.pointsVie < 4){
			fail("mauvais calcul des pv apres ouverture de coffre");
		}
		c1.contientXP(p1);
		if (p1.exp < 51){
			fail("mauvais calcul de l'xp après ouverture du coffre");
		}
		
	}

}
