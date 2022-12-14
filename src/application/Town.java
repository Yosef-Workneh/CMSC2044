package application;


public class  Town  {
  
   String name;
   Town templateTown;
  
  
   public  Town(String name){
       this.name = name;
      
   }
   public Town( Town templateTown){
	   
	   this.templateTown= templateTown;
	 
   }
   

   public String getName() {
       
	   return name;
   }
   
    public int compareTo( Town o){
       
 	   return name.compareTo(o.name);
   
    }
    
    public String toString()
    {
    return  name;
    }
    
    @Override
    public int hashCode() {
        return name.hashCode();
          
    }
    
    @Override
    public boolean equals(Object obj) {
         Town town = ( Town) obj;
 return this.name.compareTo(town.name) == 0;
          
    }
   public void setTemplateTown( Town templateTown) {
        this.templateTown = templateTown;
   }
 
    
   public  Town getTemplateTown() {
       return templateTown;
   }

}

  

