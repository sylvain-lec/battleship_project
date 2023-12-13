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
		if (taille<1 || taille>26)
			throw new IllegalArgumentException("mauvaise taille"); //Vérifie la taille de la grille
		for (int i = 0 ; i<taillesNavires.length ; i++) //vérifie si les navires sont au moins de taille 1
			if (taillesNavires[i]<1)
				throw new IllegalArgumentException("taille minimale navire : 1");
		this.navires = new Navire[taillesNavires.length];
		this.nbNavires = 0;
		this.taille = taille;
		tirsRecus = new Coordonnee[10];
		nbTirsRecus = 0;
		this.placementAuto(taillesNavires);
	}
	
	public GrilleNavale(int taille, int nbNavires) {
		// permet d'obtenir une grille navale vide de taille taille pouvant accueillir jusqu'à nbNavires.
		if (taille<1 || taille>26) //vérifie la taille de la grille
			throw new IllegalArgumentException("mauvaise taille");
		if (nbNavires < 1)
			throw new IllegalArgumentException("nombre minimum navires : 1");
		this.navires = new Navire[nbNavires];
		this.nbNavires = 0;
		this.taille = taille;
		tirsRecus = new Coordonnee[10];
		nbTirsRecus = 0;
	}

	public String toString() {
		
		StringBuffer grille= new StringBuffer (); // Creer la grille
		StringBuffer premiereLigne = new StringBuffer ("   "); //Creer la première ligne composée des lettres de l'alphabet
		StringBuffer ligneStandard= new StringBuffer (); // Creer les autres lignes
		
		// On obtient la premiere ligne 
		
		for (int i = 0; i < taille; i++) {
			char lettre =(char) ('A' + i); 
			premiereLigne.append(lettre + " ");	
		}
		grille.append(premiereLigne + "\n") ;
		
		// On crée les autres lignes 
		
		StringBuffer lignePoint = new StringBuffer("");
		String chiffre2 =""; 
		
		for (int j = 0;j < taille;j++) {
			int chiffre = j+1;
			
			if (chiffre < 10)
				chiffre2 = chiffre2 + " " +chiffre; // nbre à un chiffre avec un espace avant
			else
				 chiffre2 = chiffre2 + chiffre;  // nbre à deux chiffres sans espace avant
//		    chiffre2 += (chiffre < 10) ? " " + chiffre : String.valueOf(chiffre); // Proposition de code_light
			for(int k = 0;k < taille;k++) {
				char point = '.';
				lignePoint.append(point +" ") ; //itération des ". "
//				lignePoint.append('.' + " "); // Proposition de code_light
			}

//				Réinitialisations
			ligneStandard.append(chiffre2 + " ");
			ligneStandard.append(lignePoint);
			grille.append(ligneStandard +  "\n");
			ligneStandard = new StringBuffer ("");
			lignePoint = new StringBuffer ();
			chiffre2="";
		}
		
		// Positionnement des navires
		// char de passage à la ligne + décalage
		int largeurGrille = 4 + (taille* 2);
		
		for (int i = 0; i < nbNavires ; i++) {
			int coordonneeLigne = navires[i].getDebut().getLigne() + 1; // Retrouver la ligne du navire i
			int indiceColonne = navires[i].getDebut().getColonne()*2 + 3; // Retrouver la colonne du navire i
			int Debut = (largeurGrille*coordonneeLigne) + indiceColonne; // point de départ du navire

			if (navires[i].getFin().getLigne() == navires[i].getDebut().getLigne()) 
//				Le navire est orienté en horizontal
				for (int j = 0; j < navires[i].tailleNavire(); j++)
					grille.setCharAt(Debut +j*2, '#'); // remplace "." par "#" vers la droite sur la longueur du navire
			else {
//				Le navire est orienté en vertical
				for (int k = 0; k < navires[i].tailleNavire(); k ++)
					grille.setCharAt(Debut + largeurGrille*k, '#');//remplace "." par "#" vers le bas sur la longueur du navire
			}		
		}

		//Positionnement des tirs TODO
		
		for (int i = 0; i < tirsRecus.length; i++) {
			int coordonneeLigne = tirsRecus[i].getLigne() + 1 ; // Retrouver la ligne du tirsRecus
			int indiceColonne = tirsRecus[i].getColonne()*2 +3; // Retrouver la colonne du tirsRecus
			int PositionTirsRecus = (largeurGrille*coordonneeLigne) + indiceColonne;
			
			if (grille.charAt(PositionTirsRecus) == '.')
//				Une case libre ayant reçu un tir 
//				for (int j = 0; j < navires[i].tailleNavire(); j++)
					grille.setCharAt(PositionTirsRecus, 'O');
			else {
//				Une partie touchée d'un navire.
//				for (int k = 1; k <= navires[i].tailleNavire(); k ++)
					grille.setCharAt(PositionTirsRecus, 'X');
			}	
		}
				
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
				if (this.navires[i].touche(n) || this.navires[i].chevauche(n) || n.getFin().getLigne() >= taille || n.getFin().getColonne() >= taille)
					return false;
		}
		this.navires[nbNavires] = n;
		nbNavires ++;
		return true;	
	}
	
	public void placementAuto(int[] taillesNavires) {
		// Place automatiquement et aléatoirement taillesNavires.length navires dont les tailles sont données dans taillesNavire.
		for (int i = 0; i < taillesNavires.length; )
			if (this.ajouteNavire(new Navire(new Coordonnee(new Random().nextInt(taille - taillesNavires[i] + 1), new Random().nextInt(taille - taillesNavires[i] + 1)), taillesNavires[i], new Random().nextBoolean())))
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
		if (!(this.estDansTirsRecus(c))) {
			for (int i = 0; i < nbNavires; i++)
				// pas ce recoitTir, mais celui de navires !
				if (navires[i].recoitTir(c))
					return true;
		}
		return false;

	}
	
	public boolean estTouche(Coordonnee c) {
		// Retourne true si et seulement si un des navires présents dans this a été touché en c.
		for (int i = 0; i < nbNavires; i++) {
			if (navires[i].estTouche(c))
				return true;
		}
		return false;
	}
	
	public boolean estALEau(Coordonnee c) {
		// Retourne true si et seulement si c correspond à un tir reçu dans l'eau par this.
		for (int i = 0; i < nbNavires; i++) {
			if (navires[i].estTouche(c))
				return false;
		}
		return true;

	}
	
	public boolean estCoule(Coordonnee c) {
		// Retourne true si et seulement si un des navires présents dans this a été touché en c et est coulé.
		for (int i = 0; i < nbNavires; i++) {
			if (navires[i].estTouche(c) && navires[i].estCoule())
				return true;
		}
		return false;
	}
	
	public boolean perdu() {
		//Retourne true si et seulement si tous les navires de this ont été coulés.
		for (int i = 0; i < nbNavires; i++) {
			if (!(navires[i].estCoule()))
				return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		int [] tab = {3, 2, 2, 3};
		GrilleNavale test = new GrilleNavale(10, 2);
		GrilleNavale test2 = new GrilleNavale(10, tab);
		Coordonnee c = new Coordonnee("A7");
		Coordonnee d = new Coordonnee("B2");
		Coordonnee e = new Coordonnee("C5");
		Navire nav = new Navire(c, 2, false);
		//System.out.println(""+ c.getLigne()+ c.getColonne());
		Coordonnee [] tab2 = {c,d};
		test2.ajouteDansTirsRecus(e);
		test2.setTirsRecus(tab2);
		System.out.println(test2.toString());
		

	
	}
}
