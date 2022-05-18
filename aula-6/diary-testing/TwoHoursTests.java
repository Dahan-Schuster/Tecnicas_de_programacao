/**
 * Perform tests of the Day class that involve
 * making double-hour appointments.
 * 
 * @author Dahan Schuster
 * @version 2022.04.30
 */
public class TwoHoursTests
{
    // The Day object being tested.
    private Day day;
	static final int DURATION = 2;

    /**
     * Constructor for objects of class TwoHoursTests
     */
    public TwoHoursTests()
    {
        // Create a Day object that can be used in testing.
        // Individual methods might choose to create
        // their own instances.
        day = new Day(1);
    }

	public static void main(String[] args)
	{
		TwoHoursTests tests = new TwoHoursTests();

		tests.testDoubleBooking();
		tests.fillTheDay();
		tests.findSpaces();
	}

    /**
     * Test basic functionality by booking at either end
     * of a day, and in the middle.
     */
    public void makeThreeAppointments()
    {
        // Start with a fresh Day object.
        day = new Day(1);
        // Create three one-hour appointments.
        Appointment first = new Appointment("Java lecture", DURATION);
        Appointment second = new Appointment("Java class", DURATION);
        Appointment third = new Appointment("Meet John", DURATION);
        
        // Make each appointment at a different time.
        day.makeAppointment(9, first);
        day.makeAppointment(13, second);
        day.makeAppointment(16, third);
        
        day.showAppointments();
    }
    
    /**
     * Check that double-booking is not permitted.
     */
    public void testDoubleBooking()
    {
        // Set up the day with three legitimate appointments.
        makeThreeAppointments();
        Appointment badAppointment = new Appointment("Error", DURATION);
        day.makeAppointment(9, badAppointment);
        
        // Show that the badAppointment has not been made.
        day.showAppointments();
    }

    /**
     * Test basic functionality by filling a complete
     * day with appointments.
     */
    public void fillTheDay()
    {
        // Start with a fresh Day object.
        day = new Day(1);
        for(int time = Day.START_OF_DAY;
                    time <= Day.FINAL_APPOINTMENT_TIME - 1;
                        time += 2) {
            day.makeAppointment(time,
                                new Appointment("Test " + time, DURATION));
        }
        
        day.showAppointments();
    }

	public void findSpaces()
	{
		day = new Day(1);
		Appointment twoHours = new Appointment("2h", DURATION);
		day.makeAppointment(9, new Appointment("1h", 1));

		day.showAppointments();

		System.out.println("There's a 2h space at " + day.findSpace(twoHours) + "h"); 

		System.out.println("There's a 2h space at 9h? " + (day.findSpaceAtTime(twoHours, 9) ? "yes" : "no"));
		System.out.println("There's a 2h space at 17h? " + (day.findSpaceAtTime(twoHours, 17) ? "yes" : "no"));
		System.out.println("There's a 2h space at 13h? " + (day.findSpaceAtTime(twoHours, 13) ? "yes" : "no"));
	}
}
