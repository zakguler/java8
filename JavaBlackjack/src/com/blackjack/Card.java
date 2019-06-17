package com.blackjack;

import java.util.LinkedList;

public class Card {
	
	private Suit cardSuit;
	private CardNumber cardNumber;
	private boolean showCard;
	
	/**
	 * 
	 * @param cardSuit
	 * @param cardNumber
	 */
	public Card (Suit cardSuit, CardNumber cardNumber){
		this.cardSuit = cardSuit;
		this.cardNumber = cardNumber;
		this.showCard = true;
	}
	
	/**
	 * 
	 * @param cardSuit
	 * @param cardNumber
	 * @param showCard
	 */
	public Card (Suit cardSuit, CardNumber cardNumber, boolean showCard){
		this.cardSuit = cardSuit;
		this.cardNumber = cardNumber;
		this.showCard = showCard;
	}
	
	public Suit getCardSuit() {
		return cardSuit;
	}
	
	public CardNumber getCardNumber() {
		return cardNumber;
	}

	public boolean isShowCard() {
		return showCard;
	}

	public void setShowCard(boolean showCard) {
		this.showCard = showCard;
	}

	@Override
	public String toString() {
		return cardNumber.name() + " of " + cardSuit.name();
	}
		
}
