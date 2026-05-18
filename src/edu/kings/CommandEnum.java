package edu.kings;
/**
 * Enumerator of command words. 
 * @author Brandon Rosado
 */
public enum CommandEnum {
/** go.*/
GO("go"),
/** quit.*/
QUIT("quit"),
/** help.*/
HELP("help"),
/** look.*/
LOOK("look"),
/** search.*/
SEARCH("search"),
/** pick up.*/
TAKE("take"),
/** examine.*/
EXAMINE("examine"),
/** drop.*/
DROP("drop"),
/** Play.*/
PLAY("play"),
/** checking inventory.*/
INVENTORY("inventory"),
	
/** these are for Blackjack.java. 
 *  Hit.*/
	HIT("hit"),
	/** stand.*/
	STAND("stand");
	


	
	
	/**
	 * Command Word.
	 */
	private String command;
	
	private CommandEnum(String word) {
		this.command = word;
	}
	
	public String getCommand() {
		return command;
	}
	
}
