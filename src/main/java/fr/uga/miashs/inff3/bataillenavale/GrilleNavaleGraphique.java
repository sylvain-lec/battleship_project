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
		
	}
	
	public boolean recoitTir(Coordonnee c) {
		
	}

}
