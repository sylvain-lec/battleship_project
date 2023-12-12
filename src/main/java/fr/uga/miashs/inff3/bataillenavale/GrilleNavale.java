package fr.uga.miashs.inff3.bataillenavale;

import java.util.Random;

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
		//Retourne true après avoir ajouté n à this si cet ajout est possible. L'ajout est impossible si n touche ou chevauche un navire déjà présent dans this, ou encore si n dépasse les limites de this.
		for (int i = 0; i < navires.length; i++) {
				if (this.navires[i].touche(n) || this.navires[i].chevauche(n) || n.getFin().getLigne() > taille || n.getFin().getColonne() > taille)
					return false;
		}
		this.navires[nbNavires] = n;
		nbNavires += 1;
		return true;	
	}
	
	public void placementAuto(int[] taillesNavires) {
		// Place automatiquement et aléatoirement taillesNavires.length navires dont les tailles sont données dans taillesNavire.
		for (int i = 0; i < taillesNavires.length; i++)
			this.ajouteNavire(new Navire(new Coordonnee(new Random().nextInt(taille), new Random().nextInt(taille)), taillesNavires[i], new Random().nextBoolean()));
	}
	
	private boolean estDansGrille(Coordonnee c) {
	// Retourne true si et seulement si c est dans this.
		
	}
	
	private boolean estDansTirsRecus(Coordonnee c) {
	// Retourne true si et seulement si c correspond à un tir reçu par this.
	}
	
	private boolean ajouteDansTirsRecus(Coordonnee c) {
	// Ajoute c aux tirs reçus de this si nécessaire. Retourne true si et seulement si this est modifié.
	}
	
	public boolean recoitTir(Coordonnee c) {
	// Ajoute c aux tirs reçus de this si nécessaire. Retourne true si et seulement si c ne correspondait pas déjà à un tir reçu et a permis de toucher un navire de this.
	}
	
	public boolean estTouche(Coordonnee c) {
	// Retourne true si et seulement si un des navires présents dans this a été touché en c.
	}
	
	public boolean estALEau(Coordonnee c) {
	// Retourne true si et seulement si c correspond à un tir reçu dans l'eau par this.
	}
	
	public boolean estCoule(Coordonnee c) {
	// Retourne true si et seulement si un des navires présents dans this a été touché en c et est coulé.
	}
	
	public boolean perdu() {
	//Retourne true si et seulement si tous les navires de this ont été coulés.
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
