package Array;

public class FindNum {
	
	public boolean Find(int [][] array,int target) {
    	int row = array.length;
    	int column = array[0].length;
    	if(array == null || row == 0 || column == 0) return false;
    	for(int i = 0; i < row; i++){
    		if(array[i][column-1] < target){
    			continue;
    		}else{
    			if(find1(array[i], target))
    				return true;
    		}
    	}
    	return false;
    }
    
    private boolean find1(int[] arr, int t){
    	int len = arr.length;
    	if(len ==0 || arr == null) return false;
    	for(int i = 0; i < len; i++){
    		if(arr[i] == t) return true;
    	}
    	return false;
    }
    
    
	public static void main(String[] args){
		int[][] array = {{1,2,3,4,5},{2,3,4,5,6},{3,4,5,6,7},{4,5,6,7,8},{5,6,7,8,9}};
    	int target = 10;
    	FindNum f = new FindNum();
    	System.out.print(f.Find(array, target));
	}

}
