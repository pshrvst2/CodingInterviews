import java.util.List;


public class ArrayBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode sortedArrayToBST(final List<Integer> a) {
		
		if(a==null)
			return null;
		
		return createTree(a, 0, a.size()-1);
	}
	
	public TreeNode createTree(final List<Integer> a, int start, int end)
	{
		if(start>end)
			return null;
		
		int mid = (start+end)/2;
		
		TreeNode node = new TreeNode(a.get(mid));
		
		/* construct the left subtree */
       node.left = createTree(a, start, mid - 1);

       /* construct the right subtree */
       node.right = createTree(a, mid + 1, end);
        
       return node;
	}

}
