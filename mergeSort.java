package Practice1DS;

public class mergeSort {
	public static void main(String[] args){
//		int[] a = {5,2,6,88,9,10,3,11,0};
//		int[] a = {5,2};
//		int[] a = {50};
//		int[] a = {};
//		int[] a = {1,2,3,4,5};
		int[] a = {5,4,3,2,1};
		System.out.println("Unsorted");
		print(a);
		mergesort(a);
		System.out.println();
		System.out.println("Sorted");
		print(a);
	}

	private static void mergesort(int[] a) {
		if(a.length<=1) return;
		int mid = a.length/2;
		int[] left= new int[mid];
		int[] right= new int[a.length-mid];
		for(int i =0; i<mid; i++){
			left[i]=a[i];			
		}
		for(int i =mid; i<a.length; i++){
			right[i-mid]=a[i];			
		}
//		System.out.println("\nLeft");
//		print(left);
//		
//		System.out.println("\nRight");
//		print(right);
		mergesort(left);
		mergesort(right);
		merge(left,right,a);
		
	}

	private static void merge(int[] left, int[] right, int[] a ) {
		int i = 0;
		int j = 0;
		int n=0;
		while(i<left.length && j<right.length){
			if(left[i] <= right[j]){
				a[n]=left[i];
				i++;n++;
			}
			else if(left[i] > right[j]){
				a[n]=right[j];
				j++;n++;
			}
			
		}
		while(i<left.length){
			a[n] = left[i];
			i++;n++;
		}
		while(j<right.length){
			a[n] = right[j];
			j++;n++;
		}
		
		
	}

	private static void print(int[] a) {
		for(int i:a)
			System.out.print(i+" ");
		
	}
	
}
	
//	
//	public static void main(String[] args){
//		int[] a ={4,3,2,1,5,8,7,6,10,9};
////		int[] a =new int[10];
////		int[] L = {1,2,5,6,10};
////		int[] R = {0,3,4,7,9};
//		mergeSort(a);
////		merge(L,R,a);
//		System.out.println();
//		print(a);
//	}
//
//	private static void mergeSort(int[] a) {
//		int mid = a.length/2;
//		if(a.length<2) return;
//		int[] left = new int[mid];
//		int[] right = new int[a.length-mid];
//		for(int li= 0;li<mid;li++){
//			left[li] = a[li];
//		}
//		System.out.println("\nLeft");
//		print(left);
//		for(int ri=0; ri<right.length; ri++){
//			right[ri]=a[ri+mid];
//		}
//		System.out.println("\nRight");
//		print(right);
//		mergeSort(left);
//		mergeSort(right);
//		merge(left,right,a);	
//	}
//
//	private static void merge(int[] l, int[] r, int[] a) {
//		int lenthL=l.length;
//		int lenthR=r.length;
//		int i=0, j=0, k =0;
//		while(i<lenthL && j<lenthR){
//			if(l[i] <= r[j]){
//				a[k]=l[i];
//				i++;k++;
//			}
//			else{
//				a[k]=r[j];
//				j++;k++;
//			}
//		}
//		while(j<lenthR){
//			a[k]=r[j];
//			j++;k++;
//		}
//		while(i<lenthL){
//			a[k]=l[i];
//			i++;k++;
//		}		
//	}
//
//	private static void print(int[] a) {
//		for(int i=0; i<a.length;i++){
//			System.out.print(a[i] + " ");
//		}
//		
//	}
//
//}
