package com.dp;

public class StairCase {
	
	/*
	
	If you hop 1 step, then you have n-1n−1 remaining stairs
	If you hop 2 steps, then you have n-2n−2 remaining stairs
	If you hop 3 steps, then you have n-3n−3 remaining stairs
	
	Hence, the total number of ways that the child can hop the stairs become:
		
		countWays(n-1) + countWays(n-2)+ countWays(n-3)
		
		*/
	
	public static void main(String[] args) {
		
		System.out.println(rec_stairCase(5));
	}
	
	public static int rec_stairCase(int n) {
		
		if(n <0) {
			return 0;
		}
		
		if(n == 0) {
			return 1;
		}
		
		return rec_stairCase(n-1) + rec_stairCase(n-2) + rec_stairCase(n-3);
	}
	
	
	// O(n) time complexity, but O(n) space
	public static int tabular_stairCase(int n ) {
		
		int[] dp = new int[n+1];
		dp[0] = 1; // to reach 0th step we need 1 step
		dp[1] = 1; // to reach 1th step we need 1 step
		dp[2] = 2; // // to reach 2th step we need 2 steps
		
		for(int i=3; i<=n; i++) {
			dp[i] = dp[n-1] + dp[n-2] + dp[n-3];
		}
		
		return dp[n];
	}
	
	public static int tableOptimized_stairCase(int n) {
		
		int thirdLast = 1;
		int secondLast = 1;
		int last = 2;
		int current = 0;
		
		for(int i=3; i<=n; i++) {
			current = thirdLast + secondLast + last;
			thirdLast = secondLast;
			secondLast = last;
			last = current;
		}
		
		return current;
	}
}
