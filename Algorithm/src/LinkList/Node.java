package LinkList;

public class Node {
	int val ;
	Node next = null;
	
	Node(int val){
		this.val = val;
	}
	
	public static void Print(Node head){
		if(head == null) return;
		Node node = head;
		while(node != null){
			System.out.print(node.val+"  ");
			node = node.next;
		}
	}
}
