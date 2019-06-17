package com.blackjack;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Deck {
	
	private LinkedList<Card> cards = new LinkedList<>();

	/**
	 * constructor create a deck of cards
	 * shuffle it if shuffleDeck: true
	 * @param numberOfDecks
	 */
	public Deck(int numberOfDecks, boolean shuffleDeck) {
		// make sure the numberOfDecks is > 0	
		for (int indexDeck = 0; indexDeck < numberOfDecks; indexDeck++) {
			for (Suit suit: Suit.values()) {
				for (CardNumber cardNumber: CardNumber.values())
					cards.add(new Card(suit, cardNumber));
			}
		}
		
		if (shuffleDeck) {			
			Collections.shuffle(this.cards);
		}
	}

	public Card removeCard() {		
		return cards.pollFirst();
	} 
	
	public int getCardsCount() {
		return cards.size();
	}
	
	public void printDeck() {
		AtomicInteger automicIndex = new AtomicInteger(1);
		cards.forEach( card -> {
			System.out.println(automicIndex.getAndIncrement() + "-" + card.getCardNumber() + " of" + card.getCardSuit() + "-"); 
		});	
	}
	
}
