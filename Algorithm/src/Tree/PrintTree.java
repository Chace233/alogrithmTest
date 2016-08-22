package Tree;

public class PrintTree {
	public static void prePrint(TreeNode root){
		if(root == null) return;
		System.out.print(root.val +"  ");
		prePrint(root.left);
		prePrint(root.right);
	}
	
	public static void midPrint(TreeNode root){
		if(root == null) return ;
		midPrint(root.left);
		System.out.print(root.val+"  ");
		midPrint(root.right);
	}
	
	public static void postPrint(TreeNode root){
		if(root == null) return;
		postPrint(root.left);
		postPrint(root.right);
		System.out.print(root.val+"  ");
	}
}
