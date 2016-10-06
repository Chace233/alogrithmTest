package Sort;

public class paoSort {
	public static void paoSort(int[] arr){
		int len = arr.length;
		if(len < 2){
			return;
		}
		for(int i = 1; i < len; i++){
			for(int j = 0; j < len-i; j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args){
		int[] arr = {2,4,6,8,9,7,5,3,1};
		paoSort.paoSort(arr);
		for(int i = 0; i < 9; i++){
			System.out.print(arr[i]+"  ");
		}
	}
}
