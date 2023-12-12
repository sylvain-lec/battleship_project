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
		if (grille.perdu())
			return 4;
		else if (grille.estTouche(c))
			return 1;
		else if (grille.estCoule(c))
			return 2;
		// sinon c'est dans l'eau
		return 3;
	}
}
