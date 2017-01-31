package jeu;

public class Personnage {
	
	int pointsVie;
	int exp;
	int niveau;
	
	//constructeur par défaut (nouveau personnage)
	public Personnage (){
		pointsVie = 10;
		exp = 0;
		niveau = 1;
	}
	
	//constructeur utilisé lors d'un chargement (le personnage récupère toutes ses caractéristiques)
	public Personnage (int pv, int xp, int nv){
		pointsVie = pv;
		exp = xp;
		niveau = nv;
	}
	
	//Personnage donne coup à Ennemi -> changement des pv ennemi, et de l'xp du perso
	public void donneCoup(Personnage perso, Ennemi enn){
		int degatsMoy = perso.niveau*3; //à chaque niveau, le personnage gagne 3 pts de dégats moyens
		perso.exp += 10; //à cahque coup le personnage gagne de l'experience
		int degats;
		//à chaque coup, le perso peut faire un échec, une réussite ou une réussite critique qui influent sur les degats du coup
		int jetDe = (int)Math.random()*2;
		if (jetDe == 0){ //echec
			degats = degatsMoy - 2;
		}
		else {
			if (jetDe == 1){ //réussite
				degats = degatsMoy;
			}
			else { //réussite critique
				degats = degatsMoy + 2;
			}
		}
		enn.pointsVie -= degats; //on enlève les points de vie correspondants à l'ennemi	
	}
	
	public boolean estMort(Personnage perso){
		return (perso.pointsVie == 0);
	}
	
}
