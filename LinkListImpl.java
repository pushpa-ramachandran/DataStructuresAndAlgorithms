package Practice1DS;

import java.util.concurrent.SynchronousQueue;

public class LinkListImpl {
	Node head = null;
	public static void main(String[] args){
		LinkListImpl list = new LinkListImpl();
		list.add(1);
		list.add(2);
		list.add(3);		
//		list.insert(4,1);
		list.insert1(1,4);		
		list.traverse();		
		list.remove(1);//removal of n+1 is wrong
		list.traverse();
		System.out.println("Iterative reversing ...");
		list.reverse();
		list.traverse();
		System.out.println("Recursive reversing ...");
		list.recurReverse(list.head);
		list.traverse();
		System.out.println("Forward printing using Recursion...");
		list.fprintRecur(list.head);
		System.out.println("\nReverse printing using Recursion...");
		list.revPrintRecur(list.head);
//		list.revTraverse();
//		list.reverse();
	}
	
	private void revPrintRecur(Node r) {
		// base case
		if(r == null) return;
		revPrintRecur(r.next);
		System.out.print(r.data+" ");
		
	}

	private void fprintRecur(Node n) {
		//base case
		if(n == null){
			return;
		}
		System.out.print(n.data+" ");
		fprintRecur(n.next);
		
	}

	private void recurReverse(Node p) {
		//base case
		if(p.next==null){
			head = p;
			return;
		}
		recurReverse(p.next);
		Node q = p.next;
		q.next = p;
		p.next=null;		
	}

	private void reverse() {
		Node current = head;
		Node previous = null;
		Node next = null;
		while(current != null){
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
	}

	private void remove(int index) {
		//empty list
		if(head == null){
			System.out.println("empty list.... Remove unsuccessful");
			return;
		}
		if(index == 1){//head to be removed
			if(head.next != null){//head and other elements
				Node tmp = head;
				head = head.next;
				tmp = null;
			}
			else{//head is the only element
				head = null;				
			}
		}else{//middle element to be removed
			Node current = head;
			int count =2;
			while(true){
				if(count == index){//reached the index
					if(current.next != null){//not the last element
						current.next = current.next.next;
						break;
					}
					else{//last element
						current.next = null;
						break;
					}
					
				}else if (count <= index){//not reached the index. increment
					
					if(current.next != null){//not hte end
						count++;
						System.out.println(count);
						current = current.next;
					} 
				
					else{//reached the end
						
						System.out.println("Invalid index...for removal");
						break;
					}}
					
				
				}		
		}		
	}


	private void insert1(int data, int index) {
		int count =1;
		Node n = new Node();
		n.data = data;
		n.next = null;
		if(index == 1){//to be added as head
			if(head == null){//if list is empty
				head =n;				
			}else{//add as the head
				Node n1 = head;
				head = n;
				n.next = n1;			
			}
				
		}
		else{
			Node tmp = head;
		while(true){
			if(count+1 == index){//index found
				if(tmp.next == null){//to be added as the last node
					tmp.next = n;
					break;
				}
				else{//to be inserted in between
					Node n1 = tmp.next;
					tmp.next = n;
					n.next = n1;
					break;					
				}				
			}
			else if (count+1 < index){
				if(tmp.next != null){
					tmp = tmp.next;
					count++;
				}
				else{
					System.out.println("invalid index");
					break;
				}
			}
		}
		
	}
	}

	private void insert(int data, int index) {
		Node n = new Node();
		n.data = data;
		Node tmp = head;
		int count=1;
		if(head == null){	//to be added at head					
			if(count == index){
			System.out.println(data + " added at head at index 1 as the list is empty" );
			head = n;
			}
			else{
				System.out.println(data + " can be added as head at index 1 as the list is empty," );
			}			
		}
		else{
			while(true){
				if(count+1 == index){
					if(tmp.next == null){//to be added as the last node
					
					tmp.next=n;
					System.out.println(data + " Added at " + index);
					break;
					}
					else{
						Node n1 = tmp.next;
						tmp.next = n;
						n.next = n1;
						break;
					}
				}
				else if ((count+1 < index)){
				if(tmp.next != null){
					
					tmp = tmp.next;
					count++;
					System.out.println("count " + count);
					}
				else {
					System.out.println("Invalid index");
					break;
					
				}
				}
			}
		}
		
		
		
	}

	private void traverse() {
		//empty list
		System.out.println("Traversing.....");
		if (head == null){
			System.out.println("empty list");
		}
		else{	//non empty list
			Node tmp = head;
			while(tmp.next!=null){
				System.out.println("Node " + tmp.data);
				tmp = tmp.next;
			}
			//last node
			System.out.println("Node " + tmp.data);
			
		}
		
	
		
	}

	private void add(int i) {
		//create the new node
		Node n = new Node();
		n.data=i;
		n.next = null;
		//empty list
		if(head == null){
			head = n;
			System.out.println(i + " Node added as head");			
		}
		else{	//non-empty list
			Node tmp = head;
			while(tmp.next != null){
				tmp = tmp.next;
			}
			tmp.next = n;
			System.out.println(i + " Node added at the end");
		}
		
	
		
	}
	class Node{
		Object data;
		Node next;
	}
	

}
