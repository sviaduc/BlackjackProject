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
	public Card(Suit suit, Rank rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Card [suit=");
		builder.append(suit);
		builder.append(", rank=");
		builder.append(rank);
		builder.append("]");
		return builder.toString();
	}
	

	
	
	
	
}