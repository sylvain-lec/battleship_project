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
		Navire n1 = new Navire(new Coordonnee("A1"), tab[0], true);
		g1 = new GrilleNavale (10, tab);
		assertEquals(10,g1.getTaille());
		assertEquals(5,g1.getNbNavires());
		assertEquals(2,g1.getNavires()[0].tailleNavire());
	}

	@Test
	public void testGrilleNavale1() {
		
	}

	@Test
	public void testToString() {
		
}

	@Test
	public void testGetTaille() {
		
	}

	@Test
	public void testAjouteNavire() {
		
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
