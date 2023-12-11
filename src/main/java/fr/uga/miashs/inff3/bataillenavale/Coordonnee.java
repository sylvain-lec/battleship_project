package fr.uga.miashs.inff3.bataillenavale;

public class Coordonnee implements Comparable<Coordonnee> {
	private int ligne ;
	private int colonne ;
	
	public Coordonnee(int colonne, int ligne) {
		if (colonne<0 || colonne>25 || ligne<0 || ligne>25)
			throw new IllegalArgumentException("coordonnées non valides");
		this.ligne = ligne;
		this.colonne = colonne;
	}
	public Coordonnee(String s) {
		if (s.length()<2 || s.length()>3 || s.charAt(0)<'A' || s.charAt(0)>'Z')
			throw new IllegalArgumentException("coordonnées non valides");
		//if (s.charAt(0)>='a' && s.charAt(0)<='z')
			
		this.colonne = s.charAt(0)-'A';
		try {
		if (s.length()==2)
			this.ligne = s.charAt(1)-'1';
		else 
			this.ligne = Integer.parseInt(s.substring(1))-1;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("coordonnées non valides");
		}
	}

	public String toString() {
		char col = (char) ((char)colonne+'A');
		ligne += 1;
		return ""+col+ligne;
	}
	public int getColonne() {
		return colonne;
	}
	public int getLigne() {
		return ligne;
	}

	public boolean equals(Object obj) {
		return (obj instanceof Coordonnee) && compareTo((Coordonnee)obj)==0; 
	}
	public boolean voisine(Coordonnee c) {
		return ((this.ligne == c.ligne-1 || this.ligne == c.ligne+1) && this.colonne == c.colonne) || ((this.colonne == c.colonne-1 || this.colonne == c.colonne+1) && this.ligne == c.ligne);
		
	}
	public int compareTo(Coordonnee c) {
		if (this.ligne == c.ligne)
			return this.colonne - c.colonne ;
		else
			return this.ligne - c.ligne ;
	}
	public static void main(String[] args) {
		Coordonnee test = new Coordonnee(3,1);
		Coordonnee test2 = new Coordonnee(0,1);
		System.out.println(test.compareTo(test2));
	}
}
