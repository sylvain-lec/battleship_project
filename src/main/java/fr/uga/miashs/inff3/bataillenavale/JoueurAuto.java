package fr.uga.miashs.inff3.bataillenavale;

import java.util.Random;

public class JoueurAuto extends JoueurAvecGrille {
	public JoueurAuto(GrilleNavale g, String nom) {
		super(g, nom);
	}
	
	public JoueurAuto(GrilleNavale g) {
		super(g);
	}

	protected void retourAttaque(Coordonnee c, int etat) {
		// pas sûr que le joueur auto ait besoin d'un retour
		if (etat==GAMEOVER)
			System.out.println(this.getNom() + " a gagné !");
		else if (etat==COULE)
			System.out.println(this.getNom() + " : tir en " + c+" : navire coulé");
		else if (etat==TOUCHE)
			System.out.println(this.getNom() + " : tir en " + c+" : navire touché");
		else // etat==A_L_EAU
			System.out.println(this.getNom() + " : tir en " + c+" : dans l'eau");
	}
	
	protected void retourDefense(Coordonnee c, int etat) {
		// pas sûr que le joueur auto ait besoin d'un retour
		if (etat==GAMEOVER)
			System.out.println(this.getNom() + " a perdu :(");
		else if (etat==COULE)
			System.out.println(this.getNom() + " : tir ennemi en " + c+", un navire a coulé" + "\n");
		else if (etat==TOUCHE)
			System.out.println(this.getNom() + " : tir ennemi en " + c+", un navire a été touché" + "\n");
		else // etat==A_L_EAU
			System.out.println(this.getNom() + " : tir ennemi en " + c+", aucun bateau n'a été touché" + "\n");
	}
	
	public Coordonnee choixAttaque() {
		// genere coordonnee aleatoire
		Coordonnee attaque = new Coordonnee(new Random().nextInt(super.getTailleGrille() - 1), new Random().nextInt(super.getTailleGrille() - 1));
		return attaque;
		}
}