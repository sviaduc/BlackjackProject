package com.sviaduc.blackjack;
import java.util.Scanner;

public class Game {
	Player player =new Player();
	Dealer dealer = new Dealer();

	public static void main(String[] args) {
		Game game = new Game();
		game.run();
	}
	public void run() {
		Deck deck = initializeDeck();
		playerTurn(deck);
	
		}
	
	private void playerTurn(Deck deck) {
		player.getHand().addCard(deck.dealCard());
		player.getHand().addCard(deck.dealCard());
		System.out.println("Card counter: " + deck.getCard().size());
		int playerHandValue = 0;
		for (Card c : player.getHand().getCards()) {
		System.out.println(c);	
		playerHandValue = playerHandValue + c.getRank().getValue();
		
		}
		System.out.println("Player's Hand: " + playerHandValue);
		
		if(playerHandValue == 21) {
			System.out.println("Blackjack!!");
			dealerTurn(deck);
		}
		
		while(playerHandValue < 21){
		Scanner kb = new Scanner(System.in);
		System.out.println("Do you want to: ");
		System.out.println("(1)Hit");
		System.out.println("(2)Stand");
		int choice = kb.nextInt();
		
		switch(choice) {
		case 1:
		player.getHand().addCard(deck.dealCard());
		System.out.println("Card counter: " + deck.getCard().size());
		int playerHandValue1 = 0;
		for (Card c : player.getHand().getCards()) {
		System.out.println(c);	
		playerHandValue1 = playerHandValue1 + c.getRank().getValue();
		playerHandValue = playerHandValue + playerHandValue1;
		System.out.println(playerHandValue);
		}
			break;
		case 2:
			dealerTurn(deck);
			break;
			
		}
		
		}
		if(playerHandValue > 21) {
			System.out.println("You Busted!");
		}
		
	}	
		
	private void dealerTurn(Deck deck) {
		System.out.println("*********Dealers Hand*********");
		dealer.getHand().addCard(deck.dealCard());
		dealer.getHand().addCard(deck.dealCard());
		System.out.println("Card counter: " + deck.getCard().size());
		int dealerHandValue = 0;
		for (Card c : dealer.getHand().getCards()) {
			System.out.println(c);	
			dealerHandValue = dealerHandValue + c.getRank().getValue();
			
		}
		System.out.println("Dealer's Hand: " + dealerHandValue);
		//if dealers hand is under 17, dealer will draw card
		while(dealerHandValue <= 16) {
			dealerHandValue = 0;
			dealer.getHand().addCard(deck.dealCard());
			System.out.println("Card counter: " + deck.getCard().size());
			for (Card c : dealer.getHand().getCards()) {
				System.out.println(c);	
				dealerHandValue = dealerHandValue + c.getRank().getValue();
			}
			System.out.println("Dealer's Hand: " + dealerHandValue);
		}
		
	}

	public Deck initializeDeck() {
		Deck deck = new Deck();
		
		for (Rank r : Rank.values()) {
			for(Suit s : Suit.values()) {
				Card c = new Card(r,s);
				deck.addCard(c);
			}
		}
		deck.shuffleDeck();
		return deck;
	}
	
//	public int checkForAces(Player player) {
//		
//		
//		int playerValue = 0;
//		
//		for (Card c : player.getHand().getCards()) {
//		    playerValue = playerValue + c.getRank().getValue();
//		    
//		}
//		
//		System.out.println(playerValue);
//		for (Card c : player.getHand().getCards()) {
//		    if (playerValue > 21 && c.getRank().equals(Rank.ACE)) {
//		        playerValue = playerValue - 10;
//		    }
//		}
//		
//		return playerValue;
//		}

}
