import static org.junit.Assert.*;
import org.junit.Test;

public class StudentJunitTests {

    @Test
    public void testAddPropertyAndTotalRent() {
        ManagementCompany mc = new ManagementCompany("Da Company", "123-456-6767");
        Property p1 = new Property("Apartment1", "Freakyville", 7, "The freakmiester");
        Property p2 = new Property("the throne room", "The holy roman empire", 13324, "The emporer");

        int index1 = mc.addProperty(p1);
        int index2 = mc.addProperty(p2);

        assertEquals(0, index1);
        assertEquals(1, index2);
        assertEquals(2, mc.getPropertyCount());
        assertEquals(13331, mc.totalRent(), 0.001);
    }

    @Test
    public void testManagementCompanyCopyConstructor() {
        ManagementCompany mc1 = new ManagementCompany("Da Company", "123-456-6767");
        mc1.addProperty(new Property("Apartment1", "Freakyville", 7, "The freakmiester"));
        mc1.addProperty(new Property("the throne room", "The holy roman empire", 13324, "The emporer"));

        ManagementCompany mc2 = new ManagementCompany(mc1);

        assertEquals(mc1.getName(), mc2.getName());
        assertEquals(mc1.getTaxId(), mc2.getTaxId());
        assertEquals(mc1.getPropertyCount(), mc2.getPropertyCount());
        assertEquals(mc1.totalRent(), mc2.totalRent(), 0.001);
        assertNotSame(mc1.getProperty(0), mc2.getProperty(0));
    }
    
    @Test
    public void testSetters()
    {
    	Property p = new Property();

    	p.setCity("S");

    	assertEquals("S", p.getCity());
    }
}
