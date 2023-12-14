package fr.uga.miashs.inff3.bataillenavale;

import java.awt.Color;

public class GrilleNavaleGraphique extends GrilleNavale {
	private GrilleGraphique grille;
	
	public GrilleNavaleGraphique(int taille) {
		super(taille, 5);
		//int[] liste = super.ListeNavires();
		//super.setNbNavires(liste.length);
		grille = new GrilleGraphique(taille);
	}
	
	public GrilleGraphique getGrilleGraphique() {
		return this.grille;
		
	}
	
	public boolean ajouteNavire(Navire n) {
		//Spécialisation de la méthode héritée de GrilleNavale. Les cases correspondant au navire ajouté doivent être coloriées en Color.GREEN. 
		if(super.ajouteNavire(n)) {
			grille.colorie(n.getDebut(),n.getFin(),Color.GREEN);
			return true;
		}
		return false;
	}
	
	public boolean recoitTir(Coordonnee c) {
		//Spécialisation de la méthode héritée de GrilleNavale. La case correspondant au tir doit être coloriée en Color.RED si le tir a touché un navire ou en Color.BLUE s'il est à l'eau.
	/*	for (int i = 0; i<super.getNbNavires();i++) {
			if(super.recoitTir(c) && super.estTouche(c)) {
				grille.colorie(c,Color.RED);
				grille.setClicActive(false);
				return true;
			}else if (super.recoitTir(c) && super.estALEau(c)) {
				grille.colorie(c,Color.BLUE);	
				grille.setClicActive(false);
				return false;
			}
		}
		return false;
		*/
		//grille.setClicActive(false);
		if(super.recoitTir(c)) {
			grille.colorie(c, Color.RED);
			return true;
		}
		else if (super.estALEau(c)) {
			grille.colorie(c, Color.BLUE);
			return false;
		}
		return false;
	}
}
