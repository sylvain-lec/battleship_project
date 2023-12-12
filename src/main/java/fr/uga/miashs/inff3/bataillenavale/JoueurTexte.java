package fr.uga.miashs.inff3.bataillenavale;

import java.util.Scanner;

public class JoueurTexte extends JoueurAvecGrille {
	private Scanner sc;

	public JoueurTexte(GrilleNavale g, String nom) {
		super(g, nom);
	}
	
	public JoueurTexte(GrilleNavale g) {
		super(g);
	}
	
	protected void retourAttaque(Coordonnee c, int etat) {
		// Réalise l'affichage à la console des étapes de jeu.
		// c est la coordonnée à laquelle le tir a eu lieu et etat le résultat de l'attaque. etat ne peut être que TOUCHE, COULE, A_L_EAU, ou GAMEOVER.
		
	}
	
	protected void retourDefense(Coordonnee c, int etat) {
		
	}
	
	public Coordonnee choixAttaque() {
		// recueille au clavier la saisie de la coordonnée à attaquer
		System.out.print("Coordonnées de l'attaque: ");
		// enregistrement de l'input dans une nouvelle coordonnee
		Coordonnee attaque = new Coordonnee(sc.nextLine());
		return attaque;
	}

}