/*
* 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
* 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
* 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
* NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
* 
* 说白了就是查找数组中的最小元素，但是注意这个数组有两部分是排序的  并且有特殊情况{1,0,1,1,1}这个也是{0,1,1,1,1};的旋转
 */
package Array;

public class minNumberInRotateArray {
	public static int minNumberInRotateArray(int[] arr){
		int left = 0, right = arr.length-1;
		if(arr == null || right < 0) return 0;
		if(arr[left] != arr[right]) return minNum(arr, left, right);
		else return min(arr);
	}
	
	private static int minNum(int[] arr, int left, int right){
		if(arr == null || right < 0) return 0;
		int mind = (left+right)/2;
		if(left == mind || right == mind) return arr[left]<arr[right] ? arr[left] :arr[right];
		if(arr[left] < arr[mind]) left = mind;
		else if(arr[right] > arr[mind]) right = mind;
		
		return minNum(arr, left, right);
	}
	
	private static int min(int[] arr){
		int len = arr.length;
		if(arr == null || len == 0) return 0;
		int min = Integer.MAX_VALUE;
		for(int i = 0;i<len; i++){
			if(min > arr[i]){
				min = arr[i];
			}
		}
		return min;
	}
	
	public static void main(String[] args){
		int[] arr = {1,1,0,1,1};
		System.out.print(minNumberInRotateArray.minNumberInRotateArray(arr));
	}
}
