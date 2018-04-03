package pontoon;

/*
Hand Class - part of the Pontoon game
by Alex Kretzschmar

Hand represents a typical Hand of cards, independent of any specific
rules or constraints implied by a particular game. To be used as part
of a game this class should be extended.
**/

import java.util.ArrayList;

public class Hand {
    
    private final ArrayList<Card> hand; // Declares hand variable.
    
    public static void main(String[] args)
    {
        // Initialise a deck and shuffle it.
        Deck theDeck = new Deck();
        Deck.shuffle(theDeck);
        
        // Construct new Hand object and fill it with 2 cards.
        Hand testHand = new Hand();
        testHand.addCard(Deck.dealCard());
        testHand.addCard(Deck.dealCard());
        // Test print and therefore getCard.
        testHand.print();
        
        // Test all Hand methods in no particular order.
        testHand.addCard(Deck.dealCard());
        System.out.println("Hand size: " 
                            + testHand.getHandSize());
        testHand.printNewCard();
    }
    
   /**                                                               
    * Constructor - Hand() creates a new hand object of type
    * ArrayList<Card>. Empty when created.
    */
    public Hand ()
    {
        hand = new ArrayList<Card>();
    }
   
   /** 
    * Prints a Hand to console. Iterates for all cards in a hand. 
    */ 
    public void print()
    {
        for (int i = 0; i < getHandSize(); i++)
        {
            Card card = getCard(i);
            System.out.println("Card "+ (i+1) 
                + ": " + card.toString());
        }
    }
    
   /**
    * Adds a card to a hand.
    * 
    * @param card The Card to be added to the hand (usually dealt from
    * a deck).
    */ 
    public void addCard(Card card) 
    {
        hand.add(card);
    }
    
   /**
    * Queries the hand for it's size. Makes use of the built-in ArrayList
    * size functionality.
    * 
    * @return Integer value of size of the hand.
    */ 
    public int getHandSize() 
    {
      return hand.size();
    }
    
   /**
    * Get the details of a card in the specified position within the hand.
    * Most useful when used as part of a for loop.
    * 
    * @param i Position of the card requested within the ArrayList.
    * @return The requested Card object.
    */ 
    public Card getCard(int i) 
    {
        return (Card)hand.get(i);
    }
    
   /**
    * Prints the last card added to the Hand.
    */ 
    public void printNewCard ()
    {
        Card card = getCard(getHandSize() - 1);
        System.out.println(card.toString());
    }
}

