/**
 * Interface for user interaction
 * UserInterface classes must provide methods to
 * communicate with the user and return its answers
 * 
 * @author Dahan Schuster
 * @version 2022-05-06
 */
public interface UserInterface {
	
	/**
	 * Must show a message to the user
	 * @param message
	 */
	public void print(String message);

	/**
	 * Must return a String representing the commands entered by the user
	 * @return input - a command string
	 */
	public String getCommandInput();

	/**
	 * Must prompt the message to the user and return an answer
	 * 
	 * @param prompt
	 * @return input - the answer string
	 */
	public String promptInput(String prompt);

    /**
     * Print out the opening message for the player.
     */
	public void printWelcome(Player player);

    /**
	 * Print out some help information.
     */
	public void printHelp();
}
