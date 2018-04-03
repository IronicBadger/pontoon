package pontoon;

import java.util.ArrayList;
import java.util.Collections;

/*
Deck Class - part of the Pontoon game
by Alex Kretzschmar

Deck is used to represent a deck of 52 playing cards. 
**/

public class Deck {
    
    private static ArrayList<Card> deck;
    
   /**                                                                
    * Test harness for class Deck - creates a testDeck, then shuffles  
    * the deck. It then deals 10 cards from the top of the deck and 
    * outputs the values after converting toString.                                                                                                
    **/
    public static void main(String[] args) 
    {
        // Initialise a deck and shuffle it.
        Deck testDeck = new Deck();
        shuffle(testDeck);
        
        // Deal 10 cards from top of deck and print them.
        for (int i = 1; i <= 10; i++)
        {
            Card testCard = dealCard();
            System.out.println("Card "+ i + ": " 
                    + testCard.toString());
        }
    }
    
   /** Constructor Deck() - creates a new deck of 52 cards.
    * The first for loop runs 4 times (once for each suit)
    * and the inner loop runs 13 times per suit.
    */ 
    
    public Deck()
    {
        deck = new ArrayList<Card>();
        for (int SuitValue = 0; SuitValue <= 3; SuitValue++)
        {
            for (int FaceValue = 1; FaceValue <= 13; FaceValue++)
            {
                deck.add(new Card(FaceValue, SuitValue));
            }
        }
    }        
    
   /**
    * Deals a card from the deck and makes it available to be added to
    * a hand etc.
    * 
    * @return A Card from the deck, shrinking it by 1.
    */ 
    public static Card dealCard()
    {
        Card card = deck.remove(0);
        return card;
    }

   /**
    * Shuffles the specified Deck into a random order.
    * 
    * @param tDeck The deck that is to be shuffled.
    */
    public static void shuffle(Deck tDeck)
    {
        Collections.shuffle(deck);
    }   
}
