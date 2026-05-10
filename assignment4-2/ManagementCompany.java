
public class ManagementCompany 
{
	public static final int MAX_PROPERTIES = 5;
	private String name;
	private String taxId;
	private Property[] properties;
	private int propertyCount;
	
	public ManagementCompany(String name, String taxId, Property[] properties, int propertyCount)
	{
		this.name = name;
		this.taxId = taxId;
		this.properties = properties;
		this.propertyCount = propertyCount;
	}
	
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
		propertyCount = m.propertyCount;
		properties = new Property[5];

		for(int i = 0; i < propertyCount; i++)
		{
			properties[i] = new Property(m.properties[i]);
		}
	}

    public String getName()
    {
        return name;
    }

    public String getTaxId()
    {
        return taxId;
    }
	
    public Property[] getProperties()
    {
        return properties;
    }
    
    public int getPropertyCount()
    {
        return propertyCount;
    }
    
    public void setName(String name)
	{
		this.name = name;
	}
	
	public void setTaxId(String taxId)
	{
		this.taxId = taxId;
	}
	
	public void setProperties(Property[] properties)
	{
		this.properties = properties;
	}
	
	public void setPropertyCount(int propertyCount)
	{
		this.propertyCount = propertyCount;
	}
    
	public int addProperty(Property p)
	{
		if(propertyCount > 4)
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
		for(int i = 0; i < propertyCount;i++)
		{
			total += properties[i].getRentAmount();
		}
		return total;
	}
	
	public String toString()
    {
		String a = "";
		for(int i = 0; i < propertyCount; i++)
		{
			a += properties[i].toString() + "\n";
		}
        String b = name + " " + taxId + "\n" + a + "\n" + "Total Rent: " + totalRent();
		return b;
    }
	
	public Property getProperty(int index)
    {
        return properties[index];
    }
}
