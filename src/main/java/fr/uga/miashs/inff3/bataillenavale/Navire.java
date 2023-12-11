package fr.uga.miashs.inff3.bataillenavale;

public class Navire {
	
	private Coordonnee debut;
	private Coordonnee fin;
	private Coordonnee[] partiesTouchees;
	private int nbTouchees; 

	public Navire(Coordonnee debut,int longueur,boolean estVertical){
		
		this.debut = debut;
		
	
	if (estVertical==true) 
		this.fin = new Coordonnee (this.debut.getColonne(),(longueur-1));
	else
		this.fin = new Coordonnee ((longueur-1),this.debut.getLigne());
		
	}

	public String toString() {
		
		String position;
		
		if()
		return null;
	}
	
	public Coordonnee getDebut() {
		return this.debut;
	}
	public Coordonnee getFin() {
		return this.fin;
	}
	public boolean contient(Coordonnee c) {
		
		if (this.debut.getColonne()==this.fin.getColonne()) {
			if(c.getColonne()==this.debut.getColonne() && (c.getLigne()>=this.debut.getLigne()&& c.getLigne()<=this.fin.getLigne()))
				return true;
		}else {
			if(c.getLigne()==this.debut.getLigne() && (c.getColonne()>= this.debut.getColonne() && c.getColonne()<= this.fin.getColonne()))
				return true;
		}
		
		return false;
	}
	
	public boolean touche(Navire n) {
		
	}
	public boolean chevauche(Navire n) {
		
	}
	public boolean recoitTir(Coordonnee c) {
		
	}
	public boolean estTouche(Coordonnee c) {
		
	}
	public boolean estTouche() {
		
	}
	public boolean estCoule() {
		
	}
	public static void main(String[] args) {
		Navire test = new Navire (new Coordonnee(2,2),3,true);
		test.contient(new Coordonnee(2,2));
		
		
	}
	
}