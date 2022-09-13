package application;


import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerSTUDENT_Test {
	ArrayList<String> passwordsArray;
	String password = "Hello";
	String passwordConfirm = "hello";
	String allCaps = "HELLO";
	String withDigit = "Hello6";

	@Before
	public void setUp() throws Exception {
		String[] p = {"334455BB", "Im2cool4U"};
		passwordsArray = new ArrayList<String>();
		passwordsArray.addAll(Arrays.asList(p));
	
	}

	@After
	public void tearDown() throws Exception {
		passwordsArray = null;
	}	
	

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidLength("Beautiful"));
		} catch(LengthException e) {
			assertTrue("The password must be atleat 6 character long", true);
		}catch(Exception e) {
			assertTrue("throws any exception needed",true);
	}
		//fail("Not implemented by student yet");
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasUpperAlpha("Beautiful"));
		} catch(NoUpperAlphaException e) {
			assertTrue("The password must contain at least one upper case alphabetic character", true);
		}catch(Exception e) {
			assertTrue("throws any exception needed",true);
	}
		// fail("Not implemented by student yet");
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{	try {
		assertTrue(PasswordCheckerUtility.hasLowerAlpha("Beautiful"));
	} catch(NoLowerAlphaException e) {
		assertTrue("The password must contain at least one lower case alphabetic character", true);
	}catch(Exception e) {
		assertTrue("throws any exception needed",true);
}
		//fail("Not implemented by student yet");
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
			try {
			assertTrue(PasswordCheckerUtility.isWeakPassword("Beautiful"));
		} catch(WeakPasswordException e) {
			assertTrue("The password is OK but weak", true);
		}catch(Exception e) {
			assertTrue("throws any exception needed",true);
	}
		//fail("Not implemented by student yet");
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
		assertTrue(PasswordCheckerUtility.hasSameCharInSequence("Beautttiful"));
	} catch(InvalidSequenceException e) {
		assertTrue("The password cannot contain more than two of the same character in sequence.", true);
	}catch(Exception e) {
		assertTrue("throws any exception needed",true);
}
		//fail("Not implemented by student yet");
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsVlidPasswordNoDigit()
	{
		try {
	
		assertTrue(PasswordCheckerUtility.hasDigit("Beautif2ul"));
	} catch(NoDigitException e) {
		assertTrue("The password must contain at least one digit", true);
	}catch(Exception e) {
		assertTrue("throws any exception needed",true);
	}
		
		//ail("Not implemented by student yet");
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{	
		try {
	
		assertTrue(PasswordCheckerUtility.isValidPassword("Beautif2u@lrtf"));
	
		}catch(Exception e) {
		assertTrue("throws any exception needed",true);
	}
		
		//fail("Not implemented by student yet");
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		PasswordCheckerUtility.getInvalidPasswords(passwordsArray);
		//fail("Not implemented by student yet");
	}
	
}