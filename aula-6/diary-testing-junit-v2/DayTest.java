import org.junit.*;

/**
 * The test class DayTest.
 *
 * @author  David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class DayTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class DayTest
     */
    public DayTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
	@BeforeClass
    protected void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
	@AfterClass
    protected void tearDown()
    {
    }

    /**
     * Test basic functionality by booking at either end
     * of a day, and in the middle.
     */
	@Test
    public void testMakeThreeAppointments()
    {
        Day day1 = new Day(1);
        Appointment appointm1 = new Appointment("Java lecture", 1);
        Appointment appointm2 = new Appointment("Java class", 1);
        Appointment appointm3 = new Appointment("Meet John", 1);
        assertEquals(true, day1.makeAppointment(9, appointm1));
        assertEquals(true, day1.makeAppointment(13, appointm2));
        assertEquals(true, day1.makeAppointment(17, appointm3));
    }

    /**
     * Check that double-booking is not permitted.
     */
	@Test
    public void testDoubleBooking()
    {
        Day day1 = new Day(1);
        Appointment appointm1 = new Appointment("Java lecture", 1);
        Appointment appointm2 = new Appointment("Error", 1);
        assertEquals(true, day1.makeAppointment(9, appointm1));
        assertEquals(false, day1.makeAppointment(9, appointm2));
    }

	/**
	 * Check if the search for free space is working.
	 */
	@Test
	public void testFindSpace()
	{
		Day day = new Day(1);
		Appointment appointment = new Appointment("1h appointment", 1);

		assertEquals(true, day.makeAppointment(9, appointment));
		assertEquals(10, day.findSpace(appointment));
	}

	/**
	 * Check if a two hours appointment can not be made
	 * one hour before another appointment
	 */
	@Test
	public void testCanNotMakeAppointment()
	{
		DayBetter day = new DayBetter(1);
		Appointment appointment1 = new Appointment("1h appointment", 1);
		Appointment appointment2 = new Appointment("2h appointment", 2);

		assertEquals(true, day.makeAppointment(10, appointment1));
		assertEquals(false, day.makeAppointment(9, appointment2));
	}
}


