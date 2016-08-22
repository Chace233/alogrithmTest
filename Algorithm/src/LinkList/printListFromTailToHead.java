package LinkList;

import java.util.ArrayList;
import java.util.Collections;

public class printListFromTailToHead {
	public ArrayList<Integer> printListFromTailToHead(Node listNode){
		ArrayList<Integer> list = new ArrayList<Integer>();
		Node node = listNode;
		while(node != null){
			list.add(node.val);
			node = node.next;
		}
		Collections.reverse(list);
		return list;
	}
	
	public static void main(String[] args){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		printListFromTailToHead p = new printListFromTailToHead();
		System.out.print(p.printListFromTailToHead(n1));
	}
}
