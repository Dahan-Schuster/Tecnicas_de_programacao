/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class Game 
{
    private UserInterface userInterface;
    private Parser parser;
    private Player player;

    private static final double PLAYER_MAX_CARRY_WEIGHT = 0.4;

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        userInterface = new TerminalInterface();
        parser = new Parser();
        createPlayer();
        createRooms();
    }

    /**
     * Prompts the player's info and initialize the object
     */
    private void createPlayer()
    {
        String name = userInterface.promptInput("Username: ");
        player = new Player(name, PLAYER_MAX_CARRY_WEIGHT);
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        // create the rooms
        Room outside, theatre, pub, lab, office;

        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        
        // initialise room exits and items
        outside.setExit("east", theatre);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theatre.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        // crate the items
        Item banana, keyboard, beer, article, dvd;

        banana = new Item("a very yellow banana", 0.5);
        keyboard = new Item("a pretty RGB colored keyboard", 0.7);
        beer = new Item("a warm cup of beer", 0.4);
        article = new Item("a boring article about bananas", 0.1);
        dvd = new Item("a DVD of the 8th season of The Office", 0.3);

        outside.setItem("banana", banana);
        theatre.setItem("keyboard", keyboard);
        pub.setItem("beer", beer);
        lab.setItem("article", article);
        office.setItem("dvd", dvd);

        player.setCurrentRoom(outside);  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        userInterface.printWelcome(player);

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
        boolean finished = false;
        while (! finished) {
            String input = userInterface.getCommandInput();
            Command command = parser.getCommand(input);
            finished = processCommand(command);
        }

        userInterface.print("Thank you for playing.  Good bye.");
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            userInterface.print("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            userInterface.printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("take")) {
            takeItem(command);
        }
        else if (commandWord.equals("drop")) {
            dropItem(command);
        }
        else if (commandWord.equals("inspect")) {
            inspectItem(command);
        }
        else if (commandWord.equals("info")) {
            getCurrentRoomInfo();
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        // else command not recognised.
        return wantToQuit;
    }

    // implementations of user commands:

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            userInterface.print("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = player.getCurrentRoom().getExit(direction);

        if (nextRoom == null) {
            userInterface.print("There is no door!");
        }
        else {
            player.setCurrentRoom(nextRoom);
            userInterface.print(player.getCurrentRoom().getLongDescription());
        }
    }

    /**
     * Try to get an item. If there's an item in the location, 
     */
    private void takeItem(Command command)
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know what item do take...
            userInterface.print("Take what?");
            return;
        }

        String name = command.getSecondWord();
        Item item = player.findItemInsideCurrentRoom(name);

        if (item == null) {
            userInterface.print("This item isn't here!");
        } else if (player.take(name)) {
            userInterface.print(
                "You got " + item.getDescription() +
                " and now are carrying " +
                player.getCurrentCarryWeight() + " Kg"
            );
        } else {
            userInterface.print(
                "Oh, you can only carry a maximum of " +
                player.getCarryWeightLimit() + " Kg!"
            );
        }
    }

    private void dropItem(Command command)
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know what item do drop...
            userInterface.print("Drop what?");
            return;
        }

        String name = command.getSecondWord();
        if (player.drop(name)) {
            userInterface.print(
                "You dropped " + name + " in the current room" +
                " and now are carrying " +
                player.getCurrentCarryWeight() + " Kg"
            );
        } else {
            userInterface.print("Do you remember taking this item? 'Cause I don't...");
        }
    }

    private void inspectItem(Command command) {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know what item do drop...
            userInterface.print("Inspect what?");
            return;
        }

        String name = command.getSecondWord();
        Item item = player.findItemInsideCurrentRoom(name);

        if (item == null) {
            userInterface.print("Item not found");
        } else {
            userInterface.print(
                "You found " + item.getDescription() + ". " +
                "It weigths " + item.getWeight() + " Kg"
            );
        }
    }

    private void getCurrentRoomInfo() {
        userInterface.print(player.getCurrentRoom().getLongDescription());
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            userInterface.print("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
