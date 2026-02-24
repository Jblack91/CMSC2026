package test;

/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: The section that deals with the patients
 * Due: 2/23/2026 
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here:Julian Black
*/
public class Patient
{
    private String firstName;
    private String middleName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String Phone;
    private String emergencyContactName;
    private String emergencyContactPhone;

    public Patient()
    {
        firstName = "";
        middleName = "";
        lastName = "";
        streetAddress = "";
        city = "";
        state = "";
        zipCode = "";
        Phone = "";
        emergencyContactName = "";
        emergencyContactPhone = "";
    }

    public Patient(String first, String middle, String last)
    {
        firstName = first;
        middleName = middle;
        lastName = last;
        streetAddress = "";
        city = "";
        state = "";
        zipCode = "";
        Phone = "";
        emergencyContactName = "";
        emergencyContactPhone = "";
    }
    
    public Patient(String first, String middle, String last,
            String address, String city, String state,
            String zip, String Phone,
            String emergencyName, String emergencyPhone)
    		{
    			this.firstName = first;
    			this.middleName = middle;
    			this.lastName = last;
    			this.streetAddress = address;
    			this.city = city;
    			this.state = state;
    			this.zipCode = zip;
    			this.Phone = Phone;
    			this.emergencyContactName = emergencyName;
    			this.emergencyContactPhone = emergencyPhone;
}

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getStreetAddress()
    {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress)
    {
        this.streetAddress = streetAddress;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    public String getPhone()
    {
        return Phone;
    }

    public void setPhone(String Phone)
    {
        this.Phone = Phone;
    }

    public String getEmergencyContactName()
    {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName)
    {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactPhone()
    {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone)
    {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    public String buildFullName()
    {
        return firstName + " " + middleName + " " + lastName;
    }

    public String buildAddress()
    {
        return streetAddress + " " + city + " " + state + " " + zipCode;
    }

    public String buildEmergencyContact()
    {
        return emergencyContactName + " " + emergencyContactPhone;
    }

    public String toString()
    {
        return "Patient Name: " + buildFullName()
                + "\nAddress: " + buildAddress()
                + "\nPhone: " + Phone
                + "\nEmergency Contact: " + buildEmergencyContact();
    }
}