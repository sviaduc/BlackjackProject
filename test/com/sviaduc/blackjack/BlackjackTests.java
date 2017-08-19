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

    @Before
    public void setUp() throws Exception {
        p = new Player();
        deck = new Deck();

        for (Suit s : Suit.values()) { // iterates through Suit enums
            for (Rank r : Rank.values()) { // gives values to cards
                Card c = new Card(s, r); // calls Card constructor to create Card obj
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
    public void test_deal_p_a_card_and_it_should_get_removed() {
        assertEquals(52, deck.getCard().size());
        assertNull(p.getHand().getCards()); // null because there are no cards in the hand
        p.getHand().addCard(deck.dealCard());
        assertEquals(51, deck.getCard().size());
        assertNotNull(p.getHand().getCards()); //
    }
    
//    @Test
//    public void test() {
//        p.getHand().addCard(new Card(Rank.ACE, Suit.CLUBS));
//        p.getHand().addCard(new Card(Rank.ACE, Suit.CLUBS));
//        p.getHand().addCard(new Card(Rank.TEN, Suit.CLUBS));
//        p.getHand().addCard(new Card(Rank.FIVE, Suit.CLUBS));
//        
//        GameApp app = new GameApp();
//        int i = app.checkForAces(p);
//        
//        assertEquals(17, i);
//    }

}
