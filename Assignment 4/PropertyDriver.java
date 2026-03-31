/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Driver
 * Due: 3/30/2026
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Julian Black
*/
public class PropertyDriver
{

    public static void main(String[] args)
    {

        ManagementCompany m = new ManagementCompany("Campus Realty", "123-45-6789");


        Property p1 = new Property("Apt1", "Rockville", 1200, "Bob");

        Property p2 = new Property("Apt2", "Gaithersburg", 1500, "Carol");

        Property p3 = new Property("House1", "Bethesda", 1800, "Alice");


        m.addProperty(p1);

        m.addProperty(p2);

        m.addProperty(p3);


        System.out.println(m.toString());

    }

}
