
public class String_ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String reverseWords(String a) {
	    
	    String retString = "";
		if(a==null || a.length()==0)
	        return retString;
	    
	    String[] words = a.split("\\s");
	    int len = words.length;
	    
	    if(len==0)
	    	return a;
	    
	    for(int i = len-1; i >= 0; i--)
	    {
	    	String temp = words[i];
	    	if(!words[i].equals(""))
	    	{
	    		retString = retString+words[i];
	    		retString = retString+" ";
	    	}
	    }
	    
	    retString = retString.substring(0, retString.length()-1);
	    return retString;
	}

}
