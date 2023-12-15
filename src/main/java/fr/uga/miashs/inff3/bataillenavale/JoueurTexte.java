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
		if (etat==GAMEOVER)
			System.out.println(super.getNom()+", vous avez gagné !");
		else if (etat==COULE)
			System.out.println(super.getNom()+", tir en "+c+" : un navire a coulé");
		else if (etat==TOUCHE)
			System.out.println(super.getNom()+", vous avez touché un navire en "+ c);
		else // etat==A_L_EAU
			System.out.println(super.getNom()+", vous avez tiré dans l'eau en " + c);
	}
	
	protected void retourDefense(Coordonnee c, int etat) {
		//c est la coordonnée à laquelle le tir a eu lieu et etat le résultat de ce tir. etat ne peut être que TOUCHE, COULE, A_L_EAU, ou GAMEOVER. 
		if (etat==GAMEOVER)
			System.out.println(super.getNom()+", vous avez perdu :(");
		else if (etat==COULE)
			System.out.println(super.getNom()+", tir en "+c+" : votre navire a coulé"  + "\n");
		else if (etat==TOUCHE)
			System.out.println(super.getNom()+", votre navire a été touché en " + c  + "\n");
		else //etat==A_L_EAU
			System.out.println(super.getNom()+", tir en "+c+" :  tout va bien hakuna matata"  + "\n");
	}
	
	public Coordonnee choixAttaque() {
		Scanner sc = new Scanner(System.in);
		Coordonnee attaque = null;
		// recueille au clavier la saisie de la coordonnée à attaquer
		do {
			try { //exception si coordonnee hors des limites de la grille
				System.out.println(super.getNom()+", choisissez les coordonnées de l'attaque : ");
				attaque = new Coordonnee(sc.next()); // enregistrement de l'input dans une nouvelle coordonnee puis retourner la valeur
				if(attaque.getColonne() >= this.getTailleGrille() || attaque.getLigne() >= this.getTailleGrille())
					throw new IllegalArgumentException();
			}
			catch(IllegalArgumentException ex) { //  
				System.out.println("Veuillez entrer des coordonnées de type LettreNombre, en respectant les dimensions de la grille" + "\n");
				}
			catch(Exception e) { // REVOIR CATCH
			System.out.println("coordonnées incorrectes");
			}
			
						
		} while (attaque == null || attaque.getColonne() >= this.getTailleGrille() || attaque.getLigne() >= this.getTailleGrille()); // répéter si coordonnee hors des limites de la grille
		return attaque;
	}
	
	public static void main(String[] args) {
		Coordonnee c = new Coordonnee("B3");
		GrilleNavale g = new GrilleNavale(10,2);
		JoueurTexte j = new JoueurTexte(g, "sylvain");
		j.choixAttaque(); j.retourAttaque(c, 2);
	}
}