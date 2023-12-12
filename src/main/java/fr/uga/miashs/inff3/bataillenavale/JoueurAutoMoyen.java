package fr.uga.miashs.inff3.bataillenavale;

import java.util.Random;

public class JoueurAutoMoyen extends JoueurAuto {
	public Coordonnee[] historiqueTirs;
	public int nbTirs;
	
	public JoueurAutoMoyen(GrilleNavale g, String nom) {
		super(g, nom); 
		historiqueTirs = new Coordonnee[getTailleGrille()*2]; //tableau de taille (taille*2). TailleGrille vient de Joueur
		nbTirs = 0;
	}
	public boolean aDejaTire(Coordonnee c) {
		//je voulais utiliser estDansTirsRecus (de la classe GrilleNavire) mais elle est private, donc j'ai fait cette méthode
		//regarde si on a déjà tiré dans la coordonnée c
		for (int i=0 ; i<nbTirs ; i++) {
			if (historiqueTirs[i].equals(c))
				return true;
		}
		return false;	
		
	}
	public Coordonnee choixAttaque() {
		
	Coordonnee attaque;
	//on génère des coordonnées tant qu'on a déjà tiré dessus ou qu'on a déjà tiré à côté 
	//pas sûr qu'il faille regarder si on a tiré à côté. on peut faire un bot intelligent qui tire à côté quand un coup touche
	do {
		attaque = new Coordonnee(new Random().nextInt(super.getTailleGrille() - 1), new Random().nextInt(super.getTailleGrille() - 1));
		for (int i=0 ; i<nbTirs ; i++) {
			if (historiqueTirs[i].equals(attaque) || attaque.voisine(historiqueTirs[i]))//on a déjà tiré ici ou à côté
				attaque = null; //condition du do-while
				break;
		}
	} while (attaque==null); //on sort quand attaque n'est plus null, donc quand on a pas déjà tiré ici ou à côté
	
	nbTirs++;
	historiqueTirs[nbTirs-1] = attaque;
	return attaque;

	}
	public static void main(String[] args) {
		GrilleNavale g = new GrilleNavale(28,2);
		JoueurAutoMoyen j = new JoueurAutoMoyen(g, "sylvain");
		System.out.println(j.choixAttaque()); 

	}

}
