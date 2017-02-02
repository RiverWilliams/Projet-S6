package tests_junit;

import static org.junit.Assert.*;

import org.junit.Test;

import jeu.Ennemi;
import jeu.NiveauJeu;
import jeu.Personnage;

public class PersonnageTest {

	@Test
	public void test() {

		Personnage p1 = new Personnage(20, 80, 1);
		Ennemi e1 = new Ennemi(new NiveauJeu(1), null);
		p1.donneCoup(e1);
		//vérification de l'experience apres un coup
		if (p1.exp != 90){
			fail("mauvaise augmentation de l'experience : "+p1.exp);
		}
		//verification des pv ennemi apres un coup
		if (e1.pointsVie < 1){
			fail("mauvais calcul des pvs de l'ennemi apres coup : "+e1.pointsVie);
		}
		
		Personnage p2 = new Personnage();
		//verification de la bonne gestion de la mort
		if (p2.estMort()){
			fail("erreur de mort");
		}
		
		//verification de la bonne gestion des passages de level
		p1.donneCoup(e1);
		p1.donneCoup(e1);
		p1.levelSuperieur();
		if (p1.level != 2){
			fail("erreur passage lvl supérieur " +p1.exp +"  "+ p1.level);
		}
		p1.donneCoup(e1);
		p1.levelSuperieur();
		if (p1.level != 2){
			fail("erreur passage 2 lvl supérieur " +p1.exp +"  "+ p1.level);
		}
	}

}
