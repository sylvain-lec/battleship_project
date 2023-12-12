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
		// jsp ce qu'il faut faire ici j'ai fait un peu au hasard
	
		if (etat==GAMEOVER)
			System.out.println("Gagné !");
		if (etat==TOUCHE)
			System.out.println("tir en " + c+" : vous avez touché un navire");
		if (etat==COULE)
			System.out.println("tir en " + c+" : vous avez coulé un navire");
		if (etat==A_L_EAU)
			System.out.println("tir en " + c+" : vous avez tiré dans l'eau");
	}
	
	protected void retourDefense(Coordonnee c, int etat) {
		//c est la coordonnée à laquelle le tir a eu lieu et etat le résultat de ce tir. etat ne peut être que TOUCHE, COULE, A_L_EAU, ou GAMEOVER. 
		if (etat==GAMEOVER)
			System.out.println("Vous avez perdu :(");
		if (etat==TOUCHE)
			System.out.println("tir en " + c+" : un navire a été touché");
		if (etat==COULE)
			System.out.println("tir en " + c+" : un navire a coulé");
		if (etat==A_L_EAU)
			System.out.println("tir en " + c+" : tout va bien yayyy");
	}
	
	public Coordonnee choixAttaque() {
		// genere coordonnee aleatoire
		
		//version simple :
		//Coordonnee attaque = new Coordonnee(new Random().nextInt(super.getTailleGrille() - 1), new Random().nextInt(super.getTailleGrille() - 1));
		//return attaque;
		
		Coordonnee attaque;
		do {
			attaque = new Coordonnee(new Random().nextInt(super.getTailleGrille() - 1), new Random().nextInt(super.getTailleGrille() - 1));
		} while (super.grille.estDansTirsRecus(attaque) || attaque.voisine(???)); //methode de superclasse estDansTirsRecus private
		
		return attaque;
	
}
