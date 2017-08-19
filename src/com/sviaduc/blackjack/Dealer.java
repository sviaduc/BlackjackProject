package com.sviaduc.blackjack;

public class Dealer {

	String name;
	Hand hand;
	
	

	public Dealer() {
		super();
		this.hand = new Hand();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
}
