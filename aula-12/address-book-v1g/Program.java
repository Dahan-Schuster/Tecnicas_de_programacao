public class Program {
	public static void main(String[] args) {
		AddressBookDemo gui = new AddressBookDemo();
		// gui.showInterface();

		AddressBook book = new AddressBook();
		book.removeDetails("oi");
	}
}
