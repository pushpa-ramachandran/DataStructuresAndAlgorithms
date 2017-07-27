package Practice1DS;

public class QCircArray {	
	int max = 2;
	int[] a = new int[max];
	int front = -1;
	int rear = -1;
	public static void main(String[] args) {
		QCircArray q = new QCircArray();
		System.out.println("Is Empty? true - " + q.isEmpty());
		q.enq(1);
		q.enq(2);
		q.enq(3);
		System.out.println("Is Empty?  false - " + q.isEmpty());
		System.out.println("dq  1 " +q.dq());
		System.out.println("dq  2 " +q.dq());
		System.out.println("Is Empty?  true - " + q.isEmpty());
		System.out.println("dq  3 " +q.dq());
		System.out.println("Is Empty?  true - " + q.isEmpty());
		}

	private int dq() {
		int i = -1;
		if(isEmpty()){
			System.out.println("Empty Q.. DQ failed ..");
		}
		else{
			//only one element 
			int p = (front+1)%max;
			if(p == rear){//last element in the Q
				front=-1;
				rear=-1;				
			}			
			i = a[p];
				
			}		
		return i;
	}
	private void enq(int i) {
		int p = (rear+1)%max;
		if(p==front){//Q full
			System.out.println("Q is full");
		}
		else{
			rear=p;
			a[rear] = i;
		}if(front ==-1)
			front=0;
		
				
	}
	private boolean isEmpty() {
		if((front == -1 && rear == -1) || ( front == rear)) return true;		
		else return false;
	}

}
