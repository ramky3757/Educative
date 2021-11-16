package com.dp;

import java.util.Arrays;

public class Partition {
	
	public static Object canPartition(int[]num)
    {
        int n = num.length;
        // find the total sum
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += num[i];

        // if 'sum' is a an odd number, we can't have two subsets with same total
        if (sum % 2 != 0)
            return false;
        // we are trying to find a subset of given numbers that has a total sum of ‘sum/2’.
        sum /= 2;

        boolean [][]lookupTable = new boolean[n][];
        for (int i = 0; i < n; i++)
            lookupTable[i] = new boolean[sum + 1];

        // populate the sum=0 columns, as we can always for '0' sum with an empty set
        for (int i = 0; i < n; i++)
            lookupTable[i][0] = true;

        // with only one number, we can form a subset only when the required sum is equal to its value
        for (int s = 1; s <= sum; s++)
            lookupTable[0][s] = (num[0] == s ? true : false);

        // process all subsets for all sums
        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= sum; s++) {
            // if we can get the sum 's' without the number at index 'i'
            if (lookupTable[i - 1][s]) {
                lookupTable[i][s] = lookupTable[i - 1][s];
            } else if (s >= num[i]) { // else if we can find a subset to get the remaining sum
                lookupTable[i][s] = lookupTable[i - 1][s - num[i]];
            }
            }
        }
        // the bottom-right corner will have our answer.
        return lookupTable[n - 1][sum];
    }
	
	public static void main(String[] args) {
		
		int set2[] = {1, 1, 3, 4, 7};
	    System.out.println(Arrays.toString(set2) + "\t--->\t" + canPartition(set2));
	}

}
