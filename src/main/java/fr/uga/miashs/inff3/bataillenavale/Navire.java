package fr.uga.miashs.inff3.bataillenavale;

public class Navire {
	
	private Coordonnee debut;
	private Coordonnee fin;
	private Coordonnee[] partiesTouchees;
	private int nbTouchees; 

	public Navire(Coordonnee debut, int longueur, boolean estVertical){
		this.debut = debut;
		// si vertical, ligne impactée par longueur sinon c'est la colonne
		if (estVertical) 
			this.fin = new Coordonnee (this.debut.getLigne() + (longueur - 1), this.debut.getColonne());
		else
			this.fin = new Coordonnee (this.debut.getLigne(), this.debut.getColonne() + (longueur - 1));
	}
	
	public boolean estVertical() {
		// test si navire est vertical = true
		if (debut.getLigne() == fin.getLigne())
			return false;
		return true;		
	}

	public String toString() {
		int longueur;
		String orientation = "";
		if (!estVertical()) {
			longueur = fin.getColonne() - debut.getColonne();
			orientation += "vertical";
		}
		else {
			longueur = fin.getLigne() - debut.getLigne();
			orientation += "horizontal";
		}
		// retourne un résultat de type "Navire(B1, 4, horizontal)"
		return ("Navire(" + debut.toString() + ", " + longueur + ", " + orientation + ")");
	}
	
	public Coordonnee getDebut() {
		return this.debut;
	}
	
	public Coordonnee getFin() {
		return this.fin;
	}
	
	public boolean contient(Coordonnee c) {
		// si vertical, test si c sur même colonne que this et si ligne de c comprise entre début et fin de this
		if (estVertical()) {
			if (c.getColonne() == this.debut.getColonne() && (c.getLigne() >= this.debut.getLigne() && c.getLigne() <= this.fin.getLigne()))
				return true;
		}
		else {
		// si horizontal, test si c sur même ligne que this et si colonne de c comprise entre début et fin de this
			if(c.getLigne() == this.debut.getLigne() && (c.getColonne() >= this.debut.getColonne() && c.getColonne() <= this.fin.getColonne()))
				return true;
		}
		return false;
	}
	
	public boolean touche(Navire n) {
		
	}
	
	public boolean chevauche(Navire n) {
		
	}
	
	public boolean recoitTir(Coordonnee c) {
		
	}
	
	public boolean estTouche(Coordonnee c) {
		
	}
	
	public boolean estTouche() {
		
	}
	
	public boolean estCoule() {
		
	}
	
	public static void main(String[] args) {
		Navire test = new Navire (new Coordonnee(2,2),3,true);
		test.contient(new Coordonnee(2,2));		
	}
	
}