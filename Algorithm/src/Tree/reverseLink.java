package Tree;

public class reverseLink {
    public TreeNode reverse(int [] pre,int [] in) {
        TreeNode head =creatTree(pre,0 ,pre.length-1, in, 0, in.length-1);
        return head;
    }
    
    public TreeNode creatTree(int[] pre, int left, int right, int[] in, int begin, int end){
    	if(left > right || begin > end){
    		return null;
    	}
    	TreeNode root = new TreeNode(pre[left]);
    	
    	for(int i = begin; i <= end; i++){
    		if(pre[left] == in[i]){
    			root.left = creatTree(pre, left+1, left+i-begin, in, begin, i-1);
    			root.right = creatTree(pre, left+1+i-begin, right, in, i+1, end);
    		}
    	}
    	return root;
    }
    
    public static void main(String[] args){
    	int[] pre = {1,2,4,7,3,5,6,8};
    	int[] in = {4,7,2,1,5,3,8,6};
    	reverseLink r = new reverseLink();
    	TreeNode head = r.reverse(pre, in);
    	PrintTree.postPrint(head);
    }
}
