package Practice1DS;

import java.util.Scanner;

public class FibSeries {
	public static void main(String[] args){
		System.out.println("enter a number: ");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println("Using Iterative solution " + fibIter(n));
		System.out.println("Using Recursive solution " + fibRecur(n));
		
	}

	private static int fibRecur(int n) {
		// base case
		if(n<=1) return n;
		int n1 = fibRecur(n-1);System.out.println("fibRecur(n-1)" + (n1));
		int n2 = fibRecur(n-2);System.out.println("fibRecur(n-2)" + (n2));
		return n1+n2;
	}

	private static int fibIter(int n) {
		int r = 0;int count =2;
		int f1 =0; int f2=1;
		while(count<=n){
//			System.out.println(f2);
			r=f1+f2;
			f1=f2;
			f2=r;
			
			count++;			
		}		
		return r;
	}

}
