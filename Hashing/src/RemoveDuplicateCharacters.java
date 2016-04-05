import java.util.HashMap;


public class RemoveDuplicateCharacters {

	public static void main(String[] args)
	{
		removeDuplicateLetters("abcab");
	}

	public static String removeDuplicateLetters(String s) 
	{

		if(s==null || s.length()==0)
			return s;

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<s.length(); i++)
		{
			char c = s.charAt(i);
			map.put(c,i);

		}

		int lowestIndex = getLowestIndex(map);
		int start = 0;
		int end = lowestIndex;

		while(map.size()>0)
		{
			char ch = 'z' + 1;
			int pointer = 0;
			for(int j = start; j<= end; j++)
			{
				char x = s.charAt(j);
				if(x<ch && map.containsKey(x))
				{
					ch = x;
					pointer = j;
				}
			}
			sb.append(ch);
			map.remove(ch);
			start = pointer + 1;
			end = getLowestIndex(map);
		}
		return sb.toString();
	}

	public static int getLowestIndex(HashMap<Character, Integer> map)
	{
		int low = Integer.MAX_VALUE;
		for(Integer in : map.values())
		{
			low = Math.min(low, in);
		}
		return low;
	}

}
