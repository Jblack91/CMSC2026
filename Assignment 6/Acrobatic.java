/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Acrobatic
 * Due:5/4/2026
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Julian Black
*/

package BobsCircus;
public class Acrobatic extends Person {

    public Acrobatic(String name, int age, int yearsWorked, String job, String imagePath) {
    	super(name, age, yearsWorked, job, imagePath);
    }

    @Override
    public String toString() {
        return "Acrobatic - " + super.toString();
    }
}
