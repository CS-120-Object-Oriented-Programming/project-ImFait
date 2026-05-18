package edu.kings;
import java.util.HashMap;

/**
 * This class represents the entire world that makes up the "Campus of Kings"
 * application. "Campus of Kings" is a very simple, text based adventure game.
 * Users can walk around some scenery. That's all. It should really be extended
 * to make it more interesting!
 *
 * This world class creates the world where the game takes place.
 *
 * @author Maria Jump
 * @version 2015.02.01
 *
 * Used with permission from Dr. Maria Jump at Northeastern University
 */
public class World {
	/** The rooms in the world. */
	private HashMap<String, Room> rooms;

	/**
	 * Constructor for the world.
	 */
	public World() {
		rooms = new HashMap<String, Room>();
		createRooms();
		
	}

	
	
	/**
	 * This method takes care of creating all of the aspects of the world for
	 * the "Campus of Kings" application.
	 *
	 * @param name
	 *            The provided name of the room.
	 * @return The room associated with the provided name
	 */
	public Room getRoom(String name) {
		return rooms.get(name.toLowerCase());
	}

	/////////////////////////////////////////////////////////////////////////////////////
	// Start of private helper methods

	/**
	 * Helper method for recreating a Room. Ensure that the room is created and
	 * installed in to the collection of Rooms
	 *
	 * @param theRoom
	 *            The room to add to the world.
	 */
	private void addRoom(Room theRoom) {
		rooms.put(theRoom.getName().toLowerCase(), theRoom);
	}

	/**
	 * Helper method for creating doors between rooms.
	 *
	 * @param from
	 *            The room where the door originates.
	 * @param direction
	 *            The direction (duh).
	 * @param to
	 * 			  Where to.
	 */
	private void createDoor(Room from, String direction, Room to) {
		Door newDoor = new Door(to);
		rooms.get(from.getName().toLowerCase()).allDoors.put(direction, newDoor);
		
	}
	
	private void createRooms() {
		// item creation (i couldnt figure out the function so this is my improv)
		Item cracker = new Item("crackers" , "small bag of saltines, honestly not bad for this place." , 1 , 0);
		Item bottle = new Item("bottle", "empty bottle.. thats literally it", 0, 1);
		Item cigarette = new Item("cigarette", "cheap cigarette on the house, least they can do for taking your money", 0, 0);
		
		
		// Template: Room placeholder = new Room("" , "" , null);
		//casino rooms
		Room entrance = new Room("Entrance" , "old rundown looking entrance, there is a large half lit neon sign that says 'The Lemon Pit casino!'" , null);
		Room lobby = new Room("lobby" , "in the lobby there is a exchange desk... though they stopped using chips years ago" , cigarette);
		Room slots = new Room("slots" , "multiple rows of old slot machines, some not working, it feels like they go as far as the eye can see..." , null);
		Room bathroom = new Room("bathroom" , "mens and womens bathrooms, looks gross" , null);
		Room cafeteria = new Room("cafeteria" , "a small cafeteria with the worst food you have had the misfortune of tasting." , cracker);
		Room tables = new Room("tables" , "a bunch of tables with all different kinds of card games... type play for blackjack", null);
		Room bar = new Room("bar" , "a small wooden bar with more people than any room of the casino.. \nhas the smell of cheap booze and dead dreams" , bottle);
		Room roulette = new Room("roulette" , "a big roulette table.. you feel an urge to go all in on red..." , null);
		
		// new room stuff
		this.addRoom(entrance);
		this.addRoom(lobby);
		this.addRoom(slots);
		this.addRoom(bathroom);
		this.addRoom(cafeteria);
		this.addRoom(tables);
		this.addRoom(bar);
		this.addRoom(roulette);
		
		//doors for casino
		this.createDoor(entrance, "north", lobby);
		this.createDoor(lobby, "south", entrance);
		
		this.createDoor(lobby, "north", slots);
		this.createDoor(slots, "south", lobby);
		
		this.createDoor(slots, "west", bathroom);
		this.createDoor(bathroom, "east", slots);
		
		this.createDoor(slots, "east", cafeteria);
		this.createDoor(cafeteria, "west", slots);
		
		this.createDoor(slots, "north", tables);
		this.createDoor(tables, "south", slots);
		
		this.createDoor(bar, "west", tables);
		this.createDoor(tables, "east", bar);
		
		this.createDoor(tables, "west", roulette);
		this.createDoor(roulette, "east", tables);
		
		this.createDoor(bathroom, "north", roulette);
		this.createDoor(roulette, "south", bathroom);
		
		this.createDoor(bar, "south", cafeteria);
		this.createDoor(cafeteria, "north", bar);
		
	}
}
