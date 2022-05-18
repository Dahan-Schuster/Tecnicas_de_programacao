import java.util.Scanner;

public class TerminalInterface implements UserInterface {
    
	private Scanner reader;         // source of command input

	public TerminalInterface() {
		reader = new Scanner(System.in);
	}

	/**
	 * Prompts the user for a command in the console
	 * @return an ArrayList of words 
	 */
	@Override
	public String getCommandInput() {
        System.out.print("> ");        // print prompt
		return readLine();
	}

	/**
	 * Prompts the user for a value in the console
	 */
	@Override
	public String promptInput(String prompt) {
		System.out.print(prompt);     // print prompt
		return readLine();
	}

	private String readLine() {
		String inputLine;   // will hold the full input line
        inputLine = reader.nextLine();
		return inputLine;
	}

	/**
	 * Prints the message in the console
	 */
	@Override
	public void print(String message) {
		System.out.println(message);
	}

	/**
	 * Prints out the Wellcome message to the user
	 * @param roomDescription - a description of the current room
	 */
	@Override
    public void printWelcome(Player player)
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul, " + player.getName() + "!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
		System.out.println(player.getCurrentRoom().getLongDescription());
    }

    /**
	 * Print out some help information.
	 * Here we print some stupid, cryptic message and a list of the 
	 * command words.
     */
	@Override
    public void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
		System.out.println(CommandWords.getCommandList());
    }
}