package mianshiti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class maxShine {
	public int maxShine(int n){
		int result = 0;
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0;i < n; i++){
			Scanner in = new Scanner(System.in);
			System.out.println("Please enter a string: ");
			String input = in.nextLine();
			list.add(input);
		}
		
		int num = list.size();
		int len = ((String) list.get(0)).length();
		for(int j = 0; j < num; j++){
			String str = list.get(j);
			for(int p = 0;p < len; p++){
				char c = str.charAt(p);
				if(map.containsKey(c)){
					int value = map.get(c);
					map.put(c, value+p);
				}
			}
		}
		return result;
	}
	
	private static List<Map.Entry<String, Integer>> sort(HashMap map){
		List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		
		Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>(){

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return (o2.getValue()-o1.getValue());
			}
		});
		return entryList;
	}
	
}
