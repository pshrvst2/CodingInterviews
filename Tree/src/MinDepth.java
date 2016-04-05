
public class MinDepth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minDepth(TreeNode a) {
		
	    return depth(a);
	}

	public int depth(TreeNode a)
	{
		if(a==null)
			return 0;
		if(a.left==null && a.right==null)
		    return 1;
        
        if (a.left == null)
            return depth(a.right) + 1;
  
        // If right subtree is NULL, recur for right subtree
        if (a.right == null)
            return depth(a.left) + 1;
       
		int left = depth(a.left);
		int right = depth(a.right);

		return Math.min(left,right)+1;
	}

}
