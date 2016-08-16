
public class Solution {
	static int i = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//test
		System.out.println(returnVal1() + " and " + returnVal2());

	}
	
	public static int returnVal1()
	{
		return i--;
	}
	
	public static int returnVal2()
	{
		return i;
	}

}
