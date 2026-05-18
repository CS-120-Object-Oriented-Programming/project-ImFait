package edu.kings;

/**
 * Item class, where all item information is stored.
 */
public class Item {
	/**
	 * Name of the item.
	 */	
	private String name; 
	/**
	 * Description of the item.
	 */
	private String description;
	/**
	 * Point value of the item.
	 */
	private int pts; 
	/**
	 * Weight of the item.
	 */
	private int weight;
	
	public Item(String newName, String newDescription, int newPts, int newWeight) {
		this.name = newName;
		this.description = newDescription;
		this.pts = newPts;
		this.weight = newWeight;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getPts() {
		return pts;
	}

	public void setPts(int pts) {
		this.pts = pts;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String toString() {
		
		String retVal =  name + ": " + description + ", worth: " + pts + " points, weighs: " + weight + "lbs.";
		return retVal;
	}
	
	
	
}
