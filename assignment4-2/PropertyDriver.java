public class PropertyDriver 
{
	public static void main(String[] args) 
	{
		ManagementCompany m = new ManagementCompany("Da Company", "123-456-6767");
        Property p1 = new Property("Apartment1", "Freakyville", 7, "The freakmiester");
        Property p2 = new Property("the throne room", "The holy roman empire", 13324, "The emporer");
        m.addProperty(p1);
        m.addProperty(p2);
        System.out.println(m.toString());
	}
}

