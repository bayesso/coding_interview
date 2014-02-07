/**
[Question]
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

[Solution Idea]
Idea 1: Computational complexity O(nlog n), space complexity O(1)
    Step 1: sort array
    Step 2: set two pointers p1 and p2 on left and right (positions 0 and n-1), and move them towards the center, until touch. If sum is less than target, move p1 to right. If sum is more than target, move p2 to left. 
    
Idea 2: Computational complexity O(n), space complexity O(n)
    Set a HashMap. Scan the array from left to right. Set x as the current element, if target-x is in map, we find the pair. Otherwise, move the pointer to right 
*/


public class Solution {
    /* Solution with idea 1
    public int[] twoSum(int[] numbers, int target) {
        Arrays.sort(numbers);
        int L = 0, R = numbers.length-1;
        int[] output = new int[2];
        while (L < R)
        {
            if (numbers[L] + numbers[R] == target)
            {
                output[0] = L+1;
                output[1] = R+1;
                break;
            }
            else if (numbers[L] + numbers[R] < target)
            {
                L++;
            }
            else
            {
                R--;
            }
        }
        
        return output;
    }
    */
    
    public int[] twoSum(int[] numbers, int target) 
    {
        Map<Integer, Integer> ht = new HashMap<Integer, Integer>();
        int[] output = new int[2];
        for (int i=0; i<numbers.length; i++)
        {
            if (!ht.containsKey(target-numbers[i]))
            {
                ht.put(numbers[i], i);
            }
            else
            {
                output[1] = i + 1;
                output[0] = ht.get(target-numbers[i]) + 1;
                break;
            }
        }
        
        return output;
    }
}


