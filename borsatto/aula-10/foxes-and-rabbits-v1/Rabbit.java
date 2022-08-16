import java.util.List;
import java.util.Random;

/**
 * A simple model of a rabbit.
 * Rabbits age, move, breed, and die.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class Rabbit extends Animal
{
    // Characteristics shared by all rabbits (static fields).

    // The age at which a rabbit can start to breed.
    private static final int BREEDING_AGE = 5;
    // The age to which a rabbit can live.
    private static final int MAX_AGE = 40;
    // The likelihood of a rabbit breeding.
    private static final double BREEDING_PROBABILITY = 0.15;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 4;
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();

    /**
     * Create a new rabbit. A rabbit may be created with age
     * zero (a new born) or with a random age.
     * 
     * @param randomAge If true, the rabbit will have a random age.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Rabbit(boolean randomAge, Field field, Location location)
    {
		super(field, location);
        setAge(0);
        if(randomAge) {
            setAge(rand.nextInt(MAX_AGE));
        }
    }
    
    /**
     * This is what the rabbit does most of the time - it runs 
     * around. Sometimes it will breed or die of old age.
     * @param newRabbits A list to add newly born rabbits to.
     */
	@Override
    public void act(List<Actor> newRabbits)
    {
        incrementAge();
        if(isActive()) {
            giveBirth(newRabbits);            
            // Try to move into a free location.
            Location newLocation = getField().freeAdjacentLocation(getLocation());
            if(newLocation != null) {
                setLocation(newLocation);
            }
            else {
                // Overcrowding.
                setDead();
            }
        }
    }
    
	/** @return a newborn rabbit with age 0 */
	@Override
	protected Animal getNewYoung(Location loc) {
		return new Rabbit(false, getField(), loc);
	}

	/** @return número máximo de proles que um coelho pode gerar por vez */
	@Override
	protected int getMaxLitterSize() {
		return MAX_LITTER_SIZE;
	}

	/** @return a probabilidade de um coelho procriar */
	@Override
	protected double getBreedingProbability() {
		return BREEDING_PROBABILITY;
	}

	/** @return a idade que um coelho começa a procriar */
	@Override
	protected int getBreedingAge() {
		return BREEDING_AGE;
	}

	/** @return a idade máxima que um coelho pode alcançar */
	@Override
	protected int getMaxAge() {
		return MAX_AGE;
	}
}
