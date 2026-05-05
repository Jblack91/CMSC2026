/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: lion junit
 * Due:5/4/2026
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Julian Black
*/
package BobsCircus;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LionJUnitTest {

    private Lion lion;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        lion = new Lion("Joe", 3, "African", "Red", "images/Lion.png");
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        outputStream.reset();
    }

    @Test
    public void testGetName() {
        assertEquals("Joe", lion.getName());
    }

    @Test
    public void testGetAge() {
        assertEquals(3, lion.getAge());
    }

    @Test
    public void testGetSpecies() {
        assertEquals("African", lion.getSpecies());
    }

    @Test
    public void testGetColor() {
        assertEquals("Red", lion.getColor());
    }

    @Test
    public void testGetImagePath() {
        assertEquals("images/Lion.png", lion.getImagePath());
    }

    @Test
    public void testToString() {
        String expected =
            "Lion [Name: Joe, Age: 3, Species: African, Color: Red]";
        assertEquals(expected, lion.toString());
    }

    // ===== makeSound TEST (portable) =====
    @Test
    public void testMakeSound() {
        lion.makeSound();
        assertEquals("Roar!" + System.lineSeparator(),
                     outputStream.toString());
    }

    // ===== move TEST (portable, matches extra newline) =====
    @Test
    public void testMove() {
        lion.move();

        String output = outputStream.toString()
                                    .replace("\r\n", "\n");

        assertEquals("Runs.\n\n", output);
    }
}
