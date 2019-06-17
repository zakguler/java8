package com.blackjack;

public class RunVBlackjack {

	public static void main(String[] args) {
		
		int numberOfDecks = 1; // multiple desks
		int numberOfPlayers = 1; // for now, use only one player
		
		Game game = new Game(numberOfDecks, numberOfPlayers);

		game.startTheGame();
	}
}
