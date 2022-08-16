import java.util.HashMap;

public class Player {
	public String name;
	public double carryWeightLimit;
	public Room currentRoom;
	public HashMap<String, Item> heldItems;

	public Player(String name, double carryWeightLimit) {
		this.name = name;
		this.carryWeightLimit = carryWeightLimit;
		this.currentRoom = null;
		this.heldItems = new HashMap<String, Item>();
	}

	public String getName() {
		return name;
	}

	public double getCarryWeightLimit() {
		return carryWeightLimit;
	}

	public double getCurrentCarryWeight() {
		double total = 0;
		for (Item item : heldItems.values()) {
			total += item.getWeight();
		}

		return total;
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	/**
	 * Search for an item inside the current room with the given name
	 * @param name the name of the item
	 * @return the item, if found in the current room, null otherwise
	 */
	public Item findItemInsideCurrentRoom(String name)
	{
		return currentRoom.getItem(name);
	}

	/**
	 * Try to take an Item from inside the current room with the given name
	 * 
	 * @param item
	 * @return true if the item was taken, false otherwise
	 */
	public boolean take(String name) {
		Item item = findItemInsideCurrentRoom(name);

		if (canHoldItem(item)) {
			heldItems.put(name, item);
			currentRoom.removeItem(name);
			return true;
		}
		
		return false;
	}

	/**
	 * Search for an item in the held items and drops it in
	 * the location inside the current room
	 * 
	 * @param item
	 * @param location the location where to drop the item
	 * @return true if the item was dropped, false otherwise
	 */
	public boolean drop(String name) {
		Item item = heldItems.get(name);

		if (item != null) {
			heldItems.remove(name);
			currentRoom.setItem(name, item);
			return true;
		}
		return false;
	}

	/**
	 * Check if the player can hold the item
	 * The item can be held if its weight plus the current weight being
	 * carried by the player does not violates the player's carry weight limit
	 * 
	 * @param item
	 * @return true if the player can hold the item, false otherwise
	 */
	private boolean canHoldItem(Item item) {
		if (item == null) return false;

		return item.getWeight() + getCurrentCarryWeight() <= carryWeightLimit;
	}
}
