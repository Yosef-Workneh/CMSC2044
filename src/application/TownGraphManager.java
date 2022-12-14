package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TownGraphManager implements TownGraphManagerInterface {

private Graph g;

public TownGraphManager() {
   
	this.g = new Graph();
}

@Override
public boolean addRoad(String town1, String town2, int weight, String roadName) {

return g.addEdge(new Town(town1), new Town(town2), weight,roadName) != null;

}


@Override


public String getRoad(String town1, String town2) {
	     
	Road road = null;
	      
	     for (Road x : g.edgeSet()) {
	      
	    	  if ((x.getSource().getName().equals(town1) && x.getDestination().getName().equals(town2)) ||
	          
	    			  (x.getSource().getName().equals(town2) && x.getDestination().getName().equals(town1))) {
	      road = x;
	      }
	      }
	    return road.getName();
	  }


@Override
public boolean addTown(String v) {
	
    
    return g.addVertex(new Town(v));
}

 public Town getTown(String name) {
		     
	 Town town = null;
	 
		      for (Town t : g.vertexSet()) {
		      
		    	  if (t.getName().equals(name)) {
		      town = t;
		      }
		      
		      
		      }
		      return town;
		  }

 

@Override
public boolean containsTown(String v) {

	return g.containsVertex(new Town(v));
}


@Override
public boolean containsRoadConnection(String source, String destination) {

	
	return g.containsEdge(new Town(source), new Town(destination));
}


@Override
public ArrayList<String> allRoads() {

	ArrayList<String> arr = new ArrayList<>();

	for (Road r : g.edgeSet()) {

		if (!arr.contains(r.getName())) {

			arr.add(r.getName());
}
}

	Collections.sort(arr);

	return arr;
}

@Override
public boolean deleteRoadConnection(String source, String destination, String road) {

	return g.removeEdge(new Town(source), new Town(destination), 1, road) != null;
}


@Override
public boolean deleteTown(String v) {

	return g.removeVertex(new Town(v));
}

@Override
public ArrayList<String> allTowns() {

	ArrayList<String> arr = new ArrayList<>();

for (Town t : g.vertexSet()) {

	if (!arr.contains(t.getName())) {

		arr.add(t.getName());
}
}
Collections.sort(arr);

return arr;
}


@Override
public ArrayList<String> getPath(String town1, String town2) {

	return g.shortestPath(getTown(town1),  getTown(town2));
}


public void clear() {

	g = new Graph();

}

  

public void populateTownGraph(File selectedFile)throws FileNotFoundException {

    try {
        Scanner File = new Scanner(selectedFile);
       
        String Line, name = "";
        int weight = 0;
       
        String source, destination = "";
       
        while(File.hasNext()) {
            
        	Line = File.nextLine();
      
            name = Line.substring(0, Line.indexOf(','));
           
            weight = Integer.parseInt(Line.substring(Line.indexOf(',') + 1,
             
            		Line.indexOf(';')));
           
           source = Line.substring(Line.indexOf(';') + 1);
           source = source.substring(0, source.indexOf(';'));
           destination = Line.substring(Line.indexOf(';') + 1);
           destination = destination.substring(destination.indexOf(';') + 1, destination.length());
           
      
            Town STown = new Town(source);
            Town destinationTown = new Town(destination);
            
            if(!g.containsVertex(STown)) g.addVertex(STown);
            if(!g.containsEdge(STown, destinationTown))
            	
               g.addEdge(STown, destinationTown, weight, name);
       }
    }
    catch(Exception exception) {
       
    	System.out.println("error in readFile");
        exception.printStackTrace();
    }

	
}

}


