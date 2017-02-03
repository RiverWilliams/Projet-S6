package tests_junit;

import static org.junit.Assert.*;

import org.junit.Test;

import jeu.Ennemi;
import jeu.NiveauJeu;
import jeu.Personnage;

public class EnnemiTest {

	@Test
	public void test() {

		Ennemi e1 = new Ennemi(new NiveauJeu(1), "pv");
		Personnage p1 = new Personnage(5,80,1);
		
		if(e1.estMort()){
			fail("erreur calcul de mort");
		}
		
		e1.pointsVie = 0;
		if (! e1.estMort()){
			fail("erreur du calcul de mort 2");
		}
		
		e1.donneLoot(p1);	
		if (p1.pointsVie != 8){
			fail("nombre de pv perso incorrecte apres loot" + p1.pointsVie);
		}
		e1.donneLoot(p1);
		if (p1.pointsVie != 10){
			fail(" nombre pv incorrecte apres loot (cas ou pv+loot > pv max)");
		}
		
		e1.loot = "xp";
		e1.donneLoot(p1);
		if (p1.exp != 90){
			fail("exp incorrecte apres loot");
		}
		
		e1.pointsVie = 10;
		e1.donneCoup(p1);
		if(p1.pointsVie > 9){
			fail("mauvais calcul pv apres coup");
		}
		
	}

}
