package fr.uga.miashs.inff3.bataillenavale;

public abstract class Joueur {
	public final static int TOUCHE = 1;
	public final static int COULE = 2;
	public final static int A_L_EAU = 3;
	public final static int GAMEOVER = 4;

	private Joueur adversaire;
	private int tailleGrille;
	private String nom;
	
	public Joueur(int tailleGrille, String nom) {
		// permet d'obtenir un joueur de nom nom et jouant sur une grille de taille taillegrille.
		this.nom = nom;
		this.tailleGrille = tailleGrille;
		adversaire = null;
	}
	
	public Joueur(int tailleGrille) {
		// permet d'obtenir un joueur jouant sur une grille de taille taillegrille.
		this.nom = null;
		this.tailleGrille = tailleGrille;
		adversaire = null;
	}

	public int getTailleGrille() {
		//	Accesseur en lecture pour tailleGrille.
		return tailleGrille;
	}
	
	public String getNom() {
		// 	Accesseur en lecture pour nom
		return nom;
	}
	
	public void jouerAvec(Joueur j) {
		//Démarre une partie contre j. Avant de lancer le déroulement du jeu, il faut veiller à établir le lien entre les 2 joueurs et bien entendu vérifier qu’il puisse être établi.
		//TODO
		deroulementJeu(this, j);
		
	}
	
	private static void deroulementJeu(Joueur attaquant, Joueur defenseur) {
		int res = 0;
		while (res != GAMEOVER) {
			Coordonnee c = attaquant.choixAttaque();
			res = defenseur.defendre(c);
			attaquant.retourAttaque(c, res);
			defenseur.retourDefense(c, res);
			Joueur x = attaquant;
			attaquant = defenseur;
			defenseur = x;
		}
	}
	
	protected abstract void retourAttaque(Coordonnee c, int etat);
	protected abstract void retourDefense(Coordonnee c, int etat);
	public abstract Coordonnee choixAttaque();
	public abstract int defendre(Coordonnee c);