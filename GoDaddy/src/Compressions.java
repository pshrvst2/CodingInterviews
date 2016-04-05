/**
 * 
 */

/**
 * @author Piyush
 *
 */
public class Compressions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		compress("aabb");
		/*compress("aaaaabbbbbbbbbccccpqrstuv");
		compress("aaaaabbbbbbbbbbccccdeeeeeee");*/

	}
	
	public static String compress(String str)
	{
		if(str.isEmpty())
			return "";
		
		String retStr = "";
		StringBuffer sb = new StringBuffer();
		char[] charArr = str.toCharArray();
		char prev = 0;
		int i = 0;
		int currCount = 0;
		for(char curr : charArr)
		{
			if(i == 0)
			{
				prev = curr;
				currCount++;
				i++;
				continue;
			}
			
			if(prev==curr)
			{
				currCount++;
				prev = curr;
			}
			else if(curr!=prev && currCount>1)
			{
				sb.append(prev);
				sb.append(currCount);
				currCount = 1;
			}
			else if(curr!=prev && currCount==1)
			{
				prev = curr;
				//sb.append(prev);
				//currCount = 1;
			}
			i++;
			
		}
		
		if(currCount>1)
		{
			sb.append(prev);
			sb.append(currCount);
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

}
