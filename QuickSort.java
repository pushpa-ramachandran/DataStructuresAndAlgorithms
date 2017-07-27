package Practice1DS;

public class QuickSort {
	public static void main(String[] args){
		int[] a ={10,7,1,9,8,0,4};
		System.out.println("Before sorting");
		print(a);
		quickSort(a,0,a.length-1);
//		System.out.println(partition(a,0,a.length-1));
		System.out.println("\nAfter sorting");
		print(a);
		
	}

	private static void quickSort(int[] a, int start, int end) {
		if(start<end){
		int i = partition(a,start,end);
		quickSort(a,start,i-1);
		quickSort(a,i+1,end);}
		
	}

	private static int partition(int[] a, int start, int end) {
		int pivot = a[end];
		int pIndex =start;
		for(int i=start;i<=end-1;i++){
			if(a[i]<=pivot){
				int t = a[pIndex] ;
				a[pIndex]=a[i];
				a[i]=t;
				pIndex++;
			}
			print(a);
		}
		int t2 = a[pIndex];
		a[pIndex]=a[end];
		a[end] = t2;
		return pIndex;
	}


	private static void print(int[] a) {
		System.out.println();
		for(int i : a) System.out.print(i+" ");		
	}
}
