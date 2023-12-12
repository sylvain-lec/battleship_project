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
		
		String grille=" ";
		String premiereLigne = "   ";
		String ligneStandard="";
		
		// On obtient la premiere ligne composée des lettre de l'alphabet
	
		
		for (int i = 0;i <this.getTaille();i++) {
			char lettre =(char) ('A' + i);
			premiereLigne=premiereLigne + lettre+ " ";				
		}
		
		grille = grille + premiereLigne + "\n" ;
		
		// On crée les autres lignes 
		
		String lignePoint = " ";
		String chiffre2 ="";
		
		for (int j = 0;j <this.getTaille();j++) {
			int chiffre = j+1;
			
			if (chiffre < 10)
				chiffre2 = chiffre2 + " " +chiffre;
			else
				 chiffre2 = chiffre2 +chiffre;
			for(int k = 0;k <this.getTaille();k++) {
				
				char point = '.';
				lignePoint = lignePoint + point +" " ;
			}
			ligneStandard = ligneStandard + chiffre2 + " ";
			ligneStandard = ligneStandard + lignePoint;
			grille = grille + ligneStandard +  "\n";
			ligneStandard = "";
			lignePoint = " ";
			chiffre2="";
		}
		return grille;
	}
		
		
		
		
		


	public boolean ajouteNavire(Navire n) {
		
		return true;
	}
	public static void main(String[] args) {
		int [] tab = new int [0];
		GrilleNavale test = new GrilleNavale (10, tab);
		System.out.println(test.toString());
		
		
	}
}
