	/*
	 * 思路：
	 * ABC: A:100  B:10  C:1  
	 * BCA: B:100  C:10  A:1
	 * 所以A的权值可以这么计算：100+1=101
	 *    B的权值：100+10＝110；
	 *    C的权值：10+1=11；
	 *    排序之后  B:110->9   A:101->8   C:11->7   最后的结果为 990+808+77=1875
	 *    其实最后的运算与ABC代表哪个数字没什么关系
	 *    
	 */
package other;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class maxMapping {
	public static void main(String[] args){
		int n = 0;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < n; i++) {
			Scanner in1 = new Scanner(System.in);
			String str = in1.nextLine();
			if(str.length() > 12) return;
			list.add(str);
		}
		int result = maxMapping.MaxSum(list);
		System.out.println(result);
	}
	
	
	public static int MaxSum(ArrayList<String> list){
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int size = list.size();
		for (int i = 0; i < size; i++) {
			String str = list.get(i);
			for(int j = 0; j < str.length(); j++){
				char ch = str.charAt(j);
				if(map.containsKey(ch)){
					int val = map.get(ch);
					val = (int) (val+Math.pow(10, (str.length()-j-1)));
					map.put(ch, val);
				}else{
					map.put(ch, (int) Math.pow(10, (str.length()-j-1)));
				}
			}
		}
		
        List<Map.Entry<Character, Integer>> list1 = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());  
        Collections.sort(list1, new Comparator<Map.Entry<Character, Integer>>() {  
            //降序排序  
            @Override  
            public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());  
            }  
        });
        System.out.println(list1);
        int maxSum = 0;
        int nu = 9;
        for(Map.Entry<Character, Integer> mapping : list1){
        	maxSum += mapping.getValue() * nu;
        	nu--;
        }
        return maxSum;
	}
}
