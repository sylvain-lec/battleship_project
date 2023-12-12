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
	
		if (etat==4)
			System.out.println("tir en " + c +" : gameover");
		if (etat==1)
			System.out.println("tir en " + c+" : navire touché");
		if (etat==2)
			System.out.println("tir en " + c+" : navire coulé");
		if (etat==3)
			System.out.println("tir en " + c+" : à l'eau");
	}
	
	protected void retourDefense(Coordonnee c, int etat) {
		//affichage à la console des étapes de jeu
		this.retourAttaque(c, etat);
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
