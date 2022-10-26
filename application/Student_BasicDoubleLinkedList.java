package application;
//package _solution;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Student_BasicDoubleLinkedList {
	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Double> linkedDouble;
	BasicDoubleLinkedList<Computer> linkedComp;
	StringComparator comparator;
	DoubleComparator comparatorD;
	CarComparator comparatorCar;
	
	public Computer a=new Computer("Apple", "MaccBook", 2021);
	public Computer b=new Computer("Dell", "Xps", 2019);
	public Computer c=new Computer("Lenovo", "X13", 2018);
	public Computer d=new Computer("Hp", "series", 2005);
	public Computer e=new Computer("Toshiba", "Windows10", 2014);
	public Computer f=new Computer("Asus", "PTCruiser", 2022);

	public ArrayList<Computer> fill = new ArrayList<Computer>();
	

	@Before
	public void setUp() throws Exception {
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd("Hello");
		linkedString.addToEnd("World");
		comparator = new StringComparator();
		
		linkedDouble = new BasicDoubleLinkedList<Double>();
		linkedDouble.addToEnd(15.0);
		linkedDouble.addToEnd(100.0);
		comparatorD = new DoubleComparator();
		
		linkedComp= new BasicDoubleLinkedList<Computer>();
		linkedComp.addToEnd(b);
		linkedComp.addToEnd(c);
		comparatorCar = new CarComparator();
	}

	@After
	public void tearDown() throws Exception {
		linkedString = null;
		linkedDouble = null;
		linkedComp = null;
		comparatorD = null;
		comparator = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(2,linkedString.getSize());
		assertEquals(2,linkedDouble.getSize());
		assertEquals(2,linkedComp.getSize());
	}
	
	@Test
	public void testAddToEnd() {
		assertEquals("World", linkedString.getLast());
		linkedString.addToEnd("End");
		assertEquals("End", linkedString.getLast());
		
		assertEquals(c,linkedComp.getLast());
		linkedComp.addToEnd(d);
		assertEquals(d,linkedComp.getLast());
	}
	
	@Test
	public void testAddToFront() {
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront("Begin");
		assertEquals("Begin", linkedString.getFirst());
		
		assertEquals(b,linkedComp.getFirst());
		linkedComp.addToFront(a);
		assertEquals(a,linkedComp.getFirst());
	}
	
	@Test
	public void testGetFirst() {
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
		
		assertEquals(b,linkedComp.getFirst());
		linkedComp.addToFront(a);
		assertEquals(a,linkedComp.getFirst());
	}

	@Test
	public void testGetLast() {
		assertEquals("World", linkedString.getLast());
		linkedString.addToEnd("New");
		assertEquals("New", linkedString.getLast());
		
		assertEquals(c,linkedComp.getLast());
		linkedComp.addToEnd(d);
		assertEquals(d,linkedComp.getLast());
	}
	
	@Test
	public void testToArrayList()
	{
		ArrayList<Computer> list;
		linkedComp.addToFront(a);
		linkedComp.addToEnd(d);
		list = linkedComp.toArrayList();
		assertEquals(a,list.get(0));
		assertEquals(b,list.get(1));
		assertEquals(c,list.get(2));
		assertEquals(d,list.get(3));
	}
	
	@Test
	public void testIteratorSuccessfulNext() {
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("End", iterator.next());
		
		linkedComp.addToFront(a);
		linkedComp.addToEnd(d);
		ListIterator<Computer> iteratorCar = linkedComp.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());
	}
	
	@Test
	public void testIteratorSuccessfulPrevious() {
		linkedComp.addToFront(a);
		linkedComp.addToEnd(d);
		ListIterator<Computer> iteratorCar = linkedComp.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(d, iteratorCar.next());
		assertEquals(true, iteratorCar.hasPrevious());
		assertEquals(d, iteratorCar.previous());
		assertEquals(c, iteratorCar.previous());
		assertEquals(b, iteratorCar.previous());
		assertEquals(a, iteratorCar.previous());
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		linkedComp.addToFront(a);
		linkedComp.addToEnd(d);
		ListIterator<Computer> iteratorCar = linkedComp.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());
		
		try{
			//no more elements in list
			iteratorCar.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionPrevious() {
		linkedComp.addToFront(a);
		linkedComp.addToEnd(d);
		ListIterator<Computer> iteratorCar = linkedComp.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(d, iteratorCar.next());
		assertEquals(true, iteratorCar.hasPrevious());
		assertEquals(d, iteratorCar.previous());
		assertEquals(c, iteratorCar.previous());
		assertEquals(b, iteratorCar.previous());
		assertEquals(a, iteratorCar.previous());
		
		try{
			//no more elements in list
			iteratorCar.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorUnsupportedOperationException() {
		linkedComp.addToFront(a);
		linkedComp.addToEnd(d);
		ListIterator<Computer> iteratorCar = linkedComp.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());
		
		try{
			//remove is not supported for the iterator
			iteratorCar.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
		
	}
	
	@Test
	public void testRemove() {
		// remove the first
		assertEquals(b, linkedComp.getFirst());
		assertEquals(c, linkedComp.getLast());
		linkedComp.addToFront(a);
		assertEquals(a, linkedComp.getFirst());
		linkedComp.remove(a, comparatorCar);
		assertEquals(b, linkedComp.getFirst());
		//remove from the end of the list
		linkedComp.addToEnd(d);
		assertEquals(d, linkedComp.getLast());
		linkedComp.remove(d, comparatorCar);
		assertEquals(c, linkedComp.getLast());
		//remove from middle of list
		linkedComp.addToFront(a);
		assertEquals(a, linkedComp.getFirst());
		assertEquals(c, linkedComp.getLast());
		linkedComp.remove(b, comparatorCar);
		assertEquals(a, linkedComp.getFirst());
		assertEquals(c, linkedComp.getLast());
		
	}

	@Test
	public void testRetrieveFirstElement() {
		assertEquals(b, linkedComp.getFirst());
		linkedComp.addToFront(a);
		assertEquals(a, linkedComp.getFirst());
		assertEquals(a, linkedComp.retrieveFirstElement());
		assertEquals(b,linkedComp.getFirst());
		assertEquals(b, linkedComp.retrieveFirstElement());
		assertEquals(c,linkedComp.getFirst());
		
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
		assertEquals("New", linkedString.retrieveFirstElement());
		assertEquals("Hello",linkedString.getFirst());
		assertEquals("Hello", linkedString.retrieveFirstElement());
		assertEquals("World",linkedString.getFirst());
		
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals(c, linkedComp.getLast());
		linkedComp.addToEnd(d);
		assertEquals(d, linkedComp.getLast());
		assertEquals(d, linkedComp.retrieveLastElement());
		assertEquals(c,linkedComp.getLast());
		
		assertEquals("World", linkedString.getLast());
		linkedString.addToEnd("New");
		assertEquals("New", linkedString.getLast());
		assertEquals("New", linkedString.retrieveLastElement());
		assertEquals("World",linkedString.getLast());
	}

	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class CarComparator implements Comparator<Computer>
	{

		@Override
		public int compare(Computer arg0, Computer arg1) {
			// Just put cars in alphabetic order by make
			return arg0.toString().compareTo(arg1.toString());
		}
		
	}
	
	private class Computer{
		String make;
		String model;
		int year;
		
		public Computer(String make, String model, int year){
			this.make = make;
			this.model = model;
			this.year = year;
		}
		
		public String getMake(){
			return make;
		}
		public String getModel(){
			return model;
		}
		public int getYear(){
			return year;
		}
		
		public String toString() {
			return (getMake()+" "+getModel()+" "+getYear());
		}
	}
}
