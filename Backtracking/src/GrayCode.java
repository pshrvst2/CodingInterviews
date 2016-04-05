import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Piyush
 *
 */
public class GrayCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = grayCode(3);
		System.out.println(list.size());
		/*for(Integer in : list)
			System.out.println(in);*/

	}

	public static ArrayList<Integer> grayCode(int a) {
	    
	    ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(0);
        for(int i=0;i<a;i++)
        {
            //int inc = 1<<i;
        	int inc = arr.size();
            System.out.println(inc);
            for(int j=arr.size()-1;j>=0;j--)
            {
            	System.out.println("j + inc = "+j+" + "+inc);
                arr.add(arr.get(j)+inc);
            }
        }
        return arr;
	}
}
