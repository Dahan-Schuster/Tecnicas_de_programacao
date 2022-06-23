public class Program {
    private static final String FILENAME = "notebook.txt";

    public static void main(String[] args) {
        Notebook note = new Notebook();
        Program.fillAndSave(note);
        Program.readAndList(note);
    }

    private static void readAndList(Notebook note) {
        note.readFromFile(FILENAME);
        note.listNotes();
    }

    private static void fillAndSave(Notebook note) {
        note.storeNote("Sky");
        note.storeNote("Children");
        note.storeNote("of");
        note.storeNote("the");
        note.storeNote("Light");

        note.saveToFile(FILENAME);
    }
}
