package Practice1DS;

public class bubbleSort {
	public static void main(String[] args){
		int[] a ={3,4,1,9,0,5};
//		int[] a ={3};
//		int[] a ={};
//		int[] a ={1,2,3,4,5};
//		int[] a ={3,4,1,9,0,5};
		System.out.println("Unsorted Array");
		print(a);
		bubble(a);
		System.out.println("\nSorted Array");
		print(a);
	}
	private static void bubble(int[] a) {
		int maxI = a.length-1;
		for(int i=0;i<=maxI;i++){
			for(int j=0; j<=maxI-1-i;j++){
				if(a[j] > a[j+1]){
					int temp = a[j+1];
					a[j+1] = a[j];
					a[j]=temp;
				}
			}
		}
		
	}
	private static void print(int[] a) {
		for(int i : a){
			System.out.print(i+" ");
		}		
	}	
}
//	//practice 1
//	public static void main(String[] args){
//		int[] a ={7,5,4,8,3,1};
//		System.out.println("\nUnsorted array");
//		print(a);
//		bubble(a);
//		System.out.println();
//		System.out.println("\nSorted array");
//		print(a);		
//	}
//
//	private static void bubble(int[] a) {
//		int maxI= a.length-1;
//		for(int i=0; i<=maxI;i++){
//			print(a);
//			for(int j=0; j<=maxI-1-i;j++){
//				if(a[j] > a[j+1]){
//					int temp = a[j];
//					a[j] = a[j+1];
//					a[j+1]= temp;
//				}
//			}
//		}
//		
//	}
//
//	private static void print(int[] a) {
//		System.out.println();
//		for(int i =0; i <a.length; i++){
//			System.out.print(a[i] + " ");
//		}
//		
//	}
//	
//}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	public static void main(String[] args){
////	int[] a ={2,3,4,1,6,7};
//	int[] a ={1,2,3,4,5,7};
//	System.out.println("Before sorting ...");
//	print(a);
//	bubble(a);
//	System.out.println("\nAfter sorting...");
//	print(a);
//}
//
//	private static void bubble(int[] a) {
//		int flag=0;
//		for(int i=0; i<a.length-1;i++){
//			
//			for(int j=0; j<a.length-2-i;j++){
//				if(a[j] > a[j+1]){
//					int temp =a[j];
//					a[j] = a[j+1];
//					a[j+1] = temp;
//					flag =1;
//				}			
//			}
//			if(flag==0) {
//				System.out.println("Already sorted");
//				break;
//			}
//		}
//		
//	}
//
//	private static void print(int[] a) {
//		for(int x =0; x<=a.length-1; x++){
//			System.out.print(a[x] + " ");
//		}
//		
//	}
//}
