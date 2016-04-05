public class MaxPath {
	
	//Root of the binary tree
	Node root;
	
	public int findMaxUtil(Node node, Res res)
	{
		if(node == null)
			return 0;
		
		// l and r store maximum path sum going through left and
        // right child of root respectively
		int l = findMaxUtil(node.left, res);
        int r = findMaxUtil(node.right, res);
        
        // Max path for parent call of root. This path must
        // include at-most one child of root
        int max_single = Math.max(Math.max(l, r) + node.data,node.data);
        
        // Max Top represents the sum when the Node under
        // consideration is the root of the maxsum path and no
        // ancestors of root are there in max sum path
        int max_top = Math.max(max_single, l + r + node.data);
 
        // Store the Maximum Result.
        res.val = Math.max(res.val, max_top);
		return max_single;
	}

	public int findMaxSum()
	{
		Res res = new Res();
		res.val = Integer.MIN_VALUE;
		findMaxUtil(root, res);
		return res.val;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MaxPath tree = new MaxPath();
		tree.root = new Node(10);
		tree.root.left = new Node(2);
		tree.root.right = new Node(10);
		tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(1);
        tree.root.right.right = new Node(-25);
        tree.root.right.right.left = new Node(3);
        tree.root.right.right.right = new Node(4);
        System.out.println("maximum path sum is : " +
                            tree.findMaxSum());

	}

}

//An object of Res is passed around so that the
//same value can be used by multiple recursive calls.
class Res {
	public int val;
}
