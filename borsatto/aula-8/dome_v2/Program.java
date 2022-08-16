public class Program {
	public static void main(String[] args) {
		CD cd = new CD("Admirável Chip Novo", "Pitty", 11, 40);
		cd.setComment("Aonde estão meus olhos de robô?");
		
		DVD dvd = new DVD("Into the Wild", "Sean Penn", 148);
		dvd.setComment("A true beauty of visual arts");

		Videogame g1 = new Videogame("Celeste", 40, "Platform", "Windows, Linux, Nintendo Switch, PlayStation 4, Xbox One", 2018);
		g1.setOwn(true);
		
		Videogame g2 = new Videogame("Minecraft", 0, "Survival", "Java, Android, IOS, PlayStation 4, Xbox One", 2011);
		g2.setOwn(true);

		Database db = new Database();

		db.addItem(g1);
		db.addItem(g2);
		db.addItem(cd);
		db.addItem(dvd);

		db.list();
	}
}
