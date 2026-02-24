package test;

/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: The class that deals with the procedures section
 * Due: 2/23/2026 
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here:Julian Black
*/

public class Procedure
{
    private String procedureName;
    private String procedureDate;
    private String practitionerName;
    private double charges;

    public Procedure()
    {
        procedureName = "";
        procedureDate = "";
        practitionerName = "";
        charges = 0.0;
    }

    public Procedure(String name, String date)
    {
        procedureName = name;
        procedureDate = date;
        practitionerName = "";
        charges = 0.0;
    }

    public Procedure(String name, String date, String practitioner, double charges)
    {
        this.procedureName = name;
        this.procedureDate = date;
        this.practitionerName = practitioner;
        this.charges = charges;
    }

    public String getProcedureName()
    {
        return procedureName;
    }

    public void setProcedureName(String procedureName)
    {
        this.procedureName = procedureName;
    }

    public String getProcedureDate()
    {
        return procedureDate;
    }

    public void setProcedureDate(String procedureDate)
    {
        this.procedureDate = procedureDate;
    }

    public String getPractitionerName()
    {
        return practitionerName;
    }

    public void setPractitionerName(String practitionerName)
    {
        this.practitionerName = practitionerName;
    }

    public double getCharge()
    {
        return charges;
    }

    public void setCharges(double charges)
    {
        this.charges = charges;
    }

    public String toString()
    {
        return procedureName + "\t" + procedureDate + "\t"
                + practitionerName + "\t"
                + String.format("%.2f", charges);
    }
}
