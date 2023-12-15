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
		if (taille<5 || taille>26)
			throw new IllegalArgumentException("choisir une taille entre 5 et 26"); //Vérifie la taille de la grille
		for (int i = 0 ; i<taillesNavires.length ; i++) //vérifie si les navires sont au moins de taille 1
			if (taillesNavires[i]<1)
				throw new IllegalArgumentException("taille minimale navire : 1");
		this.navires = new Navire[taillesNavires.length]; //LONGUEUR EXPECTED - 1
		this.nbNavires = 0;
		this.taille = taille;
		tirsRecus = new Coordonnee[10];
		nbTirsRecus = 0;
		this.placementAuto(taillesNavires);
		
	}
	
	public GrilleNavale(int taille, int nbNavires) {
		// permet d'obtenir une grille navale vide de taille taille pouvant accueillir jusqu'à nbNavires.
		if (taille<5 || taille>26) //vérifie la taille de la grille
			throw new IllegalArgumentException("choisir une taille entre 5 et 26");
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
		// (décalage pour les noms de lignes + char de passage à la ligne) + (espaces autour des points donc *2)
		int largeurGrille = 4 + (taille* 2);
		
		for (int i = 0; i < nbNavires ; i++) {
			int coordonneeLigne = navires[i].getDebut().getLigne() + 1; // Retrouver la ligne du navire i (+1 retour à la ligne)
			int indiceColonne = navires[i].getDebut().getColonne()*2 + 3; // Retrouver la colonne du navire i (pas de char de passage à la ligne)
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

		//Positionnement des tirs
		
		for (int i = 0; i < nbTirsRecus; i++) {
			int coordonneeLigne = tirsRecus[i].getLigne() + 1 ; // Retrouver la ligne du tirsRecus
			int indiceColonne = tirsRecus[i].getColonne()*2 +3; // Retrouver la colonne du tirsRecus
			int PositionTirsRecus = (largeurGrille*coordonneeLigne) + indiceColonne;// Position du tirsRecu sur la grille
			
			if (grille.charAt(PositionTirsRecus) == '.')
//				Une case libre qui a reçu un tir 
					grille.setCharAt(PositionTirsRecus, 'O');
			else {
//				Une partie touchée d'un navire.
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
	/*public void setNbNavires(int nbNavires) {
		this.nbNavires = nbNavires;
	}*/
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
	
	public int[] ListeNavires() {
		int[] res = null;
		if (taille >= 5 && taille < 10) {
			res = new int[] {2, 2, 3};
		}
		else if (taille >= 10 && taille < 15) {
			res = new int[] {2, 2, 3, 3, 4};
		}
		else if (taille >= 15 && taille < 20) {
			res = new int[] {2, 2, 3, 3, 4, 4, 5};
		}
		else {
			res = new int[] {2, 2, 3, 3, 4, 4, 5, 5, 6};
		}
		return res;
	}
	
	public boolean ajouteNavire(Navire n) {
		//Retourne true après avoir ajouté n à this si cet ajout est possible. L'ajout est impossible si n touche ou chevauche un navire déjà présent dans this, ou encore si n dépasse les limites de this.
		for (int i = 0; i < nbNavires; i++) { // vérifie que le navire n'est pas sur ou a coté d'un autre
				if (this.navires[i].touche(n) || this.navires[i].chevauche(n))
					return false;
		}
		// vérifie que le bateau ne déborde pas de la grille
		if (n.getFin().getLigne() >= taille || n.getFin().getColonne() >= taille)
			return false;
		
		// agrandit le tableau navires si besoin 
		if (navires.length == nbNavires) {
			Navire[] tmp = new Navire[navires.length+5];
			for (int i=0 ; i<nbNavires ; i++) {
				tmp[i] = navires[i];
			}
			navires = tmp;
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
		
		// Vérif si tableau tirsRecus pleint, dans ce cas, ajoute 10 slots
		if (tirsRecus.length == nbTirsRecus) {
			Coordonnee[] tab = new Coordonnee[tirsRecus.length+10];
			for (int i = 0; i < nbTirsRecus; i++) {
				tab[i] = tirsRecus[i];
			}
			tirsRecus = tab;
		}
		// Si le tir n'est pas déjà reçu sur c, alors enregistre et incrémente nbTirsRecus + return true
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
			ajouteDansTirsRecus(c);
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
			if (navires[i].contient(c) && navires[i].estCoule())//navires[i].estTouche(c) && 
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
		//GrilleNavale test = new GrilleNavale(10, 2);
		GrilleNavale test2 = new GrilleNavale(10, tab);
		Coordonnee c = new Coordonnee("A7");
		Coordonnee d = new Coordonnee("B2");
		Coordonnee [] tab2 = {c,d};
		Coordonnee e = new Coordonnee("C5");
		test2.ajouteDansTirsRecus(e);
		System.out.println(""+ c.getLigne()+ c.getColonne());
		System.out.println(test2.tirsRecus[0]);
		test2.setTirsRecus(tab2);
		System.out.println(test2.toString());

	}
}
