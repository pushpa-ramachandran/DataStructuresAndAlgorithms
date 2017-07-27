package Practice1DS;

public class QArr {
	int max = 2;
	int[] a = new int[max];
	int front = -1;
	int rear = -1;

	public static void main(String[] args) {
		QArr q = new QArr();
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
			System.out.println("fronttt " + front + " rear " + rear);
			if(front+1 == rear && !isEmpty() &&front+1 <max){
				i = a[++front];
				front=-1;
				rear=-1;
				System.out.println("front and rear set at -1");
			}
			else{	//multiple elements
				if(front+1 < max)
				i = a[++front];				
			}		
			}		
		return i;
	}

	private void enq(int i) {
		if(rear+1 >= max){
			System.out.println("Array maxed out.. Can not add");
		}
		else{
		a[++rear] = i;
		System.out.println(i + " added at rear " + rear );
		}		
	}

	private boolean isEmpty() {
		if(front == -1 && rear == -1) return true;
		else return false;
	}

}
