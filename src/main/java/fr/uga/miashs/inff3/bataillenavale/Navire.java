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
	
	public int tailleNavire() {
		if (estVertical())
			return (this.fin.getLigne() - this.debut.getLigne() + 1);
		else
			return (this.fin.getColonne() - this.debut.getColonne() + 1);
	}

	public String toString() {
		String orientation = "";
		if (!estVertical())
			orientation += "vertical";
		else {
			orientation += "horizontal";
		}
		// retourne un résultat de type "Navire(B1, 4, horizontal)"
		return ("Navire(" + debut.toString() + ", " + this.tailleNavire() + ", " + orientation + ")");
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
	
	public Coordonnee[] tableauCoordonnees() {
		Coordonnee[] tab = new Coordonnee[this.tailleNavire()];
		if (this.estVertical()) {
			// on boucle de la ligne du début à la fin pour this
			for (int i = this.debut.getLigne(), j = 0; i == this.fin.getLigne(); i++) {
				// on remplit le tableau de l'indice 0 à tailleNavire
				tab[j] = new Coordonnee(i, this.fin.getColonne());
			}
		}
		else {
			// on boucle de la colonne du début à la fin pour this
			for (int i = this.debut.getColonne(), j = 0; i == this.fin.getColonne(); i++) {
				// on remplit le tableau de l'indice 0 à tailleNavire
				tab[j] = new Coordonnee(this.fin.getLigne(), i);
			}
		}
		return tab;
	}
	
	public boolean touche(Navire n) {
		// Retourne true si et seulement si this est adjacent à n. L'adjacence par la diagonale ne compte pas.
		for (int i = 0; i < this.tailleNavire(); i++) {
			for (int j = 0; j < n.tailleNavire(); j++) {
				if (this.tableauCoordonnees()[i].voisine(n.tableauCoordonnees()[j]))
					return true;
			}
		}
		return false;
		/* USELESS
		 if (this.estVertical()) {
			// on boucle de la ligne de début à la fin pour this
			for (int i = this.debut.getLigne(); i <= this.fin.getLigne(); i++) {
				// on stocke les coordonnées de this pour le test ultérieur
				Coordonnee CoordonneTestThis = new Coordonnee(i, this.debut.getColonne());
				if (n.estVertical()) {
					// on boucle de la ligne de début à la fin pour n
					for (int j = n.debut.getLigne(); j <= this.fin.getLigne(); j++) {
						// on stocke les coordonnées de n pour le test ultérieur
						Coordonnee CoordonneTestN = new Coordonnee(j, n.debut.getColonne());
						// on compare la voisinité des coordonnées
						if (CoordonneTestThis.voisine(CoordonneTestN))
							// si voisinité = true
							return true;
					}
				}
				// n est horizontal
				else {
					for (int j = n.debut.getColonne(); j <= this.fin.getColonne(); j++) {
						Coordonnee CoordonneTestN = new Coordonnee(n.debut.getLigne(), j);
						if (CoordonneTestThis.voisine(CoordonneTestN))
							return true;
					}
				}
			}
		}
		// this est horizontal
		else {*/
	}
	
	public boolean chevauche(Navire n) {
		// Retourne true si et seulement si this chevauche n, c'est-à-dire que this et n occupent au moins une coordonnée en commun.
		for (int i = 0; i < this.tailleNavire(); i++) {
			for (int j = 0; j < n.tailleNavire(); j++) {
				if (this.tableauCoordonnees()[i].equals(n.tableauCoordonnees()[j]))
					return true;
			}
		}
		return false;
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