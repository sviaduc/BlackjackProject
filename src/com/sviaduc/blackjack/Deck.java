package com.sviaduc.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	int numDelt = 2;
	private List<Card> card;

	public List<Card> getCard() {
		return card;
	}

	public void setCard(List<Card> card) {
		this.card = card;
	}

	public Deck() {
		super();
	}
	
	public void addCard(Card c) {
		if(card == null) {
			card = new ArrayList<Card>();
			card.add(c);
		}
		else {
			card.add(c);
		}
	}
	
	public Card dealCard(){
		
		return card.remove(0);
	}
	
	public void shuffleDeck(){
		Collections.shuffle(card);
	}
	
	public void cardsLeft(){
		
	}
}


