package Practice1DS;

public class StackLinkList {
	Node head = null;
		
	public static void main(String[] args) {
		StackLinkList s = new StackLinkList();
//		s.push(1);
//		s.push(2);
//		s.push(3);
//		System.out.println(s.peek());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
		String str = "Good Day!";
		System.out.println(s.reverseString(str));
		
	}
	
	private String reverseString(String str) {
		char[] strs = str.toCharArray();
		for (char a : strs){
			this.push(a);
		}
		
		StringBuilder sbr = new StringBuilder();
		while(this.peek() != null){
			char b = (char) this.pop();
			System.out.println(b);
			sbr.append(String.valueOf(b));
		}
		return sbr.toString();
		
		
	}

	private Object pop() {
		//Empty stack
		if(head==null){
			System.out.println("Empty stack pop");
			return null;
		}
		else{
			Object d = head.data;
			head = head.next;
			return d;
		}		
	}

	private Object peek() {
		if(head == null){//empty stack
			System.out.println("Empty stack peek");
			return null;
		}
		else
			return head.data;
	}

	private void push(Object i) {
		//create a node
		Node n = new Node();
		n.data=i;
		n.next=null;
		
		//Empty stack
		if(head==null){
			head = n;
			System.out.println(i +" added at the empty head");
		}
		else{//adding at the head
			n.next = head;
			head = n;
			System.out.println(i + " added at the head");
		}	
	}

	class Node{
		Object data;
		Node next;
	}

}
