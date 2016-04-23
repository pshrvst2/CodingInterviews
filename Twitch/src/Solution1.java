import java.util.*;


public class Solution1 {

	public static void main(String[] args)
	{
		
		System.out.println(isPalindrome("aba"));
	}
	
	public static String isPalindrome(String s)
	{
		List<Character> orgList = new ArrayList<Character>();
		for(char c : s.toCharArray())
			orgList.add(c);
		
		if(permutations("", orgList, s.length()))
			return "YES";
		return "NO";
	}
	
	public static boolean permutations(String currStr, List<Character> list, int len)
	{
		if(currStr.length() == len)
		{
			return isPal(currStr);
		}
		
		StringBuffer sb = new StringBuffer(currStr);
		for(int i = 0; i < list.size(); i++)
		{
			sb.append(list.get(i));
			List<Character> remList = new ArrayList<Character>(list);
			remList.remove(i);
			if(permutations(sb.toString(), remList, len))
				return true;
		}
		return false;
	}
	
	public static boolean isPal(String str)
	{
		StringBuffer sb = new StringBuffer(str);
		if(str.equals(sb.reverse().toString()))
		{
			//System.out.println(str);
			return true;
		}
		return false;
	}
}
