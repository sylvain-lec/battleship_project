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
		//c est la coordonnée à laquelle le tir a eu lieu et etat le résultat de ce tir. etat ne peut être que TOUCHE, COULE, A_L_EAU, ou GAMEOVER. 
		this.retourAttaque(c, etat);
	}
	
	public Coordonnee choixAttaque() {
		Scanner sc = new Scanner(System.in);
		// recueille au clavier la saisie de la coordonnée à attaquer
		System.out.print("Coordonnées de l'attaque: ");
		// enregistrement de l'input dans une nouvelle coordonnee
		Coordonnee attaque = new Coordonnee(sc.nextLine());
		return attaque; //CA RETOURNE RIEN
	}

	public static void main(String[] args) {
		Coordonnee c = new Coordonnee("B3");
		GrilleNavale g = new GrilleNavale(10,2);
		JoueurTexte j = new JoueurTexte(g, "sylvain");
		j.choixAttaque(); j.retourAttaque(c, 2);
	}
}