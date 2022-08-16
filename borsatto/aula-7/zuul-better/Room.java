import java.util.Set;
import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private HashMap<String, Item> items;        // stores items of this room.

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
		items = new HashMap<String, Item>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * Define an item in this room.
     * @param name The name of the item.
     * @param item  The Item object.
     */
	public void setItem(String name, Item item)
	{
		items.put(name, item);
	}

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        String desc = "You are " + description + ".\n" + getExitString();
		desc += "\n" + getItemsString();

		return desc;
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return a string describing the room's items, for example
     * "Items: banana laptop".
     * @return Details of the room's exits.
     */
    public String getItemsString()
    {
        String returnString = "Items:";
		Set<String> keys = items.keySet();
		
		if (keys.isEmpty())
			return returnString + " there are no items";
        
		for(String item : keys) {
			returnString += " " + item;
		}
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    /**
     * Return the item that is placed in the room with the given name
     * If there is no item with that name, return null.
     * @param name The items's name.
     * @return The item with the given name.
     */
	public Item getItem(String name)
	{
		return items.get(name);
	}

    /**
     * Removes the item that is placed in the room with the given name
     * If there is no item with that name, nothing happens.
     * @param name The items's name.
     */
	public void removeItem(String name)
	{
		items.remove(name);
	}
}

