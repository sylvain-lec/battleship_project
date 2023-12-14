package fr.uga.miashs.inff3.bataillenavale;

import java.awt.Color;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class JoueurGraphique extends JoueurAvecGrille {

	private GrilleGraphique grilleTirs;
	
	// CONSTRUCTEURS
	public JoueurGraphique(GrilleNavaleGraphique grilleDefense, GrilleGraphique grilleTirs, String nom) {
		// permet d'obtenir un joueur graphique de nom nom qui effectue des tirs en cliquant sur grilleTirs et dont la flotte est placée sur grilleDefense.
		super(grilleDefense, nom);
		this.grilleTirs = grilleTirs;
	}
	
	public JoueurGraphique(GrilleNavaleGraphique grilleDefense, GrilleGraphique grilleTirs) {
		// permet d'obtenir un joueur graphique qui effectue des tirs en cliquant sur grilleTirs et dont la flotte est placée sur grilleDefense.
		super(grilleDefense);
		this.grilleTirs = grilleTirs;
	}
	
	// METHODES
	public Coordonnee choixAttaque() {
		//Consiste à récupérer la coordonnée choisie depuis grilleTirs.
		Coordonnee attaque = grilleTirs.getCoordonneeSelectionnee();
		return attaque; 
	}
	
	protected void retourAttaque(Coordonnee c, int etat) {
		//Affichage d'un JOptionPane lorsque le tir a touché ou coulé un navire, ou lorsque la partie est perdue.
		Color couleur = etat == A_L_EAU ? Color.BLUE : Color.RED; grilleTirs.colorie(c, couleur);
		switch (etat) {
		case TOUCHE:
			JOptionPane.showMessageDialog(grilleTirs, "Vous avez touché un navire en " + c);
			break;
		case COULE:
			JOptionPane.showMessageDialog(grilleTirs, "Vous avez coulé un navire en " + c);
			break;
		case GAMEOVER:
			JOptionPane.showMessageDialog(grilleTirs, "Vous avez gagné!!!");
		}
	}

	@Override
	protected void retourDefense(Coordonnee c, int etat) {

	}



}
