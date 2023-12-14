package fr.uga.miashs.inff3.bataillenavale;

import java.awt.EventQueue;
import java.awt.GridLayout;

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
		int[] liste = grilleDefense.ListeNavires();
		grilleDefense.placementAuto(liste);
		
		// initialise contentPane
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		// crée un nouveau panel puis ajoute les deux grilles (1er = a gauche celle de tirs et 2nd= à droite celle de défense)
		contentPane.setLayout(new GridLayout(1,2));
		contentPane.add(grilleTirs);
		contentPane.add(grilleDefense.getGrilleGraphique());
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}
	
}