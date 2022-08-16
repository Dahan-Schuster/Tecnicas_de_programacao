/**
 * A KeyException especific for trying to add a already existing key in the
 * Address Book
 * 
 * @author Dahan Schuster
 * @version 22/06/2022
 */
public class DuplicateKeyException extends KeyException {

	public DuplicateKeyException(String key) {
		super(key);
	}

	@Override
	public String toString() {
		return "The key " + this.key + " is already in use.";
	}
}