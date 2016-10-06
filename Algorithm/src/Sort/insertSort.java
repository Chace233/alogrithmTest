package Sort;

public class insertSort {
	public static void insertSort(int[] arr){
		int len = arr.length;
		if(len < 2){
			return;
		}
		for(int i = 1; i < len; i++){
			int temp = arr[i];
			int j = i-1;
			for(; j >= 0; j--){
				if(arr[j] >= temp){
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args){
		int[] arr = {2,4,6,8,9,7,5,3,1};
		insertSort.insertSort(arr);
		for(int i = 0; i < 9; i++){
			System.out.print(arr[i]+"  ");
		}
	}
}
