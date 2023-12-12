package fr.uga.miashs.inff3.bataillenavale;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestGrilleNavale {
	
	private GrilleNavale g1;
	private GrilleNavale g2;
	private GrilleNavale g3;

	@Test
	public void testGrilleNavale() {
		// Vérifie que grille de taille 10 et 5 navires.
		int[] tab = {2, 2, 3, 3, 4};
		g1 = new GrilleNavale (10, tab);
		// assignation du navire commencant a A1, de longueur tab[0] et vertical à la place [0] du tableau navire de g1
		g1.getNavires()[0] = new Navire(new Coordonnee("A1"), tab[0], true);
		// Test tailles grille
		assertEquals(10,g1.getTaille());
		// test nbre de navires (2 versions)
		assertEquals(5,g1.getNbNavires());
		assertEquals(g1.getNavires().length,g1.getNbNavires());
		// test taille du navire [Ø]
		assertEquals(2,g1.getNavires()[0].tailleNavire());
	}

	@Test
	public void testGrilleNavale1() {
		g2 = new GrilleNavale (15, 3);
		// Test tailles grille
		assertEquals(15,g2.getTaille());
		// test nbre de navires (2 versions)
		assertEquals(3,g2.getNbNavires());
		assertEquals(g2.getNavires().length,g2.getNbNavires());
	}

	@Test
	public void testToString() {
		
}

	@Test
	public void testGetTaille() {
		
	}

	@Test
	public void testAjouteNavire() {
		Navire a1 = new Navire(new Coordonnee("A1"), 2, true);
		// a2 chevauche a1
		Navire a2 = new Navire(new Coordonnee("A2"), 2, false);
		// a3 touche a1
		Navire a3 = new Navire(new Coordonnee("A3"), 2, false);
		// b5 ne touche pas & ne chevauche pas a1
		Navire b5 = new Navire(new Coordonnee("B3"), 2, true);
		// navire hors limites
		Navire a0 = new Navire(new Coordonnee(g1.getTaille()+1, g1.getTaille()+1), 2, true);
		// Test ajout a1 seul
		assertTrue(g1.ajouteNavire(a1));
		// Test ajout b5 autorisé après a1
		assertTrue(g1.ajouteNavire(b5));
		// Test ajout a2 NON autorisé après a1
		assertFalse(g1.ajouteNavire(a2));
		// Test ajout a3 NON autorisé après a1
		assertFalse(g1.ajouteNavire(a3));
		// Test ajout a0 NON autorisé 
		assertFalse(g1.ajouteNavire(a0));
	}

	@Test
	public void testPlacementAuto() {
		
	}

	@Test
	public void testEstDansGrille() {

	}

	@Test
	public void testEstDansTirsRecus() {

	}

	@Test
	public void TestAjouteDansTirsRecus() {
		
	}

	@Test
	public void testRecoitTir() {

	}

	@Test
	public void testEstTouche() {
		
	}

	@Test
	public void testEstALEau() {
		
	}

	@Test
	public void testEstCoule() {
		
	}

	@Test
	public void testPerdu() {

	}

}
