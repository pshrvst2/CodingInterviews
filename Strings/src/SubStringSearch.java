
public class SubStringSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strStr("b", "b"));

	}
	
public static int strStr(final String haystack, final String needle) {
	    
	    if(haystack == null || needle == null || haystack.length()==0 || needle.length()==0)
	        return -1;
	        
	    int start = 0;
	    int end = haystack.length();
	    
	    while(start<=(end-needle.length()))
	    {
	        if(haystack.charAt(start) == needle.charAt(0))
	        {
	            String temp = haystack.substring(start, start+needle.length());
	            if(temp.equals(needle))
	                return start;
	            
	        }
	        start++;
	    }
	    
	    return -1;
	}

}
