package mySort;

import Array.printArray;

public class heapSort {
	public static void createMaxHeap(int[] data, int lastIndex){
		for(int i = (lastIndex-1)/2 ; i >= 0; i--){
			int k = i;
			
			while(2*k+1 <= lastIndex){
				int biggerIndex = 2*k+1;
				if(biggerIndex < lastIndex){
					if(data[biggerIndex] < data[biggerIndex+1]){
						biggerIndex++;
					}
				}
				if(data[k] < data[biggerIndex]){
					swap(data, k, biggerIndex);
					k = biggerIndex;
				}else{
					break;
				}
			}
		}
	}
	
	public static void heapsort(int[] data){
		if(data.length < 2) return;
		for(int i = 0; i < data.length; i++){
			createMaxHeap(data,data.length-1-i);
			swap(data, 0, data.length-i-1);
			printArray.Print(data);
			System.out.println();
		}
	}
	
	public static void swap(int[] data, int k, int b){
		if(k > data.length || b > data.length){
			System.out.println("输入的值超出了数据的长度");
			return;
		}
		int temp = data[k];
		data[k] = data[b];
		data[b] = temp;
	}
	
	public static void main(String[] args){
		int[] data = {1,3,4,5,8,7,2,6};
		heapSort.heapsort(data);
		printArray.Print(data);
	}
}
