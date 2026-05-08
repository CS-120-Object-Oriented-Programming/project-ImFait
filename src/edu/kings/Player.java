/**
 * Author: Brandon Rosado
 */
package edu.kings;
import java.util.ArrayList;


public class Player {
	
/** This is the players current location.*/
private Room location;
/** This is the players inventory.*/
private ArrayList<Item> inventory = new ArrayList<Item>();
/** Max carry weight.*/
private int maxWeight = 100;
/** current weight of inventory.*/
private int invWeight;
/** Player balance.*/
private int bal;

public Player(Room local) { // constructor
		location = local;
	}

public int getBal() {
	return bal;
}

public Room getLocation() { // getter
	return location;
}

public int getMaxWeight() {
	return maxWeight;
}

public ArrayList getInventory() {
	return inventory;
}

public void pickUp(Item item) {
	if (invWeight + item.getWeight() <= maxWeight) {
		inventory.add(item);
		Writer.println(item.getName() + " has been picked up and added to inventory.");
		addWeight(item.getWeight());
		location.removeItem(item);
	} else { Writer.println( item.getName() + " weighs too much to pick up... try dropping some items.");}
	
}

public void dropItem(Item item) {
	inventory.remove(item);
	Writer.println(item.getName() + " has been dropped.");
	removeWeight(item.getWeight());
	
}

public void addWeight(int add) {
	invWeight += add;
}

public void removeWeight(int remove) {
	invWeight -= remove;
}

public void setLocation( Room newRoom) { // setter
	location = newRoom;
}

}