package Sort;

public class heapSort {

	public static void maxify (int[] arr, int size, int i) {
		int left = 2*i+1;
		int right = 2*i+2;
		int largest = i;
		if (left < size && arr[left] > arr[i]) {
			largest = left;
		}
		if (right < size && arr[largest] < arr[right]) {
			largest = right;
		}
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
		}
		if(left >= size || right >= size){
			return;
		}
		maxify(arr, size, left);
		maxify(arr, size, right);
	}
	public static void buildMaxHeap (int[] arr) {
		int m = arr.length/2;
		for (int i = m; i >= 0; i--) {
			maxify(arr, arr.length, i);
		}
	}
	public static void heapSort (int[] arr) {
		buildMaxHeap(arr);
		int len = arr.length;
		for (int i = len-1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			len--;
			maxify(arr, len, 0);
		}	
	}
	
	public static void main (String[] args) {
		int[] arr = {2,4,6,8,9,7,5,3,1};
		heapSort.heapSort(arr);
		for(int i = 0; i < 9; i++){
			System.out.print(arr[i]+"  ");
		}
	}
}
