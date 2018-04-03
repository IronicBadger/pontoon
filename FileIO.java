package pontoon;

/**
* FileIO Class - part of the Pontoon game.
* by Alex Kretzschmar
*
* Facilitates the output of game results to a CSV file.
**/

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class FileIO {
    
   /**
    * Test harness for FileIO.
    */ 
    public static void main(String [] args)
    {
        // Tests file write capabilities with 3 fixed integers.
        outputCSV(15, 16, 2);
    }
    
   /**
    * Outputs results from a Pontoon game to a CSV file in package
    * root called "PontoonResults.csv".
    * 
    * @param player Integer of players score.
    * @param dealer Integer of dealers score.
    * @param pCount Integer of playCount representing the number
    *               games played that session.
    */ 
    public static void outputCSV(int player,
                                    int dealer, int pCount)
    {
        File pFile = new File("PontoonResults.csv");
        try
	{
            if(!pFile.exists()) // Checks if file exists.
            {   
                // Creates a new .csv file and fills the headings.
                FileWriter writeNew = new FileWriter(pFile);                
                writeNew.append("Session Game Number,"
                        + "Player Score,"
                        + "Dealer Score"
                        + "\n");
                writeNew.flush();
                writeNew.close(); 
            }
                // If Pontoon.csv exists, add to end of file.
                BufferedWriter bw = new BufferedWriter(
                                    new FileWriter(pFile, true));
                StringBuilder sb = new StringBuilder();
                // Appends passed parameters to a String in 
                // preparation for output.
                sb.append(String.valueOf(pCount)+",");
                sb.append(String.valueOf(player)+",");
                sb.append(String.valueOf(dealer)+",\n");
                // Concatenates StringBuilder for output.
                bw.write(sb.toString());
                bw.close();            
	}
	catch(IOException e)
	{
	     e.printStackTrace();
	} 
     }
}
