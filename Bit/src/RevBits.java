
public class RevBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(3));
		System.out.println(reverse(4294967294l));

	}

	public static long reverse(long a) {

		long rev = 0;

		for (int i = 0; i < 32; i++) 
		{
			rev <<= 1;
			if ((a & (1 << i)) != 0)
				rev |= 1;
		}

		return rev;
	}

}
