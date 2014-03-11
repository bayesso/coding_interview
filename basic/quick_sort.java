/**
 * [Quick sort algorithm]
 * 1. Write the partition function
 * 2. Write a recursion to call the partition function
 * Note that a variant of QuickSort() will consider the case with duplicates in the number list. 
*/

import java.util.*;

public class quick_sort
{
	public static Random rnd = new Random();

	// Very useful swap function
	public static void swap(int[] x, int L1, int L2)
	{
		if (L1 != L2)
		{
			int tmp = x[L1];
			x[L1] = x[L2];
			x[L2] = tmp;
		}
	}

	// Core of quick sort algorithm
	// Randomly find a pivot, and move all element less than pivot to the left, others to the right
	public static int partition(int[] x, int L, int R)
	{
		// Pick pivot randomly
		int pivot_index = rnd.nextInt(R-L+1) + L;
		int pivot_value = x[pivot_index];
		swap(x, pivot_index, R);

		// Scan
		int p = L;
		for (int i=L; i<=R; i++)
		{
			if (x[i] < pivot_value)
			{
				swap(x, i, p);
				p++;
			}
		}

		// Swap back
		swap(x, p, R);

		return p;
	}

	// Recursively split by pivot
	public static void helper(int[] x, int L, int R)
	{
		if (L >= R)
		{
			return;
		}

		int pivot_index = partition(x, 0, x.length-1);
		helper(x, L, pivot_index-1);
		helper(x, pivot_index+1, R);
	}

	// main QuickSort function
	public static void QuickSort(int[] x)
	{
		helper(x, 0, x.length-1);
	}

	public static void main(String[] args)
	{
		int[] x = {7, 3, 1, 4, 9, 10, -5};
		QuickSort(x);
		for (int s : x)
		{
			System.out.print(s + " ");
		}
		System.out.println();
	}
}