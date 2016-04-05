
public class SameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SameTree st = new SameTree();
		st.isSameTree(null, null);

	}
	
public int isSameTree(TreeNode a, TreeNode b) {
	    
	    boolean ret = check(a,b);
	    
	    if(ret)
	        return 1;
	    else
	        return 0;
	}
	
	public boolean check(TreeNode a, TreeNode b)
    {
        if((a==null && b!= null) || (b==null && a!= null))
            return false;
        
        if(a==null && b==null)
            return true;
        
        if(a.val != b.val)
            return false;
        
        boolean left = check(a.left, b.left);
        boolean right = check(a.right, b.right);
        
        if(!left || !right)
            return false;
        
        return true;
    }

}
