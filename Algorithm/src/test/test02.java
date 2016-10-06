package test;

import java.util.HashMap;
import java.util.Scanner;

public class test02 {

	public static void main(String[] args){
		int n=0, initSize=0;
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			n = in.nextInt();
			initSize = in.nextInt();
			
			if(n < 1 || n > 10000 || initSize < 1 || initSize > 10000){
				return;
			}
			
			Scanner input = new Scanner(System.in);
			int[] arr = new int[initSize];
			int handle = 0;
			HashMap<Integer, int[]> map = new HashMap<Integer, int[]>(); 
			for(int i = 0; i < n; i++){
				String line = input.nextLine();
				System.out.println(line);
				String c = line.substring(0, line.indexOf(' '));
				int n1 = Integer.parseInt(line.substring(line.indexOf(' ')+1));
				if(c.equalsIgnoreCase("new")){
					int res = myNew(arr, n1, handle, map);
					if(res == -1){
						System.out.println("NULL");
					}else{
						handle++;
						System.out.println(handle);
					}
				}else if(c.equalsIgnoreCase("del")){
					boolean d = del(arr, handle, map);
					if(d == false){
						System.out.println("ILLEGAL_OPERATION");
					}
				}else if(c.equalsIgnoreCase("def")){
					def(arr, map, handle);
				}
			}
		}
	}
	
	public static int myNew(int[] arr,int n,int handle, HashMap map){
		if(kong(arr) < n){
			return -1;
		}
		int count = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == 0){
				count ++;
			}else if(arr[i] == 0){
				count = 0;
			}
			if(count >= n){
				int[] b = new int[2];
				b[0] = i-n;
				b[1] = i;
				handle ++;
				map.put(handle, b);
				return handle;
			}
		}
		return -1;
	}
	
	public static boolean del(int[] arr, int handle, HashMap map){
		if(map.containsKey(handle)){
			int[] b = (int[]) map.get(handle);
			for(int i = b[0]; i < b[1]; i++){
				arr[i] = 0;
			}
			return true;
		}
		return false;
	}
	
	public static void def(int[] arr, HashMap map, int count){
		for(int j = 1; j < count; j++){
			for(int i = 0; i <arr.length; i++){
				if(map.containsKey(j)){
					int[] b = (int[])map.get(j);
					int cha = b[0]-i;
					int size = b[1]-b[0];
					b[0] = i;
					b[1] = b[1]-cha;
					i += size;
					map.put(i, b);
				}
			}
		}
	}
	
	public static int kong(int[] arr){
		int count = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == 0){
				count ++;
			}
		}
		return count;
	}
}
