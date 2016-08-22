/*
*输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
*假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
*例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。 
*/
package Tree;

public class reConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = createTree(pre, 0, pre.length-1, in, 0, in.length-1);
        return root;
    }
    
    private TreeNode createTree(int[] pre, int left, int right, int[] in, int begin, int end){
    	if(left > right || begin > end){
    		return null;
    	}
    	TreeNode root =new TreeNode(pre[left]);
    	
    	for(int i = begin; i<=end; i++){
    		if(pre[left] == in[i]){
    			root.left = createTree(pre, left+1, left+i-begin, in, begin, i-1);
    			root.right = createTree(pre, left+i+1-begin, right, in, i+1, end);
    		}
    	}
    	return root;
    }
    
    public static void main(String[] args){
    	reConstructBinaryTree r = new reConstructBinaryTree();
    	int[] pre = {1,2,4,7,3,5,6,8};
    	int[] in = {4,7,2,1,5,3,8,6};
    	PrintTree.postPrint(r.reConstructBinaryTree(pre, in));
    }
}
