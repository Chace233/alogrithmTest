import Tree.PrintTree;
import Tree.PrintTree2;
import Tree.TreeNode;

public class Main {
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
