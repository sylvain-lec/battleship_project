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
			System.out.println("Gagné !");
		else if (etat==COULE)
			System.out.println("tir en " + c+" : vous avez coulé un navire");
		else if (etat==TOUCHE)
			System.out.println("tir en " + c+" : vous avez touché un navire");
		else // etat==A_L_EAU
			System.out.println("tir en " + c+" : vous avez tiré dans l'eau");
	}
	
	protected void retourDefense(Coordonnee c, int etat) {
		// pas sûr que le joueur auto ait besoin d'un retour
		if (etat==GAMEOVER)
			System.out.println("Vous avez perdu :(");
		else if (etat==COULE)
			System.out.println("tir en " + c+" : un navire a coulé");
		else if (etat==TOUCHE)
			System.out.println("tir en " + c+" : un navire a été touché");
		else // etat==A_L_EAU
			System.out.println("tir en " + c+" : tout va bien yayyy");
	}
	
	public Coordonnee choixAttaque() {
		// genere coordonnee aleatoire
		Coordonnee attaque = new Coordonnee(new Random().nextInt(super.getTailleGrille() - 1), new Random().nextInt(super.getTailleGrille() - 1));
		return attaque;
		}
}