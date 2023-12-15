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
			System.out.println("tir en " + c+" : un navire de " + this.getNom() + " a coulé");
		else if (etat==TOUCHE)
			System.out.println("tir en " + c+" : un navire de " + this.getNom() + " a été touché");
		else // etat==A_L_EAU
			System.out.println("tir en " + c+" : aucun bateau de " + this.getNom() + " n'a été touché");
	}
	
	public Coordonnee choixAttaque() {
		// genere coordonnee aleatoire
		Coordonnee attaque = new Coordonnee(new Random().nextInt(super.getTailleGrille() - 1), new Random().nextInt(super.getTailleGrille() - 1));
		return attaque;
		}
}