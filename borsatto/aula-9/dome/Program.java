public class Program {
	public static void main(String[] args) {
		Database db = new Database();

		Item item = new Item("O guia do mochileiro das galáxias", 42);
		item.setComment("A resposta para a vida, o universo e tudo mais.");
		item.setOwn(true);
		db.addItem(item);

		CD cd = new CD("Whenever You Need Somebody", "Rick Astley", 10, 30);
		cd.setOwn(true);
		cd.setComment("Rick rollll");
		db.addItem(cd);

		DVD dvd = new DVD("Capitão Fantástico", "Matt Ross", 148);
		dvd.setComment("Já assistiu capitão fantástico hoje?");
		db.addItem(dvd);

		db.list();
	}
}
