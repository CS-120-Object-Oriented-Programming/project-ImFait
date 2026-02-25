/**
 * Author: Brandon Rosado
 */
package edu.kings;

/**
 * 
 */
public class Player {
	String location;

	
public Player(String room) { // constructor
		location = room;
	}
	
public String getLocation() { // getter
	return location;
}

public void setLocation(String newLocation) { // setter
	this.location = newLocation;
}

public static void main(String[] args) {
		Player obj = new Player("center of campus");
		
	}
}