import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class Shivam {
	
	static class TreeNode{
		String val;
		TreeNode left = null;
		TreeNode right = null;
		
		public TreeNode(String val)
		{
			this.val = val;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] scores = {"4","2","5","1","4","6","6"};
		gatherScores(scores);
	}
	
	public static String gatherScores(String[] scores)
	{
		StringBuffer sb = new StringBuffer();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		TreeNode root = null;
		for(String score : scores)
		{
			if(!map.containsKey(score))
			{
				map.put(score, 1);
			}
			else
			{
				int count = map.get(score);
				map.put(score, count++);
			}
			root = insertNode(score, root);
		}
		
		// traverse the tree and save in string buffer
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			TreeNode node = q.poll();
			if(node==null)
			{
				sb.append(",");
				continue;
			}
			sb.append(node.val).append(":").append(map.get(node.val)).append(",");
			q.add(node.left);
			q.add(node.right);
		}
		
		System.out.println(sb.toString());
		return null;
		
	}
	
	public static TreeNode  insertNode(String score, TreeNode node)
	{
		if(node == null)
		{
			node = new TreeNode(score);
			return node;
		}
		
		if(Integer.valueOf(score) < Integer.valueOf(node.val))
		{
			node.left = insertNode(score, node.left);
		}
		else if(Integer.valueOf(score) < Integer.valueOf(node.val))
		{
			node.right = insertNode(score, node.right);
		}
		else
		{
			return node;
		}
		
		return node;
	}

}
