import java.util.Stack;


public class ReverseOfWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(reverseWords1("fwbpudnbrozzifml osdt  ulc jsx kxorifrhubk ouhsuhf  sswz qfho dqmy  sn myq igjgip iwfcqq"));
		System.out.println(reverseWords("fwbpudnbrozzifml osdt  ulc jsx kxorifrhubk ouhsuhf  sswz qfho dqmy  sn myq igjgip iwfcqq"));
		System.out.println(reverseWordsUsingStack("   a   b "));

	}

	public static String reverseWords1(String a) {

		String retString = "";
		if(a==null || a.length()==0)
			return retString;

		StringBuffer sb = new StringBuffer(a);
		sb = sb.reverse();

		String rev = sb.toString();

		char[] chars = rev.toCharArray();
		StringBuffer sb2 = new StringBuffer();
		for(int i = 0; i < chars.length; i++)
		{

			if(chars[i]!=' ')
			{
				sb2.append(chars[i]);
			}
			else
			{
				if(sb2.length()>0)
				{
					retString = retString + sb2.reverse().toString();
					sb2.delete(0, sb2.length());
				}
				retString = retString + " ";

			}
		}

		if(sb2.length()>0)
		{
			retString = retString + sb2.reverse().toString();
		}

		return retString;

	}

	public static String reverseWords(String a) {

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

	public static String reverseWordsUsingStack(String s) 
	{

		if(s==null || s.length()==0)
			return s;
		s=s.trim();
		String[] words = s.split("\\s");
		Stack<String> stack = new Stack<String>();

		for(String word : words)
		{
			if(!word.equals(""))
				stack.push(word);
		}

		StringBuffer sb = new StringBuffer();

		while(!stack.isEmpty())
		{
			sb.append(stack.pop());
			if(stack.size()!=0)
				sb.append(" ");
		}

		String retStr = sb.toString();
		retStr = retStr.substring(0,retStr.length());
		return retStr;

	}

}
