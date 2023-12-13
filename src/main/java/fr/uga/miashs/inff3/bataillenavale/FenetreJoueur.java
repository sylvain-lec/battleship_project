package fr.uga.miashs.inff3.bataillenavale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FenetreJoueur extends JFrame {

	private JPanel contentPane;
	private GrilleGraphique grilleTirs;
	private GrilleNavaleGraphique grilleDefense;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreJoueur frame = new FenetreJoueur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public FenetreJoueur() {
		this("Nom du joueur", 10);
		}
	
	public FenetreJoueur(String nom, int taille) {
		// permet d'obtenir une fenêtre pour un joueur de nom nom avec des grilles de taille taille. Un placement de navires automatique sur grilleDefense peut être réalisé.
		if (taille < 5) {
			taille = 5;
			}
		grilleTirs = new GrilleGraphique(taille);
		grilleDefense = new GrilleNavaleGraphique(taille);
		setTitle(nom);
		
		// placement auto des bateaux en fonction de la taille
		if (taille > 5 && taille < 10) {
			int[] bateaux = {2, 2, 3};
			grilleDefense.placementAuto(bateaux);
		}
		else if (taille < 10) {
			int[] bateaux = {2, 2, 3, 3, 4};
			grilleDefense.placementAuto(bateaux);
		}
		else if (taille < 15) {
			int[] bateaux = {2, 2, 3, 3, 4, 4};
			grilleDefense.placementAuto(bateaux);
		}
		else if (taille < 20) {
			int[] bateaux = {2, 2, 3, 3, 4, 4, 5};
			grilleDefense.placementAuto(bateaux);
		}
		else {
			int[] bateaux = {2, 2, 3, 3, 4, 4, 5, 5, 6};
			grilleDefense.placementAuto(bateaux);
		}
		
		// initialise contentPane
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}
	
}