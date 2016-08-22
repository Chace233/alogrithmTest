package Tree;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class PrintTree2 {
	public static void preOrder(TreeNode root){
		if(root == null) return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			if(node != null)
				System.out.print(node.val+"  ");
			if(node.right != null) stack.push(node.right);
			if(node.left != null) stack.push(node.left);
		}
	}
	
	public static void midOrder(TreeNode root){
		if(root == null) return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		while(node != null || !stack.isEmpty()){
			while(node != null){
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			System.out.print(node.val+"  ");
			node = node.right;
		}
	}
	
	public static void postOrder(TreeNode root){
		if(root == null) return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Map<TreeNode, Boolean> map = new HashMap<TreeNode, Boolean>();
		stack.push(root);
		while(! stack.isEmpty()){
			TreeNode node = stack.peek();
			if(node.left != null && !map.containsKey(node.left)){
				node = node.left;
				while(node != null){
					if(map.containsKey(node)) break;
					else stack.push(node);
					node = node.left;
				}
				continue;
			}
			if(node.right != null && !map.containsKey(node.right)){
				stack.push(node.right);
				continue;
			}
			TreeNode node1 = stack.pop();
			map.put(node1, true);
			System.out.print(node1.val+"  ");
		}
	}
	
	public static void levelOrder(TreeNode root){
		if(root == null) return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			System.out.print(node.val +"  ");
			if(node.left != null)
				queue.add(node.left);
			if(node.right != null)
				queue.add(node.right);
		}
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args){
		PrintTree2 p = new PrintTree2();
		
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		n3.left = n6; n3.right = n7;
		n4.left = n8; n4.right = n9;
		
		System.out.println("前序遍历：");
		p.preOrder(n1);
		System.out.println();
		System.out.println("中序遍历：");
		p.midOrder(n1);
		System.out.println();
		System.out.println("后序遍历：");
		p.postOrder(n1);
		System.out.println();
		System.out.println("安装输出：");
		p.levelOrder(n1);
	}
}
