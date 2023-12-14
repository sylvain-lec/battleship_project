package fr.uga.miashs.inff3.bataillenavale;

public class Navire {
	
	private Coordonnee debut;
	private Coordonnee fin;
	private Coordonnee[] partiesTouchees;
	private int nbTouchees; 

	public Navire(Coordonnee debut, int longueur, boolean estVertical){
		if (longueur <= 0) {
            throw new IllegalArgumentException("Longueur invalide");
        }
		this.debut = debut;
		// si vertical, ligne impactée par longueur sinon c'est la colonne
		if (estVertical) 
			this.fin = new Coordonnee (this.debut.getLigne() + (longueur - 1), this.debut.getColonne());
		else
			this.fin = new Coordonnee (this.debut.getLigne(), this.debut.getColonne() + (longueur - 1));
		partiesTouchees = new Coordonnee[10]; // 10 c'est bien
		nbTouchees = 0;
	}
	
	public int tailleNavire() {
		return (1 + this.fin.getLigne() - this.debut.getLigne() + this.fin.getColonne() - this.debut.getColonne());
	}

	public String toString() {
		String orientation = "";
		if (this.fin.getLigne() == this.debut.getLigne())
			orientation += "horizontal";
		else {
			orientation += "vertical";
		}
		// retourne un résultat de type "Navire(B1, 4, horizontal)"
		return ("Navire(" + debut + ", " + this.tailleNavire() + ", " + orientation + ")");
	}
	
	public Coordonnee getDebut() {
		return this.debut;
	}
	
	public Coordonnee getFin() {
		return this.fin;
	}
	
	public boolean contient(Coordonnee c) {
		//test si c ligne comprise entre début et fin de this et colonne de c comprise entre début et fin de this
		if(c.getLigne() >= this.debut.getLigne() && c.getLigne() <= this.fin.getLigne() && (c.getColonne() >= this.debut.getColonne() && c.getColonne() <= this.fin.getColonne()))
				return true;
		return false;
	}
	
	/*public Coordonnee[] tableauCoordonnees() {
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
	}*/
	
	public boolean touche(Navire n) {
		// Retourne true si et seulement si this est adjacent à n. L'adjacence par la diagonale ne compte pas.
		int debutLigneThis = debut.getLigne();
        int finLigneThis = fin.getLigne();
        int debutColonneThis = debut.getColonne();
        int finColonneThis = fin.getColonne();
    
        int debutLigneN = n.debut.getLigne();
        int finLigneN = n.fin.getLigne();
        int debutColonneN = n.debut.getColonne();
        int finColonneN = n.fin.getColonne();
		     
        boolean ligneCommune = (finLigneThis >= debutLigneN && debutLigneThis <= finLigneN); 
        boolean colonneCommune = (finColonneThis >= debutColonneN && debutColonneThis <= finColonneN);
    
        return (ligneCommune && (debutColonneThis == finColonneN + 1 || finColonneThis == debutColonneN - 1)) || (colonneCommune && (debutLigneThis == finLigneN + 1 || finLigneThis == debutLigneN - 1));
		
		/* Methode avec tableau de coordonnées
		for (int i = 0; i < this.tailleNavire(); i++) {
		 
			for (int j = 0; j < n.tailleNavire(); j++) {
				if (this.tableauCoordonnees()[i].voisine(n.tableauCoordonnees()[j]))
					return true;
			}
		}
		return false;*/
	}
	
	public boolean chevauche(Navire n) {
		// Retourne true si et seulement si this chevauche n, c'est-à-dire que this et n occupent au moins une coordonnée en commun.
		int debutLigneThis = debut.getLigne();
        int finLigneThis = fin.getLigne();
        int debutColonneThis = debut.getColonne();
        int finColonneThis = fin.getColonne();
    
        int debutLigneN = n.debut.getLigne();
        int finLigneN = n.fin.getLigne();
        int debutColonneN = n.debut.getColonne();
        int finColonneN = n.fin.getColonne();
		     
        boolean ligneCommune = (finLigneThis >= debutLigneN && debutLigneThis <= finLigneN); 
        boolean colonneCommune = (finColonneThis >= debutColonneN && debutColonneThis <= finColonneN);
        
        return (ligneCommune && colonneCommune);
        
        /* Methode avec tableau de coordonnées
		 for (int i = 0; i < this.tailleNavire(); i++) {
			for (int j = 0; j < n.tailleNavire(); j++) {
				if (this.tableauCoordonnees()[i].equals(n.tableauCoordonnees()[j]))
					return true;
			}
		}
		return false;*/
	}
	
	public boolean recoitTir(Coordonnee c) {
		// Retourne true si et seulement si this contient c. Dans ce cas, c est ajoutée aux parties touchées si nécessaire.
		int debutLigneThis = debut.getLigne();
        int finLigneThis = fin.getLigne();
        int debutColonneThis = debut.getColonne();
        int finColonneThis = fin.getColonne();
        
        boolean ligneCommune = (finLigneThis >= c.getLigne() && debutLigneThis <= c.getLigne()); 
        boolean colonneCommune = (finColonneThis >= c.getColonne() && debutColonneThis <= c.getColonne());
        if (ligneCommune && colonneCommune && !(this.estTouche(c))) {
        	nbTouchees += 1;
    		// agrandit le tableau navires si besoin 
    		if (partiesTouchees.length == nbTouchees) {
    			Coordonnee[] tmp = new Coordonnee[partiesTouchees.length+5];
    			for (int i=0 ; i<nbTouchees ; i++) {
    				tmp[i] = partiesTouchees[i];
    			}
    			partiesTouchees = tmp;
    		}
            // intègre les coordonnées du tir c dans le tableau après éventuels tirs précédents
            partiesTouchees[nbTouchees - 1] = c;
            return true;
        }
        return false;
		
		/* Methode avec tableau de coordonnées
		for (int i = 0; i < this.tailleNavire(); i++) {
				if (this.tableauCoordonnees()[i].equals(c))
					return true;
		}
		return false;*/
	}
	
	public boolean estTouche(Coordonnee c) {
	// Retourne true si et seulement si this a été touché par un tir en c.
		for (int i = 0; i < nbTouchees; i++) {
			if (partiesTouchees[i].equals(c))
				return true;
		}
		return false;
	}
	
	public boolean estTouche() {
	// Retourne true si et seulement si this a au moins une partie touchée.
		return nbTouchees > 0;
	}
	
	public boolean estCoule() {
		return nbTouchees == tailleNavire();
	}
}