package com.sviaduc.blackjack;


public class Card {
	private Suit suit;
	private Rank rank;
	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	public Card(Rank rank ,Suit suit) {
		super();
		this.suit = suit;
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Card: ");
		builder.append(rank);
		builder.append(" of ");
		builder.append(suit);
		return builder.toString();
	}
	

	
	
	
	
}