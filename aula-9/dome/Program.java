public class Program {
	public static void main(String[] args) {
		Database db = new Database();

		db.addItem(new Item("First item", 42));
		db.addItem(new CD("Rick Astley Whenever You Need Somebody", "Rick Astley", 10, 30));
		db.addItem(new DVD("Capitão Fantástico", "Matt Ross", 148));

		db.list();
	}
}
