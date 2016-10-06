package Sort;

public class shellSort {
	public static void shellSort(int[] arr){
		int len = arr.length;
		if(len < 2) return ;
		int d = len;
		while(true){
			d = d/2;
			for (int i = 0; i < d; i++) {
				for (int j = i+d; j < len; j+=d) {
					int temp = arr[j];
					int p = j-d;
					for (; p >= 0 ; p = p-d) {
						if(arr[p] > temp){
							arr[p+d] = arr[p];
							arr[p] = temp;
						}
					}
				}
			}
			if(d == 1){
				break;
			}
		}
	}
	
	public static void main(String[] args){
		int[] arr = {2,4,6,8,9,7,5,3,1};
		shellSort.shellSort(arr);
		for(int i = 0; i < 9; i++){
			System.out.print(arr[i]+"  ");
		}
	}
}
