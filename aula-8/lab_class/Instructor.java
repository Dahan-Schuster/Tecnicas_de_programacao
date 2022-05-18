/**
 * The Instructor class represents a instructor in a scholar administration system.
 * It holds the instructor's details relevant in our context.
 * 
 * @author Dahan Schuster
 * @version 2022.05.18
 */
public class Instructor extends Person {

	// the subject field of the instructor
	private String subject;
	
	/**
     * Create a new instructor with a given name, ID number and subject field.
     */
	public Instructor(String name, String ID, String subject) {
		super(name, ID);
		this.subject = subject;
	}

	/** Change the subject field of the instructor */
	public void changeSubject(String subject) {
		this.subject = subject;
	}

	/** Return the subject field of the instructor */
	public String getSubject() {
		return subject;
	}

	/**
    * Print the instructor's name, ID number and subject field to the output terminal.
    */
    public void print()
    {
        System.out.println(getName() + " (Instructor ID #" + getID() + ") - " + subject);
    }
	
}
