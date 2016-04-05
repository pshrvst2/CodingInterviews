
public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuffer sb = new StringBuffer();
		sb.append('"');
		sb.append('"');
		sb.append('"');
		
		int re = isPalindrome(sb.toString());

	}
	
public static int isPalindrome(String a) {
	
		if(a==null || a=="")
			return 1;
		
		int ret = 1;
	    a = a.toLowerCase();
	    char[] str = a.toCharArray();
	    
	    int start = 0;
	    int end = a.length()-1;
	    
	    while(start<=end)
	    {
	    	char begin=0;
	    	char endChar=0;
	    	
	    	while(!Character.isLetterOrDigit(str[start]) & start<end)
	    	{
	    		start++;
	    	}
	    	begin = str[start];
	    	
	    	while(!Character.isLetterOrDigit(str[end]) & start<end)
	    	{
	    		end--;
	    	}
	    	endChar = str[end];
	    	
	    	if(begin!=endChar)
	    	{
	    		ret = 0;
	    		break;
	    	}
	    	else
	    	{
	    		start++;
	    		end--;
	    	}
	    }
	    
	    return ret;
	}

	public void temp(String a)
	{
		String[] words = a.split("//s");
		a.length();
		
		int len = words.length;
	}

}
