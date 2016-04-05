import java.util.HashMap;
import java.util.HashSet;


public class REPEATSTR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lengthOfLongestSubstring("dadbc");
		//lengthOfLongestSubstring("bbbb");

	}
	
	public static int lengthOfLongestSubstring(String a) {

	    
	    if(a==null || a.length()==0 )
	        return 0;
	    
	    int max = 1;
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	    int i = 0;
	    int j = 1;
	    int diff = 0;
	    map.put(a.charAt(i), i);
	    while(j<a.length())
	    {
	        if(a.charAt(i)!=a.charAt(j) && !map.containsKey(a.charAt(j)))
	        {
	            map.put(a.charAt(j),j);
	            diff = j-i;
	            j++;
	        }
	        else
	        {
	        	char c = a.charAt(j);
	        	if(map.containsKey(c))
	        		i = map.get(c);
	        	else
	        		i++;
	            j = i+1;
	            diff = 0;
	            map.clear();
	        }
	        
	        if(diff+1>max)
	            max = diff+1;
	    }
	   
	    return max;
	}

	public static int lengthOfLongestSubstring1(String a) {


		if(a==null || a.length()==0 )
			return 0;

		int max = 1;
		HashSet<Character> set = new HashSet<Character>();
		int i = 0;
		int j = 1;
		int diff = 0;
		set.add(a.charAt(i));
		while(j<a.length())
		{
			if(a.charAt(i)!=a.charAt(j) && !set.contains(a.charAt(j)))
			{
				set.add(a.charAt(j));
				diff = j-i;
				j++;
			}
			else
			{
				i++;
				j = i+1;
				diff = 0;
				set.clear();
			}

			if(diff+1>max)
				max = diff+1;
		}

		return max;
	}

}
