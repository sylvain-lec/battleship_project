package fr.uga.miashs.inff3.bataillenavale;

public abstract class JoueurAvecGrille extends Joueur {
	private GrilleNavale grille;
	
	public JoueurAvecGrille(GrilleNavale g, String nom) {
		super(g.getTaille(), nom);
		grille = g;
	}
	
	public JoueurAvecGrille(GrilleNavale g) {
		super(g.getTaille());
		grille = g;
	}
	
	public int defendre(Coordonnee c) {
		// c est la coordonnée à laquelle l’attaquant a choisi d’effectuer un tir. 
		// Elle retourne le résultat du tir qui ne peut être que TOUCHE, COULE, A_L_EAU, ou GAMEOVER.
		grille.recoitTir(c); //méthode de GrilleNavale qui ajoute c aux tirs reçus
		if (grille.perdu())
			return GAMEOVER;
		else if (grille.estCoule(c))
			return COULE;
		else if (grille.estTouche(c))
			return TOUCHE;
		// sinon c'est dans l'eau
		return A_L_EAU;
	}

	public GrilleNavale getGrille() {
		return grille;
	}
	
}
