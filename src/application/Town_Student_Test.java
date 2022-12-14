package application;


import static org.junit.Assert.*;

import org.junit.Test;


public class Town_Student_Test {
	@Test
	public void testgetName() {
		
		Town town1 = new Town("town1");
		Town town2 = new Town("town2");
		assertEquals("town1", town1.getName());
		assertEquals("town2", town2.getName());
	}

	@Test
	public void testToString() {
		Town town1 = new Town("town1");
		Town town2 = new Town("town2");
		assertEquals("town1", town1.toString());
		assertEquals("town2", town2.toString());
	}

	
	@Test
	public void testEquals() {
		Town town1 = new Town("T1");
		Town town2 = new Town("T2");
		assertFalse(town1.equals(town2));
		assertTrue(town2.equals(town2));
	}
}