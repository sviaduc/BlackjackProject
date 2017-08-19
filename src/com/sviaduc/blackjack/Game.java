package com.sviaduc.blackjack;

public class Game {
	Player player =new Player();

	public static void main(String[] args) {
		Game game = new Game();
		game.run();
	}
	public void run() {
		Deck deck = initializeDeck();
//		for (Card c: deck.getCard()) {
//			System.out.println(c.getRank() + " of " + c.getSuit() + " " + c.getRank().getValue());
//		}
		player.getHand().addCard(deck.dealCard());
		player.getHand().addCard(deck.dealCard());
		System.out.println(deck.getCard().size());
		int playerHandValue = 0;
		for (Card c : player.getHand().getCards()) {
		System.out.println(c);	
		playerHandValue = playerHandValue + c.getRank().getValue();
		
		}
		System.out.println("Players Hand: " + playerHandValue);
	}
	public Deck initializeDeck() {
		Deck deck = new Deck();
		
		for(Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				Card c = new Card(s,r);
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
