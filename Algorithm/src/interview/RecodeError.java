package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RecodeError {
	
	private static List<Map.Entry<String, Integer>> MapSort(HashMap<String, Integer> map){
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return (o2.getValue()-o1.getValue());
			}
			
		});
		return list;
	}
	
	public static HashMap<String, Integer> Error(String[] err){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		if(err == null) return map;
		for(int i = 0; i < err.length; i++){
			String el = err[i];
			if(map.containsKey(el)){
				int num = map.get(el);
				map.put(el, num+1);
			}else{
				map.put(el, 1);
			}
		}
		return map;
	}
	
	private static void Print(List<Map.Entry<String, Integer>>list){
		if(list == null) return ;
		for(int i = 0; i < (list.size()>8? 8:list.size()); i++){
			Entry<String, Integer> entry = list.get(i);
			String line = entry.getKey();
			
			line = subStr(line);
			System.out.println(line+"   "+entry.getValue());
		}
	}
	
	private static String subStr(String str){
		str = str.trim();
		String path = str.substring((str.lastIndexOf('\\'))+1, (str.lastIndexOf(" ")));
		String line = str.substring(str.lastIndexOf(" "), str.length());
		if(path.length() > 16){
			path = path.substring(path.length()-16, path.length());
		}
		return path+line;
	}
	
	public static void recoder(String[] err){
		HashMap<String, Integer> map = Error(err);
		List<Map.Entry<String, Integer>> list = MapSort(map);
		Print(list);
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args){
		RecodeError re = new RecodeError();
		String[] err = {"e:\\1\\aa3.txt 3",
				        "e:\\3\\aa1.txt 2",
			      	    "e:\\2\\aa2.txt 3",
				        "e:\\3\\aa1.txt 1",
				        "e:\\1\\aa1.txt 3",
				        "e:\\3\\aa1.txt 2",
				        "e:\\1\\aa3.txt 3",
				        "e:\\2\\aa3.txt 2",
				        "e:\\3\\aa3.txt 2",
				        "e:\\1\\aa2.txt 2",
				        "e:\\1\\aa3.txt 1",
				        "e:\\1\\aa3.txt 1",
				        "e:\\2\\aa3.txt 2",
				        "e:\\1\\aa2.txt 1",
				        "e:\\3\\aa1.txt 2",
				        "e:\\1\\aa1.txt 3",
				        "e:\\2\\aa1.txt 1" };//e:\3\aa3.txt 2 e:\1\aa1.txt 1 e:\2\aa2.txt 2 e:\3\aa3.txt 2 e:\1\aa2.txt 1 e:\1\aa3.txt 2 e:\1\aa3.txt 3 e:\1\aa2.txt 3 e:\3\aa1.txt 3 e:\2\aa2.txt 2 e:\1\aa1.txt 1 e:\2\aa3.txt 1 e:\3\aa1.txt 1 e:\2\aa1.txt 3 e:\3\aa3.txt 2 e:\1\aa3.txt 3 e:\2\aa3.txt 3 e:\1\aa2.txt 3 e:\2\aa2.txt 1 e:\1\aa3.txt 1 e:\1\aa3.txt 1 e:\3\aa3.txt 3 e:\3\aa3.txt 2 e:\1\aa2.txt 3 e:\1\aa2.txt 3 e:\1\aa2.txt 3 e:\1\aa1.txt 1 e:\2\aa3.txt 1 e:\3\aa3.txt 1 e:\2\aa3.txt 2 e:\3\aa1.txt 3 e:\2\aa2.txt 2 e:\2\aa2.txt 2 e:\2\aa3.txt 1 e:\1\aa3.txt 3 e:\3\aa1.txt 2 e:\3\aa2.txt 2 e:\1\aa2.txt 1 e:\2\aa2.txt 1 e:\2\aa1.txt 2 e:\2\aa2.txt 1 e:\1\aa2.txt 1 e:\2\aa3.txt 1 e:\2\aa2.txt 1 e:\2\aa1.txt 2 e:\3\aa2.txt 3 e:\3\aa1.txt 3 e:\2\aa2.txt 3 e:\2\aa3.txt 1 e:\3\aa3.txt 2 e:\2\aa3.txt 1 e:\1\aa1.txt 2 e:\3\aa3.txt 1 e:\3\aa1.txt 1 e:\2\aa2.txt 3 e:\3\aa3.txt 2 e:\2\aa1.txt 3 e:\1\aa3.txt 3 e:\3\aa2.txt 1 e:\2\aa1.txt 3 e:\1\aa3.txt 3 e:\2\aa2.txt 2 e:\1\aa1.txt 2 e:\3\aa1.txt 1 e:\1\aa3.txt 1 e:\3\aa1.txt 2 e:\1\aa1.txt 2 e:\1\aa1.txt 3 e:\3\aa1.txt 1 e:\3\aa1.txt 1 e:\2\aa3.txt 3 e:\2\aa2.txt 1 e:\2\aa1.txt 2 e:\2\aa2.txt 1 e:\3\aa2.txt 3 e:\1\aa2.txt 1 e:\3\aa2.txt 2 e:\2\aa1.txt 1 e:\2\aa3.txt 3 e:\1\aa1.txt 2 e:\1\aa1.txt 1 e:\1\aa1.txt 2 };
		re.recoder(err);
	}
}
