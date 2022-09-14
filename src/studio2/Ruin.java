package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		System.out.println("How much money are you starting with?");
		double startAmount = in.nextDouble();
		double setAmount = startAmount;

		System.out.println("Whats the chance you win the game?");
		double winChance = in.nextDouble();

		System.out.println("How much money is a successful day?");
		double winLimit = in.nextDouble();

		System.out.println("How many simulations would you like to run?");
		int simulationCount = in.nextInt();
		int count = 0;
		int wins = 0;
		int losses = 0;
		
		
		for (int x = 1; x <= simulationCount; x++)
		{
		
			startAmount = setAmount;
			count = 0;
			while ((startAmount >=1) && (startAmount <= winLimit))
			{
				double randomNumber = Math.random();
				if (randomNumber <= winChance)
				{ 
					startAmount ++;
				
				}
				else
				{
					startAmount --;
					

				}
				count ++;
			}
			
			if (startAmount == 0)
			{
				System.out.println("Simulation " + x + ": " + count + " Ruin");
				losses++;
			}
			else 
			{
				System.out.println("Simulation " + x + ": " + count + " Success!");
				wins++;


			}
			
		}
		System.out.println("Total wins: " + wins);
		System.out.println("Total ruins: " + losses);
		
		double expectedRuin = 0;
		double a = (1-winChance)/winChance;
		
			if (winChance == 0.5)
			{
			expectedRuin = (1-(startAmount/winLimit));
			}
			else
			{
			expectedRuin = ((a^startAmount)-(a^winLimit))/(1-a^winLimit);
			}
		

	}
}

