
public class AToI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*System.out.println(atoi(" +7") );
		System.out.println(atoi(" -88297 248252140B12 37239U4622733246I218  9 1303   44 A83793H3G2 1674443R591 4368 7  97"));
		System.out.println(atoi("-6435D56183011M11   648G1 903778065  762 75316456373673B5 334 19885 90668 8 98K  X277 9846 "));
		System.out.println(atoi("44024E11 G24  378556582G0467E    6 613  1 2173 9829 5K5H099 2Q  458890732 94  0 "));
		System.out.println(atoi("+4136YF3913 2 1568 8520 76288761844685 6701829 789U7626785718K68177"));
		System.out.println(atoi(" V515V 5793K 627 23815945269 1 1249794L 631 8755 7"));
		System.out.println(atoi("-54332872018247709407 4 54"));*/
		System.out.println(atoi("-A26626 445569J260714W5 9 2 59   11 52C401"));
		

	}

	public static int atoi(final String a) {
		
		if(a==null | a.length()==0)
			return 0;

		int ret = 0;

		String words[] = a.split("\\s");
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;

		for(int i = 0; i < words.length; i++)
		{
			try
			{
				String temp = words[i].toString();
				char[] tempChar = temp.toCharArray();

				if(temp.equals("-") || temp.equals("+"))
					return 0;
				else if(!Character.isDigit(temp.charAt(0)) & temp.charAt(0)!='+' & temp.charAt(0)!='-' )
				{
					return 0;
				}
				else
				{
					for(char c : tempChar)
					{
						if(!Character.isLetterOrDigit(c) & c!='+' & c!='-')
							return 0;
					}

					if(temp.charAt(0)=='+')
					{
						temp = temp.substring(1);
						char[] b = temp.toCharArray();
						
						if(Character.isLetter(b[0]))
							return 0;

						int index = 0;
						for(char c : b)
						{
							if(index>0 & !Character.isDigit(c))
								break;
							index++;
						}

						temp = temp.substring(0, index);
					}
					else if(temp.charAt(0)=='-')
					{
						char[] b = temp.toCharArray();
						
						if(Character.isLetter(b[1]))
							return 0;

						int index = 0;
						for(char c : b)
						{
							if(index>0 & !Character.isDigit(c))
								break;
							index++;
						}

						temp = temp.substring(0, index);
					}
					else
					{
						char[] b = temp.toCharArray();

						int index = 0;
						for(char c : b)
						{
							if(index>0 & !Character.isDigit(c))
								break;
							index++;
						}

						temp = temp.substring(0, index);
					}
					Double lonGG = Double.valueOf(temp);

					if(lonGG>max)
						return max;
					else if(lonGG<min)
						return min;
					else
						return Integer.valueOf(temp);
				}

			}
			catch(Exception e)
			{
				// do nothing
			}

		}

		return ret;
	}
}
