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
		rentAmount = 0;
		owner = "";
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
	}
	
	public String getPropertyName()
	{
		return propertyName;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public String getOwner()
	{
		return owner;
	}
	
	public double getRentAmount()
	{
		return rentAmount;
	}
	
	public void setPropertyName(String propertyName)
	{
		this.propertyName = propertyName;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public void setOwner(String owner)
	{
		this.owner = owner;
	}
	
	public void setRentAmount(double rentAmount)
	{
		this.rentAmount = rentAmount;
	}
	
	public String toString()
    {
        String a = propertyName + ", " + city + ", Rent: $" + String.format("%.2f", rentAmount) + ", Owner: " + owner;
		return a;
    }
	
	public Property(Property p)
    {
        propertyName = p.propertyName;
        city = p.city;
        rentAmount = p.rentAmount;
        owner = p.owner;
    }
	
}