/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: ticketing office junit
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


public class TicketingOfficeJUnitTest 
{
	
		private TicketingOffice ticketingOffice = new TicketingOffice("Blue", 10, 15, "images/TicketOffice.png");

	    @Test
	    public void testGetLength() {
	        assertEquals(10, ticketingOffice.getLength());
	    }

	    @Test
	    public void testGetWidth() {
	        assertEquals(15, ticketingOffice.getWidth());
	    }

	    @Test
	    public void testGetColor() {
	        assertEquals("Blue", ticketingOffice.getColor());
	    }

	    @Test
	    public void testGetBuildingType() {
	        assertEquals("Ticketing Office", ticketingOffice.getBuildingType());
	    }

	    @Test
	    public void testGetImagePath() {
	        assertEquals("images/TicketOffice.png", ticketingOffice.getImagePath());
	    }

	    @Test
	    public void testToString() {
	        String expected =
	            "\nBuilding Type: Ticketing Office \nColor: Blue \nSize: 10.0 x 15.0\n";
	        assertEquals(expected, ticketingOffice.toString());
	    }
}