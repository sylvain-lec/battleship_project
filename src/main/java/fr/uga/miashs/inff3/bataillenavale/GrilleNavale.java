package fr.uga.miashs.inff3.bataillenavale;

import java.util.Random;

public class GrilleNavale {
	private Navire[] navires;
	private int nbNavires;
	private int taille;
	private Coordonnee[] tirsRecus;
	private int nbTirsRecus; // tjrs utiliser cet int pour avoir le nbre de tirs recus car le tableau est init à 10.

	public GrilleNavale(int taille, int[] taillesNavires) {
		// permet d'obtenir une grille navale de taille taille dans laquelle ont été placés automatiquement taillesNavires.length navires dont les tailles sont données dans taillesNavires.
		this.navires = new Navire[taillesNavires.length];
		this.nbNavires = 0;
		this.taille = taille;
		tirsRecus = new Coordonnee[10];
		nbTirsRecus = 0;
		this.placementAuto(taillesNavires);
	}
	
	public GrilleNavale(int taille, int nbNavires) {
		// permet d'obtenir une grille navale vide de taille taille pouvant accueillir jusqu'à nbNavires.
		this.navires = new Navire[nbNavires];
		this.nbNavires = 0;
		this.taille = taille;
		tirsRecus = new Coordonnee[10];
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
		
		for (int j = 0;j <taille;j++) {
			int chiffre = j+1;
			
			if (chiffre < 10)
				chiffre2 = chiffre2 + " " +chiffre;
			else
				 chiffre2 = chiffre2 +chiffre;
			for(int k = 0;k <taille;k++) {
				
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
		
		// Positionnement des navires
		int largeurGrille = 3 + (taille* 2);
		
		for (int i = 0; i < navires.length ; i++) {
			int coordonneeLigne =navires[i].toString().charAt(7); // Retrouver la colonne du navire i
			int indiceColonne = navires.toString().charAt(8); // Retrouver la ligne !!!réadapter quand le nbre est à 2 chiffres
			int Debut = (largeurGrille*coordonneeLigne) + indiceColonne;
		
			if (navires[i].getFin().getLigne() == navires[i].getDebut().getLigne())
//				orientation += "horizontal"
				for (int j = 0; j < navires[i].tailleNavire(); j++)
					grille.setCharAt(Debut +j, '#');
			else {
//				orientation += "vertical"
				for (int k = 1; k <= navires[i].tailleNavire(); k ++)
					grille.setCharAt(Debut + largeurGrille, '#');
			}
			//Positionnement des tirs libres
			
		}
		/*for (int i = 0; i < tirsRecus.length; i++) {
			int coordonneeLigne =tirsRecus[i].getColonne(); // Retrouver la colonne du navire i
			int indiceColonne = tirsRecus[i].getLigne(); // Retrouver la ligne !!!réadapter quand le nbre est à 2 chiffres
			int Debut = (longueurGrille*coordonneeLigne) + indiceColonne;
			
			if (grille.charAt(Debut)[i].getFin().getLigne() == navires[i].getDebut().getLigne())
//				orientation += "horizontal"
				for (int j = 0; j < navires[i].tailleNavire(); j++)
					grille.setCharAt(Debut +j, '#');
			else {
//				orientation += "vertical"
				for (int k = 1; k <= navires[i].tailleNavire(); k ++)
					grille.setCharAt(Debut + longueurGrille, '#');
			}	
		}*/
				
		return grille.toString();	
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
		//Retourne true après avoir ajouté n à this si cet ajout est possible. L'ajout est impossible si n touche ou chevauche un navire déjà présent dans this, ou encore si n dépasse les limites de this.
		for (int i = 0; i < nbNavires; i++) {
				if (this.navires[i].touche(n) || this.navires[i].chevauche(n) || n.getFin().getLigne() > taille || n.getFin().getColonne() > taille)
					return false;
		}
		this.navires[nbNavires] = n;
		nbNavires ++;
		return true;	
	}
	
	public void placementAuto(int[] taillesNavires) {
		// Place automatiquement et aléatoirement taillesNavires.length navires dont les tailles sont données dans taillesNavire.
		for (int i = 0; i < taillesNavires.length; )
			if (this.ajouteNavire(new Navire(new Coordonnee(new Random().nextInt(taille), new Random().nextInt(taille)), taillesNavires[i], new Random().nextBoolean())))
				i++;
	}
	
	private boolean estDansGrille(Coordonnee c) {
		// Retourne true si et seulement si c est dans this.
		return (c.getColonne() < taille && c.getLigne() < taille);
	}
	
	private boolean estDansTirsRecus(Coordonnee c) {
		// Retourne true si et seulement si c correspond à un tir reçu par this.
		for (int i = 0; i < nbTirsRecus; i++) {
			if (tirsRecus[i].equals(c))
				return true;
		}
		return false;
	}
	
	private boolean ajouteDansTirsRecus(Coordonnee c) {
		// Ajoute c aux tirs reçus de this si nécessaire. Retourne true si et seulement si this est modifié.
		if (!(this.estDansTirsRecus(c))) {
			tirsRecus[nbTirsRecus] = c;
			nbTirsRecus ++;
			return true;
		}
		return false;
	}
	
	public boolean recoitTir(Coordonnee c) {
	// Ajoute c aux tirs reçus de this si nécessaire. Retourne true si et seulement si c ne correspondait pas déjà à un tir reçu et a permis de toucher un navire de this.
		return true;

	}
	
	public boolean estTouche(Coordonnee c) {
	// Retourne true si et seulement si un des navires présents dans this a été touché en c.
		return true;

	}
	
	public boolean estALEau(Coordonnee c) {
	// Retourne true si et seulement si c correspond à un tir reçu dans l'eau par this.
		return true;

	}
	
	public boolean estCoule(Coordonnee c) {
	// Retourne true si et seulement si un des navires présents dans this a été touché en c et est coulé.
		return true;

	}
	
	public boolean perdu() {
	//Retourne true si et seulement si tous les navires de this ont été coulés.
		return true;

	}
	
	
	public static void main(String[] args) {
		int [] tab = {3, 2};
		GrilleNavale test = new GrilleNavale(10, 2);
		Navire nav = new Navire(new Coordonnee(0,0), 2, true);
		test.ajouteNavire(nav);
		//test.placementAuto(tab);
		System.out.println(test);
	
	}
}
