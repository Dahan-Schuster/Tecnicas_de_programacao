/**
 * Item class
 * Holds the logic for each item inside the rooms
 * 
 * @author Dahan Schuster
 * @version 2022-05-06
 */
public class Item {
	private String description;
	private double weight;

	public Item(String desc, double wght) {
		description = desc;
		weight = wght;
	}

	public String getDescription() {
		return description;
	}

	public double getWeight() {
		return weight;
	}
}
