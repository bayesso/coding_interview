/*
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/


public class Solution 
{
    public int singleNumber(int[] A) 
    {
        int one = 0, two = 0;
        int n = A.length;
        for (int i=0; i<n; i++)
        {
            int one_ = (one ^ A[i]) && ~two;
            int two_ = (A[i] & one) || (~A[i] & one);
            one = one_;
            two = two_;
        }
        
        return one;
    }
}

