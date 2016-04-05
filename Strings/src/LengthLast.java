
public class LengthLast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLastWord("    "));

	}
	
public static int lengthOfLastWord(final String a) {
	    
	    if(a==null || a.length()==0)
	        return 0;
	    
	    String[] words = a.split("\\s");
	    int len = words.length;
	    
	    if(len==0)
	    	return 0;
	    
	    String word = words[len-1];
	    return word.length();
	}

public static int lengthOfLastWord1(final String a) {
    
    if(a==null || a.length()==0)
        return 0;
    int retVal = 0;
    for(int i = a.length()-1; i>=0; i--)
    {
    	Character c = a.charAt(i);
    	if(retVal==0 && c==' ')
    		continue;
    	else if(Character.isLetterOrDigit(c))
    	{
    		retVal++;
    	}
    	else if(c==' ')
    	{
    		return retVal;
    	}
    }
    return retVal;
}

}
