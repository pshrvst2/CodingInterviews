
public class IsPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPrime(2));

	}
	
	public static int isPrime(int A) 
	{
		String ret = "";
		StringBuffer sb = new StringBuffer();
		char[] b = ret.toCharArray();
		for(int i = b.length-1; i>=0; i--)
		{
			char t = b[i];
			sb.append(t);
			
		}
		double upperLimit = (double)(Math.sqrt(A));
		int ul = (int) Math.floor(upperLimit);
		
		if(A<2)
		{
			return 0;
		}
		for (int i = 2; i <= ul; i++) {
			if (A % i == 0) return 0;
		}
		return 1;
	}
}
