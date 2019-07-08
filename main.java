//  main.java
//  SlotMachineSimulation
//
//  Created by Quiyet Brul on 6/13/19.
//  Copyright © 2019 Quiyet Brul. All rights reserved.

import java.util.*;

public class SlotMachineSim
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        Random imgIdx = new Random();
        
        boolean isNumber;  
        char ans, ansFormat;
        double prize = 0; 
        double prizeTotal = 0;
        double gambleMoney = 0;
        
        do
        {
            System.out.println("=======================================");
            //VALIDATION FOR USER INPUT
            do
            {
                System.out.print("Enter $ to gamble: ");
                if (userInput.hasNextDouble())
                {
                    isNumber = true;
                    gambleMoney = userInput.nextDouble();
                    
                    if (gambleMoney <= 0)
                    {
                        isNumber = false;
                        System.out.println("ERROR-1A: Must be a positive number.");
                        userInput.nextLine();
                    }
                    else
                    {
                        isNumber = true;
                        break;
                    }
                }
                else
                {
                    isNumber = false;
                    System.out.println("ERROR-1B: Must be a positive number.");
                    userInput.nextLine();
                }
            } while(!(isNumber));
            
            //RANDOMIZED RESULTS
            int imgInd1 = imgIdx.nextInt(5);
            int imgInd2 = imgIdx.nextInt(5);
            int imgInd3 = imgIdx.nextInt(5);
            String[] imgMatch = {"Cherries", "Oranges", "Plums", "Bells", "Melons", "Bars"};
            System.out.print("\nResults: ");
            System.out.println(imgMatch[imgInd1] + "   " +
                             imgMatch[imgInd2] + "   " +
                             imgMatch[imgInd3] + "   ");
                             
            //RESULTS MATCHING + PRIZE                 
            if (imgMatch[imgInd1] == imgMatch[imgInd2] ||
                imgMatch[imgInd1] == imgMatch[imgInd3] ||
                imgMatch[imgInd2] == imgMatch[imgInd3])
                {
                    System.out.println("You won double!");
                    prize = 2 * gambleMoney;
                    System.out.println("Round Prize: " + prize);  
                    prizeTotal += prize;
                }
            else if (imgMatch[imgInd1] == imgMatch[imgInd2] &&
                imgMatch[imgInd1] == imgMatch[imgInd3] &&
                imgMatch[imgInd2] == imgMatch[imgInd3])
                {
                    System.out.println("You won triple!");
                    prize = 3 * gambleMoney;
                    System.out.println("Round Prize: " + prize);  
                    prizeTotal += prize;
                }
            else
                {
                    System.out.println("You lost!");
                }
                
            
            
            //REPEAT
            System.out.print("\nPlay again (y||n)? ");
            ans = userInput.next().charAt(0);
            ansFormat = Character.toLowerCase(ans);
            
            //REPEAT VALIDATION
            while(!(ansFormat == 'y') && !(ansFormat == 'n'))
            {
                System.out.println("ERROR-2A: Must be y||n only.");
                System.out.print("Play again (y||n)? ");
                ans = userInput.next().charAt(0);
                ansFormat = Character.toLowerCase(ans);
            } 
            
            System.out.println("");
            
            
        } while(ansFormat == 'y');            
        
        System.out.println("Total prize: " + prizeTotal);

    }
}
