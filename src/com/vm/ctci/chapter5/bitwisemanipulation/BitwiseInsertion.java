package com.vm.ctci.chapter5.bitwisemanipulation;

/**
 * Inserting m into n such that m starts at bit j and ends at bit i. We are
 * given two numbers n and m, and two-bit positions, i and j. Insert bits of m
 * into n starting from j to i. We can assume that the bits j through i have
 * enough space to fit all of m. That is, if m = 10011, you can assume that
 * there are at least 5 bits between j and i. You would not, for example, have j
 * = 3 and i = 2, because m could not fully fit between bit 3 and bit 2.
 * 
 * @author Venkatesh Manohar
 *
 */
public class BitwiseInsertion {

	public static int insert(int n, int m, int i, int j) {
		/* Create a mask to clear bits i through j 
        in n. EXAMPLE: i = 2, j = 4. Result 
        should be 11100011. For simplicity, we'll 
        use just 8 bits for the example. */
		int allOnes = ~0;
		System.out.println(allOnes);
		//11110000000
		int left = allOnes <<(j+1);
		System.out.println(left);
		//0000000011
		int right = (1<<i)-1;
		
		int mask = left | right;
		int n_masked = n & mask;
		int m_shifted = m<<i;
		
		return n_masked|m_shifted; 
	}
	
	public static void main (String[] args) {
		insert(0, 0, 0, 0);
		// in Binary N= 10000000000 
        int n = 1024;  
          
        // in Binary M= 10011 
        int m = 19;    
          
        int i = 2, j = 6; 
       
        System.out.println(insert(n,m,i,j)); 
	}
}
