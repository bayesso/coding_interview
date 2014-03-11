import java.util.*;

public class test1
{
	public static void f(int x)
	{
		x = x + 1;
	}

	public static void f(int[] x)
	{
		int n = x.length;
		for (int i=0; i<n; i++)
		{
			x[i] = x[i] + 1;
		}
	}

	public static void f(ArrayList<Integer> x)
	{
		x.add(10000);
	}
	public static void main(String[] args)
	{
		/*
		// Check integer
		int x = 0;
		f(x);
		System.out.println(x);
		
		
		// Check array
		int[] x = new int[10];
		f(x);
		for (int i=0; i<x.length; i++)
		{
			System.out.println(x[i]);
		}
		*/

		ArrayList<Integer> x = new ArrayList<Integer>();
		f(x);
		System.out.println(x);
	}
}