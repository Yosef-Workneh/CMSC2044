package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {

	CourseDBStructure structure = new CourseDBStructure(20);


	public void add(String id, int crn, int credits, String roomNum, String InstName) {

		CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, InstName);

		structure.add(element);
	}

	@Override
	public CourseDBElement get(int crn) {

		try {
			return structure.get(crn);
		} 
		catch (IOException i) {

			i.getMessage();
		}

		return null;
	}

	public void readFile(File input) throws FileNotFoundException {

		String id;
		int crn;
		int numCredits;
		String roomNum;
		String InstName;

		try {
			Scanner file = new Scanner(input);

			while(file.hasNext()) {

				id = file.next();
				crn = file.nextInt();
				numCredits = file.nextInt();
				roomNum = file.next();
				InstName = file.nextLine();

				add(id, crn, numCredits, roomNum, InstName);
			}

			file.close();
		}
		catch(FileNotFoundException e) {

			System.out.print("File not found");
			e.getMessage();
		}
	}

	@Override
	public ArrayList<String> showAll() {

		ArrayList <String> arraylist = new ArrayList <String>();

		for (int i = 0; i < structure.hashTable.length; i++) { 

			LinkedList<CourseDBElement> linkedlist = structure.hashTable[i];

			if(!(linkedlist == null)) {

				for(int x = 0; x < linkedlist.size(); x++) { 

					CourseDBElement element = linkedlist.get(x);

					arraylist.add(element.toString());

				}
			}
		}
		return arraylist;
	}
}

	 
