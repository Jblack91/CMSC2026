/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Bird Junit
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

public class BirdJUnitTest {

    private Bird bird;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        bird = new Bird("Borb", 3, "pidgeon", "Black", "images/bird.png");
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        outputStream.reset();
    }

    @Test
    public void testGetName() {
        assertEquals("Borb", bird.getName());
    }

    @Test
    public void testGetAge() {
        assertEquals(3, bird.getAge());
    }

    @Test
    public void testGetSpecies() {
        assertEquals("pidgeon", bird.getSpecies());
    }

    @Test
    public void testGetColor() {
        assertEquals("Black", bird.getColor());
    }

    @Test
    public void testGetImagePath() {
        assertEquals("images/bird.png", bird.getImagePath());
    }

    @Test
    public void testToString() {
        String expected =
            "Bird [Name: Borb, Age: 3, Species: pidgeon, Color: Black]";
        assertEquals(expected, bird.toString());
    }

    // ===== makeSound TEST (portable) =====
    @Test
    public void testMakeSound() {
        bird.makeSound();
        assertEquals("Chirp!" + System.lineSeparator(),
                     outputStream.toString());
    }

    // ===== move TEST (portable, matches extra newline) =====
    @Test
    public void testMove() {
        bird.move();

        String output = outputStream.toString()
                                    .replace("\r\n", "\n");

        assertEquals("Flies.\n\n", output);
    }
}
