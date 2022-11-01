import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Hashing {

	public static void main(String[] args) {
	
		int Arraysize = 10;
		int N = Arraysize;
		int pk,ip;
		 int offset;
		 Integer[] hash = new Integer[N];
		
		  ArrayList <Integer> arraylist = new ArrayList<Integer>(Arrays.asList (27,53,13,10,138,109,49,174,26,24));

		   for(Integer x : arraylist) {
		   
			   pk = x.hashCode();
		       
			   ip = Math.abs (pk % N);
		    
		      if(!(hash[ip] == null)) {
		     
		          int q = pk/N;
		      
		      if(!(q % N == 0)) {
		        
		    	  offset = Math.abs(q);
		      
		      }else {
		      
		    	  offset = 19;
		      }
		      
		      do {
		      
		    	  System.out.println(" Collison can not replace "+ x +" : "+ ip+ " is already occupied by "+ hash[ip]);
		        
		      ip = (ip + offset) % N;
		      
		      } while(!(hash[ip] == null));
		      
		    }
		      
		     hash[ip] = x;
		    
		     System.out.println( x + ": " + ip);
		    
	}
		 
	System.out.println("      Bucket Hashing     ");
		 
	     System.out.println();
	     
	     int index;
	     
		   LinkedList<Integer>[] H = new LinkedList[N];
		   
		   for(Integer i:arraylist) {
		      
			   pk = i.hashCode();
		      
		      index = (pk) % N;
		     
		      if(H[index] == null) {
		       
		    	  H[index] = new LinkedList<Integer>();
		      }
		        H[index].add(i);
		    
		   }
		   
		   for( LinkedList <Integer> current : H) {
		     
			   if (current == null) {
		      
			   System.out.print("null,");
		       System.out.println();
		       continue;
		     }else {
		        
		     for (Integer x : current) {
		       String z = x+",";
		       
		       System.out.print(z);
		            
		     
		     }
		     }
		     
		     System.out.println();
		   }
		   
		   
		 }
}
