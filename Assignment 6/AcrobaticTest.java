/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Acrobatic junit
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


public class AcrobaticTest 
{
	
		private Acrobatic acrobatic = new Acrobatic("Joel", 25, 5, "Acrobatic", "images/Acrobatic.png");

	    @Test
	    public void testGetName() {
	        assertEquals("Joel", acrobatic.getName());
	    }

	    @Test
	    public void testGetAge() {
	        assertEquals(25, acrobatic.getAge());
	    }

	    @Test
	    public void testGetYearsWorked() {
	        assertEquals(5, acrobatic.getYearsWorked());
	    }

	    @Test
	    public void testGetJob() {
	        assertEquals("Acrobatic", acrobatic.getJob());
	    }

	    @Test
	    public void testGetImagePath() {
	        assertEquals("images/Acrobatic.png", acrobatic.getImagePath());
	    }

	    @Test
	    public void testToString() {
	        String expected =
	            "Acrobatic - Name: Joel, Age: 25, Job: Acrobatic, Years Worked: 5";
	        assertEquals(expected, acrobatic.toString());
	    }
}