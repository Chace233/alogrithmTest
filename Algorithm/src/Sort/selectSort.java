package Sort;

public class selectSort {
	public static void selectSort(int[] arr){
		int len = arr.length;
		if(len < 2){
			return;
		}
		for(int i = 0; i < len - 1; i++){
			int p = i;
			for(int j = i+1; j < len; j++){
				if(arr[p] > arr[j]){
					p = j;
				}
			}
			if(p != i){
				int n = arr[i];
				arr[i] = arr[p];
				arr[p] = n;
			}
		}
	}
	public static void main(String[] args){
		int[] arr = {2,4,6,8,9,7,5,3,1};
		selectSort.selectSort(arr);
		for(int i = 0; i < 9; i++){
			System.out.print(arr[i]+"  ");
		}
	}
}
