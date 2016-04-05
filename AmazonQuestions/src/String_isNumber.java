
public class String_isNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(isNumber("      "));
		System.out.println(isNumber(" 0.1"));

	}
	
public static int isNumber(final String a) {
	    
	    String num = a;
	    int i = 0;
	    while(i<a.length() && num.charAt(i)==' ')
	    {
	    	i++;
	    }
	    if(i==a.length())
	        return 0;
	    num = num.substring(i);
	    
	    char[] numChar = num.toCharArray();
	    try
	    {
	    	Long lng = Long.valueOf(num);
	    	Double dbl = Double.valueOf(num);
	    }
	    catch(Exception e)
	    {
	    	try
	    	{
	    		Double dbl = Double.valueOf(num);
	    	}
	    	catch(Exception ex)
	    	{
	    		return 0;
	    	}
	    }
	    for(char c : numChar)
	    {
	        if(Character.isLetter(c) && c!='e')
	           return 0;
	        if(c==' ')
	            return 0;
	    }
	    
	    return 1;
	}

}
