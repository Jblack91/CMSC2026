/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Stores property
 * Due: 3/30/2026
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Julian Black
*/

public class ManagementCompany
{

    public static final int MAX_PROPERTIES = 5;

    private String name;
    private String taxId;
    private Property[] properties;
    private int propertyCount;


    public ManagementCompany(String name, String taxId)
    {
        this.name = name;
        this.taxId = taxId;

        properties = new Property[MAX_PROPERTIES];

        propertyCount = 0;
    }


    public ManagementCompany(ManagementCompany m)
    {
        name = m.name;
        taxId = m.taxId;

        properties = new Property[MAX_PROPERTIES];

        propertyCount = m.propertyCount;

        for(int i = 0; i < propertyCount; i++)
        {
            properties[i] = new Property(m.properties[i]);
        }
    }


    public int addProperty(Property p)
    {

        if(propertyCount >= MAX_PROPERTIES)
        {
            return -1;
        }

        properties[propertyCount] = new Property(p);

        propertyCount++;

        return propertyCount - 1;

    }


    public double totalRent()
    {

        double total = 0;

        for(int i = 0; i < propertyCount; i++)
        {
            total = total + properties[i].getRentAmount();
        }

        return total;

    }


    public int getPropertyCount()
    {
        return propertyCount;
    }


    public String getName()
    {
        return name;
    }


    public String getTaxId()
    {
        return taxId;
    }


    public Property getProperty(int index)
    {

        if(index < 0 || index >= propertyCount)
        {
            return null;
        }

        return properties[index];

    }


    public String toString()
    {

        String result = "";

        result = result + name + " " + taxId + "\n";

        for(int i = 0; i < propertyCount; i++)
        {
            result = result + properties[i].toString() + "\n";
        }

        result = result + "Total Rent: " + totalRent();

        return result;

    }

}