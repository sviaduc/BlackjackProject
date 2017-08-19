package com.sviaduc.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	
	List<Card> cards;
	
	
	
	public void addCard(Card c) {
		if(cards == null) {
			cards = new ArrayList<>();
			cards.add(c);
		}
		else {
			cards.add(c);
		}
	}



	public List<Card> getCards() {
		return cards;
	}



	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	
}
