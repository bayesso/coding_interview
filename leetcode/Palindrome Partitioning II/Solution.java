/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

*/

public class Solution 
{
	public boolean[][] isPalinMatrix(String s)
	{
		int n = s.length();
		boolean[][] output = new boolean[n][n];
		for (int i=0; i<n; i++)
		{
			output[i][i] = true;
		}
		for (int i=1; i<n; i++)
		{
			output[i][i-1] = true;
		}

		for (int k=1; k<n; k++)
		{
			for (int i=0; i+k<n; i++)
			{
				output[i][i+k] = (s.charAt(i) == s.charAt(i+k)) && output[i+1][i+k-1];
			}
		}

		return output;
	}
	public boolean isPalin(String s)
	{
		int L = 0, R = s.length()-1;
		while (L < R)
		{
			if (s.charAt(L) != s.charAt(R))
			{
				return false;
			}
			L++;
			R--;
		}

		return true;
	}

	/*
	public int helper(String s, int R, int[] x, boolean[][] isPalinMat)
	{
		if (R < 0)
		{
			return 0;
		}

		int minCutValue = Integer.MAX_VALUE;
		for (int i=0; i<=R; i++)
		{
			String curStr = s.substring(i, R+1);
			if (isPalinMat[i][R])
			{
				if (x[i] == 0)
				{
					x[i] = helper(s, i-1, x, isPalinMat);
				}
				int tmp = x[i];
				if (tmp < minCutValue)
				{	
					minCutValue = tmp;
				}
			}
		}

		return minCutValue + 1;
	}

    public int minCut(String s) 
    {
    	int[] x = new int[s.length()];
    	boolean[][] isPalinMat = isPalinMatrix(s);
        return helper(s, s.length()-1, x, isPalinMat);
    }
    */

    public int minCut(String s) 
    {
    	int n = s.length();
    	int[] x = new int[n];
    	boolean[][] isPalinMat = isPalinMatrix(s);
        
        //x[0] = 1;
        for (int i=0; i<n; i++)
        {
        	int tmp = Integer.MAX_VALUE;
        	for (int k=0; k<=i; k++)
        	{
        		if (isPalinMat[k][i])
        		{
        			if (k == 0)
        			{
        				tmp = 0;
        				break;
        			}
        			else
        			{
        			    if (x[k-1] + 1 < tmp)
        			    {
        				    tmp = x[k-1] + 1;
        			    }
        			}
        		}
        	}

        	x[i] = tmp;
        }

        return x[n-1];
    }
}