package Practice1DS;

public class InsertionSort {
	public static void main(String[] args){
	//Practice 1
//	int[] a ={3,1,4,5,7,0,2};
//	int[] a ={3,1};
//	int[] a ={3};
//	int[] a ={};
//	int[] a ={4,3,2,1};
	int[] a ={1,2,3,4};
	System.out.println("Unsorted Array");;
	print(a);
	insertSort(a);
	System.out.println("\nSorted Array");;
	print(a);
	}
	private static void insertSort(int[] a) {
		for(int i=1; i<a.length;i++){
			int hole = i;
			int value = a[hole];
			while(hole>0 && a[hole-1] > value){
				a[hole] = a[hole-1] ;
				hole--;
			}
			a[hole]=value;
		}
		
	}


	private static void print(int[] a) {
		for(int i :a){
			System.out.print(i + " ");
		}
		
	}
	
}
//	
//	public static void main(String[] args){
////		int[] a ={3,5,6,7,2,8};
////		int[] a ={1,2,3,4,5};
//		int[] a ={4,3,2,1};
//		System.out.println("Before Sorting....");
//		print(a);
//		insertionSorting(a);
//		System.out.println("\nAfter Sorting....");
//		print(a);		
//	}
//	private static void insertionSorting(int[] a) {
//		int value =0;
//		int hole =0;
//		for(int i=1; i<a.length; i++){
//			value =a[i];
//			hole=i;
//			while(hole>0 && a[hole-1] > value){
//				a[hole] = a[hole-1];
//				System.out.println("swapped");
//				hole--;
//			}
//			a[hole] = value;
//		}
//		
//	}
//	private static void print(int[] a) {
//		for(int x=0; x<a.length;x++){
//			System.out.print(a[x]+" ");
//		}		
//	}
//}
