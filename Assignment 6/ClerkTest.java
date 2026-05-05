/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Clerk junit
 * Due:5/4/2026
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Julian Black
*/
package BobsCircus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class ClerkTest 
{
	
		private Clerk clerk = new Clerk("Joe", 18, 2, "Clerk", "images/TicketingCashier.png");

	    @Test
	    public void testGetName() {
	        assertEquals("Joe", clerk.getName());
	    }

	    @Test
	    public void testGetAge() {
	        assertEquals(18, clerk.getAge());
	    }

	    @Test
	    public void testGetYearsWorked() {
	        assertEquals(2, clerk.getYearsWorked());
	    }

	    @Test
	    public void testGetJob() {
	        assertEquals("Clerk", clerk.getJob());
	    }

	    @Test
	    public void testGetImagePath() {
	        assertEquals("images/TicketingCashier.png", clerk.getImagePath());
	    }

	    @Test
	    public void testToString() {
	        String expected =
	            "Clerk - Name: Joe, Age: 18, Job: Clerk, Years Worked: 2";
	        assertEquals(expected, clerk.toString());
	    }
}