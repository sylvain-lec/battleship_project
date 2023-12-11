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
	public int getTaille() {
		return taille;
	}
	public boolean ajouteNavire(Navire n) {
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
