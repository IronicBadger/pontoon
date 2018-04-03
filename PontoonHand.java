package pontoon;

/*
PontoonHand Class - part of the Pontoon game.
by Alex Kretzschmar

PontoonHand extends Hand because a standard hand may not require any
calculations, but when used in the context of a game it does. Also
included is a print method with specific Pontoon Hand formatting.
**/

public class PontoonHand extends Hand {
    
    public static void main(String[] args)
    {
        Deck theDeck = new Deck();
        Deck.shuffle(theDeck);
        PontoonHand testHand = new PontoonHand();
        
        testHand.addCard(Deck.dealCard());
        testHand.addCard(Deck.dealCard());
        testHand.print("Test");
        
        testHand.addCard(Deck.dealCard());
        testHand.printNewCard(); 
        testHand.print("Test");
    }
    
   /** 
    * Calculates the score of a Pontoon Hand and the value of 
    * the Ace card (1 or 11). Aces are checked for every time.
    * 
    * @return Score of the cards in the Hand.
    */ 
    public int calcHandValue ()
    {
        boolean Ace = false; // set to true if hand contains an Ace
        int HandValue = 0;   // running total of hand value
        
        for (int i = 0; i < getHandSize(); i++)
        {            
            // get i'th card score
            int iCardVal = getCard(i).getCardScore();
            
            if (iCardVal == 1)
            {
                Ace = true; // means an Ace is in the hand somewhere
            }
            HandValue = HandValue + (iCardVal);   
        }
        
        // Ace is set always to 1, this 'if' adds 10 always if an Ace
        // is true but only when that would not make HandValue < 21.
        if (Ace == true && HandValue + 10 <= 21)
        {
            HandValue = HandValue + 10; 
        }
        return HandValue;
    }
     
   /** 
    * Prints a Pontoon Hand to console, card by card and displays
    * total value of the hand. Overrides print in Hand.
    * 
    * @param extS Pass this string to print the desired moniker.
    */ 
    public void print(String extS)
    {       
        // Queries hand size and iterates accordingly.
        for (int i = 0; i < getHandSize(); i++)
        {
            // Gets i-th card and prints to console.
            Card card = getCard(i);
            System.out.println(extS + " card "+ (i+1) 
                + ": " + card.toString());
        }
        // Prints the hand value as a String. 
        System.out.println(extS + " hand total: "
                + calcHandValue() + "\n");
    }
}
