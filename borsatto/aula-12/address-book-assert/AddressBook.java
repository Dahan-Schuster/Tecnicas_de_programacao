import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * A class to maintain an arbitrary number of contact details.
 * Details are indexed by both name and phone number.
 * This version uses assert statements to check internal
 * consistency.
 * 
 * @author David J. Barnes and Michael Kolling.
 * @version 2008.03.30
 */
public class AddressBook
{
    // Storage for an arbitrary number of details.
    private TreeMap<String, ContactDetails> book;
    private int numberOfEntries;

    /**
     * Perform any initialization for the address book.
     */
    public AddressBook()
    {
        book = new TreeMap<String, ContactDetails>();
        numberOfEntries = 0;
    }
    
    /**
     * Look up a name or phone number and return the
     * corresponding contact details.
     * @param key The name or number to be looked up.
     * @return The details corresponding to the key.
     */
    public ContactDetails getDetails(String key)
    {
        return book.get(key);
    }

    /**
     * Return whether or not the current key is in use.
     * @param key The name or number to be looked up.
     * @return true if the key is in use, false otherwise.
     */
    public boolean keyInUse(String key)
    {
        return book.containsKey(key);
    }

    /**
     * Add a new set of details to the notebook.
     * @param details The details to associate with the person.
     */
    public void addDetails(ContactDetails details)
    {
        if(details == null) {
            throw new IllegalArgumentException("Null details passed to addDetails.");
        }
        book.put(details.getName(), details);
        book.put(details.getPhone(), details);
        numberOfEntries++;

        assert consistentSize() : "Inconsistent book size in addDetails";
    }
    
    /**
     * Change the details previously stored under the given key.
     * @param oldKey One of the keys used to store the details.
                     This should be a key that is currently in use.
     * @param details The replacement details. Must not be null.
     * @throws IllegalArgumentException If either argument is null.
     */
    public void changeDetails(String oldKey,
                              ContactDetails details)
    {
        if(details == null) {
            throw new IllegalArgumentException("Null details passed to changeDetails.");
        }
        if(oldKey == null){
            throw new IllegalArgumentException("Null key passed to changeDetails.");
        }
        if(keyInUse(oldKey)){
            removeDetails(oldKey);
            addDetails(details);
        }

		assert consistentSize() : "Número de entradas difere entre o início e o fim";
    }

    /**
     * Search for all details stored under a key that starts with
     * the given prefix.
     * @param keyPrefix The key prefix to search on. This may be
     *                  of zero length, but must not be null.
     * @return An array of those details that have been found.
     */
    public ContactDetails[] search(String keyPrefix)
    {
        // Build a list of the matches.
        List<ContactDetails> matches = new LinkedList<ContactDetails>();
        if(keyPrefix != null) {
            // Find keys that are equal-to or greater-than the prefix.
            SortedMap<String, ContactDetails> tail = book.tailMap(keyPrefix);
            Iterator<String> it = tail.keySet().iterator();
            // Stop when we find a mismatch.
            boolean endOfSearch = false;
            while(!endOfSearch && it.hasNext()) {
                String key = it.next();
                if(key.startsWith(keyPrefix)) {
                    matches.add(book.get(key));
                }
                else {
                    endOfSearch = true;
                }
            }
        }
        ContactDetails[] results = new ContactDetails[matches.size()];
        matches.toArray(results);
        return results;
    }

    /**
     * @return The number of entries currently in the
     *         address book.
     */
    public int getNumberOfEntries()
    {
        return numberOfEntries;
    }

    /**
     * Remove the entry with the given key from the address book.
     * The key should be one that is currently in use.
     * @param key One of the keys of the entry to be removed.
     * @throws IllegalArgumentException If the key is null.
     */
    public void removeDetails(String key)
    {
        if(key == null){
            throw new IllegalArgumentException("Null key passed to removeDetails.");
        }
        if(keyInUse(key)) {
            ContactDetails details = book.get(key);
            book.remove(details.getName());
            book.remove(details.getPhone());
            numberOfEntries--;
        }
        assert !keyInUse(key);
        assert consistentSize() : "Inconsistent book size in removeDetails";
    }

    /**
     * @return All the contact details, sorted according
     * to the sort order of the ContactDetails class.
     */
    public String listDetails()
    {
        // Because each entry is stored under two keys, it is
        // necessary to build a set of the ContactDetails. This
        // eliminates duplicates.
        StringBuffer allEntries = new StringBuffer();
        Set<ContactDetails> sortedDetails = new TreeSet<ContactDetails>(book.values());
        for(ContactDetails details : sortedDetails) {
            allEntries.append(details);
            allEntries.append('\n');
            allEntries.append('\n');
        }
        return allEntries.toString();
    }
    
    /**
     * Check that the numberOfEntries field is consistent with
     * the number of entries actually stored in the address book.
     * @return true if the field is consistent, false otherwise.
     */
    private boolean consistentSize()
    {
        Collection<ContactDetails> allEntries = book.values();
        // Eliminate duplicates as we are using multiple keys.
        Set<ContactDetails> uniqueEntries = new HashSet<ContactDetails>(allEntries);
        int actualCount = uniqueEntries.size();
        return numberOfEntries == actualCount;
    }
}
