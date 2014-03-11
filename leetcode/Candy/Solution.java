/*

here are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

[Solution] Note the rule "r[i]>r[i+1] then x[i]>x[i+1]; r[i]<r[i-1] then x[i]<x[i-1]". This implies that, r[i]=r[i+1], x[i]>x[i+1] or x[i]<x[i+1] or x[i]=x[i+1]. 

*/


public class Solution 
{
    public int candy(int[] ratings) 
    {
    	int n = ratings.length;
    	if (n == 1)
    	{
    		return 1;
    	}


    	int[] x = new int[n];
    	x[0] = 1;
    	for (int i=1; i<n; i++)
    	{
    		if (ratings[i] > ratings[i-1])
    		{
    			x[i] = x[i-1] + 1;
    		}
    		else
    		{
    			x[i] = 1;
    		}
    	}    

    	int res = x[n-1];
    	for (int i=n-2; i>=0; i--)
    	{
    		if (ratings[i] > ratings[i+1] && x[i] <= x[i+1])
    		{
    			x[i] = x[i+1] + 1;
    		}

    		res = res + x[i];
    	}

    	return res;
    }
}