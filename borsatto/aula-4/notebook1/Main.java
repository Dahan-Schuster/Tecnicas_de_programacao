public class Main {
    public static void main(String[] args) {

		Notebook notebook = new Notebook();
        notebook.storeNote("banana");

        notebook.search("banana");
        notebook.search("maçã");
    }

}
