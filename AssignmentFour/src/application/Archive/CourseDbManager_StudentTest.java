package application;




import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * 
 */
public class CourseDbManager_StudentTest {
	private CourseDBManagerInterface dataMgr = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			dataMgr.add("CMSC203",20504,4,"DS452","Yehune Belay");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		dataMgr.add("CMSC203",29504,4,"DE250","Yehune Belay");
		dataMgr.add("CMSC203",47503,4,"DE250","Haile G/Selassie");
		dataMgr.add("CMSC204",10559,4,"DE250","Hailey Samoa");
		ArrayList<String> list = dataMgr.showAll();
		assertEquals(list.get(0),"\nCourse:CMSC204 CRN:10559 Credits:4 Instructor:Hailey Samoa Room:SC450");
	 	assertEquals(list.get(1),"\nCourse:CMSC203 CRN:47503 Credits:4 Instructor:Haile G/Selassie Room:SC450");
		assertEquals(list.get(2),"\nCourse:CMSC203 CRN:29504 Credits:4 Instructor:Yehune Belay Room:SC450");
	}
	
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC203 30504 4 SC450 Joey Bag-O-Donuts");
			inFile.print("CMSC204 30503 4 SC450 Jill B. Who-Dunit");
			
			inFile.close();
			dataMgr.readFile(inputFile);
			assertEquals("CMSC203",dataMgr.get(30504).getID());
			assertEquals("CMSC204",dataMgr.get(30503).getID());
			assertEquals("SC450",dataMgr.get(30503).getRoomNum());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}
