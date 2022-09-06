import static org.junit.Assert.*;

import org.junit.After;

import org.junit.Before;

import org.junit.Test;

public class GradebookTester {

      private GradeBook g1;
      private GradeBook g2;
      
      @Before
         public void setUp() {

            g1 = new GradeBook(5);
            g2 = new GradeBook(5);
       

            g1.addScore(50.0);
            g1.addScore(75.0);
            
            g2.addScore(60.0);
            g2.addScore(70.0);
          
      }

      @After

      public void tearDown() {

            g1 = null;
            g2 = null;
      }

      @Test

      public void testAddScore() {

            g1 = new GradeBook(5);
            g2 = new GradeBook(5);
            


            assertEquals(0, g1.getScoreSize());
            g1.addScore(2.0);
            g1.addScore(4.0);  
            assertEquals(g1.getScoreSize(),2);
            assertEquals(g1.getScoreSize(),2);
            assertFalse(g1.toString().equals("2.0 4.0 "));
            assertTrue(g1.addScore(120.0));


            assertEquals(0, g2.getScoreSize());
            g2.addScore(4.0);
            g2.addScore(6.0);  
            assertEquals(g2.getScoreSize(),2);
            assertEquals(g2.getScoreSize(),2);
            assertFalse(g2.toString().equals("4.0 6.0 "));
            assertTrue(g2.addScore(100.0));


      }

      @Test

      public void testSum() {
    	  
            assertEquals(125.0, g1.sum(), 0.01);
            g1.addScore(30.0);
            assertEquals(155, g1.sum(), 0.01);
            
            assertEquals(130.0, g2.sum(), 0.01);
            g2.addScore(50.0);
     

      }
      @Test
      public void testMinimum() {

            assertEquals(50.0, g1.minimum(), 0.001);
            g1.addScore(5.0);
            assertEquals(5.0, g1.minimum(), 0.001);
            

            assertEquals(60.0, g2.minimum(), 0.001);
            g2.addScore(6.0);
            assertEquals(6.0, g2.minimum(), 0.001);
       

            

      }

      @Test

      public void testFinalScore() {
    	  
            assertEquals(75.0, g1.finalScore(), 0.1);
            g1.addScore(60.0);
            assertEquals(135, g1.finalScore(), 0.01);
            assertEquals(70.0, g2.finalScore(), 0.1);
            g2.addScore(50.0);
     
         
    

      }
}

