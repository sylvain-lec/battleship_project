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
	
	public Coordonnee choixAttaque() {
	//on génère des coordonnées tant qu'on a déjà tiré dessus ou qu'on a déjà tiré à côté 
	//pas sûr qu'il faille regarder si on a tiré à côté. on peut faire un bot intelligent qui tire à côté quand un coup touche (pour couler le navire)

		Coordonnee attaque;
	do {
		attaque = new Coordonnee(new Random().nextInt(super.getTailleGrille() - 1), new Random().nextInt(super.getTailleGrille() - 1));
		for (int i=0 ; i<nbTirs ; i++) {
			if (historiqueTirs[i].equals(attaque) || attaque.voisine(historiqueTirs[i])) {//on a déjà tiré ici ou à côté
				attaque = null; //condition de continuation du do-while
				break;
			}
		}
	} while (attaque==null); //on sort quand attaque n'est plus null, donc quand on a pas déjà tiré ici ou à côté
	//on met à jour le nb de tirs et le tableau qui stocke les tirs
	nbTirs++;
	historiqueTirs[nbTirs-1] = attaque;
	return attaque;
	}
	
	public static void main(String[] args) {
		JoueurAutoMoyen j = new JoueurAutoMoyen(new GrilleNavale(22,2), "sylvain");
		System.out.println("génération aléatoire de coordonnées : "+j.choixAttaque()); 
	}
}