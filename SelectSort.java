package Practice1DS;

public class SelectSort {
	public static void main(String[] args){
	int[] a ={4,3,2,5,6,7,0};
//	int[] a ={4,3};
//	int[] a ={4};
//	int[] a ={};
	
	System.out.println("Unsorted Array");
	print(a);
	selectSort(a);
	System.out.println("\nSorted Array");
	print(a);		
}

	private static void selectSort(int[] a) {
		int maxI= a.length-1;
		if(maxI<=1) return;
		int min=0;
		for(int i =0; i<=maxI-1; i++){
			min=i;
			for(int j=i+1;j<=maxI; j++){
				if(a[min]>a[j]){
					min=j;
				}
			}
			int temp= a[i];
			a[i]=a[min];
			a[min]=temp;
		}
		
	}

	private static void print(int[] a) {
		for(int i=0; i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		
	}	

}
//practice 1
//	public static void main(String[] args){
//		//int[] a ={4,3,2,5,6,7};
//		int[] a ={4,3,2,5,6,7,1};
//		
//		System.out.println("Unsorted Array");
//		print(a);
//		selectSort(a);
//		System.out.println("\nSorted Array");
//		print(a);		
//	}
//	private static void selectSort(int[] a) {
//		if(a.length<=1) return;
//		int min = 0;
//		for(int i=0; i<a.length-1;i++){
//			print(a);
//			min=i;
//			for(int j=i+1; j<a.length;j++){
//				if(a[i]>a[j]){
//					min=j;
//				}
//			}
//			int temp;
//			temp=a[i];
//			a[i]=a[min];
//			a[min]=temp;
//		}		
//	}
//	private static void print(int[] a) {
//		System.out.println();
//		for(int i=0; i < a.length;i++){
//			System.out.print(a[i]+" ");
//		}
//		
//	}
//	
//}
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
	
//	
//	public static void main(String[] args){
//		int[] a = {2,3,6,7,1,5};
//		System.out.println("\nBefore Sorting....");
//		print(a);
//		selectionSort(a);
//		System.out.println("\nAfter Sorting....");
//		print(a);
//	}
//
//	private static void selectionSort(int[] a) {
//		for(int i=0;i<a.length-2;i++ ){
//			int min= i;
//			for(int j=i+1;j<a.length-1;j++){
//				if(a[i] > a[j]){
//					min =j;
//				}
//			}
//			int temp = a[i];
//			a[i] =a[min];
//			a[min] = temp;
//		}
//		
//	}
//
//	private static void print(int[] a) {
//		
//		for(int x =0; x<a.length;x++){
//			System.out.print(a[x] + " ");
//		}
//		
//	}
//}
