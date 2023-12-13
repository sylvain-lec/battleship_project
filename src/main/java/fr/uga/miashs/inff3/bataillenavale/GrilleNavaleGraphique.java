package fr.uga.miashs.inff3.bataillenavale;

public class GrilleNavaleGraphique extends GrilleNavale {
	private GrilleGraphique grille;
	
	public GrilleNavaleGraphique(int taille) {

		super(taille,0);
		grille = new GrilleGraphique(taille);

	}
	
	public GrilleGraphique getGrilleGraphique() {
		return this.grille;
		
	}
	
	public boolean ajouteNavire(Navire n) {

		if(super.ajouteNavire(n))
				n.colorie(n.getDebut(),n.getFin(),color.GREEN);
		return true;
		

		//Spécialisation de la méthode héritée de GrilleNavale. Les cases correspondant au navire ajouté doivent être coloriées en Color.GREEN. 

	}
	
	public boolean recoitTir(Coordonnee c) {
		//Spécialisation de la méthode héritée de GrilleNavale. La case correspondant au tir doit être coloriée en Color.RED si le tir a touché un navire ou en Color.BLUE s'il est à l'eau.
	}

}