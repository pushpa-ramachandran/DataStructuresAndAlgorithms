package Practice1DS;

import java.util.Stack;

public class BalanceParenthesis {

	public static void main(String[] args) {
		BalanceParenthesis b = new BalanceParenthesis();
		System.out.println("(a+b) "+ b.check("(a+b)"));
		System.out.println(" a+b) "+ b.check("a+b)"));
		System.out.println(" (a+b " +b.check("(a+b"));
		System.out.println("((a+b) " +b.check("((a+b)"));
		System.out.println("({a+b)} " + b.check("({a+b)}"));
		System.out.println(" " + b.check(" "));
		System.out.println("[a+b] "+ b.check("[a+b]"));
		System.out.println("(a+b(d*g/j) "+ b.check("(a+b(d*g/j)"));
		System.out.println("(a+b(d*g/j)) "+ b.check("(a+b(d*g/j))"));
		System.out.println("{a+b} "+ b.check("{a+b}"));
	}

	private boolean check(String str) {
		boolean balanced = false;
		boolean paired = false;
		char left= ' ';
		Stack<Character> s = new Stack<Character>();
		if(str == " " || str == null){
			balanced = false;
			System.out.println("String " + str + " empty or null");
		}else{
			char[] cArr = str.toCharArray();
			for(int i = 0; i<cArr.length; i++){
				if(cArr[i] =='(' || cArr[i] =='{' || cArr[i] =='[' ){//char is any of the left bracket type, push it to stack
					
					s.push(cArr[i]);
					//System.out.println("stack peeked after push" + s.peek());
				}
				else if(cArr[i] ==')' || cArr[i] =='}' || cArr[i] ==']' ) {//char is any of the right bracket type, pop from the stack and check for the pair
					if(!s.isEmpty()){
					//System.out.println("stack peeked before pop " + s.peek());
					 left = s.pop();
					//System.out.println("left " + left + " cArr[i]" + cArr[i]); 
					}
					switch(cArr[i]){
					case ')':						
						if(left == '(') { 
							paired = true;
							//System.out.println("Paired in ( " + paired);
							}
						else {paired = false;
						//System.out.println("Paired in ) " + paired);
						}
						break;
						
					case '}':
						if(left == '{') {
							paired = true;
							//System.out.println("Paired in } " + paired);
							}
						else {
							paired = false;
							//System.out.println("Paired in } " + paired);
							}
						break;
						
					case ']':
						if(left == '[') {
							paired = true;
							//System.out.println("Paired in ] " + paired);
							}
						else {paired = false;
						//System.out.println("Paired in ] " + paired);
						}
						break;
						
					}
				}
			}
			//System.out.println("Paired " + paired + " isEmpty " + s.isEmpty());
			if(paired && s.isEmpty()) balanced = true;
			else balanced = false;		
		}		
		return balanced;
	}

}
