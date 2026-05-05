/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Arena junit
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


public class ArenaJUnitTest 
{
	
		private Arena arena = new Arena("Green", 6, 8, "images/Arena.png");

	    @Test
	    public void testGetLength() {
	        assertEquals(6, arena.getLength());
	    }

	    @Test
	    public void testGetWidth() {
	        assertEquals(8, arena.getWidth());
	    }

	    @Test
	    public void testGetColor() {
	        assertEquals("Green", arena.getColor());
	    }

	    @Test
	    public void testGetBuildingType() {
	        assertEquals("Arena", arena.getBuildingType());
	    }

	    @Test
	    public void testGetImagePath() {
	        assertEquals("images/Arena.png", arena.getImagePath());
	    }

	    @Test
	    public void testToString() {
	        String expected =
	            "\nBuilding Type: Arena \nColor: Green \nSize: 6.0 x 8.0\n";
	        assertEquals(expected, arena.toString());
	    }
}