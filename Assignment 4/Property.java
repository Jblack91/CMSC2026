/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Represents one rental property
 * Due: 3/30/2026
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Julian Black
*/

public class Property
{

    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;


    public Property()
    {
        propertyName = "";
        city = "";
        rentAmount = 0.0;
        owner = "";
    }


    public Property(String propertyName, String city, double rentAmount, String owner)
    {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
    }


    public Property(Property p)
    {
        propertyName = p.propertyName;
        city = p.city;
        rentAmount = p.rentAmount;
        owner = p.owner;
    }


    public String getPropertyName()
    {
        return propertyName;
    }


    public void setPropertyName(String propertyName)
    {
        this.propertyName = propertyName;
    }


    public String getCity()
    {
        return city;
    }


    public void setCity(String city)
    {
        this.city = city;
    }


    public double getRentAmount()
    {
        return rentAmount;
    }


    public void setRentAmount(double rentAmount)
    {
        this.rentAmount = rentAmount;
    }


    public String getOwner()
    {
        return owner;
    }


    public void setOwner(String owner)
    {
        this.owner = owner;
    }


    public String toString()
    {
        return propertyName + ", " + city + ", " + owner + ", " + rentAmount;
    }

}