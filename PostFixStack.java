package Practice1DS;

import java.util.Scanner;
import java.util.Stack;

public class PostFixStack {

	public static void main(String[] args) {
		System.out.println(" 2 3 *-> " + postFix(" 2 3 *"));//6
		System.out.println("Result 11 " + postFix("1 2 3 * + 4 +"));
		System.out.println("Result 6 " + postFix("5 2 4 * + 7 -"));
		System.out.println("Result 25 " + postFix("2 3 + 4 5 * +"));
		System.out.println("Result 82 " + postFix("8 5 * 7 4 2 + * +"));
		System.out.println("Result 18 " + postFix("6 8 2 / 1 - *"));

	}

	private static int postFix(String string) {
		Scanner tokens = new Scanner(string);
		Stack<Integer> s = new Stack<Integer>();
		int result =0;
		while(tokens.hasNext()){
			if(tokens.hasNextInt()){
				s.push(tokens.nextInt());
			}
			else{
				int n1=s.pop();
				int n2 = s.pop();
				String operator = tokens.next();
				if(operator.equals("+"))  s.push(n1+n2);
				else if(operator.equals("%"))  s.push(n2+n1);
				else if(operator.equals("*"))  s.push(n1*n2);
				else if(operator.equals("-"))  s.push(n2-n1);
				else if(operator.equals("/"))  s.push(n2/n1);
			}
		}
		
		return s.pop();
	}

}
