// Question: Given an array of integers, every element appears twice except for one. Find that single one. Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
// Solution idea: use the property of XORin bit manipulation: x^x=0 and x^1=x

public class Solution {
    public int singleNumber(int[] A) {
        int x = 0;
        for (int i=0; i<A.length; i++)
        {
            x = x ^ A[i];
        }
        
        return x;
    }
}
