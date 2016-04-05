import java.util.TreeMap;

/**
 * 
 */

/**
 * @author Piyush
 *
 */
public class BinarySearchTree {

	public static Node root;
	
	public BinarySearchTree()
	{
		this.root = null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeMap tree = new TreeMap();
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(3);
		bst.insert(8);
		bst.insert(1);
		bst.insert(4);
		bst.insert(6);
		bst.insert(2);
		bst.insert(10);
		bst.insert(9);
		bst.insert(20);
		bst.insert(25);
		bst.insert(15);
		bst.insert(16);
		System.out.println("Original Tree : ");
		bst.display(root);

	}
	
	public boolean find(int id)
	{
		Node current = root;
		
		while(current!=null)
		{
			if(current.data==id)
				return true;
			else if(current.data < id)
				current = current.left;
			else
				current = current.right;
		}
		
		return false;
	}
	
	public void display(Node node)
	{
		if(node == null)
			return;
		
		display(node.left);
		System.out.print(" "+node.data);
		display(node.right);
	}
	
	public void insert(int value)
	{
		Node newNode = new Node(value);
		
		if(root==null)
		{
			root = newNode;
			return;
		}
		
		Node current = root;
		Node parent = null;
		
		while(true)
		{
			parent = current;
			if(value < current.data)
			{
				current = current.left;
				if(current == null)
				{
					parent.left = newNode;
					return;
				}
			}
			else
			{
				current = current.right;
				if(current == null)
				{
					parent.right = newNode;
					return;
				}
			}
			
		}
	}
	
}
