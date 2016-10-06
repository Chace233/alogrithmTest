package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		String n = "";
		Scanner in = new Scanner(System.in);
		n = in.nextLine();
		long res = Main.A(n);
		System.out.println(res);
		//while(in.hasNext()){
			
			//String [] ts = new String[n];
			//Scanner inp = new Scanner(System.in);
			//for(int i = 0; i < n; i++){
			//	ts[i] = inp.nextLine();
			//}
			//String res = Main.sortFunc(ts);
			//System.out.println(res);
		//}
			
	}
	
	public static int A(String str){
		int sum = 0;
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < str.length()-1; i++){
			for(int j = i+1; j < str.length(); j++){
				if((j-i+1) % 2 ==0){
					String strr1 = str.substring(i, (i+(j-i+1)/2));
					String strr2 = str.substring((i+(j-i+1)/2), j+1);
					//System.out.println(strr1+"   "+strr2);
					if(strr1.compareTo(strr2) == 0){
						if(!list.contains(strr1)){
							list.add(strr1);
							sum ++;
						}
					}
				}
			}
		}
		return sum;
	}
	
	public static long minB(long n){
		String str = "0"+Long.toBinaryString(n);
		//System.out.println(str);
		int count1 = 0;
		StringBuilder sb=new StringBuilder(str);
		System.out.println("sb"+sb);
		for(int i = str.length()-1; i > 0; i--){
			if(str.charAt(i) == '1' && str.charAt(i-1) == '0'){
				sb.setCharAt(i,'0');
				sb.setCharAt(i-1,'1');
				System.out.println("0:"+count1);
				if(count1 > 0){
					System.out.println("111");
					for(int j = i+1; j < sb.length(); j++){
						System.out.println(sb);
						if(count1 != 0){
							sb.setCharAt(j,'0');
							count1--;
						}else {
							sb.setCharAt(j,'1');
						}
					}
				}
			}
			if(str.charAt(i) == '0'){
				count1 ++;
			}
		}
		return Long.valueOf(sb.toString(),2) ;
	}
	
	////////////////////////////////////////////////////////////////////////////
	public static int minA(int a, int b, int c){
		int min = b;
		int minsub = c;
		int c1 = susum(c);
		for(int i = a; i <= b; i++){
			int nn = susum(i);
			if(Math.abs((c1-nn)) < minsub){
				minsub = Math.abs((c1-nn));
				min = i;
			}
		}
		return min;
	}
	
	public static int susum(int a){
		int sum = 0;
		int b = a;
		if(b < 10) return b;
		while(b > 0){
			sum += (b%10);
			b = b / 10;
		}
		return sum;
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	public static int makeFibonacciNum(int n){
		ArrayList<Integer> list = Fibonacci(n);
		int num1 = list.get(list.size()-1);
		int num2 = list.get(list.size()-2);
		return ((num1-n)<(n-num2)?(num1-n):(n-num2));
	}
	public static ArrayList<Integer> Fibonacci(int n){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		for(int i = 2; i < n; i++){
			int num1 = list.get(i-2);
			int num2 = list.get(i-1);
			list.add(num1+num2);
			if((num1+num2) > n){
				break;
			}
		}
		return list;
	}
	
	///////////////////////////////////////////////////////////////////////////////
	public static String sortFunc(String[] arr){
		if(arr == null) return "both";
		int flag = -1;
		for(int i = 0; i < arr.length-1; i++){
			if(arr[i].compareTo(arr[i+1]) < 0 && arr[i].length()<arr[i+1].length() && (flag==-1||flag==3)){
				flag = 3;
			}else if(arr[i].compareTo(arr[i+1]) < 0 && (flag == -1 || flag == 3 || flag == 1)){
				flag = 1;
			}else if(arr[i].length() < arr[i+1].length() &&  (flag == -1 || flag == 3 || flag==2)){
				flag = 2;
			}else {
				flag = 0;
			}
		}
		if(flag == 1){
			return "lexicographically";
		}else if(flag == 2){
			return "lengths";
		}else if(flag == 3){
			return "both";
		}
		return "none";
		
	}
	
	////////////////////////////////////////////////////////////////////////
	public static int minSec(int[][] arr,int n){
		if(arr == null) return 0;
		int[] res = new int[n];
		for(int i = 0; i < n; i++){
			res[i] = (arr[0][i] + arr[1][i] - 2) ;
		}
		
		Arrays.sort(res);
		return res[0];
	}
	
	/////////////////////////////////////////////////////////////////////////
	
	
	public static int PrintMinNumber(int [] numbers) {
        int n;
        String s="";
        ArrayList<Integer> list= new ArrayList<Integer>();
        n=numbers.length;
        for(int i=0;i<n;i++){
        	list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>(){
  
        	public int compare(Integer str1,Integer str2){
        		String s1=str1+""+str2;
        		String s2=str2+""+str1;
        		return (s2.compareTo(s1));
        	}
        });
  
        for(int j:list){
        	s+=j;
        }
        return Integer.parseInt(s);
    }
	
	
///////////////////////////////////////////////////////////////////////////////////////////
	public static boolean CompareTo(String a,String b){
		int lena = a.length();
		int lenb  = b.length();
		if(lena == lenb) return a.compareTo(b)>0;
		else if(lena > lenb){
			for(int i = 0;i < lenb;i++){
				if(a.charAt(i) > b.charAt(i)) return true;
			}
			return CompareTo(a.substring(lenb,lena),b);
		}
		else {
			for(int i = 0;i < lena;i++){
				if(a.charAt(i) > b.charAt(i)) return true;
			}
			return CompareTo(a,b.substring(lena,lenb));
		}
	}

	public static void selectSort(String[] num){
		for(int i = 0;i < num.length;i++){
			int n = i;
			for(int j = i+1;j < num.length;j++){
				if(!CompareTo(num[n],num[j]) ) n = j;
			}
			if(n != i){
				String temp = num[n];
				num[n] = num[i];
				num[i] = temp;
			}
		}
	}
	public static int PrintMaxNumber(int [] numbers) {
		if(numbers == null || numbers.length==0) return 0;
		String[] num = new String[numbers.length];
		for(int i = 0;i < numbers.length;i++){
			num[i]=numbers[i]+"";
		}
		selectSort(num);
		String result  = num[0];
		for(int i = 1;i < num.length;i++){
			result += num[i];
		}
		result = result.trim();
		return Integer.parseInt(result);
	}
///////////////////////////////////////////////////////////////////////////////////////////
	
	public static int numOfT(int n , int[] ts){
		Arrays.sort(ts);
		int num = 0;
		if(n == 1){
			return 2;
		}
		if(n == 2){
			
		}
		for(int i = 0; i < ts.length; i+=3){
			if(ts[i+2]-ts[i+1] > 10){
				
			}else if(ts[i+1]-ts[i] > 10){
				
			}
		}
		return num;
	}
	
	
	
	public static int numOfLine(int[][] ps, int p, int n){
		int sum = 0;
		for(int i = 0; i < p; i++){
			int cha = (ps[i][1] - ps[i][0] > 0)?(ps[i][1] - ps[i][0]) : (ps[i][0] - ps[i][1]);
			if(cha < n/2){
				sum += cha;
			}else{
				sum += (n - cha);
			}
		}
		return sum;
	}
	
	public static int[] numAB(String str,int k){
		int[] result = new int[2];
		String res = "";
		for(int i = 0; i < k; i++){
			String strr = "";
			for(int j = 0; j < str.length(); j++){
				if(str.charAt(j) == 'A'){
					strr += "B";
				}else if(str.charAt(j) == 'B'){
					strr += "BA";
				}
			}
			str = strr;
			res = strr;
		}
		for(int i = 0; i < res.length(); i++){
			if(res.charAt(i) == 'A'){
				result[0] ++;
			}else if(res.charAt(i) == 'B'){
				result[1] ++;
			}
		}
		return result;
	}
	
    public static int LastRemaining_Solution(int n, int m) {
        if(n < 1) return -1;
        if(n == 1) return n;
        int count = 0;
        int i = -1;
        int c = 0;
        int[] num = new int[n];
        while(count < n){
            i++;
            if(i == n) i = 0;
            if(num[i] == -1) {
                continue;
            }
            c++;
            if(c % m == 0) {
                num[i] = -1;
                count ++;
            }
        }
        return i;
    }
	
	public static int MoreThanHalfNum_Solution(ArrayList array) {
        int len = array.size();
        if(len == 0) return 0;
        int temp = (int)array.get(0);
        int count = 0;
        for(int i = 0;i < len;i++){
        	if((int)array.get(i) == temp)
        		count++;
        	else if(count > 0)
        		count --;
        	else{
        		temp = (int) array.get(i);
        		count = 1;
        	}
        }
        count = 0;
        for(int i = 0;i < len;i++){
        	if((int)array.get(i) == temp)
        		count++;
        }
        return count>(len/2) ? temp:-1;
    }
	
	public static String maxLine(String str1, String str2) {
       str1 = str1.toLowerCase();  
       str2 = str2.toLowerCase();  
       int len1 = str1.length();  
       int len2 = str2.length();  
       String min = null;  
       String max = null;  
       String target = null;
       min = len1 <= len2 ? str1 : str2;
       max = len1 >  len2 ? str1 : str2;
       //最外层：min子串的长度，从最大长度开始
       for (int i = min.length(); i >= 1; i--) {
           //遍历长度为i的min子串，从0开始
           for (int j = 0; j <= min.length() - i; j++) {  
               target = min.substring(j, j + i);  
               //遍历长度为i的max子串，判断是否与target子串相同，从0开始
               for (int k = 0; k <= max.length() - i; k++) {  
                   if (max.substring(k,k + i).equals(target)) {  
                       return max.substring(k,k + i);  
                   }
               }
           }
       }  
       return "";  
	}
	

}
