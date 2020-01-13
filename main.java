//  main.java
//  SlotMachineSimulation
//
//  Created by Quiyet Brul on 7/4/19.
//  Copyright © 2019 Quiyet Brul. All rights reserved.

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        Random rand = new Random();
        
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
            int imgIdx1 = rand.nextInt(6);
            int imgIdx2 = rand.nextInt(6);
            int imgIdx3 = rand.nextInt(6);
            String[] imgMatch = {"Cherries", "Oranges", "Plums", "Bells", "Melons", "Bars"};
            System.out.print("\nResults: ");
            System.out.println(imgMatch[imgIdx1] + "   " +
                             imgMatch[imgIdx2] + "   " +
                             imgMatch[imgIdx3] + "   ");
                             
            //RESULTS MATCHING + PRIZE                 
            if (imgMatch[imgIdx1] == imgMatch[imgIdx2] &&
                imgMatch[imgIdx1] == imgMatch[imgIdx3])
                {
                    System.out.println("You won triple!");
                    prize = 3 * gambleMoney;
                    prizeTotal += prize;                    
                }
            else if (imgMatch[imgIdx1] == imgMatch[imgIdx2] ||
                imgMatch[imgIdx1] == imgMatch[imgIdx3] ||
                imgMatch[imgIdx2] == imgMatch[imgIdx3])
                {
                    System.out.println("You won double!");
                    prize = 2 * gambleMoney;
                    prizeTotal += prize;
                }
            else
                {
                    System.out.println("You lost!");
                }
            
            System.out.println("Round Prize: " + prize); 
            
            
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
