/**
 * Author: Brandon Rosado
 */
package edu.kings;


public class Player {
	
 /** 
  * this is the players current location. 
  */
private Room location;
	
public Player(Room local) { // constructor
		location = local;
	}
	
public Room getLocation() { // getter
	return location;
}

public void setLocation( Room newRoom) { // setter
	location = newRoom;
}

}