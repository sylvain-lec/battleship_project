package fr.uga.miashs.inff3.bataillenavale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BatailleNavale {
	
	private Joueur joueur1, joueur2;
	private int tailleGrille;
	
	private void demarrerPartie() {
		new Thread() {
		public void run() {
		joueur1.jouerAvec(joueur2);
		}
		}.start();
		}

	private JFrame frmBattailleNavale;
	private JTextField field_taille;
	private JTextField nomJoueur1;
	private final ButtonGroup buttonGroup = new ButtonGroup(); // buttonGroup est pour le joueur 2 normal
	private final ButtonGroup buttonGroup_1 = new ButtonGroup(); // buttonGroup_1 est pour le joueur 1 normal
	private JTextField nomJoueur2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BatailleNavale window = new BatailleNavale();
					window.frmBattailleNavale.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BatailleNavale() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBattailleNavale = new JFrame();
		frmBattailleNavale.setTitle("Battaille Navale");
		frmBattailleNavale.setBounds(100, 100, 450, 300);
		frmBattailleNavale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_haut = new JPanel();
		panel_haut.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		frmBattailleNavale.getContentPane().add(panel_haut, BorderLayout.NORTH);
		panel_haut.setLayout(new BorderLayout(0, 0));
		
		field_taille = new JTextField();
		field_taille.setText("10");
		panel_haut.add(field_taille);
		field_taille.setColumns(10);
		
		JLabel nom_partie = new JLabel("Taille de grille :");
		panel_haut.add(nom_partie, BorderLayout.WEST);
		
		JPanel panel_central = new JPanel();
		frmBattailleNavale.getContentPane().add(panel_central, BorderLayout.CENTER);
		panel_central.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_central_1 = new JPanel();
		panel_central_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Joueur 1", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_central.add(panel_central_1);
		panel_central_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_Joueur1 = new JPanel();
		panel_central_1.add(panel_Joueur1);
		panel_Joueur1.setLayout(new BorderLayout(0, 0));
		
		JLabel titreNom1 = new JLabel("Nom :");
		panel_Joueur1.add(titreNom1, BorderLayout.WEST);
		
		nomJoueur1 = new JTextField();
		panel_Joueur1.add(nomJoueur1, BorderLayout.CENTER);
		nomJoueur1.setText("M. David");
		nomJoueur1.setColumns(10);
		
		JPanel panel_radio1 = new JPanel();
		panel_central_1.add(panel_radio1);
		panel_radio1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JRadioButton Joueur1Graphique = new JRadioButton("Joueur graphique");
		buttonGroup_1.add(Joueur1Graphique);
		Joueur1Graphique.setSelected(true);
		panel_radio1.add(Joueur1Graphique);
		
		JRadioButton Joueur1Texte = new JRadioButton("Joueur Texte");
		buttonGroup_1.add(Joueur1Texte);
		panel_radio1.add(Joueur1Texte);
		
		JRadioButton Joueur1Auto = new JRadioButton("Joueur Auto");
		buttonGroup_1.add(Joueur1Auto);
		panel_radio1.add(Joueur1Auto);
		
		JPanel panel_central_2 = new JPanel();
		panel_central_2.setBorder(new TitledBorder(null, "Joueur 2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_central.add(panel_central_2);
		panel_central_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_Joueur2 = new JPanel();
		panel_central_2.add(panel_Joueur2);
		panel_Joueur2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_radio2 = new JPanel();
		panel_central_2.add(panel_radio2);
		panel_radio2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel titreNom2 = new JLabel("Nom :");
		panel_Joueur2.add(titreNom2, BorderLayout.WEST);
		
		nomJoueur2 = new JTextField();
		nomJoueur2.setText("M. Bardou");
		panel_Joueur2.add(nomJoueur2, BorderLayout.CENTER);
		nomJoueur2.setColumns(10);
		
		JRadioButton Joueur2Graphique = new JRadioButton("Joueur graphique");
		buttonGroup.add(Joueur2Graphique);
		Joueur2Graphique.setSelected(true);
		panel_radio2.add(Joueur2Graphique);
		
		JRadioButton Joueur2Texte = new JRadioButton("Joueur Texte");
		buttonGroup.add(Joueur2Texte);
		panel_radio2.add(Joueur2Texte);
		
		JRadioButton Joueur2Auto = new JRadioButton("Joueur Auto");
		buttonGroup.add(Joueur2Auto);
		panel_radio2.add(Joueur2Auto);
		
		JPanel panel_bas = new JPanel();
		frmBattailleNavale.getContentPane().add(panel_bas, BorderLayout.SOUTH);
		
		JButton boutton_go = new JButton("Let's fight!");
		boutton_go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// initialise la taille de la grille et catch les erreurs
				try {
					tailleGrille = Integer.parseInt(field_taille.getText());
				
                
					// Initialise type de joueurs en fonction du choix des boutons radios				
					
					//GRAPHIQUE JOUEUR 1 - Version Ca Marche
					if(Joueur1Graphique.isSelected()) {
						GrilleNavaleGraphique grilledef = new GrilleNavaleGraphique(tailleGrille);
						GrilleGraphique grilletir = new GrilleGraphique(tailleGrille);
	
						// placement auto des bateaux en fonction de la taille
						int[] liste = grilledef.ListeNavires();
						grilledef.placementAuto(liste);
						
						FenetreJoueur F1 = new FenetreJoueur(nomJoueur1.getText(), grilletir, grilledef.getGrilleGraphique());
						joueur1 = new JoueurGraphique (grilledef, grilletir, nomJoueur1.getText());
						F1.setVisible(true);
					}
					
					//TEXTE JOUEUR 1
					else if(Joueur1Texte.isSelected()) {
						//V1
						/* int[] bateauxTexte = {2, 2, 3, 3, 4};
						GrilleNavale grilletext = new GrilleNavale(tailleGrille, bateauxTexte);
						joueur1 = new JoueurTexte(grilletext, nomJoueur1.getText());
						System.out.println(nomJoueur1.getText());
						System.out.println(grilletext);*/
						
						//VERSION PLACEMENT AUTO
						GrilleNavale grilledef = new GrilleNavale(tailleGrille, 1);
						// placement auto des bateaux en fonction de la taille
						int[] liste = grilledef.ListeNavires();
						grilledef.placementAuto(liste);
						joueur1 = new JoueurTexte(grilledef, nomJoueur1.getText());
						System.out.println(nomJoueur1.getText() + "\n" + grilledef);						
					}
					
					//AUTO JOUEUR 1
					else {
						/*V1
						int[] bateauxAuto = {2, 2, 3, 3, 4};
						GrilleNavale grilleAuto = new GrilleNavale(tailleGrille, bateauxAuto);
						joueur1 = new JoueurAuto(grilleAuto, nomJoueur1.getText());
						System.out.println(nomJoueur1.getText());
						System.out.println(grilleAuto);	*/
						
						// VERSION PLACEMENT AUTO
						GrilleNavale grilledef = new GrilleNavale(tailleGrille, 1);
						// placement auto des bateaux en fonction de la taille
						int[] liste = grilledef.ListeNavires();
						grilledef.placementAuto(liste);
						joueur1 = new JoueurAutoMoyen(grilledef, nomJoueur1.getText());
						System.out.println(nomJoueur1.getText() + "\n" + grilledef);						
					}
					
					
					//GRAPHIQUE JOUEUR 2 - Version Ca Marche
					if(Joueur2Graphique.isSelected()) {
						GrilleNavaleGraphique grilledef2 = new GrilleNavaleGraphique(tailleGrille);
						GrilleGraphique grilletir2 = new GrilleGraphique(tailleGrille);
						
						// placement auto des bateaux en fonction de la taille
						int[] liste = grilledef2.ListeNavires();
						grilledef2.placementAuto(liste);
						
						FenetreJoueur F2 = new FenetreJoueur(nomJoueur2.getText(), grilletir2, grilledef2.getGrilleGraphique());
						joueur2 = new JoueurGraphique (grilledef2, grilletir2, nomJoueur2.getText());
						F2.setVisible(true);
						System.out.println(grilledef2);
					}
					
					//TEXTE  JOUEUR 2
					else if(Joueur2Texte.isSelected()) {
						/*V1
						int[] bateauxTexte = {2, 2, 3, 3, 4};
						GrilleNavale grilletext = new GrilleNavale(tailleGrille, bateauxTexte);
						joueur2 = new JoueurTexte(grilletext, nomJoueur2.getText());
						System.out.println(nomJoueur2.getText());
						System.out.println(grilletext);*/
						
						// VERSION PLACEMENT AUTO
						GrilleNavale grilledef = new GrilleNavale(tailleGrille, 1);
						// placement auto des bateaux en fonction de la taille
						int[] liste = grilledef.ListeNavires();
						grilledef.placementAuto(liste);
						joueur2 = new JoueurTexte(grilledef, nomJoueur2.getText());
						System.out.println(nomJoueur2.getText() + "\n" + grilledef);
						}
					
					//AUTO JOUEUR 2
					else {
						/*V1
						int[] bateauxAuto = {2, 2, 3, 3, 4};
						GrilleNavale grilleAuto = new GrilleNavale(tailleGrille, bateauxAuto);
						joueur2 = new JoueurAuto(grilleAuto, nomJoueur2.getText());
						System.out.println(nomJoueur2.getText());
						System.out.println(grilleAuto);*/
						
						//VERSION PLACEMENT AUTO
						GrilleNavale grilledef = new GrilleNavale(tailleGrille, 1);
						// placement auto des bateaux en fonction de la taille
						int[] liste = grilledef.ListeNavires();
						grilledef.placementAuto(liste);
						joueur2 = new JoueurAutoMoyen(grilledef, nomJoueur2.getText());
						System.out.println(nomJoueur2.getText() + "\n" + grilledef);												
					}
					
					// lance la partie en fonction des bouttons radios
					demarrerPartie();
					//---------------------------------------
					}
				catch(NumberFormatException pasUnNombre) {
                    // Texte n'est pas un int valide, ca degage
                    JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				catch(IllegalArgumentException moinsDe5) {
					// <5, interdit
                    JOptionPane.showMessageDialog(null, "Valeur minimum 5", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel_bas.add(boutton_go);
		
	}
	
}