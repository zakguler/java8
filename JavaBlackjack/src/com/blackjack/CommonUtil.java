package com.blackjack;

import java.util.LinkedList;

public class CommonUtil {

	/**
	 * Get Card Value
	 * @param cards
	 * @return
	 */
	public static int getCardValue(LinkedList<Card> cards) {
		int totalValue = 0;
		int numberOfAces = 0;
					
		for (Card card: cards) {
			
			switch(card.getCardNumber()) {
			
				case ACE: 
					numberOfAces++;
					totalValue += 11;
					break;
				
				case TWO: 
					totalValue += 2;
					break;

				case THREE: 
					totalValue += 3;
					break;

				case FOUR: 
					totalValue += 4;
					break;

				case FIVE: 
					totalValue += 5;
					break;

				case SIX: 
					totalValue += 6;
					break;

				case SEVEN: 
					totalValue += 7;
					break;

				case EIGHT: 
					totalValue += 8;
					break;

				case NINE: 
					totalValue += 9;
					break;

				case TEN: 
					totalValue += 10;
					break;

				case JACK: 
					totalValue += 10;
					break;

				case QUEEN: 
					totalValue += 10;
					break;

				case KING: 
					totalValue += 10;
					break;
				}

				while (totalValue > 21 && numberOfAces >= 1) {
					totalValue -= 10;
					numberOfAces--;
				}
				
		}
		
		return totalValue;
	}
}
