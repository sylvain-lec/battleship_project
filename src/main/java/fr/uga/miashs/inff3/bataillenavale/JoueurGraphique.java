package fr.uga.miashs.inff3.bataillenavale;

public class JoueurGraphique extends JoueurAvecGrille {

	private GrilleGraphique grilleTirs;
	
	// CONSTRUCTEURS
	public JoueurGraphique(GrilleNavaleGraphique grilleDefense, GrilleGraphique grilleTirs, String nom) {
		super(grilleDefense, nom);
		this.grilleTirs = grilleTirs;
	}
	
	public JoueurGraphique(GrilleNavaleGraphique grilleDefense, GrilleGraphique grilleTirs) {
		super(grilleDefense);
		this.grilleTirs = grilleTirs;
	}
	
	// METHODES
	public Coordonnee choixAttaque() {
		
	}
	
	protected void retourAttaque(Coordonnee c, int etat) {
		Color couleur = etat == A_L_EAU ? Color.BLUE : Color.RED; grilleTirs.colorie(c, couleur);
		switch (etat) {
		case TOUCHE:
			JOptionPane.showMessageDialog(grilleTirs, "Vous avez touché un navire en " + c);
			break;
		case COULE:
		JOptionPane.showMessageDialog(grilleTirs, "Vous avez coulé un navire en " + c);
			break;
		case GAMEOVER:
		JOptionPane.showMessageDialog(grilleTirs, "Vous avez gagné!!!");

	}

	@Override
	protected void retourDefense(Coordonnee c, int etat) {

	}



}
