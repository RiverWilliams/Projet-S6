package jeu;

public class Ennemi {
	
	public int pointsVie;
	NiveauJeu niv;
	public String loot;
	
	public Ennemi (NiveauJeu niv, String loot){
		this.niv = niv;
		pointsVie = niv.niveau*12;
		this.loot = loot;
	}
	
	//ennemi donne coup au personnage -> modif des pv du personnage 
	public void donneCoup(Personnage perso){
		int degatsMoy = this.niv.niveau*2;
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
	
	public boolean estMort(){
		return (this.pointsVie == 0);
	}

}
