
public class String_LengthLast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int lengthOfLastWord(final String a) {

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

	public int lengthOfLastWordSolution(final String A) {
		int i;

		if (A.length() == 0)
			return 0;

		int n = A.length();
		int lastWordIndex = n;
		int endIndex = n;

		i = n - 1;

		while (i >= 0 && A.charAt(i) == ' ')
			i--;

		endIndex = i;

		for (; i >= 0; i--) {

			if (A.charAt(i) == ' ') {
				break;
			}

			lastWordIndex = i;	        

		}

		return Math.max(0, endIndex - lastWordIndex + 1);

	}

}
