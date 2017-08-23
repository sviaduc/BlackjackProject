package com.sviaduc.blackjack;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BlackjackTests {
	Deck deck;
    Player p;
    Dealer d;

    @Before
    public void setUp() throws Exception {
        p = new Player();
        deck = new Deck();

        for (Suit s : Suit.values()) { // iterates through Suit enums
            for (Rank r : Rank.values()) { // gives values to cards
                Card c = new Card(r, s); // calls Card constructor to create Card obj
                deck.addCard(c); // add newly created cards to deck
            }
        }
        deck.shuffleDeck();
    }

    @After
    public void tearDown() throws Exception {
        p = null;
        deck = null;
    }

    @Test
    public void test_deal_player_a_card_and_it_should_get_removed() {
        assertEquals(52, deck.getCard().size());
        assertNull(p.getHand().getCards()); // null because there are no cards in the hand
        p.getHand().addCard(deck.dealCard());
        assertEquals(51, deck.getCard().size());
        assertNotNull(p.getHand().getCards()); //
    }
    
//    @Test
//    public int test_player_check_for_aces() {
//        p.getHand().addCard(new Card(Rank.ACE, Suit.CLUBS));
//        //p.getHand().addCard(new Card(Rank.ACE, Suit.CLUBS));
//        p.getHand().addCard(new Card(Rank.TEN, Suit.CLUBS));
//        p.getHand().addCard(new Card(Rank.FIVE, Suit.CLUBS));
//        
//        Game app = new Game();
//        int i = app.playerTurn(deck);
//        
//        assertEquals(16, i);
//    }
//    
//    @Test
//    public void test_dealer_check_for_aces() {
//    	d.getHand().addCard(new Card(Rank.ACE, Suit.CLUBS));
//    //	d.getHand().addCard(new Card(Rank.ACE, Suit.CLUBS));
//    	d.getHand().addCard(new Card(Rank.TEN, Suit.CLUBS));
//    //	d.getHand().addCard(new Card(Rank.FIVE, Suit.CLUBS));
//    	
//    	Game app = new Game();
//    	int i = app.dealerTurn(deck, d.getHand().getCards().get(0) && d.getHand().getCards().get(1));
//    	
//    	assertEquals(17, i);
//    }

}
