package jeu;

public class Ennemi {
	
	int pointsVie;
	NiveauJeu niv;
	String loot;
	
	public Ennemi (NiveauJeu niv, String loot){
		this.niv = niv;
		pointsVie = niv.niveau*12;
		this.loot = loot;
	}
	
	//ennemi donne coup au personnage -> modif des pv du personnage 
	public void donneCoup(Ennemi enn, Personnage perso){
		int degatsMoy = niv.niveau*2;
		int degats;
		int jetDe = (int)Math.random()*2;
		if (jetDe == 0){ //echec
			degats = degatsMoy - 1;
		}
		else {
			if (jetDe == 1){ //réussite
				degats = degatsMoy;
			}
			else { //réussite critique
				degats = degatsMoy + 1;
			}
		}
		perso.pointsVie -= degats; 
	}
	
	public boolean estMort(Ennemi enn){
		return (enn.pointsVie == 0);
	}

}
