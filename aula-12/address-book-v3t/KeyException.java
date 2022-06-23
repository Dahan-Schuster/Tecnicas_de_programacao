/**
 * Capture exceptions regarding key accesses in the AddressBook
 * 
 * @author Dahan Schuster
 * @version 22/06/2022
 */
public abstract class KeyException extends Exception {
	
    // The key with no match.
    protected String key;

	public KeyException(String key) {
		this.key = key;
	}

    /**
     * @return The key in error.
     */
    public String getKey()
    {
        return key;
    }
    
    /**
     * @return A diagnostic string containing the key in error.
     */
	@Override
    public abstract String toString();

}
