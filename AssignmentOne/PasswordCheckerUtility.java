package application;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {

	
		public static void comparePasswords(java.lang.String password,
	            java.lang.String passwordConfirm)
	     throws UnmatchedException{
	    	 if (!(password.equals(passwordConfirm))) {
	    		 
	    		 throw new UnmatchedException();
	    		 
	    	 }
	     }
	     public static boolean comparePasswordsWithReturn(java.lang.String password,
	             java.lang.String passwordConfirm) {
	    	 
	    	 if (password.equals(passwordConfirm)) {
	    		 return true;
	    	 }
	    		 return false;
	     }
	    
	     public static boolean hasBetweenSixAndNineChars(java.lang.String password) {
	    	 
	    	 if (password.length() >= 6 && (password.length() <= 9)) {
	    		  return true;
	    	 }
	    	 return false;
	     }
	     public static boolean hasDigit(java.lang.String password)
	             throws NoDigitException{
	    	 for( int x = 0; x < password.length(); x++) {
	    	 if(Character.isDigit(password.charAt(x)))
	    	 {	            	 
	    		 return true;
	    	 }
	    	 }
	    	 throw new NoDigitException ("The password must contain at least one digit");
	             }
	     public static boolean hasLowerAlpha(java.lang.String password)
	                     throws NoLowerAlphaException{
	    	 for( int x = 0; x < password.length(); x++) {
		    	 if(Character.isLowerCase(password.charAt(x)))
		    	 {	            	 
		    		 return true;
		    	 }
		    	 }
		    	 throw new  NoLowerAlphaException ("The password must contain at least one lowercase alphabetic character");
	                     }
	      public static boolean hasSameCharInSequence(java.lang.String password) throws InvalidSequenceException {
	    	  int count = 0;
	    	  for( int x = 0; x < password.length(); x++) {
	 	    	
	 	    	for( int y = 0; y < password.length(); y++) {
	 	    		if( password.charAt(x) == password.charAt(y)) {
	 	    			count++;
	 	    		}
	 	    	}
	 	    	if( count++ > 2) {
		    		  throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence");
		    	  }
		    	  count = 0;
		 	    	 
	 	    	 }
	    	 return true;
	      }
	        
	       public static boolean hasSpecialChar(java.lang.String password)
	                                     throws NoSpecialCharacterException{
	    	   Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
	   		Matcher matcher = pattern.matcher(password);
	   		 if (!matcher.matches()) {
	   			 return true;
	   		 }
	   		 throw new NoSpecialCharacterException("The password must contain at least one special character");

	                                     }
	       public static boolean hasUpperAlpha(java.lang.String password)
	                                             throws NoUpperAlphaException{
	    	   for( int x = 0; x < password.length(); x++) {
			    	 if(Character.isUpperCase(password.charAt(x)))
			    	 {	            	 
			    		 return true;
			    	 }
			   
			    	 }
	    	   throw new  NoUpperAlphaException ("The password must contain at least one uppercase alphabetic character");
		                     }
	                                             
	       public static boolean isValidLength(java.lang.String password)
	                                                     throws LengthException{
	    	   if( password.length() >= 6)
	    	   {
	    		   return true;
	    		   }
	    	   throw new LengthException("The password must be at least 6 characters long");
	    	   }
	                                     
		public static boolean isValidPassword (java.lang.String password)
		                               throws LengthException,
		                                      NoUpperAlphaException,
		                                      NoLowerAlphaException,
		                                      NoDigitException,
		                                      NoSpecialCharacterException,
		                                      InvalidSequenceException{
			if(!(isValidLength(password))) {
		        
			      throw new LengthException("The password must be at least 6 characters long");
			  }
			  if(!(hasUpperAlpha(password))) {
			    throw new NoUpperAlphaException("The password must contain at least one upper case alphabetic character");
			  }
			    if(!(hasLowerAlpha(password))) {
			      throw new NoLowerAlphaException("The password must contain at least one lower case alphabetic character");
			    }
			   if(!(hasDigit(password))) {
			      throw new NoDigitException("The password must be at least 6 characters long");
			   }
			  if(!(hasSpecialChar(password))) {
			    throw new NoSpecialCharacterException("The password must contain at least one special character");
			  }
			  if(hasSameCharInSequence(password)) {
			    throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence");  
			    }
			  return true;
		                       
		}
		                                      
	    public static boolean isWeakPassword(java.lang.String password)
		                                 throws WeakPasswordException{
		                                	 if(hasBetweenSixAndNineChars(password)) {
		                                		 throw new WeakPasswordException("The password is OK but weak");
		                                	 }
		                                	 return false;
		                                 }
		 public static java.util.ArrayList<java.lang.String> getInvalidPasswords(java.util.ArrayList<java.lang.String> passwords){
			 ArrayList<String> InvalidPasswords = new ArrayList<String>();
			 for(String pass: passwords) {
				 try {
					if(isValidPassword(pass)) {
						pass  = null;
					}
				 }catch(LengthException | NoUpperAlphaException| NoLowerAlphaException|NoDigitException
						 |NoSpecialCharacterException|InvalidSequenceException y) {
					 InvalidPasswords.add(pass +" -> "+ y.getMessage());		
				 }
				
			 }
			 return InvalidPasswords;
		 }
	
}
	

