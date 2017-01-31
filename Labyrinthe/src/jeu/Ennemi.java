package jeu;

public class Ennemi {
	
	int pointsVie;
	int degatsMin;
	int degatsMax;
	String loot;
	
	public Ennemi (int pv, int dmin, int dmax, String loot){
		pointsVie = pv;
		degatsMin = dmin;
		degatsMax = dmax;
		this.loot = loot;
	}

}
