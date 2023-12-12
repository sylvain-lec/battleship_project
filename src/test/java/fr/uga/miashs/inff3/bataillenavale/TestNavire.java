package fr.uga.miashs.inff3.bataillenavale;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestNavire {
	private Navire n1;
	private Navire n2;
	
	private Coordonnee a1 = new Coordonnee("A1");
	private Coordonnee e1 = new Coordonnee("E1");
	@Test
	public void testConstructeurNavire() {
		// vérifie que n1 déubte en A1 et fini en C1
		n1 = new Navire(a1, 2, true) ;
		assertEquals("A1",n1.getDebut());
//		assertEquals("A2",n1.getFin());	
	}
	
	@Test
	public void testToString() {
		
	}	
	
	@Test
	public void testCoordonneeGetDebut() {
		
	}
	
	@Test
	public void testCoordonneeGetFin() {
		
	}
	
	@Test
	public void testContient() {
		
	}
	
	@Test
	public void testTouche() {
		//TODO

	}
	
	@Test
	public void testChevauche() {
		//TODO
	}
	
	@Test
	public void testRecoitTir() {
		
	}
	
	@Test
	public void testEstToucheCoordonnee() {
		
	}
	
	@Test
	public void testEstTouche() {
		
	}
	
	@Test
	public void testEstCoule() {
		
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
