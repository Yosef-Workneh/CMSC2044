package application;

import java.io.IOException;
import java.util.*;

public class CourseDBStructure implements CourseDBStructureInterface {

	int size, numEntries;
	LinkedList<CourseDBElement> hashTable[];
	static final double factor = 1.5;

	public CourseDBStructure(int s) {

		this.size = getPrimeNum((int)(s/factor));
		hashTable = new LinkedList[size];
		numEntries = 0;
	}


	private int getPrimeNum(int i) {
		int k = i/4;
		int prime = (4 * k) + 3;
		while(k < 4) {
			k++;
			prime = (4 * k) + 3;
		}
		return prime;
	}


	public CourseDBStructure(String n, int s) {
		size = s;
		hashTable = new LinkedList[size];
		numEntries = 0;
	}

	@Override
	public void add(CourseDBElement e) {
		
		int i = e.hashCode() % size;
		
		if(hashTable[i] == null) {
			hashTable[i] = new LinkedList<CourseDBElement>();
		

		hashTable[i].add(e);
		numEntries++;
		}else {
			Iterator<CourseDBElement> itr = hashTable[i].iterator(); 
			CourseDBElement element = null; 
			boolean Match = false;
			while(itr.hasNext() && !Match) { //iterator through all CourseDBElement objects in the bucket
				element = itr.next(); 
				if(element.getCRN() == e.getCRN()) //if CourseDBElement with matching CRN is found
					Match = true;
			}
			if(!Match) {//if a matching search key was NOT found, then add the object to the bucket
				hashTable[i].add(e);
				numEntries++;
			}
			if(Match) { //if matching search key was found, then update all of its values (updating CRN is not necessary as they are equal) 
				element.setInstName(e.getInstName()); 
			element.setCourseId(e.getID());
				element.setNumOfCredits(e.getNumOfCredits()); 
				element.setRoomNum(e.getRoomNum()); 
				}
		}
	}

	@Override
	public CourseDBElement get(int crn) throws IOException {

		String s = crn + "";
		int index = s.hashCode() % size;

		if(hashTable[index] == null) {
			throw new IOException();
		}
		else {

			for(int i = 0; i < size; i++) {
				
				CourseDBElement x = hashTable[index].get(i);
				if(x.getCRN() == crn) {
					return x;
				}
			}

			return null;
		}
	}

	public int getTableSize() {

		return size;
	}


	@Override
	public ArrayList<String> showAll() {
	ArrayList<String> HashList = new ArrayList<String>();
	for( int x = 0; x< size; x++) {
		if(!(hashTable[x] == null)) {
		Iterator<CourseDBElement> HashIterator = hashTable[x].iterator();
		while(HashIterator.hasNext()) {
			HashList.add(HashIterator.next().toString());
		}
		}
	}
		return HashList;
	}

}