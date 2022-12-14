package application;

public class Road {

	Town source, destination;
    String name;
    int degrees;

public Road(Town source, Town destination, int degrees, String name) {
  
   this.source = source;
   this.destination = destination;
   this.degrees = degrees;
   this.name = name;
}

public Road(Town source, Town destination, String name) {
   this.source = source;
   this.destination = destination;
   this.name = name;
        
}

public boolean contains(Town town) {
  
	
	return (source.compareTo(town) == 0 || destination.compareTo(town) == 0);
     
}
@Override
public String toString()

{
return "Road{" + "source=" + source + ", destination=" + destination + ",name=" + name + ", degrees=" + degrees + '}';

}

public String getName() {
	   return name;
	}

public Town getDestination() {
	   return destination;
	}

public Town getSource() {
   return source;
}

public int compareTo(Road road){
	   
	if (degrees > road.degrees) {
	 
		   return 1;
	}
	   if (degrees < road.degrees) {
	
		   return -1;
	}
	
	   return 0;
	}


public int getWeight() {
	
	return degrees;
}

@Override
   public boolean equals(Object r) {
   
	
    if (r == this) {
 
    	return true;
}

    if (! (r instanceof Road)) {

    	return false;
}

    Road road = (Road) r;


    return (source.equals(road.source) || source.equals(road.destination))
	&& (destination.equals(road.destination) || destination.equals(road.source));
}









}

