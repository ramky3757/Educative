package com.dp;

public class Knapsack {
	
	public static void main(String args[]) 
	  {
	    int profits[] = {1, 6, 10, 16}; // The values of the jewelry
	    int weights[] = {1, 2, 3, 5}; // The weight of each
	    System.out.println("Total knapsack profit ---> " + rec_Knapsack(profits, 4, weights, 4,  7, 0));
	    System.out.println("Total knapsack profit ---> " + rec_Knapsack(profits, 4, weights, 4, 6, 0));
	  }
	
	
	private static int rec_Knapsack(int profits[], int profitsLength, int weights[], int weightsLength, int capacity, int currentIndex ) {
		
		 // Base Case 
	    if (capacity <= 0 || currentIndex >= profitsLength || currentIndex < 0 || weightsLength != profitsLength)
	      return 0;

	    // If weight of the nth item is more than Knapsack capacity W, then 
	    // this item cannot be included in the optimal solution
	    int profit1 = 0;
	    if (weights[currentIndex] <= capacity)
	      profit1 = profits[currentIndex] + rec_Knapsack(profits, profitsLength, weights, weightsLength, 
	    		  capacity - weights[currentIndex], currentIndex + 1);

	    int profit2 = rec_Knapsack(profits, profitsLength, weights, weightsLength,  capacity, currentIndex + 1);

	    // Return the maximum of two cases:  
	    return Math.max(profit1, profit2);
		
	}

}
