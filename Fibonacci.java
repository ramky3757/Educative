package com.dp;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rec_Fib(9));;
		System.out.println(dp_fib(9));;
	}
	
	private static int rec_Fib(int n) {
		
		if(n == 0) {
			return 0;
		}
		
		if(n == 1) {
			return 1;
		}
		
		return rec_Fib(n-1) + rec_Fib(n-2);
	}
	
	private static int dp_fib(int n) {
		
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[n];
	}

}
