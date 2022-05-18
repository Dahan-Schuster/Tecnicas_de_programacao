/**
 * The Person class represents a person in a scholar administration system.
 * It holds the person's details relevant in our context.
 * 
 * @author Dahan Schuster
 * @version 2022.05.18
 */
public class Person {
	// the person's full name
	private String name;
	// the person ID
	private String id;

	/**
     * Create a new person with a given name and ID number.
     */
	public Person(String fullName, String id) {
        this.name = fullName;
        this.id = id;
	}

	 /**
     * Return the full name of this person.
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Set a new name for this person.
     */
    public void changeName(String replacementName)
    {
        name = replacementName;
    }

    /**
     * Return the ID of this person.
     */
    public String getID()
    {
        return id;
    }

    /**
     * Return the login name of this person. The login name is a combination
     * of the first four characters of the person's name and the first three
     * characters of the person's ID number.
     */
    public String getLoginName()
    {
        String subname = name.length() >= 4 ? name.substring(0,4) : name;
        String subid = id.length() >= 3 ? id.substring(0,3) : id;
        
        return subname + subid;
    }
    
    /**
     * Print the person's name and ID number to the output terminal.
     */
    public void print()
    {
        System.out.println(name + " (" + id + ")");
    }
}
