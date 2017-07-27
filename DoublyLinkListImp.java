package Practice1DS;

public class DoublyLinkListImp {
	Node head = null;
	Node tail = null;

	public static void main(String[] args) {
		DoublyLinkListImp dlist = new DoublyLinkListImp();
		dlist.add(1);
		dlist.add(2);
		dlist.add(3);
		dlist.add(4);
		dlist.add(5);
		dlist.traverse();
		dlist.reverseTraverse();
		dlist.remove(1);
		dlist.traverse();
		dlist.reverseTraverse();
		dlist.remove(3);
		dlist.traverse();
		dlist.reverseTraverse();
		dlist.remove(6);
		dlist.traverse();
//		dlist.traverse();
		dlist.reverseTraverse();
	}
	
	private void remove(int index) {
		//empty
		if(head == null && tail == null){
			System.out.println("Empty List..");
			return;
		}
		//head			
		if(index == 1){//head is the only element
			if(head.next == null){
				head=null;
				tail=null;
			}
			else{//head and other elements
			head.next.prev=null;
			head = head.next;
			}
		}
		else{//Non-head - valid index
			int count =1;
			Node current = head;
			while(count < index-1 && current.next!=null){
				current = current.next;
				count++;				
			}
			if(current.next!=null){
				if(current.next == tail){
				tail = current;
				}
			current.next = current.next.next;
			current.next.prev=current;}
				
			else{	//invalid index
				System.out.println("\n" +index + " invalid ");
			}
			
		}		
	}

	private void reverseTraverse() {
		System.out.println("Reverse traversing....");
		Node current = tail;
		if(tail == null){
			System.out.println("List is empty");
		}
		else{
			while(true){
				if(current.prev != null){
					System.out.println("Data: " + current.data);
					current = current.prev;}
				else{
					System.out.println("Data: " + current.data);
					break;
				}
			}
			
		}
		
	}

	private void traverse() {
		System.out.println("Traversing....");
		Node current = head;
		if(head == null){
			System.out.println("List is empty");
			}
		else{
			while(true){
				if(current.next != null){
					System.out.println("Data  :" + current.data);
					current = current.next;
				}
				else{
					System.out.println("Data  :" + current.data);
					break;
				}
					
			}
		}
		
	}

	private void add(int i) {
		//create node
		Node n = new Node();
		n.prev = null;
		n.next =null;
		n.data = i;
		//list empty
		if(head == null & tail == null){
			head =n;
			tail = n;
			System.out.println(i+" Added at head and tail");
		}
		//Not empty
		else{
			Node current = head;
			while(true){
				if(current.next != null){
					current = current.next;
				}
				else
					break;
			}
			current.next = n;
			n.prev = current;
			tail = n;
			System.out.println(i +" Node added as Tail");
		}		
	}

	class Node{
		Object data;
		Node prev;
		Node next;
	}

}
