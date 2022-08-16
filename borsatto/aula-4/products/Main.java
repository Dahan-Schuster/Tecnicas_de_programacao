public class Main {
	public static void main(String[] args) {
		StockManager stock = new StockManager();

		stock.addProduct(new Product(1, "Banana"));
		stock.addProduct(new Product(2, "Côco"));
		stock.addProduct(new Product(3, "Alface"));
		stock.addProduct(new Product(4, "Manga"));
		stock.addProduct(new Product(5, "Abobrinha"));
		stock.addProduct(new Product(6, "Couve"));

		stock.delivery(1, 5);
		stock.delivery(2, 7);
		stock.delivery(3, 15);
		stock.delivery(4, 10);
		stock.delivery(5, 25);
		stock.delivery(6, 12);

		stock.printProductDetails();
		stock.printProductDetails(11);

		stock.addProduct(new Product(6, "Repolho"));
	}
}
