package fr.uga.miashs.inff3.bataillenavale;

import java.awt.Color;

public class GrilleNavaleGraphique extends GrilleNavale {
	private GrilleGraphique grille;
	
	public GrilleNavaleGraphique(int taille) {

		super(taille,6);
		grille = new GrilleGraphique(taille);

	}
	
	public GrilleGraphique getGrilleGraphique() {
		return this.grille;
		
	}
	
	public boolean ajouteNavire(Navire n) {
		//Spécialisation de la méthode héritée de GrilleNavale. Les cases correspondant au navire ajouté doivent être coloriées en Color.GREEN. 
		if(super.ajouteNavire(n))
				grille.colorie(n.getDebut(),n.getFin(),Color.GREEN);
		return true;
	}
	
	public boolean recoitTir(Coordonnee c) {
		//Spécialisation de la méthode héritée de GrilleNavale. La case correspondant au tir doit être coloriée en Color.RED si le tir a touché un navire ou en Color.BLUE s'il est à l'eau.
		for (int i = 0; i<super.getNbNavires();i++) {
			if(super.recoitTir(c) && super.estTouche(c))
				grille.colorie(.getDebut(),n.getFin(),Color.RED);
			else if (super.recoitTir(c) && super.estALEau(c))
				grille.colorie(n.getDebut(),n.getFin(),Color.RED);
				
		}
			
			
	
	}

}
