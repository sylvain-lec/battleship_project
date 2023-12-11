package fr.uga.miashs.inff3.bataillenavale;

public class Coordonnee {
	
	public Coordonnee(String s) {
		// A modifier
	}
	
	public Coordonnee(int l, int c) {
		// A modifier
	}
	
	public int getLigne() {
		// A modifier
		return 0;
	}
	
	public int getColonne() {
		// A modifier
		return 0;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Coordonnee) {
			Coordonnee c = (Coordonnee) o;
			// A modifier
		}
		return false;
	}
	
	public boolean voisine(Coordonnee c) {
		// A modifier
		return true;
	}
	
	public int compareTo(Coordonnee c) {
		// A modifier
		return 0;
	}
	
	public String toString() {
		// A modifier
	   return super.toString();
	}
}
