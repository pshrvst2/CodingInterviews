
public class SymmetryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
public int isSymmetricTree(TreeNode a) {
	    
	    int ret = checkForSymm(a.left, a.right);
	    
	   return ret;
	}
	
	public int checkForSymm(TreeNode left, TreeNode right)
  {
      if(left==null && right==null)
          return 1;
      else if(left==null || right == null)
          return 0;
          
      int x = checkForSymm(left.left, right.right);
      int y = checkForSymm(left.right, right.left);
      
      if(x==0 || y==0)
          return 0;
      
      return 1;
  }


}
