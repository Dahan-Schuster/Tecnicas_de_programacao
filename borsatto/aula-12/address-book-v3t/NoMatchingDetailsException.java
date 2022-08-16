/**
 * Capture a key that failed to match an entry
 * in the address book.
 * 
 * @author David J. Barnes and Michael Kolling.
 * @version 2008.03.30
 */
public class NoMatchingDetailsException extends KeyException
{
    /**
     * Store the details in error.
     * @param key The key with no match.
     */
    public NoMatchingDetailsException(String key)
    {
        super(key);
    }
    
    /**
     * @return A diagnostic string containing the key in error.
     */
	@Override
    public String toString()
    {
        return "No details matching: " + this.key + " were found.";
    }
}
