package Sort;

public class insertSort {
	public static void insertSort(int[] arr){
		int len = arr.length;
		if(arr == null || len < 2) return;
		for(int i = 1; i < len; i++){
			int temp = arr[i];
			for(int j = i-1; j >= 0; j--){
				if(temp < arr[j]){
					arr[j+1] = arr[j];
					arr[j] = temp;
				}else{
					break;
				}
			}
		}
	}
	
	public static void main(String[] args){
		int[] arr = {1,3,6,5,2,4};
		insertSort.insertSort(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i]+"  ");
		}
	}
}
