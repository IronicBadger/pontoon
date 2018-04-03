package pontoon;

/*
Card Class - part of the Pontoon game
by Alex Kretzschmar

This class is used to generate a new card object using the values
specified by it's constructor. The CardValue must be between 1-13
the size of a standard suit in a deck, and the CardSuit must be 
between 0-3 to represent a suit.
**/

public class Card {
    
    private final int CardValue;
    private final int CardSuit;
    
   /**                                                               
    * Test harness for class Card - generates random integers to form  
    * a test card object.                                                   
    **/
    public static void main(String[] args) 
    {
        // Loop test 10 times to prove random card generation works.
        for (int i = 1; i <= 10; i++)
        {
            // Generate a random card and suit value.
            int randX = 1 + (int) Math.floor(Math.random()*13);
            int randY = (int) Math.floor(Math.random()*4);
            
            // Create new card object using random values.
            Card testcard = new Card(randX, randY);
            
            // Print testcard objects value and suit.
            System.out.println("CardValue: " 
                    + testcard.CardValue 
                    + "\nCardSuit : "+ testcard.CardSuit);
            System.out.println(testcard + "\n");
        }
    }
        
   /** Constructor Card() - creates a new playing card.
    * 
    * @param a Integer representing the face value of the card.
    * @param b Integer representing the suit value of the card.
    *
    */ 
    public Card(int a, int b)
    {
        this.CardValue = a;
        this.CardSuit = b;      
    } 
   
  /**
    * Overrides toString by concatenating toStringValue method and also
    * toStringSuit method. The output is a String (e.g. '2 of Clubs').
    * 
    * @return Concatenation of toStringValue and toStringSuit.
    **/ 
    public String toString()
    {
       return toStringValue() + " of " + toStringSuit(); 
    }
    
    /**
    * Returns a String which represents the face value of each card.
    * 
    * @return Card face value as a String.
    **/ 
    public String toStringValue()
    {    
        switch (CardValue)
        {
            case 1: return "Ace";
            case 2: return "2";
            case 3: return "3";
            case 4: return "4";
            case 5: return "5";
            case 6: return "6";
            case 7: return "7";
            case 8: return "8";
            case 9: return "9";
            case 10: return "10";
            case 11: return "Jack";
            case 12: return "Queen";
            case 13: return "King";
            default: return "UNKNOWN";
        }
    }

   /**
    * Returns a String which represents the suit value of each card
    * from 0 - 3. Each value denotes a specific suit.
    * 
    * @return Card suit value as a String.
    **/   
    public String toStringSuit()
    {
        if (CardSuit == 0)
            return "Spades";
        else if (CardSuit == 1)
            return "Clubs";
        else if (CardSuit == 2)
            return "Hearts";
        else if (CardSuit == 3)
            return "Diamonds";
        else
            return "UNKNOWN";
    }    
    
   /**
    * Returns an integer which represents the game value of each card.
    * 
    * @return Score of the card.
    **/ 
    public int getCardScore()
    {
        switch (CardValue)
        {
            case 1: return 1;
            case 2: return 2;
            case 3: return 3;
            case 4: return 4;
            case 5: return 5;
            case 6: return 6;
            case 7: return 7;
            case 8: return 8;
            case 9: return 9;
            case 10: return 10;
            case 11: return 10;
            case 12: return 10;
            case 13: return 10;
            default: return 0;
        }
    }   
}