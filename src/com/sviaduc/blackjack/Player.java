package com.sviaduc.blackjack;

public class Player {
	String name;
	double wallet;
	Hand hand;
	
	

	public Player() {
		super();
		this.hand = new Hand();
	}

	public void placeWager() {
		int wager;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
}
