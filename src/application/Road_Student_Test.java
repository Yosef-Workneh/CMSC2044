package application;

import static org.junit.Assert.*;
import org.junit.Test;


public class Road_Student_Test {
	
	@Test
	public void testContains() {
		Town town1 = new Town("T1");
		Town town2 = new Town("T2");
		Road road = new Road(town1, town2, 50, "RoadTest");
		assertEquals(true, road.contains(town2));
		assertEquals(false, road.contains(new Town("Towns")));
	}
	@Test
	public void testToString() {
		
		Road road = new Road(new Town("T1"), new Town("T2"), 50, "RoadTest1");
		assertEquals("Road{source=T1, destination=T2,name=RoadTest1, degrees=" + 50 + "}", road.toString());
	}

	
	@Test
	public void testGetName() {
		
		Road road = new Road(new Town("T1"), new Town("T2"), 50, "RoadTest2");
		assertEquals("RoadTest2", road.getName());
	}

	@Test
	public void testGetDestination() {
		Town town1 = new Town("T1");
		Town town2 = new Town("T2");
		Road r = new Road(town1, town2, 50, "RoadTest3");
		assertEquals(town2, r.getDestination());
	}
	@Test
	public void testGetSource() {
		Town town1 = new Town("T1");
		Town town2 = new Town("T2");
		Road r = new Road(town1, town2, 50, "RoadTest3");
		assertEquals(town1, r.getSource());
	}

	@Test
	public void testGetWeight() {
		Road r = new Road(new Town("T1"), new Town("T2"), 50, "Road_Test_03");
		assertEquals(50, r.getWeight());
	}


	
}