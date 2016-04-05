import java.util.ArrayList;
import java.util.HashMap;

class TrieNode{
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    int val = 0;
    
    public TrieNode(){
        
    }
    
    public TrieNode(Character c){
        this.c = c;
        this.val =1;
    }
}

public class TrieShortestPrefixPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] l = {"zebra", "dog", "duck", "dot"};
		String[] l = {"bearcat", "bert"};
		ArrayList<String> list = new ArrayList<String>();
		for(String s : l)
			list.add(s);
		ArrayList<String> rList = prefix(list);
		for(String s : rList)
			System.out.println(s);

	}
	
public static ArrayList<String> prefix(ArrayList<String> a) {
	    
	    if(a==null || a.size()==0)
	        return null;
	    ArrayList<String> retList = new ArrayList<String>();
	    TrieNode root = new TrieNode();
	    insertWords(root,a);
	    getShortestPrefix(retList, a, root);
	    return retList;
	    
	}
	
	public static void insertWords(TrieNode root, ArrayList<String> a){
	    
	    for(String str : a)
	    {
	        TrieNode node;
	        HashMap<Character, TrieNode> children = root.children;
	        for(int i = 0; i<str.length(); i++){
	            char c = str.charAt(i);
	            if(children.containsKey(c))
	            {
	                node = children.get(c);
	                node.val++;
	            }
	            else
	            {
	                node = new TrieNode(c);
	                children.put(c,node);
	            }
	            children = node.children;
	        }
	    }
	}
	
	public static void getShortestPrefix(ArrayList<String> retList, ArrayList<String> a, TrieNode root)
	{
	    
	    for(String str : a)
	    {
	    	HashMap<Character,TrieNode> children = root.children;
	        char[] charAr = str.toCharArray();
	        StringBuffer sb = new StringBuffer();
	        TrieNode temp ;
	        for(char c : charAr)
	        {
	            temp = children.get(c);
	            sb.append(c);
	           
	            if(temp.val==1)
	                break;
	            children = temp.children;
	        }
	        retList.add(sb.toString());
	    }
	}

}
