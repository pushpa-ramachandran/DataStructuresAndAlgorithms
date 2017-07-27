package Practice1DS;

public class MyQLinkedList {
	Node front = null;
	Node rear = null;
	
	public static  void main(String[] args){
		MyQLinkedList q = new MyQLinkedList();
		System.out.println(q.isEmpty());
		q.enq(1);
		q.enq(2);
		q.enq(3);
		System.out.println(q.isEmpty());
		System.out.println(q.dq());
		System.out.println(q.isEmpty());
		System.out.println(q.dq());
		System.out.println(q.isEmpty());
		System.out.println(q.dq());
		System.out.println(q.isEmpty());
		System.out.println(q.dq());
		q.enq(4);
		System.out.println(q.dq());
		
	}	
	
	private Object dq() {
		//isEmpty
		if(isEmpty()){
			System.out.println("Empty Q");
			return null;
		}
		else{
			if(front == rear){//if only one node, set front and rear as null
				Object d = front.data;
				front = rear = null;
				return d;	}				
			else{			
			//removing front
			Node prev = null;
			Node current = rear;
			while(current.next != null){
				prev = current;
				current = current.next;
			}
			Object d = current.data;
			System.out.println("Curretn data " + current.data);
			prev.next = null;
			front = prev;
			return d;
		}	}	
	}
		

	private void enq(Object i) {
		//create a node
		Node n = new Node();
		n.data= i;
		n.next=null;
		//If empty, add this as front and rear
		if(isEmpty()){
			front =n;
			rear =n;
			System.out.println("Front and rear added to the empty Q");
			System.out.println(" front " + front.data + " rear " + rear.data);
		}
		else{//add the new node at rear
			n.next = rear;
			rear =n;
			System.out.println("added to as rear");
			System.out.println("rear " + rear.data + " front " + front.data);
		}
		
	}

	private boolean isEmpty() {
		if(front == null && rear == null) return true;
		else return false;
	}

	class Node {
		Object data;
		Node next;
	}
}

//Q as a linked . Dq at the last elemnt didnt work
//For Q i didnt impleement Front and rear which is an easy implementation for Q
//	Node head = null;
//	public static void main(String[] args) {
//		
//		MyQLinkedList QList = new MyQLinkedList();
//		QList.enq(1);
//		QList.enq(2);
//		QList.enq(3);+
//		System.out.println(QList.dq());
//		System.out.println(QList.top());
//		System.out.println(QList.dq());
//		System.out.println(QList.isEmpty());
//		System.out.println(QList.dq());
//		System.out.println(QList.isEmpty());
//	}
//	
//	private boolean isEmpty() {
//		if(head == null){
//			return true;
//		}
//		else
//		return false;
//	}
//
//	private Object top() {
//		//dq is from the other end
//				//Empty Q
//				if(head == null){
//					System.out.println("Empty Q ");
//					return null;
//				}
//				else{	//Non Empty Q
//					//traverse to the end
//					Node current = head;
//					Node prev = null;
//					while(current.next != null){
//						prev = current;
//						current = current.next;
//					}
//					Object result = current.data;
////					prev.next = null;
//					return result;			
//				}	
//		
//	}
//	private Object dq() {//dq is from the other end
//		//Empty Q
//		if(head == null){
//			System.out.println("Empty Q ");
//			return null;
//		}
//		else{	//Non Empty Q
//			//traverse to the end
//			Node current = head;
//			Node prev = null;
//			while(current.next != null){
//				prev = current;
//				current = current.next;
//			}
//			Object result = current.data;
//			prev.next = null;
//			return result;			
//		}	
//	}
//	
//	private void enq(Object i) {
//		//create Node
//		Node n = new Node();
//		n.data = i;
//		n.next = null;
//		
//		//Empty Q
//		if(head==null){
//			System.out.println(i + "added as the first element at the head");
//			head = n;
//		}
//		else{//Add at the head
//			n.next = head;
//			head =n;
//			System.out.println(i + " added at the head");
//		}
//		
//		
//		
//	}
//	class Node{
//		Object data;
//		Node next;
//	}
//
//}
