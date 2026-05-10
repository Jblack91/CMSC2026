import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentPropertyTest 
{
	private Property property;
	@BeforeEach
	public void setUp() 
	{
	    property = new Property("The dog house", "Space", 12.57, "Jeorge");
	}
	@Test
	public void testGetPropertyName() 
	{
	    assertEquals("The dog house", property.getPropertyName());
	}
	@Test
	public void testGetRentAmount() 
	{
	    assertEquals(12.57, property.getRentAmount(), 0.001);
	}
	@Test
	public void testToString() 
	{
	    String expected = "The dog house, Space, Rent: $12.57, Owner: Jeorge";
	    assertEquals(expected, property.toString());
	}
		
}