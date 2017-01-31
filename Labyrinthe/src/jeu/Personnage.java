package jeu;

public class Personnage {
	
	int pointsVie;
	int exp;
	int niveau;
	
	//constructeur par d�faut (nouveau personnage)
	public Personnage (){
		pointsVie = 10;
		exp = 0;
		niveau = 1;
	}
	
	//constructeur utilis� lors d'un chargement (le personnage r�cup�re toutes ses caract�ristiques)
	public Personnage (int pv, int xp, int nv){
		pointsVie = pv;
		exp = xp;
		niveau = nv;
	}
	
	//Personnage donne coup � Ennemi -> changement des pv ennemi, et de l'xp du perso
	public void donneCoup(Personnage perso, Ennemi enn){
		int degatsMoy = perso.niveau*3; //� chaque niveau, le personnage gagne 3 pts de d�gats moyens
		perso.exp += 10; //� cahque coup le personnage gagne de l'experience
		int degats;
		//� chaque coup, le perso peut faire un �chec, une r�ussite ou une r�ussite critique qui influent sur les degats du coup
		int jetDe = (int)Math.random()*2;
		if (jetDe == 0){ //echec
			degats = degatsMoy - 2;
		}
		else {
			if (jetDe == 1){ //r�ussite
				degats = degatsMoy;
			}
			else { //r�ussite critique
				degats = degatsMoy + 2;
			}
		}
		enn.pointsVie -= degats; //on enl�ve les points de vie correspondants � l'ennemi	
	}
	
	public boolean estMort(Personnage perso){
		return (perso.pointsVie == 0);
	}
	
}
