package mySort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapSort {
	public static List<Map.Entry<String, Integer>> sort(HashMap<String, Integer> map){
		List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		
		Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>(){
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return (o2.getValue() - o1.getValue());
			}
		});
		
		return entryList;
	}
	
	public static void main(String[] args){
		HashMapSort h = new HashMapSort();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("1", 1);
		map.put("2", 2);
		map.put("3", 3);
		map.put("4", 4);
		System.out.println(map.containsKey("5"));
		List<Map.Entry<String, Integer>> list = HashMapSort.sort(map);
		for(int i = 0;i < list.size(); i++){
			Entry<String, Integer> entry = list.get(i);
			System.out.println(entry.getKey()+"  "+entry.getValue());
		}
	}
}
