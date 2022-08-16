import java.util.Random;

public class TransporterRoom extends Room {

	private Random roomChooser;

	/**
     * Create a room described "description".
	 * 
	 * @param description
	 */
    public TransporterRoom(String description) 
    {
		super(description);		
		roomChooser = new Random(System.currentTimeMillis());
    }

	/**
     * Return a string describing the room's exits. For a transporter room, it
	 * can be any room in the game, except for itself.
	 * 
     * @return Details of the room's exits.
     */
	@Override
    protected String getExitString()
    {
        return "Exits: it doesn't matter the direction, you will be transported to anywhere in the game";
    }

	/**
     * Return a random room from the defined in the Game
	 * Giving a direction is useless, since the room will
	 * aways be random
	 * 
     * @param direction
     * @return A random room in the game, except for
	 * the current Transporter Room itself
     */
	@Override
    public Room getExit(String direction) 
    {
        return getExit();
    }

	/**
     * Return a random room from the defined in the Game
	 * 
     * @return A random room in the game, except for
	 * the current Transporter Room itself
     */
	public Room getExit() {
		int numberOfRooms = exits.size();
		int chosenRoomNumber = roomChooser.nextInt(numberOfRooms);
		Room chosenRoom = super.getExit(String.valueOf(chosenRoomNumber));

		return chosenRoom;
	}
}
