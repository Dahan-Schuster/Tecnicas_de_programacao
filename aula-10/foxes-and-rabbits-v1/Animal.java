import java.util.List;

public abstract class Animal {

	// Whether the animal is alive or not.
	protected boolean alive;
	// The animal's position.
	protected Location location;
	// The field occupied.
	protected Field field;

	/**
	 * Create a new animal at location in field.
	 * 
	 * @param field    The field currently occupied.
	 * @param location The location within the field.
	 */
	public Animal(Field field, Location location) {
		this.alive = true;
		this.field = field;
		setLocation(location);
	}

	abstract public void act(List<Animal> newAnimals);

	/**
	 * Indicate that the rabbit is no longer alive.
	 * It is removed from the field.
	 */
	public void setDead() {
		alive = false;
		if (location != null) {
			field.clear(location);
			location = null;
			field = null;
		}
	}

	/**
	 * Check whether the rabbit is alive or not.
	 * 
	 * @return true if the rabbit is still alive.
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * Return the rabbit's location.
	 * 
	 * @return The rabbit's location.
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Place the rabbit at the new location in the given field.
	 * 
	 * @param newLocation The rabbit's new location.
	 */
	protected void setLocation(Location newLocation) {
		if (location != null) {
			field.clear(location);
		}
		location = newLocation;
		field.place(this, newLocation);
	}
}
