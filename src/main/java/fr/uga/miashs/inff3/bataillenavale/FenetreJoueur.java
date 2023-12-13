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
	/*public FenetreJoueur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}*/
	
	public FenetreJoueur() {
		this("Nom du joueur", 10);
		}
	
	public FenetreJoueur(String nom, int taille) {
		// permet d'obtenir une fenêtre pour un joueur de nom nom avec des grilles de taille taille. Un placement de navires automatique sur grilleDefense peut être réalisé.
		grilleTirs = new GrilleGraphique(taille);
		grilleDefense = new GrilleNavaleGraphique(taille);
		JoueurGraphique joueur = new JoueurGraphique(grilleDefense, grilleTirs, nom);
		grilleDefense.placementAuto(null);
		
		// A VALIDER !
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}
	
}