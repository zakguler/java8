package com.blackjack;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
	
	Scanner sc = new Scanner(System.in);
	String input;
	
	boolean continuePlaying = true;
	int numberOfDecks = 1; // default one deck
	int numberOfPlayers = 1; // default one player
	boolean shuffleDeck = true; // default to shuffle the cards
	
	Deck deck;	
	Dealer dealer;	
	Player player;
	
	boolean playerBust;
	boolean dealerBust;
	boolean gameOver;
	boolean stay;
	
	
	public Game(int numberOfDecks, int numberOfPlayers){
		// you can add here validations to limit the number of decks or the number of players
		this.numberOfDecks = numberOfDecks;
		this.numberOfPlayers = numberOfPlayers;
	}
	
	
	public void startTheGame(){		
		initializeGame();
		
		while(continuePlaying) {
			continuePlaying = play();
		}
		
		System.out.println("*** GOOD BYE ***");
	}
	
	
	
	public boolean play() {
		System.out.println("---------------------------------");
		System.out.println("----New game ...\n");

		// start new game
		dealer.clearHand();
		player.clearHand();
		playerBust = false;
		dealerBust = false;
		gameOver = false;
		stay = false;
		input = "";
		
		drawInitialCards(); // two cards each for the dealer and the player
		
		// player's turn
		playersTurn();
		
		// dealer's turn
		if ( ! ( playerBust || gameOver) ) {
			dealersTurn();
		}
		
		// end of the game
		printGameSummary(dealer, player);
		
		// check if the player wants to continue playing
		boolean userInput = false;
		do {
			System.out.println("\n\nWould you like to continue: y/yes or n/no");
			input = (sc.next()).toLowerCase();
			userInput = validContinueInput(input);
		}while(!userInput);
				
		return (input.equalsIgnoreCase("y") ? true : false);
	}

	
	
	public void playersTurn() {
		System.out.println("\n***Player's turn... ");		
		while( ! (gameOver || playerBust || stay) ) { // insurance to force terminate

			boolean userInput = false;
			do {
				System.out.println("\n----\nDo you want to draws: h(Hit) or s(Stay) or e/Exit");
				input = (sc.next()).toLowerCase();
				userInput = validHitStayInput(input);
			}while(!userInput);
			
			if (input.equalsIgnoreCase("h") || input.equalsIgnoreCase("hit")){
				
				dealer.printHand();
				System.out.println(" ");
				drawCardFromTheDeck(deck, player);
				
				if (player.getOnHandValue() > 21) {
					if (dealer.getOnHandValue() == 21 && dealer.getNumberOfCardsOnHand()==2) {
						dealer.addPoint(2);
					} else {
						dealer.addPoint(1);
					}
					player.printOnHandValue();
					player.printHand();
					System.out.println(" ");
					System.out.println("Player: " + player.getOnHandValue());
					System.out.println("\nPlayer busts... loses the game");
					playerBust = true;
					break;
				}
				
				player.printHand();
				player.printOnHandValue();
				
			}else  
				if (input.equalsIgnoreCase("s") || input.equalsIgnoreCase("stay")){
					stay = true;
					break;
				}else {
					if (input.equalsIgnoreCase("e") || input.equalsIgnoreCase("exit")){
						gameOver = true;
						break;
					}

				}
		}
	}

	
	
	public void dealersTurn() {
		System.out.println("\n***Dealer's turn... \n");
		System.out.println("Show dealer's cards...");
		dealer.turnShowCardOn();
		dealer.printHand();
		dealer.printOnHandValue();
		System.out.println(" ");
		
		while(  ! ( dealerBust || gameOver ) ) { // insurance to force terminate
			
			if (dealer.getOnHandValue()==21) {
				if (dealer.getNumberOfCardsOnHand() == 2) {
					
					if (player.getOnHandValue()==21) {
						if (player.getNumberOfCardsOnHand() == 2) {
							// both dealer and player have [blackjack]
							dealer.addPoint(1);
							player.addPoint(1);
							System.out.println("Dealer: " + dealer.getOnHandValue() + " -- Player: " + player.getOnHandValue());
							System.out.println("\nDealer and Player have [blackjack].");
							gameOver = true;
							break;
						}
					}
					else {
						// dealer has blackjack
						// player must have less than the dealer
						dealer.addPoint(2);
						System.out.println("Dealer: " + dealer.getOnHandValue() + " -- Player: " + player.getOnHandValue());
						System.out.println("\nDealer wins... has [blackjack].");
						gameOver = true;
						break;
					}
				}
				else {
					// dealer has 21, but not blackjack
					if (dealer.getOnHandValue() > player.getOnHandValue()) {
						dealer.addPoint(1);
						System.out.println("Dealer: " + dealer.getOnHandValue() + " -- Player: " + player.getOnHandValue());
						System.out.println("\nDealer wins.");
						gameOver = true;
						break;
					}
					else {							
						// it is a tie, both have 21
						System.out.println("Dealer: " + dealer.getOnHandValue() + " -- Player: " + player.getOnHandValue());
						System.out.println("\nIt's a tie... ");
						gameOver = true;
						break;
					}
				}
			}
			
			// at this stage, dealer won't have a blackjack
			if (player.getOnHandValue()==21 && player.getNumberOfCardsOnHand() == 2) {
				player.addPoint(2);
				System.out.println("\nPlayer wins.");
				gameOver = true;
				break;
			}
			
			if (dealer.getOnHandValue() > 21) {
				System.out.println("Dealer: " + dealer.getOnHandValue() + " -- Player: " + player.getOnHandValue());
				System.out.println("\nDealer busts... player wins the game");
				player.addPoint(1);
				dealerBust = true;
				break;
			}
			
			
			if (dealer.getOnHandValue() > 16 && dealer.getOnHandValue() < 22) {	
				
				if (dealer.getOnHandValue() == player.getOnHandValue()) {
					System.out.println("Dealer: " + dealer.getOnHandValue() + " -- Player: " + player.getOnHandValue());
					System.out.println("\nIt's a tie... ");
					gameOver = true;
					break;
				}

				if (dealer.getOnHandValue() > player.getOnHandValue()) {
					System.out.println("Dealer: " + dealer.getOnHandValue() + " -- Player: " + player.getOnHandValue());
					System.out.println("\nDealer wins... ");
					dealer.addPoint(1);
					gameOver = true;
					break;
					
				} else {
					System.out.println("Dealer: " + dealer.getOnHandValue() + " -- Player: " + player.getOnHandValue());
					System.out.println("\nPlayer wins... ");
					player.addPoint(1);
					gameOver = true;
					break;
				}					
			}

			System.out.println("\nDealer draws a card...");
			drawCardFromTheDeck(deck, dealer);
			dealer.printHand();
			dealer.printOnHandValue();

		}
	}
	
	
	
	public void drawInitialCards() {
		// Dealer: first card face down, second is face up
		dealer.drawCard(deck, false);
		dealer.drawCard(deck, true);
		dealer.printHand();

		System.out.println("----");
		// Player: both cards face up
		player.drawCard(deck);
		player.drawCard(deck);
		player.printHand();
		player.printOnHandValue();
	}
	
	
	
	public void drawCardFromTheDeck(Deck deck, Person person) {
		if (deck.getCardsCount() < 1) {
			deck = new Deck(numberOfDecks, shuffleDeck); // rebuilding the deck
			System.out.println("No more cards to draw from... ReSuffling...");
		}
		person.drawCard(deck);
		System.out.println(" ");
	}
	

	public boolean validContinueInput(String input) {
		return ( Arrays.asList("y", "n")
				.contains(input));
	}

	public boolean validHitStayInput(String input) {
		return ( Arrays.asList("h", "hit", "s","stay", "e", "exit")
				.contains(input));
	}
//	public boolean validHitStayInput(String input) {
//		return ( Stream.of("h", "hit", "s","stay", "e", "exit")
//		.anyMatch(x -> x.equalsIgnoreCase(input)) );
//	}
//	
	
	
	public void printGameSummary(Dealer dealer, Player player) {
		System.out.println("\n\n----");
		System.out.println("Game summary..");
		
		dealer.printOnHandValue();
		dealer.printTotalPoints();		
		dealer.printHand();
		
		System.out.println(" ");
		
		player.printOnHandValue();
		player.printTotalPoints();
		player.printHand();
	}
	
	public void initializeGame(){
		deck = new Deck(numberOfDecks, shuffleDeck);
		playerBust = false;
		dealerBust = false;
		gameOver = false;
		stay = false;
		input = "";
		// future implementation for multi palyers option
		// LinkedList<Person> players = new LinkedList<>();
		player = new Player();
		dealer = new Dealer();
		continuePlaying = true;
	}

	
}
