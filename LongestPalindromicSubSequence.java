package com.dp;

public class LongestPalindromicSubSequence {

	
	public static void main(String[] args) {
		System.out.println(rec_LPS("cddpd",0,"cddpd".length()-1));;
	}
	
	public static int rec_LPS(String str, int start, int end) {
		
		if(start > end) {
			return 0;
		}
		if(start == end) {
			return 1;
		}
		
		if(str.charAt(start) == str.charAt(end)) {
			return 2+ rec_LPS(str, start+1, end-1);
		}
		
		int len1 = rec_LPS(str, start+1, end);
		int len2 = rec_LPS(str, start, end-1);
		
		return Math.max(len1, len2);
		
	}
	
	//Both the space and time complexity of this algorithm is O(N^2)O(N2 ), where N is the length of the input string.
	
	public static int LPSLength(String st) 
    {
        int size = st.length();
        // Initializing a lookup table of dimensions size * size
        int [][] lookupTable;
        lookupTable = new int [size][];
        for (int i = 0; i < size; i++) {
            lookupTable[i] = new int[size];
            for (int j = 0; j < size; j++)
            lookupTable[i][j] = 0;
        }
        // every sequence with one element is a palindrome of length 1
        for (int i = 0; i < size; i++)
            lookupTable[i][i] = 1;

        for (int startIndex = size - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < size; endIndex++) 
            {
                // case 1: elements at the beginning and the end are the same
                if (st.charAt(startIndex) == st.charAt(endIndex)) 
                    lookupTable[startIndex][endIndex] = 2 + lookupTable[startIndex + 1][endIndex - 1];
                else // case 2: skip one element either from the beginning or the end
                    lookupTable[startIndex][endIndex] = Math.max(lookupTable[startIndex + 1][endIndex], lookupTable[startIndex][endIndex - 1]);
            }
        }
        return lookupTable[0][size - 1];
    }
	
}
