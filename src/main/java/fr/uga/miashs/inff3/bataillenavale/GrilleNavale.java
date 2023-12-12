package fr.uga.miashs.inff3.bataillenavale;

public class GrilleNavale {
	private Navire[] navires;
	private int nbNavires;
	private int taille;
	private Coordonnee[] tirsRecus;
	private int nbTirsRecus;

	public GrilleNavale(int taille, int[] taillesNavires) {
		this.navires = new Navire[taillesNavires.length];
		this.nbNavires = taillesNavires.length;
		this.taille = taille;
		tirsRecus = null;
		nbTirsRecus = 0;
	}
	
	public GrilleNavale(int taille, int nbNavires) {
		this.navires = new Navire[nbNavires];
		this.nbNavires = nbNavires;
		this.taille = taille;
		tirsRecus = null;
		nbTirsRecus = 0;
	}

	
	public String toString() {
		
		StringBuffer grille= new StringBuffer ();
		StringBuffer premiereLigne = new StringBuffer ("   ");
		StringBuffer ligneStandard= new StringBuffer ();
		
		// On obtient la premiere ligne composée des lettre de l'alphabet
	
		
		for (int i = 0;i <this.getTaille();i++) {
			char lettre =(char) ('A' + i);
			premiereLigne.append(lettre+ " ");				
		}
		
		grille.append(premiereLigne + "\n") ;
		
		// On crée les autres lignes 
		
		StringBuffer lignePoint = new StringBuffer("");
		String chiffre2 ="";
		
		for (int j = 0;j <this.getTaille();j++) {
			int chiffre = j+1;
			
			if (chiffre < 10)
				chiffre2 = chiffre2 + " " +chiffre;
			else
				 chiffre2 = chiffre2 +chiffre;
			for(int k = 0;k <this.getTaille();k++) {
				
				char point = '.';
				lignePoint.append(point +" ") ;
			}
			ligneStandard.append(chiffre2 + " ");
			ligneStandard.append(lignePoint);
			grille.append(ligneStandard +  "\n");
			ligneStandard = new StringBuffer ("");
			lignePoint = new StringBuffer ();
			chiffre2="";
		}
		return grille.toString();
	}
	public void CasesNavire (Coordonnee c){
		
			
	}
		
		

	public Navire[] getNavires() {
		return navires;
	}
	public void setNavires(Navire[] navires) {
		this.navires = navires;
	}
	public int getNbNavires() {
		return nbNavires;
	}
	public void setNbNavires(int nbNavires) {
		this.nbNavires = nbNavires;
	}
	public Coordonnee[] getTirsRecus() {
		return tirsRecus;
	}
	public void setTirsRecus(Coordonnee[] tirsRecus) {
		this.tirsRecus = tirsRecus;
	}
	public int getNbTirsRecus() {
		return nbTirsRecus;
	}
	public void setNbTirsRecus(int nbTirsRecus) {
		this.nbTirsRecus = nbTirsRecus;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	
	public boolean ajouteNavire(Navire n) {
		
		return true;
	}
	public static void main(String[] args) {
		int [] tab = new int [0];
		GrilleNavale test = new GrilleNavale (5, tab);
		System.out.println(test.toString());
		
		
	}
}
