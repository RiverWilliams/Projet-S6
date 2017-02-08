package jeu;

public class Coffre {
	
	NiveauJeu niveauJ;
	
	public Coffre (NiveauJeu niv){
		this.niveauJ = niv;
	}
	
	//quand un personnage ouvre un coffre, il peut trouver de la vie, de l'xp ou rien
	public void ouvrir(Personnage perso){
		int jetDe = (int)(Math.random()*5);
		if (jetDe == 0){
			System.out.println("coffre vide");
		}
		else {
			if ((jetDe == 1) || (jetDe == 2)){
				this.contientPV(perso);
			}
			else {
				this.contientXP(perso);
			}
		}
	}
	
	//quand le coffre contient de la vie (on teste le nb de pv pour le pas dépasser le nombre de pv max)
	public void contientPV(Personnage perso){
		int pvGagnes = (int)(Math.random()*10)+1;
		if ((perso.pointsVie + pvGagnes) <= (perso.level*10)){
			perso.pointsVie += pvGagnes;
		}
		else {
			perso.pointsVie = perso.level*10;
		}
	}
	
	//quand le coffre contient de l'experience
	public void contientXP(Personnage perso){
		int xpGagne = (int)(Math.random()*(this.niveauJ.niveau*5))+1;
		perso.exp += xpGagne;
		perso.levelSuperieur();
	}
	
	
	
}
