import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.LinkedList;

/**
 * Provide a simple demonstration of running a stage-one
 * scenario. A single passenger is created, and a pickup
 * requested. As the simulation is run, the passenger
 * should be picked up and then taken to their destination.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class Demo
{
    private List<Actor> actors;

    /**
     * Constructor for objects of class Demo
     */
    public Demo()
    {
        actors = new LinkedList<Actor>();
        reset();
    }
    
    /**
     * Run the demo for a fixed number of steps.
     */
    public void run()
    {
        for(int step = 0; step < 100; step++) {
            step();
        }
    }

    /**
     * Run the demo for one step by requesting
     * all actors to act.
     */
    public void step()
    {
        for(Actor actor : actors) {
            actor.act();
        }
    }
    
    /**
     * Reset the demo to a starting point.
     * A single taxi is created, and a pickup is
     * requested for a single passenger.
     * @throws IllegalStateException If a pickup cannot be found
     */
    public void reset()
    {
        actors.clear();
        TaxiCompany company = new TaxiCompany();
		List<Vehicle> vehicles = company.getVehicles();

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Taxi taxi = new Taxi(company, new Location(i, j));
				vehicles.add(taxi);		
			}
		}

		System.out.println("\n\n"+vehicles.size()+" taxis created\n\n");

		actors.addAll(vehicles);

		Random rand = new Random(System.currentTimeMillis());

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Passenger passenger = new Passenger(new Location(rand.nextInt(20), rand.nextInt(20)),
													new Location(rand.nextInt(40), rand.nextInt(40)));

				if(!company.requestPickup(passenger)) {
					throw new IllegalStateException("Failed to find a pickup.");
				}
			}
		}

		System.out.println("\n\n"+company.getAssignments().size()+" assignments\n\n");

    }
}
