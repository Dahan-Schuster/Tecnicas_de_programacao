import java.util.List;
import java.util.Random;

public abstract class Animal {

	// The animals's gge
    private int age;
	// Whether the animal is alive or not.
	private boolean alive;
	// The animal's position.
	private Location location;
	// The field occupied.
	private Field field;
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();

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
	 * Define a idade do animal
	 * @param age
	 */
	protected void setAge(int age) {
		this.age = age;
	}

	/**
     * Increase the age. This could result in the animal's death.
     */
    protected void incrementAge()
    {
        age++;
        if(age > getMaxAge()) {
            setDead();
        }
    }

	/** @return O campo em que o animal se encontra */
	public Field getField() {
		return field;
	}

	/**
	 * Indicate that the animal is no longer alive.
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
	 * Return the animal's location.
	 * 
	 * @return The animal's location.
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
	
	/**
     * Check whether or not this animal is to give birth at this step.
     * New births will be made into free adjacent locations.
     * @param newAnimals A list to add newly born animals to.
     */
    protected void giveBirth(List<Animal> newAnimals)
    {
        // New animals are born into adjacent locations.
        // Get a list of adjacent free locations.
        List<Location> free = getField().getFreeAdjacentLocations(getLocation());
        int births = breed();
        for(int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Animal young = getNewYoung(loc);
            newAnimals.add(young);
        }
    }
        
    /**
     * Generate a number representing the number of births,
     * if it can breed.
     * @return The number of births (may be zero).
     */
    protected int breed()
    {
        int births = 0;
        if(canBreed() && rand.nextDouble() <= getBreedingProbability()) {
            births = rand.nextInt(getMaxLitterSize()) + 1;
        }
        return births;
    }

	/**
	 * An animal can breed if it has reached the breeding age.
	 */
	protected boolean canBreed() {
		return age >= getBreedingAge();
	}

	/** @return a newborn animal with age 0 */
	abstract protected Animal getNewYoung(Location loc);

	/** @return número máximo de proles que um animal pode gerar por vez */
	abstract protected int getMaxLitterSize();

	/** @return a probabilidade de um animal procriar */
	abstract protected double getBreedingProbability();

	/** @return a idade que um animal começa a procriar */
	abstract protected int getBreedingAge();

	/** @return A idade máxima que o animal pode atingit */
	abstract protected int getMaxAge();
}
