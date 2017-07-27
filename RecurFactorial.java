package Practice1DS;

import java.util.Scanner;

public class RecurFactorial {
	public static void main(String[] args){
		System.out.println("Enter the number : ");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println("Factorial of " + n +" is " + recurFact(n));
	}

	private static int recurFact(int n) {
		//base case
		if(n==0) return 1;
		return (n*recurFact(n-1));
	}

}
