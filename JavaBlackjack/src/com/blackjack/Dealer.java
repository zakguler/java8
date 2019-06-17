package com.blackjack;

import java.util.concurrent.atomic.AtomicInteger;

public class Dealer extends Person {
	
	Dealer(){
		super();
	}


	/**
	 * Display each card.
	 * Dealer's first card is face down card.isShowCard()=false
	 */
	public void printHand() {
		AtomicInteger automicIndex = new AtomicInteger(1);
		cards.forEach( card -> {
			System.out.println("Dealer: Card(" + automicIndex.getAndIncrement() + ") - " + 
					(card.isShowCard() ? card.getCardNumber() + " of " + card.getCardSuit() : "[?]") ); 
		});	

	}
	

	public void printOnHandValue() {
		System.out.println("Dealer's hand value: " + getOnHandValue());		
	}

	public void printTotalPoints() {
		System.out.println("Dealer's totalPoints: " + getTotalPoints());
	}

	public void turnShowCardOn() {
		cards.get(0).setShowCard(true);
	}
	
}
