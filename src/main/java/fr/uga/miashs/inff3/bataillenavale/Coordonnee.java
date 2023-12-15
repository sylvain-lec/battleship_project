package fr.uga.miashs.inff3.bataillenavale;

public class Coordonnee implements Comparable<Coordonnee> {
	private int ligne ;
	private int colonne ;
	
	public Coordonnee(int ligne, int colonne) {
		if (colonne<0 || colonne>25 || ligne<0 || ligne>25)
			throw new IllegalArgumentException("coordonnées non valides");
		this.ligne = ligne;
		this.colonne = colonne;
	}
	
	public Coordonnee(String s) {
		if (s.length()<2 || s.length()>3 || s.charAt(0)<'A' || s.charAt(0)>'z')
			throw new IllegalArgumentException("coordonnées non valides");
		char lettre = s.charAt(0); //initialisation de la colonne
		if (s.charAt(0)>='a' && s.charAt(0)<='z') //convertit en majuscules si besoin
			lettre = (char) ((char) s.charAt(0)-'a'+'A');
		this.colonne = lettre-'A'; //convertit le caractère lettre en int
		
		try { //catch l'exception si c pas convertible en int 
		if (s.length()==2) //initialisation de ligne
			this.ligne = s.charAt(1)-'1';
		else 
			this.ligne = Integer.parseInt(s.substring(1))-1;
		} catch (NumberFormatException e) { 
			throw new NumberFormatException("coordonnées non valides");
		}
	}

	public String toString() { 
		char col = (char) ((char)colonne+'A'); //convertit la colonne en lettre majuscule
		return ""+col+(ligne+1);
	}
	
	public int getColonne() {
		return colonne;
	}
	
	public int getLigne() {
		return ligne;
	}

	public boolean equals(Object obj) { // 2 coordonnées identiques
		return (obj instanceof Coordonnee) && compareTo((Coordonnee)obj)==0; 
		
	}
	public boolean voisine(Coordonnee c) { //voisin si même ligne mais colonne à côté, ou si même colonne mais ligne à côté. PAS voisin si diagonal
		return ((this.ligne == c.ligne-1 || this.ligne == c.ligne+1) && this.colonne == c.colonne) || ((this.colonne == c.colonne-1 || this.colonne == c.colonne+1) && this.ligne == c.ligne);
		
	}
	public int compareTo(Coordonnee c) { 
		if (this.ligne == c.ligne) //si c sur la même ligne, comparer les colonnes
			return this.colonne - c.colonne ;
		else //si c pas les mêmes lignes, comparer les lignes
			return this.ligne - c.ligne ;
	}

}
