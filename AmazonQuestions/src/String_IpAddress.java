import java.util.ArrayList;


public class String_IpAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		restoreIpAddresses("0100100"); 

	}

	public static ArrayList<String> restoreIpAddresses(String a) 
	{

		ArrayList<String> res = new ArrayList<String>();
		if (a.length() > 12 || a.length() < 4)
			return res;

		for (int i=1; i<4; i++) 
		{
			String first = a.substring(0, i);
			if (!isValid(first))
				continue;
			for (int j=1; i+j < a.length() && j<4; j++) 
			{
				String second = a.substring(i, i+j);
				if (!isValid(second))
					continue;
				for (int k=1; i+j+k < a.length() && k<4; k++) 
				{
					String third = a.substring(i+j, i+j+k);
					String fourth = a.substring(i+j+k);
					if (isValid(third) && isValid(fourth)) 
					{
						String temp = first+"."+second+"."+third+"."+fourth;
						res.add(temp);
					}
				}
			}
		}

		return res;
	}

	public static boolean isValid(String s) 
	{
		if (s.length() > 1 && s.charAt(0) == '0')
			return false;
		if (Integer.valueOf(s) <= 255 && Integer.valueOf(s) >= 0)
			return true;
		else
			return false;
	}
}
