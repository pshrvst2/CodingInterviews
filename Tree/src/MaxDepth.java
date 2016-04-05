
public class MaxDepth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxDepth(TreeNode a) {

		return depth(a);
	}

	public int depth(TreeNode a)
	{
		if(a==null)
			return 0;

		int left = depth(a.left);
		int right = depth(a.right);

		return Math.max(left,right)+1;
	}

}
