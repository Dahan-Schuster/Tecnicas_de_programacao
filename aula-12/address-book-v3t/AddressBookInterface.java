/**
 * User interface for the address book
 * It can be a Text interface in the Terminal or a GUI
 * 
 * @author Dahan Schuster
 * @version 22/06/2022
 */
public abstract class AddressBookInterface {

    // The address book to be viewed and manipulated.
    protected AddressBook book;

	public AddressBookInterface() {}

	public AddressBookInterface(AddressBook book) {
		this.book = book;
	}
	
	public void setBook(AddressBook book) {
		this.book = book;
	}

	public abstract void run();
}
