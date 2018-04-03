package pontoon;

/*
Pontoon game
by Alex Kretzschmar
Student ID: 100072596

The game of Pontoon involves trying to be the first player to 21 
without going bust (over 21). 
**/

import java.util.Scanner;

public class Pontoon {

    public static void main(String[] args) 
    {
        boolean playerWin; 
        boolean playAgain = true; 
        int playCount = 0;  // reset to 0 every time game is launched
        
        System.out.println("Welcome to Pontoon!");
        System.out.println("by Alex Kretzschmar \u00a9 2013");
        
        while (playAgain == true)
        {
            playCount++;    // increments the number of games played
            System.out.println("\nGame number: " + playCount);
            playerWin = pontoonGame(playCount);  // launches the game
            if (playerWin == true)      // checks whether player won
            {    
                System.out.println("User wins! Congratulations.\n");
            }
            else                       
            {    
                System.out.println("Dealer wins! Bad luck.\n");
            }
            
            // Asks user if they want to play another game.
            playAgain = replay();
        }
        System.out.println("Thanks for playing. Bye!");
    }
    
   /**
    * Asks user whether they want to play another game.
    * 
    * @return A boolean value true if yes, false if no.
    */
    private static boolean replay()
    {
        Scanner scanner = new Scanner(System.in);
        while (true) 
        {
            System.out.println("Play again? y/n");
            String input = scanner.next().toLowerCase();
            if (input.equals("y"))
                return true;
            else if (input.equals("n"))
                return false;
            else
            {
                System.out.println("Incorrect input, try again.");
            }
        }
    }

   /**
    * The game of Pontoon. Includes twist / stick logic and validates
    * winner returning a boolean value.
    * 
    * @return A boolean value. True if user wins, false if Dealer wins.
    */ 
    static boolean pontoonGame(int playCount)
    {          
        Deck theDeck = new Deck();
        Deck.shuffle(theDeck);
        PontoonHand pHand = new PontoonHand();
        PontoonHand dHand = new PontoonHand();

        dHand.addCard(Deck.dealCard());
        pHand.addCard(Deck.dealCard());
        dHand.addCard(Deck.dealCard());
        pHand.addCard(Deck.dealCard());
        
        // Check for Pontoon at dealtime.
        if (dHand.calcHandValue() == 21)
        {
            System.out.println("Dealer has Pontoon, bad luck.");
            dHand.print("Dealer");
            pHand.print("Player");
            FileIO.outputCSV(pHand.calcHandValue(), 
                    dHand.calcHandValue(), playCount);
            return false;
        }
        if (pHand.calcHandValue() == 21)
        {
            System.out.println("Player has Pontoon, you win!");
            pHand.print("Player");
            dHand.print("Dealer");
            FileIO.outputCSV(pHand.calcHandValue(), 
                    dHand.calcHandValue(), playCount);
            return true;
        }
        // Neither player have Pontoon at deal time, let's play!
        

        // Player game code
        while (true)
        {
            // Asks player for input.
            Scanner scanner = new Scanner(System.in);
            pHand.print("Player");
            System.out.println("Twist or Stick? t/s");
            String input = scanner.next().toLowerCase();
            
            // Parse input with logic.
            if (input.matches("s"))
            {
                // User doesn't want anymore cards.
                break;
            }
            else if (input.matches("t"))
            {             
                // User wants another card.
                pHand.addCard(Deck.dealCard());
                pHand.printNewCard();
                System.out.println("New Player hand total: " 
                    + pHand.calcHandValue()+"\n");
                
                // Check if new card makes player bust.
                if (pHand.calcHandValue() > 21)
                {
                    pHand.print("Player");
                    System.out.println("Player went bust.\n");
                    FileIO.outputCSV(pHand.calcHandValue(), 
                            dHand.calcHandValue(), playCount);
                    return false;
                }
            }
            else
            {
                // Checks for incorrect input from Scanner.
                System.out.println("Incorrect input, try again.");
            }
        }
        
       /*
        * Logic to determine whether Dealer is required to twist. The
        * Dealer must do so if <= 16. Loops until satisfied or bust.
        */
        while (dHand.calcHandValue() <= 16)
        {
            // Dealer is forced to twist.
            System.out.println("Dealer twists.");              
            dHand.addCard(Deck.dealCard());
            dHand.printNewCard();
            
            if (dHand.calcHandValue() > 21)
            // does Dealer hand exceed 21?
            {
                dHand.print("Dealer");
                System.out.println("Dealer went bust.\n");
                FileIO.outputCSV(pHand.calcHandValue(), 
                        dHand.calcHandValue(), playCount);
                return true;
            }
        }
        
       /* 
        * No player went bust during the twist / stick phase we now
        * decide the winner.
        **/ 
        System.out.println();
        dHand.print("Dealer");
        pHand.print("Player");

       /*
        * Stores player hand totals as int to make calculations
        * more efficient and easier to read.
        */ 
        int pTotal = pHand.calcHandValue();
        int dTotal = dHand.calcHandValue();
        
        FileIO.outputCSV(pTotal, dTotal, playCount);
        
        if (pTotal == dTotal)           // Scores are equal
        {
           /* Checks for a 5 card trick, required only in the event
            * of a tie. If true, the player with that hand wins.
            */
            if (pHand.getHandSize() == 5) 
            {                             
                System.out.println("Player 5 card trick!");
                return true;            //Player wins
            } 
            else if (dHand.getHandSize() == 5)
            {
                System.out.println("Dealer 5 card trick!");
                return false;           //Dealer wins
            }
            System.out.println("Tie.");
            return false;
        } // end if   
        
        else if (dTotal > pTotal)       // Dealer has highest score
            return false;
        else                            // Player has highest score
            return true;
    } //end poontonGame
}
