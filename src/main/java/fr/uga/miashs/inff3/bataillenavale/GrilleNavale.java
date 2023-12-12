package fr.uga.miashs.inff3.bataillenavale;

public class GrilleNavale {
	private Navire[] navires;
	private int nbNavires;
	private int taille;
	private Coordonnee[] tirsRecus;
	private int nbTirsRecus;

	public GrilleNavale(int taille, int[] taillesNavires) {
		this.navires = null;
		this.nbNavires = taillesNavires.length;
		this.taille = taille;
		tirsRecus = null;
		nbTirsRecus = 0;
	}
	public GrilleNavale(int taille, int nbNavires) {
		this.navires = null;
		this.nbNavires = nbNavires;
		this.taille = taille;
		tirsRecus = null;
		nbTirsRecus = 0;
	}
	public int getTaille() {
		return taille;
	}
	
	
	public String toString() {
		
		String grille;
		String premiereLigne = " ";
		String ligneStandard;
		
		// On obtient la premiere ligne composée des lettre de l'alphabet
		
		for (int i = 0;i <this.getTaille;i++) {
			char lettre =(char) ('A' + i);
			premiereLigne=premiereLigne + lettre + " ";				
		}
		
		// On crée les autres lignes 
		
		for (int j = 0;j <this.getTaille;j++) {
			
		}
		
		
		
		
		
		
	}

	public boolean ajouteNavire(Navire n) {
		
		
	}
}
