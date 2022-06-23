public class Program {
	public static void main(String[] args) {

		AddressBookInterface interaction = new AddressBookTextInterface();
		AddressBookDemo demo = new AddressBookDemo(interaction);

		demo.showInterface();
	}
}
