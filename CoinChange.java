package com.dp;

public class CoinChange {
	
	public static int rec_countChange(int[] denoms, int denomsLength, int amount) {
		
		// If n is less than 0 then no  
		  // solution exists 
		  if (amount < 0 || denomsLength <= 0)
		   return 0;

		  // If there are no coins and n  
		  // is greater than 0, then no 
		  // solution exist 
		  if (denomsLength <= 0 && amount >= 1)
		   return 0;
		
		if(amount == 0) {
			return 1;
		}
		
		
		// count is sum of solutions (i)  
		  // including S[m-1] (ii) excluding S[m-1] 
		return rec_countChange(denoms, denomsLength-1, amount) + rec_countChange(denoms, denomsLength, amount - denoms[denomsLength - 1]);
		
	}
	
	//The time complexity is O(amount*denomsLength)O(amount∗denomsLength), 
	//However, the space complexity is reduced to O(amount)O(amount) in this case.
	
	public static int countChange(int denoms[], int amount) {
		  int denomsLength = denoms.length;
		  if (denomsLength <= 0 || amount <= 0)
		   return 0;

		  // lookupTable[i] will be storing the number of solutions for 
		  // the value i. We need amount+1 rows as the table is constructed 
		  // in a bottom up manner using the base case (n = 0) 
		  int[] lookupTable = new int[amount + 1];

		  // Initialize all table values to 0 
		  for (int i = 0; i < amount + 1; i++) {
		   lookupTable[i] = 0;
		  }

		  // Base case (If the given value is 0) 
		  lookupTable[0] = 1;

		  // Pick all coins one by one and update the lookupTable[] values 
		  // after the index greater than or equal to the value of the 
		  // picked coin 
		  for (int i = 0; i < denomsLength; i++)
		   for (int j = denoms[i]; j <= amount; j++)
		    lookupTable[j] += lookupTable[j - denoms[i]];

		  return lookupTable[amount];
		 }
	
	public static void main(String args[]) {
		  // Denominations: quarters (25 cents), dimes (10 cents), nickels (5 cents), and pennies (1 cent)
		  int[] denoms = {
		   25,
		   10,
		   5,
		   1
		  };
		  System.out.println(rec_countChange(denoms, 4, 10));
		  System.out.println(countChange(denoms,  10));
		 }

}
