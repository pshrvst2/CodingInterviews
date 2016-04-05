
public class Num1Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numSetBits(4294967295l);

	}

	public static int numSetBits(long a) {

		 if (a==0)
		        return 0;
	       // a = 4294967295l;
		   long rem = 0;
		   long div = a;
		   int count = 0;
		   //StringBuffer sb = new StringBuffer();
		   while(div>1)
		   {
		       rem = div%2;
		       div = div/2;
		       //sb.append(String.valueOf(rem));
		       if(rem==1)
		       {
		           count++;
		       }
		   }
		   //sb.append(String.valueOf("1"));
		   //System.out.println(sb.toString());
		   System.out.println(count);
		   return ++count;
	}

}
