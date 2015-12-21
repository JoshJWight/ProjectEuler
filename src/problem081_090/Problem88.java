package problem081_090;

import java.math.BigInteger;
import java.util.HashMap;
/**
 * 
 * @author Josh
 *
 */
public class Problem88 {
	public static void main(String args[]) 
	{
		HashMap<Long, String> nums = new HashMap<Long, String>();
		for(int i=2; i<=12000; i++)
		{
			nums.put(solve(i), "");
		}
		
		Long result = 0L;
		for(Long i: nums.keySet())
		{
			result = result+i;
		}
		
		System.out.println(result);
	}
	
	public static Long solve(int i)
	{
		Long arr[];
		for(Long s=Long.valueOf(i);s<144; s++)
		{
			arr = blank(i);
			boolean result = iterate(arr, 0, s-i+1);
			if(i==112)
			{
				print(arr);
			}
			if(result)
			{
				print(arr);
				return s;
			}
		}
		System.out.println("Reached sum greater than 1000");
		System.exit(0);
		return 0L;
	}
	
	public static Long[] blank(int n)
	{
		Long arr[] = new Long[n];
		for(int i=0; i<n; i++)
		{
			arr[i] = 1L;
		}
		return arr;
	}
	
	public static boolean iterate(Long arr[], int i, Long n)
	{
		arr[i] = n;
		
		Long s = sum(arr);
		Long p = product(arr);
		
		if(s == p)
		{
			return true;
		}
		else if(p>s)
		{
			return false;
		}
		else if(i==arr.length-1)
		{
			return false;
		}
		
		Long maxk = n-1;
		if(i>0 && arr[i-1]<maxk)
		{
			maxk=arr[i-1];
		}
		
		for(Long k = maxk; k>=2; k--)
		{
			clean(arr, i+1);
			arr[i] = k;
			boolean result = iterate(arr, i+1, n-k+1L);
			if(result==true)
			{
				return true;
			}
		}
		
		return false;
	}
	
	public static void clean(Long arr[], int i)
	{
		for(int n=i; n<=arr.length; n++)
		{
			if(arr[n]==1L)
			{
				break;
			}
			arr[n]=1L;
		}
	}
	
	public static Long sum(Long arr[])
	{
		Long result = 0L;
		for(int i=0; i<arr.length; i++)
		{
			Long l = arr[i];
			if(l==1L)
			{
				result+=arr.length-i;
				break;
			}
			else{
				result+=l;
			}
		}
		return result;
	}
	
	public static Long product(Long arr[])
	{
		Long result = 1L;
		for(Long i: arr)
		{
			if(i==1L)
			{
				break;
			}
			result = result*i;
		}
		return result;
	}
	
	public static void print(Long arr[])
	{
		System.out.print(arr.length + ": ");
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i]==1L)
			{
				System.out.print("(1 x " + (arr.length-i) + ")");
				break;
			}
			
			System.out.print(arr[i]);
			if(i!=arr.length-1)
			{
				System.out.print(" + ");
			}
		}
		System.out.println(" = " + sum(arr) + " (product=" + product(arr) + ")");
	}
}
