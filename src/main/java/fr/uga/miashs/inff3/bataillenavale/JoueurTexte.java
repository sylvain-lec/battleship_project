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
		
	}
	
	protected void retourDefense(Coordonnee c, int etat) {
		
	}
	
	public Coordonnee choixAttaque() {
		System.out.print("Coordonnées de l'attaque: ");
		// enregistrement de l'input dans une nouvelle coordonnee
		Coordonnee attaque = new Coordonnee(sc.nextLine());
		return attaque;
	}

}