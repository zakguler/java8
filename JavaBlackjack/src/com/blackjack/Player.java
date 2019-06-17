package com.blackjack;

import java.util.concurrent.atomic.AtomicInteger;

public class Player extends Person{

	Player(){	
	}
	
	public void printHand() {
		AtomicInteger automicIndex = new AtomicInteger(1);
		cards.forEach( card -> {
			System.out.println("Player: Card(" + automicIndex.getAndIncrement() + ") -" + 
					(card.isShowCard() ? card.getCardNumber() + " of " + card.getCardSuit() : " [?]") ); 
		});	
	}

	
	public void printOnHandValue() {
		System.out.println("Player's hand value: " + getOnHandValue());		
	}

	public void printTotalPoints() {
		System.out.println("Player's totalPoints: " + getTotalPoints());
	}


	
}
