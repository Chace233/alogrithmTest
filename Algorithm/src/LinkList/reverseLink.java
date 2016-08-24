package LinkList;

public class reverseLink {
	public Node reverse(Node listNode){
		if(listNode == null) return null;
		
		Node head = listNode;
		Node oldHead = listNode;
		Node p = listNode.next;
		while(p != null){
			oldHead.next = p.next;
			p.next = head;
			head = p;
			p = oldHead.next;
		}
		
		return head;
	}
	
	public static void main(String[] args){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		reverseLink p = new reverseLink();
		Node head = p.reverse(n1);
		Node.Print(head);
	}
}
