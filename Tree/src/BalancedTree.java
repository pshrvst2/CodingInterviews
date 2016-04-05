
public class BalancedTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int retVal = isBalanced(null);

	}

	public static int isBalanced(Node a) 
	{

		if(a==null)
			return 1;

		if(fetchNodeHeight(a)==-1)
		{
			return 0;
		}

		return 1;
	}

	public static int fetchNodeHeight(Node b) 
	{
		if (b == null)
			return 0;

		int leftHeight = fetchNodeHeight(b.left);
		int rightHeight = fetchNodeHeight(b.right);

		if (leftHeight == -1 || rightHeight == -1)
			return -1;

		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}

		return Math.max(leftHeight, rightHeight) + 1;

	}

}
