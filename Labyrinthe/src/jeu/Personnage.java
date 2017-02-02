package jeu;

public class Personnage {
	
	public int pointsVie;
	public int exp;
	public int level;
	
	//constructeur par défaut (nouveau personnage)
	public Personnage (){
		pointsVie = 10;
		exp = 0;
		level = 1;
	}
	
	//constructeur utilisé lors d'un chargement (le personnage récupère toutes ses caractéristiques)
	public Personnage (int pv, int xp, int nv){
		pointsVie = pv;
		exp = xp;
		level = nv;
	}

	//Personnage donne coup à Ennemi -> changement des pv ennemi, et de l'xp du perso
	public void donneCoup(Ennemi enn){
		int degatsMoy = this.level*3; //à chaque niveau, le personnage gagne 3 pts de dégats moyens
		this.exp += 10; //à cahque coup le personnage gagne de l'experience
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
	
	public void levelSuperieur(){
		if (this.exp >= (this.level*110)){
			this.level ++;
		}
	}
	
	public boolean estMort(){
		return (this.pointsVie == 0);
	}
	
}
