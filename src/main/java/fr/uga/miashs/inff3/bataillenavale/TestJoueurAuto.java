package fr.uga.miashs.inff3.bataillenavale;

import java.util.Random;

public class TestJoueurAuto extends JoueurAuto {
	public Coordonnee[] historiqueTirs;
	public int nbTirs;
	
	public TestJoueurAuto(GrilleNavale g, String nom) {
		super(g, nom); 
		historiqueTirs = new Coordonnee[getTailleGrille()*getTailleGrille()]; //tableau de taille (taille*taille). TailleGrille vient de Joueur
		nbTirs = 0;
	}
	
	public Coordonnee choixAttaque() {
	//on génère des coordonnées tant qu'on a déjà tiré dessus ou qu'on a déjà tiré à côté 
	//pas sûr qu'il faille regarder si on a tiré à côté. on peut faire un bot intelligent qui tire à côté quand un coup touche (pour couler le navire)
		Coordonnee attaque = null;
/*	//ON ESSAYE DE LE FAIRE TIRER AUTOUR SI CA A TOUCHE	
		boolean dejapris = false;
		//tire à côté si le coup d'avant a touché mais pas coulé
		if (nbTirs>0 && super.getGrille().estTouche(historiqueTirs[nbTirs-1])){// && (!(super.getGrille().estCoule(historiqueTirs[nbTirs-1])))) {
				System.out.println(super.getNom() + " alaide");
				do {
					int choix = new Random().nextInt(4);
					System.out.println(choix);
					switch (choix) { //4 choix de coordonnées possibles
						case 0 : attaque = new Coordonnee(historiqueTirs[nbTirs-1].getLigne()-1,historiqueTirs[nbTirs-1].getColonne()); //en haut
							break;
						case 1 : attaque = new Coordonnee(historiqueTirs[nbTirs-1].getLigne(),historiqueTirs[nbTirs-1].getColonne()+1); //à droite
							break;
						case 2 : attaque = new Coordonnee(historiqueTirs[nbTirs-1].getLigne()+1,historiqueTirs[nbTirs-1].getColonne()); //en bas
							break;
						case 3 : attaque = new Coordonnee(historiqueTirs[nbTirs-1].getLigne(),historiqueTirs[nbTirs-1].getColonne()-1); //à gauche
							break;
						
						}
					dejapris = false;
					for (int i=0 ; i<nbTirs ; i++) { //on vérifie qu'on n'a pas déjà tiré ici
						if (historiqueTirs[i].equals(attaque))
							dejapris = true;
							break;
					}
				} while (attaque.getLigne() >= super.getTailleGrille() || attaque.getColonne() >= super.getTailleGrille() || dejapris);
				//tant que la coordonnée est dans la grille et qu'on n'a pas déjà tiré dessus
				nbTirs++;
				historiqueTirs[nbTirs-1] = attaque;
				return attaque;
		}
	//FIN DU TEST	
	 */
		
	do {
		attaque = new Coordonnee(new Random().nextInt(super.getTailleGrille() - 1), new Random().nextInt(super.getTailleGrille() - 1));
		for (int i=0 ; i<nbTirs ; i++) {
			if (historiqueTirs[i].equals(attaque)) //|| attaque.voisine(historiqueTirs[i])) {//on a déjà tiré ici
				attaque = null; //condition de continuation du do-while
			}
			
		//}
	} while (attaque==null); //on sort quand attaque n'est plus null, donc quand on a pas déjà tiré ici
	//on met à jour le nb de tirs et le tableau qui stocke les tirs
	nbTirs++;
	historiqueTirs[nbTirs-1] = attaque;
	return attaque;
	}
}
