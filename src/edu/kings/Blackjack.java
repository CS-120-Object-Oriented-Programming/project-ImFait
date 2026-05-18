package edu.kings;

import java.util.Random;

public class Blackjack {
	/**Random value.*/
	private static Random rand = new Random();
	/** To check who won.*/
	private static int winCheck;
	
	public static void play() {
		/** card total.*/
		int total = 0;
		int dealerTotal = 0;
		int cardCount = 0;
		// dealers first card
		int dFirst = rand.nextInt(2,11);
		Writer.println("Type start to start: ");
		Command command = Reader.getCommand();
		
		dealerTotal += dFirst;
	
		//getting the suit (mostly cosmetic)
		int suit;
		suit = rand.nextInt(1 , 4);
		String suitString = suit(suit);
	
		Writer.println("The dealer draws " + dFirst + " of " + suitString + "s");
	
		// players cards
		while (total < 21 && !(command.getCommandWord() == CommandEnum.STAND) ) {
		
			int card = rand.nextInt(2, 11);
			cardCount += 1;
			
			if (card == 11) {
				if (card + total > 21) { card = 1; } 
			}
			
			total += card;
		
			suit = rand.nextInt(1 , 4);
			suitString = suit(suit);
	
			Writer.println("you draw " + card + " of " + suitString + "s");
			while (cardCount >= 2) {
				if (total == 21) {
					Writer.println("YOU GOT BLACKJACK!");
					break;
				} else if (total < 21) {
					Writer.println("Your total so far is " + total + " would you like to hit or stand?");
					command = Reader.getCommand();
					if (command.getCommandWord() == CommandEnum.HIT) {
						break;
					} else if (command.getCommandWord() == CommandEnum.STAND) {
						break;
					}
					
				} else if (total > 21) {
					Writer.println("Your total is " + total + ". You bust...");
					break;
				}
				
			}
		}
		
		dealersTurn(dealerTotal);
		if (total > 21) {Writer.println("You LOSE!");} 
		else if (winCheck > total && winCheck <= 21) { Writer.println("You LOSE!");}
		else if (winCheck < total) { Writer.println("You WIN!");}
		else if (winCheck > 21) { Writer.println("dealer busts... You WIN");}
		else if (winCheck == total) { Writer.println("DRAW!");} 
		else {Writer.println("ERROR!!");}
	}
	
	public static void dealersTurn(int total) {
		boolean dealerStand = false;
		
		while(!dealerStand && total <= 21) {
		
		//suit again
		int suit;
		suit = rand.nextInt(1 , 4);
		String suitString = suit(suit);
		
		int dCard = rand.nextInt(2 , 11);
		
		if (dCard == 11) {
			if (dCard + total > 21) { dCard = 1; } 
		}
		
		total += dCard;
		Writer.println("The dealer draws " + dCard + " of " + suitString + "s" + "\n" + "The dealers total is now " + total);
		
		if (total > 16 && total <= 21) {
			Writer.println("The dealer stands");
			dealerStand = true;
		} else { dealerStand = false; }
		
		}
		
		winCheck = total;
	
	}
	
	
	public static String suit(int suit) {
		String retVal;
		if (suit == 1) { retVal = "club";} 
		else if (suit == 2) { retVal = "heart"; } 
		else if (suit == 3) { retVal = "diamond"; } 
		else { retVal = "spade"; }
		return retVal;
	}
		
	}