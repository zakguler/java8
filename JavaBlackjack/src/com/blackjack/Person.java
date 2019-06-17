package com.blackjack;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * this object can be a Dealer or a Player
 * @author 
 *
 */
public abstract class Person {

	public LinkedList<Card>  cards = new LinkedList<>();
	private int totalPoints = 0;	

	Person(){	
		super();
	}
	
	
	public abstract void printOnHandValue();
	public abstract void printTotalPoints();
	public abstract void printHand();	
	
	public void clearTotals() {
		this.totalPoints = 0;
//		this.totalAces = 0;
	}

	public void clearHand() {
		cards.clear();
	}
	public void addPoint(int point) {
		totalPoints = totalPoints + point;
	}
	
	public void drawCard(Deck deck) {
		drawCard(deck, true);
	}
	
	public void drawCard(Deck deck, boolean showCard) {
		Card card = deck.removeCard();
		card.setShowCard(showCard);
		cards.add(card);
//		System.out.println("Card drawn: " + card.toString());
	}
	
	public int getOnHandValue() {
		return CommonUtil.getCardValue(cards);		
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public int getNumberOfCardsOnHand() {
		return cards.size();
	}
	


}
