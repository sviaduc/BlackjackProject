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
		dealer.getHand().addCard(deck.dealCard());
		dealer.getHand().addCard(deck.dealCard());
		
		System.out.println("DECK COUNT: " + deck.getCard().size() + "\n");
		int playerHandValue = 0;
		int dealerHandValue = 0;
		for (Card p : player.getHand().getCards()) {
			System.out.println(p);	
			playerHandValue = playerHandValue + p.getRank().getValue();	
		}
		for( Card d : dealer.getHand().getCards()) {
			//System.out.println("Dealers " + d);
			dealerHandValue = dealerHandValue + d.getRank().getValue();
		}
		System.out.println("Player's Hand: " + playerHandValue + "\n");
		System.out.println("Dealers " + dealer.hand.getCards().get(0));
		
		
	
		if(playerHandValue == 21 && dealerHandValue < 21) {
			System.out.println("\n Blackjack!!");
			
		}
		else if(playerHandValue == 21 && dealerHandValue==21) {
			System.out.println("\n Dealer and Player push");
		}
		else if(dealerHandValue==21 && playerHandValue<21) {
			System.out.println("\n Dealer BlackJack");
		}
		else{
			boolean sLoop = true;
			while(playerHandValue < 21 && sLoop == true){
			Scanner kb = new Scanner(System.in);
			System.out.println("\n\n Do you want to: ");
			System.out.println("(1)Hit");
			System.out.println("(2)Stand");
			int choice = kb.nextInt();
			
				switch(choice) {
				case 1:
				player.getHand().addCard(deck.dealCard());
				System.out.println("DECK COUNT: " + deck.getCard().size() + "\n");
				int playerHandValue1 = 0;
					for (Card p : player.getHand().getCards()) {
					System.out.println(p);	
					playerHandValue1 = playerHandValue1 + p.getRank().getValue();
					if(p.getRank().equals(Rank.ACE)) {
						playerHandValue1 = playerHandValue1 - 10;
					} 
					
					System.out.println(playerHandValue1);
					playerHandValue = playerHandValue1;
						if(playerHandValue == 21) {
							dealerTurn(deck, dealerHandValue);
							kb.close();
							checkWin(dealerHandValue, playerHandValue);
						}
					}
					
					break;
				case 2:
					dealerHandValue = dealerTurn(deck, dealerHandValue);
					kb.close();
					checkWin(dealerHandValue, playerHandValue);
					sLoop = false;
					break;
					
				}
			}
		}
		if(playerHandValue > 21) {
			checkWin(dealerHandValue, playerHandValue);
		}
		
	}	
		
	
	private int dealerTurn(Deck deck, int dealerHandValue) {
		System.out.println("*********Dealers Hand*********");
		System.out.println("DECK COUNT: " + deck.getCard().size() + "\n");
		for (Card d : dealer.getHand().getCards()) {
			System.out.println(d);	
		}
		System.out.println("\n Dealer's Hand: " + dealerHandValue);

		while(dealerHandValue < 17 || (dealerHandValue == 17 && dealer.getHand().getCards().size() == 2 &&
				(dealer.getHand().getCards().get(0).getRank().equals(Rank.ACE) || dealer.getHand().getCards().get(1).getRank().equals(Rank.ACE)))) {
			dealerHandValue = 0;
			dealer.getHand().addCard(deck.dealCard());
			System.out.println("DECK COUNT: " + deck.getCard().size() + "\n");
			for (Card d : dealer.getHand().getCards()) {
				dealerHandValue = dealerHandValue + d.getRank().getValue();
				if(d.getRank().equals(Rank.ACE)) {
					dealerHandValue = dealerHandValue - 10;
				} 
				System.out.println(d);
			}
	
			System.out.println("\n Dealer's Hand: " + dealerHandValue);
			
		}
		return dealerHandValue;
	}

	private Boolean checkWin(int dealerHandValue, int playerHandValue) {
		
		if(dealerHandValue > 21 && playerHandValue <= 21) {
			System.out.println("\n Dealer busted!!");
		}
		else if(dealerHandValue <= 21 && playerHandValue>21) {
			System.out.println("\n Player Busted!!");
		}
		else if(dealerHandValue > playerHandValue) {
			System.out.println("\n Dealer wins!!");
		}
		else if(dealerHandValue < playerHandValue && playerHandValue <= 21) {
			System.out.println("\n Player Wins!!");
		}
		else if (dealerHandValue == playerHandValue){
			System.out.println("\n Push...");
		}
		return true;
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
	
	// break out into more methods
	//add more unit tests
	
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
