package fr.uga.miashs.inff3.bataillenavale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField txtJoueur;

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
		
		textField = new JTextField();
		panel_Joueur1.add(textField, BorderLayout.CENTER);
		textField.setText("Joueur 1");
		textField.setColumns(10);
		
		JPanel panel_radio1 = new JPanel();
		panel_central_1.add(panel_radio1);
		panel_radio1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JRadioButton RadioButtonGraphique = new JRadioButton("Joueur graphique");
		buttonGroup_1.add(RadioButtonGraphique);
		RadioButtonGraphique.setSelected(true);
		panel_radio1.add(RadioButtonGraphique);
		
		JRadioButton RadioButtonTexte = new JRadioButton("Joueur Texte");
		buttonGroup_1.add(RadioButtonTexte);
		panel_radio1.add(RadioButtonTexte);
		
		JRadioButton RadioButtonAuto = new JRadioButton("Joueur Auto");
		buttonGroup_1.add(RadioButtonAuto);
		panel_radio1.add(RadioButtonAuto);
		
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
		
		txtJoueur = new JTextField();
		txtJoueur.setText("Joueur 2");
		panel_Joueur2.add(txtJoueur, BorderLayout.CENTER);
		txtJoueur.setColumns(10);
		
		JRadioButton ButtonGraphique_2 = new JRadioButton("Joueur graphique");
		buttonGroup.add(ButtonGraphique_2);
		ButtonGraphique_2.setSelected(true);
		panel_radio2.add(ButtonGraphique_2);
		
		JRadioButton rdbtnJoueurTexte = new JRadioButton("Joueur Texte");
		buttonGroup.add(rdbtnJoueurTexte);
		panel_radio2.add(rdbtnJoueurTexte);
		
		JRadioButton rdbtnJoueurAuto = new JRadioButton("Joueur Auto");
		buttonGroup.add(rdbtnJoueurAuto);
		panel_radio2.add(rdbtnJoueurAuto);
		
		JPanel panel_bas = new JPanel();
		frmBattailleNavale.getContentPane().add(panel_bas, BorderLayout.SOUTH);
		
		JButton boutton_go = new JButton("Lancher la partie");
		panel_bas.add(boutton_go);
		//---------------------------------------
	}

}
