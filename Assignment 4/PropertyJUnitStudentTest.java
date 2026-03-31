/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: JUnit test
 * Due: 3/30/2026
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Julian Black
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class PropertyJUnitStudentTest
{
    @Test
    public void testDefaultConstructor()
    {
        Property p = new Property();

        assertEquals("", p.getPropertyName());
        assertEquals("", p.getCity());
        assertEquals(0.0, p.getRentAmount(), 0.001);
        assertEquals("", p.getOwner());
    }

    @Test
    public void testParameterizedConstructor()
    {
        Property p = new Property("Apt 1", "Rockville", 1200.0, "Bob");

        assertEquals("Apt 1", p.getPropertyName());
        assertEquals("Rockville", p.getCity());
        assertEquals(1200.0, p.getRentAmount(), 0.001);
        assertEquals("Bob", p.getOwner());
    }

    @Test
    public void testCopyConstructor()
    {
        Property p1 = new Property("Apt 1", "Rockville", 1200.0, "Bob");
        Property p2 = new Property(p1);

        assertEquals(p1.getPropertyName(), p2.getPropertyName());
        assertEquals(p1.getCity(), p2.getCity());
        assertEquals(p1.getRentAmount(), p2.getRentAmount(), 0.001);
        assertEquals(p1.getOwner(), p2.getOwner());
        assertNotSame(p1, p2);
    }

    @Test
    public void testSettersAndGetters()
    {
        Property p = new Property();

        p.setPropertyName("House 1");
        p.setCity("Bethesda");
        p.setRentAmount(1800.0);
        p.setOwner("Alice");

        assertEquals("House 1", p.getPropertyName());
        assertEquals("Bethesda", p.getCity());
        assertEquals(1800.0, p.getRentAmount(), 0.001);
        assertEquals("Alice", p.getOwner());
    }

    @Test
    public void testToString()
    {
        Property p = new Property("Apt 1", "Rockville", 1200.0, "Bob");
        String str = p.toString();

        assertTrue(str.contains("Apt 1"));
        assertTrue(str.contains("Rockville"));
        assertTrue(str.contains("Bob"));
        assertTrue(str.contains("1200.0"));
    }
}