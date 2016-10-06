package Tree;

public class Mirror {
	public static void Mirror(TreeNode root){
		if(root == null) return ;
		else{
			TreeNode node = root.left;
			root.left = root.right;
			root.right = node;
			if(root.left != null){
				Mirror(root.left);
			}
			if(root.right != null){
				Mirror(root.right);
			}
		}
	}
}
