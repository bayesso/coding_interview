/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.

*/

public class Solution 
{
    public int canCompleteCircuit(int[] gas, int[] cost) 
    {
        int n = gas.length;
        int sum = 0;
        int accum = 0;
        int pivot = 0;
        for (int i=0; i<n; i++)
        {
        	accum = accum + gas[i] - cost[i];
        	sum = sum + gas[i] - cost[i];
        	if (sum < 0)
        	{
        		sum = 0;
        		pivot = i + 1;
        	}
        }

        if (accum < 0)
        {
        	return -1;
        }

        if (pivot == n)
        {
        	return -1;
        }

        return pivot;
    }
}
