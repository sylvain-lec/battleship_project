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
//	public String CasesNavire (Coordonnee c) {
//		int longueurGrille = 3 + (taille* 2);
//		int coordonneeLigne = Navire.toString().charAt(7);// Retrouver la colonne
//		int indiceColonne = navires.toString().charAt(8); // Retrouver la ligne !!!réadapter quand le nbre est à 2 chiffres
//		
//		int Debut = (longueurGrille*coordonneeLigne) + indiceColonne;
//		
//		for (int i = Debut; i <= navires.length; i++) {
//			navires.toString().charAt(i)= "#" ;
//			
//			if (Navire.fin.getLigne() == Navire.debut.getLigne())
////				orientation += "horizontal"
//				for (int j = 0; j < navires.length; j++)
//				navires.toString().charAt(k) = "#" ;
//			else {
////				orientation += "vertical"
//				for (int k = 0; k < navires.length; k++)
//					navires.toString().charAt(8) = "#" ;
//			}
//		}
//			
//	}

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
		Navire a = new Navire (new Coordonnee ("A12"), 3, true);
		Navire b = new Navire (new Coordonnee ("B2"), 2, false);
		Navire [] tab2 = new Navire [] { a, b};
		System.out.println(tab2[0].toString());
		System.out.println(tab2[0].toString().charAt(7));

	
	}
}
